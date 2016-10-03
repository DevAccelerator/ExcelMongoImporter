package ro.devaccelerator.excelmongoimporter.input;

import ro.devaccelerator.excelmongoimporter.output.OutputDestination;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;

/**
 * An input source that know how to output to a destination
 * 
 * @author bogdan
 */
public interface InputSource {
	public ImportResult importTo(OutputDestination destination);	
}
