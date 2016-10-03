package ro.devaccelerator.excelmongoimporter.input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author bogdan
 */
public class InputDataReaderBase implements InputDataReader {

	protected Iterator<Row> rows = null;
	private final List<String> columns = new ArrayList<>();
	private Row currentRow = null;

	@Override
	public Boolean readNext() {
		if (rows.hasNext()) {
			Row row = rows.next();

			if (row.getRowNum() == 0) { // this is the header, process it and do another next
				processHeader(row);
				if (rows.hasNext()) {
					row = rows.next();
				}
				else {
					row = null;
				}
			}
			currentRow = row;
			return currentRow != null;
		}
		return false;
	}

	@Override
	public InputData getData() {
		InputData data = new InputData();
		Iterator<Cell> cells = currentRow.cellIterator();
		while ( cells.hasNext() ) {
			Cell cell = cells.next();
			data.add(columns.get(cell.getColumnIndex()), cell.getStringCellValue());
		}
		return data;
	}

	private void processHeader(Row row) {
		Iterator<Cell> cells = row.cellIterator();
		while ( cells.hasNext() ) {
			Cell headerCell = cells.next();
			addColumn(headerCell.getStringCellValue());
		}
	}

	private void addColumn(String columnName) {
		columns.add(columnName);
	}

}
