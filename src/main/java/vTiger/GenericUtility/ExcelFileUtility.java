package vTiger.GenericUtility;
import java.io.File;
/**
/ * This class contains generic methods to read and write data from excel file	
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {
	/**
	 * This method will read the data from excel sheet and return the value 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, InvalidFormatException, IOException {

	FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
    Workbook wb=WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheet);
    Row r=sh.getRow(row);
    Cell cel=r.getCell(cell);
    String value=cel.getStringCellValue();
    wb.close();
    return value;
	
	}
	/**This method will return the last row number in particular sheet
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheet);
	    int lastRow=sh.getLastRowNum();
	    wb.close();
	    return lastRow;
	}
	/**
	 * This method will write the data into excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	
	public void writeDataIntoExcel(String sheet, int row,int cell,String value) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheet);
	    Row r=sh.getRow(row);
	    Cell cel=r.createCell(cell);
	    cel.setCellValue(value);
	    
	    FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelFilePath);
	    wb.write(fos);
	    wb.close();
	}
	
	/**
	 * This method is used to execute the test script with multiple set of data
	 * Hence it will return 2Dimensinal array object  so it can be directly 
	 * used in dataprovider
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	
	public Object[][] readMultipleDataFromExcel(String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastrow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
	
	return data;
	}
}