package vTiger.practice2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//1. load the file into file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\login_propertyfiles");
		//2. Create the object for property from java
		Properties pobj=new Properties();
		//3. load the file object into property object
		pobj.load(fis);
		//4. read data through key
		String URL=pobj.getProperty("url");
		System.out.println(URL);
		
		String BROWSER=pobj.getProperty("browser");
		System.out.println(BROWSER);
             
	}

}
