package ua.neoservice.parser;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ua.neoservice.model.Product;


public class ProductParser {
	
	
	
	public List<Product> parseFile(String fileName) {
		List<Product> result = new ArrayList<Product>();
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			Workbook workbook = new HSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				Product Product = parseRow(row);
				result.add(Product);
			}
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Product parseRow(Row row) {
		String auto = row.getCell(0).getStringCellValue();
		String code = checkNotNull(row, 1);
		String number = checkNotNull(row, 2);
		String analog = checkNotNull(row, 3);
		String brand = row.getCell(4).getStringCellValue();
		String description = row.getCell(5).getStringCellValue();
		String model = row.getCell(6).getStringCellValue();
		
		float priceFloat = (float) row.getCell(7).getNumericCellValue();
		BigDecimal price = BigDecimal.valueOf(priceFloat);
		
		return new Product(auto, code, number, analog, brand, description, model, price);
	}

	private String checkNotNull(Row row, int i) {
		Cell cell = row.getCell(i);
		String result = "";
		if (cell != null) {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				result = Integer.toString((int) cell.getNumericCellValue());
			} else {
				result = cell.getStringCellValue();
			}
		}
		return result;
	}
}
