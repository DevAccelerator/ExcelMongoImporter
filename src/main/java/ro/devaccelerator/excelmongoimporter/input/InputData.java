/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.devaccelerator.excelmongoimporter.input;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author bogdan
 */
public class InputData {
	protected Map<String, String> data = new LinkedHashMap<>();

	public void addColumn(String name, String value){
		data.put(name, value);
	}

	@Override
	public String toString() {
		return "InputData{" + "data=" + data + '}';
	}
	
}
