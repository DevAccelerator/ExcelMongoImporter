package ro.devaccelerator.excelmongoimporter.input;

import java.security.InvalidParameterException;
import ro.devaccelerator.excelmongoimporter.output.OutputDestination;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;
import ro.devaccelerator.excelmongoimporter.utils.Logger;

/**
 *
 * @author bogdan
 */
public class ExcelInputSource implements InputSource {

	protected final InputDataReader reader;

	public ExcelInputSource(String fileName) {
		if (fileName.endsWith("xls")) {
			reader = new XlsInputDataReader(fileName);
		}
		else if (fileName.endsWith("xlsx")) {
			reader = new XlsxInputDataReader(fileName);
		}
		else {
			throw new InvalidParameterException("Can only process XLS and XLSX files");
		}
	}

	@Override
	public ImportResult importTo(OutputDestination destination) {
		Logger.info(this, "Started import to " + destination);
		ImportResult results = new ImportResult();

		while ( reader.readNext() ) {
			results.record(destination.importData(reader.getData()));
		}
		return results;
	}
}
