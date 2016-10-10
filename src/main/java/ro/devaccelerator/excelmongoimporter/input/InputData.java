package ro.devaccelerator.excelmongoimporter.input;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author bogdan
 */
public class InputData {

	protected Map<String, String> data = new LinkedHashMap<>();
	protected Map<String, String> dataTypes = new LinkedHashMap<>();

	public void add(String name, String value) {
		data.put(name, value);
		dataTypes.put(name, "string");
	}
	
	public void add(String name, String value, String type) {
		data.put(name, value);
		dataTypes.put(name, type);
	}

	@Override
	public String toString() {
		return "InputData{" + "data=" + data + '}';
	}
	
	public Map<String, Object> copyToMap(Map<String, Object> map){
		data.keySet().stream().forEach((column) -> {
			if(dataTypes.get(column).equals("number")){
				try{
					map.put(column,Integer.parseInt(data.get(column)));
				} catch(NumberFormatException nfe){
					map.put(column, data.get(column));
				}
			}
			else if (dataTypes.get(column).equals("boolean")){
				map.put(column, Boolean.parseBoolean(data.get(column)));
			}
			else{
				String value = data.get(column);
				if(value.equals("GEN_GUID")){
					value = UUID.randomUUID().toString().replace("-", "").substring(0,12);
				}
				map.put(column, value);
			}
		});
		return map;
	}

}
