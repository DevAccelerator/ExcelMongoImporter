package ro.devaccelerator.excelmongoimporter;

import ro.devaccelerator.excelmongoimporter.input.InputSource;
import ro.devaccelerator.excelmongoimporter.output.OutputDestination;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;

/**
 * Commodity class, just runs the import
 * @author bogdan
 */
class Importer {

	private final InputSource source;
	private final OutputDestination destination;

	public Importer(InputSource source, OutputDestination destination) {
		this.source = source;
		this.destination = destination;
	}

	public ImportResult runImport() {
		return this.source.importTo(destination);
	}
}
