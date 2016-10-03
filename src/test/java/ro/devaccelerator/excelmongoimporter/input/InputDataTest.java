package ro.devaccelerator.excelmongoimporter.input;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author bogdan
 */
public class InputDataTest {
	
	@Test
	public void copyToMap(){
		InputData data = new InputData();
		data.add("Column", "Value");
		
		Map<String, Object> map = new HashMap<>();
		data.copyToMap(map);
		
		assertEquals("Value", map.get("Column"));
	}
}
