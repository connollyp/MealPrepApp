package mealPrep;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseCommands {
	
	public static void connectToDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mealprep", "root", "");
			System.out.print("Database is connected !");
			conn.close();
		}
		catch(Exception e) {
			System.out.print("Do not connected to DB - Error: " + e);
		}
	}

}
