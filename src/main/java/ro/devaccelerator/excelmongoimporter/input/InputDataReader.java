package ro.devaccelerator.excelmongoimporter.input;

/**
 *
 * @author bogdan
 */
public interface InputDataReader {
	Boolean readNext();
	InputData getData();
}
