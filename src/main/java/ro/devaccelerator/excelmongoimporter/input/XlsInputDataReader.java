package ro.devaccelerator.excelmongoimporter.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import ro.devaccelerator.excelmongoimporter.utils.Logger;

/**
 *
 * @author bogdan
 */
public class XlsInputDataReader extends InputDataReaderBase {
	
	public XlsInputDataReader(String fileName) {

		try(InputStream inputStream = new FileInputStream(fileName);
			POIFSFileSystem fileSystem = new POIFSFileSystem (inputStream)){
			
			HSSFWorkbook      workBook = new HSSFWorkbook (fileSystem);
			HSSFSheet         sheet    = workBook.getSheetAt (0);
			rows = sheet.rowIterator ();
		}
		catch (IOException ex) {
			Logger.error(this.getClass().getName(), "Error reading the specified path: [" + fileName + "]");
			rows = new Iterator<Row>() {
				@Override
				public boolean hasNext() {return false;}

				@Override
				public Row next() {return null;}
			};
		}
	}

}
