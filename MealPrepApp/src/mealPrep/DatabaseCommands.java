package mealPrep;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseCommands {

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try (FileInputStream f = new FileInputStream("config.properties")) {
			// load the properties file
			Properties pros = new Properties();
			pros.load(f);

			// assign db parameters
			String url = pros.getProperty("url");
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			// create a connection to the database
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to Database!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void viewFoods(Connection conn) throws SQLException {

		Statement stmt = null;
		String query = "SELECT * FROM " + "mealprep" + ".Foods_t";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int FId = rs.getInt("FId");
				String Name = rs.getString("Name");
				int Calories = rs.getInt("Calories");
				double Protein = rs.getDouble("Protein");
				double Carbs = rs.getDouble("Carbs");
				double Fat = rs.getDouble("Fat");
				double Sugar = rs.getDouble("Sugar");
				boolean Vegan = rs.getBoolean("Vegan");
				boolean Vegetarian = rs.getBoolean("Vegetarian");
				int StandardServing = rs.getInt("StandardServing");
				String ServingUnit = rs.getString("ServingUnit");
				System.out.println(
						FId + "\t" + Name + "\t" + Calories + "\t" + 
								Protein + "\t" + Carbs + "\t" + Fat + 
								"\t" + Sugar + "\t" + Vegan + "\t" + 
								Vegetarian + "\t" + StandardServing + 
								"\t" + ServingUnit);
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	public static int getFoodCalories(Connection conn, String name) throws SQLException {
		Statement stmt = null;

		String query = "SELECT Calories FROM foods_t WHERE Name = '" + name + "'";

		int Calories = 0;
		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Calories = rs.getInt("Calories");
				return Calories;
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Calories;
	}

	public static double getFoodProtein(Connection conn, String name) throws SQLException {
		Statement stmt = null;

		String query = "SELECT Protein FROM foods_t WHERE Name = '" + name + "'";

		double Protein = 0;
		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Protein = rs.getDouble("Protein");
				return Protein;
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Protein;
	}
	

}
