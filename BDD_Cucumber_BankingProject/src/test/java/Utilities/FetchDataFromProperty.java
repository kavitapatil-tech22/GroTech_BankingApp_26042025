package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Constants.ConstantsData;

public class FetchDataFromProperty {
	
	public static Properties readDataFromProperty() throws IOException
	{
		FileReader reader=new FileReader(ConstantsData.PropertyFilePath);
		Properties prop=new Properties();
		prop.load(reader);
		return prop;
		
		
	}
	

}
