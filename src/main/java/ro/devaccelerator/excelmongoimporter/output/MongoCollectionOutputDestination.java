package ro.devaccelerator.excelmongoimporter.output;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.devaccelerator.excelmongoimporter.input.InputData;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;
import ro.devaccelerator.excelmongoimporter.utils.Logger;

/**
 * An OutputDestination for an unsecured MongoDB collection
 *
 * @author bogdan
 */
public class MongoCollectionOutputDestination implements OutputDestination {

	private final String serverName;
	private final int portNumber;
	private final String collectionName;
	private final String databaseName;

	private final MongoClient client;

	public MongoCollectionOutputDestination(String serverName, String portNumber,
											String databaseName, String collectionName) {
		this.serverName = serverName;
		this.portNumber = Integer.parseInt(portNumber);
		this.collectionName = collectionName;
		this.databaseName = databaseName;

		client = new MongoClient(this.serverName, this.portNumber);
	}

	@Override
	public String importData(InputData data) {
		try {
			MongoDatabase db = client.getDatabase(databaseName);
			MongoCollection<Document> collection = db.getCollection(collectionName);
			Document document = new Document();
			data.copyToMap(document);
			collection.insertOne(document);
		}
		catch (Exception e) {
			Logger.error(this, "Could not import ", e);
			return ImportResult.ERROR_MARKER + data.toString();
		}
		return ImportResult.SUCCESS_MARKER + data.toString();
	}

	@Override
	public String toString() {
		return "MongoDB {" + "serverName=" + serverName + ", portNumber=" + portNumber + ", databaseName=" + databaseName + ", collectionName=" + collectionName + '}';
	}

}
