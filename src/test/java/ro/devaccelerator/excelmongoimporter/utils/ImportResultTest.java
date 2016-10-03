package ro.devaccelerator.excelmongoimporter.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author bogdan
 */
public class ImportResultTest {

	@Test
	public void record_success() {
		ImportResult result = new ImportResult();
		result.record(ImportResult.SUCCESS_MARKER + " it worked");

		assertTrue(result.getErrors().isEmpty());
		assertEquals(1, result.getSuccessfulImports().size());
	}

	@Test
	public void record_no_prefix_ignored() {
		ImportResult result = new ImportResult();
		result.record("Hmm, it worked");

		assertTrue(result.getErrors().isEmpty());
		assertTrue(result.getSuccessfulImports().isEmpty());
	}

	@Test
	public void record_error() {
		ImportResult result = new ImportResult();
		result.record(ImportResult.ERROR_MARKER + " it didn't work");

		assertTrue(result.getSuccessfulImports().isEmpty());
		assertEquals(1, result.getErrors().size());
	}

	@Test
	public void record_error_and_success() {
		ImportResult result = new ImportResult();
		result.record(ImportResult.ERROR_MARKER + " it didn't work");
		result.record(ImportResult.SUCCESS_MARKER + " it worked");

		assertEquals(1, result.getErrors().size());
		assertEquals(1, result.getSuccessfulImports().size());

	}
	
	@Test
	public void record_error_and_success_toString() {
		ImportResult result = new ImportResult();
		result.record(ImportResult.ERROR_MARKER + " it didn't work");
		result.record(ImportResult.SUCCESS_MARKER + " it worked");

		assertEquals("Import finished\n\t Successful: [ 1 ]\n\t Errors: [ 1 ]\n", result.toString());

	}
}
