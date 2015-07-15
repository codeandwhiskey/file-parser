package ua.neoservice.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ua.neoservice.model.Product;

public class SQLiteDAO {

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConn() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:rsb_shop_db.db");
	}

	public void createTable() {
		try (Connection connection = getConn()) {
			String query = "CREATE TABLE `test` ("+
					"`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
					"`auto`	TEXT NOT NULL,"+
					"`code`	TEXT NOT NULL,"+
					"`number`	TEXT NOT NULL,"+
					"`analog`	TEXT,"+
					"`brand`	TEXT NOT NULL,"+
					"`description`	TEXT NOT NULL,"+
					"`model`	TEXT NOT NULL,"+
					"`price`	REAL NOT NULL)";

			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addProduct(Product p, Connection connection) {
		try {
			String query = "insert into test (auto, code, number, analog, brand, description, model, price) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, p.getAuto());
			stmt.setString(2, p.getCode());
			stmt.setString(3, p.getNumber());
			stmt.setString(4, p.getAnalog());
			stmt.setString(5, p.getBrand());
			stmt.setString(6, p.getDescription());
			stmt.setString(7, p.getModel());
			stmt.setBigDecimal(8, p.getPrice());

			stmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public void addProductList(List<Product> list) throws SQLException {
		Connection connection = getConn();
		for (int i = 0; i < list.size(); i++) {
			addProduct(list.get(i), connection);
		}
		connection.close();
	}

}
