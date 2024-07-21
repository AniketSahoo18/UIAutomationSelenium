package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static DataFormatter formatter = new DataFormatter();
	private static FileInputStream fis;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;

	public static Object[][] getTestDataMap(String inputPath, String sheetName) throws IOException {

		fis = new FileInputStream(inputPath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {

			row = sheet.getRow(i + 1);

			for (int j = 0; j < colCount; j++) {

				XSSFCell cell = row.getCell(j);

				data[i][j] = formatter.formatCellValue(cell);
			}
		}

		return data;
	}

}
