/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
