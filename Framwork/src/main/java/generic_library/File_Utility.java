package generic_library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Ravikiran
 *  
 *
 */

public class File_Utility {
	/**
	 * Its used to read data from commonData.properties file based on key which we pass as an argument
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	
	public String getProperty(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/main/resources/Commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}
