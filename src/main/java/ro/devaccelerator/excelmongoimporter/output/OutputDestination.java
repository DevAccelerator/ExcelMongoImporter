/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.devaccelerator.excelmongoimporter.output;

import ro.devaccelerator.excelmongoimporter.input.InputData;

/**
 * A place where the data is imported
 * @author bogdan
 */
public interface OutputDestination {
	String importData(InputData data);	
}
