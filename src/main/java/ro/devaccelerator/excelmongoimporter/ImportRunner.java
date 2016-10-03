package ro.devaccelerator.excelmongoimporter;

import ro.devaccelerator.excelmongoimporter.input.ExcelInputSource;
import ro.devaccelerator.excelmongoimporter.output.MongoCollectionOutputDestination;
import ro.devaccelerator.excelmongoimporter.utils.CommandLineParameters;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;
import ro.devaccelerator.excelmongoimporter.utils.Logger;

/**
 * Command line runner for the import
 * @author bogdan
 */
public class ImportRunner {
	public static void main(String[] arguments) {
		Logger.info(ImportRunner.class, "Starting command line importer");
		
		CommandLineParameters parameters = new CommandLineParameters(arguments);
	
		ImportResult result = new Importer(
				new ExcelInputSource(parameters.getInputFile()),
				new MongoCollectionOutputDestination(parameters.getServer(), parameters.getPort(), 
													 parameters.getDatabaseName(), parameters.getCollectionName())
		).runImport();
		
		Logger.info(ImportRunner.class, result.toString());
		if(result.getErrors().size()>0){
		Logger.info(ImportRunner.class, "\t" + result.getErrors());
		}
		
		
	}
}
