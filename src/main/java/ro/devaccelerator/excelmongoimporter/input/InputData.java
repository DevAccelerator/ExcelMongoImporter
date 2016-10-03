package ro.devaccelerator.excelmongoimporter.input;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author bogdan
 */
public class InputData {

	protected Map<String, String> data = new LinkedHashMap<>();

	public void add(String name, String value) {
		data.put(name, value);
	}

	@Override
	public String toString() {
		return "InputData{" + "data=" + data + '}';
	}
	
	public Map<String, Object> copyToMap(Map<String, Object> map){
		data.keySet().stream().forEach((column) -> {
			map.put(column, data.get(column));
		});
		return map;
	}

}
