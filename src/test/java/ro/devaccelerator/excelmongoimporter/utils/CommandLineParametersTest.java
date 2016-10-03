package ro.devaccelerator.excelmongoimporter.utils;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * CommandLineParameters unit tests
 * Should document command line usage capabilities
 * @author bogdan
 */
public class CommandLineParametersTest {
	CommandLineParameters parameters;
	
	@Test
	public void itWorks(){
		parameters = new CommandLineParameters(new String[]{}); 
		assertNotNull(parameters);
	}
	
	@Test
	public void hasInputParameters_true(){
		String[] stringParameters = new String[]{"-input", "file.xls"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasInputParameters());
	}
	
		
	@Test
	public void hasInputParameters_false(){
		String[] stringParameters = new String[]{"-collection", "collectionName"};
		parameters = new CommandLineParameters(stringParameters); 
		assertFalse(parameters.hasInputParameters());
	}
			
	@Test
	public void hasInputParameters_false_when_malformed(){
		String[] stringParameters = new String[]{"-input", "-collection", "collectionName"};
		parameters = new CommandLineParameters(stringParameters); 
		assertFalse(parameters.hasInputParameters());
	}
	
	@Test
	public void hasInputParameters_false_when_empty(){
		String[] stringParameters = new String[]{};
		parameters = new CommandLineParameters(stringParameters); 
		assertFalse(parameters.hasInputParameters());
	}
	
	@Test
	public void two_parameters_complete(){
		String[] stringParameters = new String[]{"-input", "file.xls", "-collection", "collectionName"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasInputParameters());
	}
	
	@Test
	public void hasOutputParameters_true(){
		String[] stringParameters = new String[]{"-input", "file.xls", "-collection", "collectionName", "-database", "db"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasOutputParameters());
		assertTrue(parameters.getInputFile().equals("file.xls"));
		assertTrue(parameters.getCollectionName().equals("collectionName"));
	}	
	
		
	@Test
	public void getInputFile(){
		String[] stringParameters = new String[]{"-input", "file.xls", "-collection", "collectionName"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.getInputFile().equals("file.xls"));
	}	
	
		
	@Test
	public void getCollectionName(){
		String[] stringParameters = new String[]{"-input", "file.xls", "-collection", "collectionName"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.getCollectionName().equals("collectionName"));
	}	
	
	@Test
	public void getServer(){
		String[] stringParameters = new String[]{"-input", "file.xls", "-collection", "collectionName", "-server", "myserver.com"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.getServer().equals("myserver.com"));
	}	
	
	@Test
	public void hasOutputParameters_false(){
		String[] stringParameters = new String[]{"-input", "file.xls"};
		parameters = new CommandLineParameters(stringParameters); 
		assertFalse(parameters.hasOutputParameters());
	}
	
	@Test
	public void hasMinimumParameters_false(){
		String[] stringParameters = new String[]{"-input", "file.xls"};
		parameters = new CommandLineParameters(stringParameters); 
		assertFalse(parameters.hasMinimumParameters());
	}
	
	@Test
	public void getPortParameter_withParam(){
		String[] stringParameters = new String[]{"-port", "20000"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasParam(CommandLineParameters.OUTPUT_PORT_PARAM));
		assertEquals("20000", parameters.getPort());
	}
	
	@Test
	public void getDatabase_withParam(){
		String[] stringParameters = new String[]{"-database", "db"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasParam(CommandLineParameters.OUTPUT_DATABASE_PARAM));
		assertEquals("db", parameters.getDatabaseName());
	}
	
	@Test
	public void getPortParameter_default_withInvalidParam(){
		String[] stringParameters = new String[]{"-port", "200a0"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasParam(CommandLineParameters.OUTPUT_PORT_PARAM));
		assertEquals(CommandLineParameters.DEFAULT_PORT, parameters.getPort());
	}
	
	@Test
	public void getPortParameter_defaultParam(){
		String[] stringParameters = new String[]{"-input", "file.xls"};
		parameters = new CommandLineParameters(stringParameters); 
		assertTrue(parameters.hasParam(CommandLineParameters.OUTPUT_PORT_PARAM));
		assertEquals(CommandLineParameters.DEFAULT_PORT, parameters.getPort());
	}
	
}
