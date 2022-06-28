package data;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    static FileInputStream fis=null;
    public static FileInputStream getFileInputStream(){
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return fis;
    }
    public static Object[][] getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int totalNumberOfRows =(sheet.getLastRowNum() + 1);
        int totalNumberOfColumns =4;
        String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];

        for(int i=0;i<totalNumberOfRows;i++){
            for(int j=0;j<totalNumberOfColumns;j++){
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return arrayExcelData;
    }
}
