package ro.devaccelerator.excelmongoimporter.output;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author bogdan
 */
public class MongoCollectionOutputDestinationTest {

	@Test
	public void toString_format() {
		OutputDestination destination = new MongoCollectionOutputDestination("server", "1", "db", "coll");
		assertEquals("MongoDB {serverName=server, portNumber=1, databaseName=db, collectionName=coll}", destination.toString());
	}
}
