/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.devaccelerator.excelmongoimporter.output;

import ro.devaccelerator.excelmongoimporter.input.InputData;
import ro.devaccelerator.excelmongoimporter.utils.ImportResult;

/**
 * An OutputDestination for a MongoDB collection
 * @author bogdan
 */
public class MongoCollectionOutputDestination implements OutputDestination {

	String serverName = "";
	String portNumber = "";
	String collectionName = "";

	public MongoCollectionOutputDestination(String serverName, String portNumber, String collectionName) {
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.collectionName = collectionName;
	}

	@Override
	public String importData(InputData data) {
		return ImportResult.SUCCESS_MARKER + data.toString();
	}

}
