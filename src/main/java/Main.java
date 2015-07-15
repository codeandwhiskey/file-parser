import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;

import ua.neoservice.DAO.SQLiteDAO;
import ua.neoservice.model.Product;
import ua.neoservice.parser.ProductParser;

public class Main {
	private static List<Product> list = new ArrayList<Product>();
	private static String fileName = "test.xls";

	public static void main(String[] args) throws InvalidFormatException, IOException, XmlException {

		SQLiteDAO dao = new SQLiteDAO();
		ProductParser parser = new ProductParser();
		
		long delta = System.currentTimeMillis();
		list = parser.parseFile(fileName);
				

		dao.createTable();
		try {
			dao.addProductList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println((System.currentTimeMillis() - delta) + "ms");

	}

}
