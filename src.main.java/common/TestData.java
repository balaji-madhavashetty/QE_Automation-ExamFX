package common;

import utils.ReadPropertyFile1;
import java.util.Properties;

/**
 * Common Utility Class to read Test Data from testdata.properties file
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class TestData {
	public static String testDataFileName = "testData.properties";
	public Properties testDataFile;
	
	public TestData (){
		testDataFile = new ReadPropertyFile1().readPropertyFile(testDataFileName);
	}	
	
	public String get(String key){		
		String value = testDataFile.getProperty(key);		
		return value;			
	}	
}
