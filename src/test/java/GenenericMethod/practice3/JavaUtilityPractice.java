package GenenericMethod.practice3;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertyFileUtility;

public class JavaUtilityPractice {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		JavaUtility jut=new JavaUtility();
		int randomnum = jut.getRandomNumber();
		System.out.println(randomnum);
		String dateNotInFormat = jut.getSystemDate();
		System.out.println(dateNotInFormat);
		String dateInFormat = jut.getSystemdateInFormat();
		System.out.println(dateInFormat);
	
	    PropertyFileUtility pLib = new PropertyFileUtility();
	    String b=pLib.readDataFromPropertyFile("browser");
	    System.out.println(b);
	    
	    ExcelFileUtility eLib = new ExcelFileUtility();
	    String data=eLib.readDataFromExcel("Organisation", 1, 2);
	    eLib.writeDataIntoExcel("Organisation", 7, 2, "Hi to Priya");
	    System.out.println(data);
	}

}
