package vTiger.practice2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel4 {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException  {
		//1. load the file into file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//2. Store workbook in workbook factory
		Workbook wb=WorkbookFactory.create(fis);
	    //3. naavigate to sheet
		Sheet sh=wb.getSheet("Organisation");
	    //4. Navigate to row
	    Row row=sh.getRow(4);
	    //5. navigate to cell
	    Cell cell=row.getCell(1);
	    //6. read the response cell value
	    String value=cell.getStringCellValue();
        System.out.println(value);
}

}
