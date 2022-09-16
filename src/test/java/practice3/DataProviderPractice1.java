package practice3;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericUtility.ExcelFileUtility;

public class DataProviderPractice1 {

	@Test (dataProvider="OrgName")
 public void addProductToCart(String OrgName,String IndustryType) {
	System.out.println(OrgName+"-"+IndustryType);
} 

//@DataProvider  (name="product")
//public Object[][] getdata(){
//	Object[][] d=new Object[4][5];
	
//	d[0][0]="Samsung";
//	d[0][1]="A80";	
//	d[0][2]=3000;
//	d[0][3]="Camera";
//	d[0][4]=12;
//
//	d[1][0]="Vivo";
//	d[1][1]="A8";	
//	d[1][2]=30000;
//	d[1][3]="Camera";
//	d[1][4]=12;
//	
//	d[2][0]="Oppo";
//	d[2][1]="V1";	
//	d[2][2]=30000;
//	d[2][3]="Security";
//	d[2][4]=12;
//	
//	d[3][0]="iphone";
//	d[3][1]="13Pro";	
//	d[3][2]=30009;
//	d[3][3]="Seecure";
//	d[3][4]=15;
	
//	return d;
//}

	@DataProvider(name="OrgName")
	public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		ExcelFileUtility eUtil=new ExcelFileUtility();
		Object[][] data=eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
	
}
