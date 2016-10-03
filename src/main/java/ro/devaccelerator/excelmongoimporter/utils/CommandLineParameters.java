package ro.devaccelerator.excelmongoimporter.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Processes the command line parameters when run in command line mode
 *
 * @author bogdan
 */
public class CommandLineParameters {

	final String[] initialParameters;
	Map<String, String> parameters = new HashMap<>();

	public static final String DEFAULT_SERVER = "localhost";
	public static final String DEFAULT_PORT = "27017";

	public static final String INPUT_PARAM = "-input";

	public static final String OUTPUT_DATABASE_PARAM = "-database";
	public static final String OUTPUT_COLLECTION_PARAM = "-collection";
	public static final String OUTPUT_SERVER_PARAM = "-server";
	public static final String OUTPUT_PORT_PARAM = "-port";

	/**
	 * Constructs a command line parameter processor and processes the arguments
	 *
	 * @param args command line arguments
	 */
	public CommandLineParameters(String[] args) {
		this.initialParameters = args;
		readParameters();
	}

	/**
	 * Parses parameters from the arguments array
	 */
	private void readParameters() {
		if (initialParameters.length > 0) {
			Logger.debug(this, "Running with parameters: " + Arrays.toString(initialParameters));
			String parameterKey = "";
			for ( String parameter : initialParameters ) {
				if (parameterKey.length() > 0) {
					if (isValidValue(parameter)) {
						if (parameterKey.equals(OUTPUT_PORT_PARAM)) {
							parameters.put(parameterKey, readIntParameterWithDefault(parameter, OUTPUT_PORT_PARAM, DEFAULT_PORT));
						}
						else {
							parameters.put(parameterKey, parameter);
						}
					}
				}
				if (parameter.startsWith("-")) {
					parameterKey = parameter;
				}
			}
			if (!hasParam(OUTPUT_SERVER_PARAM)) {
				parameters.put(OUTPUT_SERVER_PARAM, DEFAULT_SERVER);
			}
			if (!hasParam(OUTPUT_PORT_PARAM)) {
				parameters.put(OUTPUT_PORT_PARAM, DEFAULT_PORT);
			}
		}
		else {
			Logger.error(this, "No parameters, minimum parameters are [ " + INPUT_PARAM + " ] and [ " + OUTPUT_COLLECTION_PARAM +" ]");
		}
	}

	/**
	 * Gets the MongoDB port parameter
	 *
	 * @return MongoDB port parameter
	 */
	public String getPort() {
		return parameters.get(OUTPUT_PORT_PARAM);
	}
	
	/**
	 * Gets the input file name
	 * @return input file name
	 */
	public String getInputFile(){
		return parameters.get(INPUT_PARAM);
	}
	
	/**
	 * Gets the server address from the command line parameters
	 * Default is localhost
	 * @return server address
	 */
	public String getServer(){
		return parameters.get(OUTPUT_SERVER_PARAM);
	}
	
	/**
	 * Gets the MongoDB database name
	 * @return MongoDB database name
	 */
	public String getDatabaseName(){
		return parameters.get(OUTPUT_DATABASE_PARAM);
	}

	/**
	 * Gets the MongoDB collection name
	 * @return MongoDB collection name
	 */
	public String getCollectionName(){
		return parameters.get(OUTPUT_COLLECTION_PARAM);
	}

	/**
	 * Checks if the minimum input parameters are present
	 *
	 * @return
	 */
	protected boolean hasInputParameters() {
		return hasParam(INPUT_PARAM);
	}

	/**
	 * Checks if the minimum output parameters are present
	 *
	 * @return
	 */
	protected boolean hasOutputParameters() {
		return hasParam(OUTPUT_COLLECTION_PARAM) && hasParam(OUTPUT_DATABASE_PARAM);
	}

	/**
	 * Checks if a specific parameter is present
	 *
	 * @param paramName the name of the parameter
	 * @return if the parameter is present
	 */
	protected boolean hasParam(String paramName) {
		return parameters.keySet().contains(paramName);
	}

	/**
	 * Checks to see if the minimum command line parameters are present.
	 * Minimum parameters are input file and output collection
	 *
	 * @return if the minimum parameters are present
	 */
	boolean hasMinimumParameters() {
		return hasInputParameters() && hasOutputParameters();
	}

	/**
	 * *
	 * Checks if a parameter value is valid
	 * Valid parameter values are not empty and don't start with -
	 *
	 * @param value - the parameter value
	 * @return if the value is valid
	 */
	private Boolean isValidValue(String value) {
		return !value.startsWith("-") && value.trim().length() > 0;
	}

	/***
	 * Reads the port parameter from the input string, validates it
	 * If it it not valid, the default port is returned
	 * @param inputParameter - the input parameter
	 * @param parameterName - the name of the parameter
	 * @param defaultParameter - the default value
	 * @return  the processed parameter
	 */
	private String readIntParameterWithDefault(String inputParameter, String parameterName, String defaultParameter) {
		String resultParameter = defaultParameter;
		try {
			int parameter = Integer.parseInt(inputParameter);
			resultParameter = "" + parameter;
		}
		catch (NumberFormatException nfe) {
			Logger.warn(this, "Invalid parameter value [ " + inputParameter + " ], [ " + parameterName + " ] must be a number, using [ " + DEFAULT_PORT + " ]");
		}
		return resultParameter;
	}
}
