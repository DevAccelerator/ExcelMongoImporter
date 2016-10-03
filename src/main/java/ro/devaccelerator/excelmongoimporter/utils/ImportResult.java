package ro.devaccelerator.excelmongoimporter.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the result of an import request
 * @author bogdan
 */
public class ImportResult {
	
	public static String SUCCESS_MARKER = "SUCCESS:";
	public static String ERROR_MARKER = "ERROR:";
	
	private final List<String> errors = new ArrayList<>();
	private final List<String> successfull = new ArrayList<>();
	
	/**
	 * Records an import result
	 * SUCCESS: means it worked
	 * ERROR: means it didn't work
	 * @param result the string result
	 */
	public void record(String result) {
		if(result.startsWith(SUCCESS_MARKER)){
			successfull.add(result);
		}
		else if(result.startsWith(ERROR_MARKER)){
			errors.add(result);
		}
		else{
			Logger.warn(this, "Not respecting the ImportResult convention will disregard the result");
		}
	}
	
	/***
	 * Returns the list of import errors
	 * @return 
	 */
	public List<String> getErrors(){
		return Collections.unmodifiableList(errors);
	}
	
	/***
	 * Returns the list of import successes
	 * @return 
	 */
	public List<String> getSuccessfulImports(){
		return Collections.unmodifiableList(successfull);
	}

	@Override
	public String toString() {
		return "Import finished\n"
				+ "\t Successful: [ " + getSuccessfulImports().size() + " ]\n"
				+ "\t Errors: [ " + getErrors().size() + " ]\n";
	}
	
}
