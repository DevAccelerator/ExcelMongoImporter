package ro.devaccelerator.excelmongoimporter.input;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
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
	
	@Test
	public void copyToMap_GEN_GUID(){
		InputData data = new InputData();
		data.add("Column", "GEN_GUID");
		
		Map<String, Object> map = new HashMap<>();
		data.copyToMap(map);
		
		assertTrue(((String)map.get("Column")).length()==12);
	}
	
	@Test
	public void copyToMap_number(){
		InputData data = new InputData();
		data.add("Column", "5", "number");
		
		Map<String, Object> map = new HashMap<>();
		data.copyToMap(map);
		
		assertEquals( 5, map.get("Column"));
	}
	
	@Test
	public void copyToMap_bool_true(){
		InputData data = new InputData();
		data.add("Column", "true", "boolean");
		
		Map<String, Object> map = new HashMap<>();
		data.copyToMap(map);
		
		assertTrue( (Boolean) map.get("Column"));
	}
		
	@Test
	public void copyToMap_bool_false(){
		InputData data = new InputData();
		data.add("Column", "false", "boolean");
		
		Map<String, Object> map = new HashMap<>();
		data.copyToMap(map);
		
		assertFalse( (Boolean) map.get("Column"));
	}
}
