package rhl.data;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenFromExcel {


    public Object[][] getExcelData(String filePath, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][1]; // excluding header

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            HashMap<String, String> map = new HashMap<>();

            for (int j = 0; j < colCount; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = row.getCell(j).getStringCellValue();
                map.put(key, value);
            }
            data[i - 1][0] = map;
        }

        workbook.close();
        fis.close();
        return data;
    }
}
