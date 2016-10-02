/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.devaccelerator.excelmongoimporter.input;

import java.io.File;
import java.security.InvalidParameterException;
import static org.junit.Assert.*;
import org.junit.Test;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;

/**
 *
 * @author bogdan
 */
public class ExcelInputSourceTest {

	@Test(expected = InvalidParameterException.class)
	public void ExcelInputSource_invalid_path_should_throw_exception() {
		new ExcelInputSource("Sample_1.doc");
	}

	@Test
	public void importTo_xls_successful() {
		ExcelInputSource source = new ExcelInputSource(getPath("Sample_1.xls"));
		ImportResult result = source.importTo((InputData data) -> ImportResult.SUCCESS_MARKER + data);
		assertEquals(2, result.getSuccessfulImports().size());
	}
	
	@Test
	public void getData_xls_should_return_valid_data() {
		ExcelInputSource source = new ExcelInputSource(getPath("Sample_1.xls"));
		source.reader.readNext();
		InputData data = source.reader.getData();
		assertEquals("InputData{data={Column1=Cell 11, Column2=Cell 12, Column3=Cell 13}}", data.toString());
	}

	@Test
	public void readNext_xls_no_file() {
		ExcelInputSource source = new ExcelInputSource("Sample_2.xls");
		assertFalse(source.reader.readNext());
	}
	
	@Test
	public void readNext_xlsx_no_file() {
		ExcelInputSource source = new ExcelInputSource("Sample_2.xlsx");
		assertFalse(source.reader.readNext());
	}
	
	
	@Test
	public void readNext_xls() {
		ExcelInputSource source = new ExcelInputSource(getPath("Sample_1.xls"));
		assertTrue(source.reader.readNext());
	}

	@Test
	public void readNext_xls_no_records() {
		ExcelInputSource source = new ExcelInputSource(getPath("Sample_no_records.xls"));
		assertFalse(source.reader.readNext());
	}

	@Test
	public void readNext_xls_empty() {
		ExcelInputSource source = new ExcelInputSource(getPath("Sample_empty.xls"));
		assertFalse(source.reader.readNext());
	}

	@Test
	public void runItXlsx() {
		ExcelInputSource source = new ExcelInputSource(getPath("Sample_1.xlsx"));
		assertTrue(source.reader.readNext());
	}

	public String getPath(String filePath) {
		File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
		return file.getAbsolutePath();
	}
}
