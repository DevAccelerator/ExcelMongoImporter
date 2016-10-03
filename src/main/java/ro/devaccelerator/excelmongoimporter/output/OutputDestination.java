package ro.devaccelerator.excelmongoimporter.output;

import ro.devaccelerator.excelmongoimporter.input.InputData;

/**
 * A place where the data is imported
 *
 * @author bogdan
 */
public interface OutputDestination {

	String importData(InputData data);

	public String toString();
}
