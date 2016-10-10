/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.devaccelerator.excelmongoimporter.input;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author bogdan
 */
public class InputDataReaderBaseTest {
	
	@Test
	public void getStringType_num(){
		InputDataReaderBase base = new InputDataReaderBase();
		assertEquals("number", base.getStringType(0));
	}
	
	@Test
	public void getStringType_string(){
		InputDataReaderBase base = new InputDataReaderBase();
		assertEquals("string", base.getStringType(1));
	}
		
	@Test
	public void getStringType_bool(){
		InputDataReaderBase base = new InputDataReaderBase();
		assertEquals("boolean", base.getStringType(4));
	}
	
	@Test
	public void getStringType_default(){
		InputDataReaderBase base = new InputDataReaderBase();
		assertEquals("string", base.getStringType(9));
	}
}
