package pom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlarun {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;

	public Xlarun(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
	}

	public String getCellData(String sheetName, String coloumName, int rowNumber) {

		int index = workbook.getSheetIndex(sheetName);

		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		int coloumNumber = 0;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(coloumName.trim()))
				coloumNumber = i;
		}

		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNumber - 1);

		cell = row.getCell(coloumNumber);

		if (cell.getCellType().equals(CellType.STRING)) {
			return cell.getStringCellValue();

		} else if (cell.getCellType().equals(CellType.NUMERIC)) {
			return String.valueOf(cell.getNumericCellValue());

		} else if (cell.getCellType().equals(CellType.FORMULA)) {
			return cell.getCellFormula();

		} else if (cell.getCellType().equals("DATE")) {
			return String.valueOf(cell.getDateCellValue());

		} else if (cell.getCellType().equals(CellType.BOOLEAN)) {
			return String.valueOf(cell.getBooleanCellValue());
		} else {
			return null;
		}

	}
}
