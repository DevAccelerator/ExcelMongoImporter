package ro.devaccelerator.excelmongoimporter.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ro.devaccelerator.excelmongoimporter.utils.Logger;

/**
 * Read data from XLSX files - Office 2007+
 * 
 * @author bogdan
 */
public class XlsxInputDataReader extends InputDataReaderBase {

	public XlsxInputDataReader(String fileName) {
		try (InputStream inputStream = new FileInputStream(fileName)) {

			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workBook.getSheetAt(0);
			rows = sheet.rowIterator();
		}
		catch (IOException ex) {
			Logger.error(this.getClass().getName(), "Error reading the specified path: [" + fileName + "]");
			rows = new Iterator<Row>() {
				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public Row next() {
					return null;
				}
			};
		}
	}

}
