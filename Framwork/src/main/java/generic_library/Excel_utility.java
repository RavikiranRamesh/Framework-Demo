package generic_library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using Apache POI libraries, used to handle MS Excel sheet
 * @author Ravikiran
 * 
 *
 */
public class Excel_utility {
	/**
	 * It is used to read the data from excel based on the arguments
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 */
	
	public String getExceldata(String sheetname,int rownum,int cellnum){
		String data= null;
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/data/TestData.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			Row row = sh.getRow(rownum);
			data=row.getCell(cellnum).getStringCellValue();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
		
	}

}
