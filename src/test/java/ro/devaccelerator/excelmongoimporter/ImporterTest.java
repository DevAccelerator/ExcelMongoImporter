package ro.devaccelerator.excelmongoimporter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ro.devaccelerator.excelmongoimporter.input.InputData;
import ro.devaccelerator.excelmongoimporter.output.OutputDestination;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;

/**
 *
 * @author bogdan
 */
public class ImporterTest {
	
	@Test
	public void runIt(){
		ImportResult result = new Importer((OutputDestination destination) -> {
			ImportResult result1 = new ImportResult();
			InputData data = new InputData();
			data.add("Column", "Record1");
			result1.record(destination.importData(data));
			return result1;
		}, (InputData data) -> ImportResult.SUCCESS_MARKER + data).runImport();
		
		assertEquals(1, result.getSuccessfulImports().size());
	}
}
