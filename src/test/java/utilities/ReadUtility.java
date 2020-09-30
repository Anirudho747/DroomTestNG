package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadUtility {
	
	Properties prop = null;
	public String path = "./src/test/resources/configuration/config.properties";
	

	public ReadUtility() {
		try{
		FileInputStream fis = new FileInputStream (path);
		prop = new Properties();
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("ReadUtility Class");
		}
	}
	
	public String getWebsite()
	{
		return(prop.getProperty("url"));
	}

}
