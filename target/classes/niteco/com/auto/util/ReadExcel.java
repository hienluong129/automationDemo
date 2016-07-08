package niteco.com.auto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import niteco.com.auto.model.NewUser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

public static Sheet sh;
public static Cell cell;
public static Row row;
public static NewUser newUser;
public static Workbook wb;
public static FileInputStream inputStream;
public static FileOutputStream outputStream;
public static ArrayList<NewUser> userList;
public static void  setExcelFile(String path, String fileName,String sheetName) throws Exception{
	try{
		FileInputStream inputStream= new FileInputStream(path);
		
		String fileExtendsionName= fileName.substring(fileName.indexOf("."));
		if(fileExtendsionName.equals(".xlsx")){
			wb= new XSSFWorkbook(inputStream);
		}
		else if(fileExtendsionName.equals(".xls")){
			wb= new HSSFWorkbook(inputStream);
		}
		sh = wb.getSheet(sheetName);
//		wb.close();
	}
	catch(Exception e){
		throw(e);
	}
}
public static String getCellData(int row, int col) throws Exception{
	try {
		cell= sh.getRow(row).getCell(col);
		String cellData= cell.getStringCellValue();
		return cellData;
	}
	catch(Exception e){
		return"";
	}
}
public static List<NewUser> read(String filePath,String fileName, String sheetName)throws Exception{
	try{
		
		
		userList= new ArrayList<NewUser>();

		setExcelFile(filePath,fileName,sheetName);
		int rowCount= sh.getLastRowNum()-sh.getFirstRowNum();
		for (int i =0; i<rowCount; i++){
			Row row=sh.getRow(i+1);
			newUser= new NewUser();
			newUser.setUserName(row.getCell(0).getStringCellValue());
			newUser.setGender(row.getCell(1).getStringCellValue());
			newUser.setDob(row.getCell(2).getStringCellValue());
			newUser.setAddress(row.getCell(3).getStringCellValue());
			newUser.setCity(row.getCell(4).getStringCellValue());
			newUser.setState(row.getCell(5).getStringCellValue());
			newUser.setPin(row.getCell(6).getStringCellValue());
			newUser.setPhone(row.getCell(7).getStringCellValue());
			newUser.setEmail(row.getCell(8).getStringCellValue());
			newUser.setPass(row.getCell(9).getStringCellValue());
			
			userList.add(newUser);
		}
		return userList;
		
	}
	catch(Exception e)
	{
		return null;
	}
	
}
public static void setCellData(String value,int r, int c){
	row= sh.getRow(r);
	cell= row.getCell(c,row.RETURN_BLANK_AS_NULL);
	if (cell == null) { 
		cell = row.createCell(c);
		cell.setCellValue(value);
		} else {
			cell.setCellValue(value);
		}
}
public static void write(String filePath, String fileName, String sheetName,String result,int c)throws Exception{
	setExcelFile(filePath,fileName,sheetName);
	int rowCount= sh.getLastRowNum()-sh.getFirstRowNum();
	for (int i =0; i<rowCount; i++){
		setCellData(result,i+1,c);
		System.out.println(sh.getRow(i+1).getCell(c).getStringCellValue());
	}
	//inputStream.close();
	outputStream= new FileOutputStream(filePath);
	wb.write(outputStream);
	outputStream.close();
	System.out.println("Success");
	
}

}
