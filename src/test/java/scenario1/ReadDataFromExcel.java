package scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	
	String fpath = System.getProperty("user.dir") + "/test/userDetail.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

  @Test(enabled=false)
  public void ReadData() {
	  row = sheet.getRow(0);
	  cell = row.getCell(0);
	  
	  Reporter.log(cell.getStringCellValue(),true);
	  
	  Reporter.log(sheet.getRow(0).getCell(1).getStringCellValue(), true);
	  Reporter.log(sheet.getRow(0).getCell(2).getStringCellValue(), true);
	    }
  
  	@Test
  	public void ReadAllData() {
  		
  		int totalRows = sheet.getPhysicalNumberOfRows();
  		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
  		for(int i = 0; i<totalRows; i++) {
  			row = sheet.getRow(i);
  			for(int j = 0; j< totalCells; j++) {
  				cell = row.getCell(j);
  				System.out.println("\t"+cell.getStringCellValue());
  			}
  				System.out.println();
  		}
  	}
  	
  	@BeforeTest
  	public void beforTest() throws IOException {
  		file = new File(fpath);
  		fis = new FileInputStream(file);
  		wb = new XSSFWorkbook(fis);
  		sheet = wb.getSheet("userdata");
  	}
  	@AfterTest
  	public void afterTest() throws IOException {
  		wb.close();
  		fis.close();
  	}
  	
}
