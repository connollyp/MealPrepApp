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
			//System.out.println("Connected to Database!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static void printMetaData(ResultSet rs) throws SQLException {
		
		int colNum = rs.getMetaData().getColumnCount();
		
		int i = 1;
		
		System.out.println();
		while(i <= colNum) {
			System.out.print(rs.getMetaData().getColumnName(i) + "\t");
			
			i++;
		}
		System.out.println();
	}

	public static void viewFoodOrMealTable(String Table) throws SQLException {
		Connection conn = getConnection();
		
		
		Statement stmt = null;
		String query = "SELECT * FROM " + "mealprep" + "." + Table;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			
			printMetaData(rs);

			while (rs.next()) {
				int Id = rs.getInt(1);
				String Name = rs.getString(2);
				int Calories = rs.getInt(3);
				double Protein = rs.getDouble(4);
				double Carbs = rs.getDouble(5);
				double Fat = rs.getDouble(6);
				double Sugar = rs.getDouble(7);
				boolean Vegan = rs.getBoolean(8);
				boolean Vegetarian = rs.getBoolean(9);
				int StandardServing = rs.getInt(10);
				String ServingUnit = rs.getString(11);
				System.out.println(
						Id + "\t" + Name + "\t" + Calories + "\t" + 
								Protein + "\t" + Carbs + "\t" + Fat + 
								"\t" + Sugar + "\t" + Vegan + "\t" + 
								Vegetarian + "\t" + StandardServing + 
								"\t" + ServingUnit);
			}
			
			System.out.println();
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	public static int getCalories(String table, String name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;

		String query = "SELECT Calories FROM " + table 
							+ " WHERE Name = '" + name + "'";

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

	public static double getProtein(String table, String name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;

		String query = "SELECT Protein FROM " + table 
							+ " WHERE Name = '" + name + "'";

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
	
	public static double getCarbs(String table, String Name) throws SQLException{
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		double Carbs = 0;
		
		String query = "SELECT Carbs FROM " + table 
							+ " WHERE Name = '" + Name + "'";
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Carbs = rs.getDouble("Carbs");
				
				return Carbs;
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		return Carbs;
	}
	
	public static double getFat(String table, String Name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		double Fat = 0;
		
		String query = "SELECT Fat FROM " + table 
							+ " WHERE Name = '" + Name + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Fat = rs.getDouble("Fat");
				
				return Fat;
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally{
			if(stmt != null) {
				stmt.close();
			}
		}
		return Fat;
	}

	public static double getSugar(String table, String Name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		double Sugar = 0;
		
		String query = "SELECT Sugar FROM " + table 
							+ " WHERE Name = '" + Name + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Sugar = rs.getDouble("Sugar");
				
				return Sugar;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Sugar;
	}
	
	public static boolean getVegan(String table, String name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		boolean Vegan = false;
		
		String query = "SELECT Vegan FROM " + table 
							+ " WHERE Name = '" + name + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Vegan = rs.getBoolean("Vegan");
				
				return Vegan;
			}
			
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Vegan;
	}
	
	public static boolean getVegetarian(String table, String name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		boolean Vegetarian = false;
		
		String query = "SELECT Vegetarian FROM " + table 
							+ " WHERE Name = '" + name + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Vegetarian = rs.getBoolean("Vegetarian");
				
				return Vegetarian;
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		return Vegetarian;
	}
	
	public static int getStandardServing(String table, String name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		int StandardServing = 1;
		
		String query = "SELECT StandardServing FROM " + table 
							+ " WHERE Name = '" + name + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				StandardServing = rs.getInt("StandardServing");
				
				return StandardServing;
			}
			
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		return StandardServing;
	}
	
	public static String getServingUnit(String table, String name) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		String ServingUnit = "";
		
		String query = "SELECT ServingUnit FROM " + table 
							+ " WHERE Name = '" + name + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				ServingUnit = rs.getString("ServingUnit");
				
				return ServingUnit;
			}
			
			rs.close();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		return ServingUnit;
	}

	public static void inputFood(String Name, int Calories, double Protein, double Carbs, double Fat, double Sugar, boolean Vegan, boolean Vegetarian, int StandardServing, String ServingUnit) throws SQLException{
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		int ID = 0;
		
		String query = "SELECT MAX(FId) FROM foods_t";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				ID = rs.getInt(1) + 1;
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
		query = "INSERT INTO foods_t VALUES (" + ID + ", '" + Name 
					+ "', " + Calories + ", " + Protein + ", " + Carbs 
					+ ", " + Fat + ", " + Sugar + ", " + Vegan + ", "
					+ Vegetarian + ", " + StandardServing + ", '" 
					+ ServingUnit + "');";
		
		try {
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);
			
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
	}
	
	public static void inputMeal(String Name, int Calories, double Protein, double Carbs, double Fat, double Sugar, boolean Vegan, boolean Vegetarian) throws SQLException{
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		int ID = 0;
		
		String query = "SELECT MAX(MId) FROM meals_t";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				ID = rs.getInt(1) + 1;
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
		query = "INSERT INTO meals_t VALUES (" + ID + ", '" + Name 
					+ "', " + Calories + ", " + Protein + ", " + Carbs 
					+ ", " + Fat + ", " + Sugar + ", " + Vegan + ", "
					+ Vegetarian + ");";
		
		try {
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);
			
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
	}
	
	public static void updateFoodsInMeal(String mealName, String foodName, double serving, String unit) throws SQLException {
		Connection conn = getConnection();
		
		Statement stmt = null;
		
		int FId = 0;
		
		String query = "SELECT MAX(FId) FROM foods_t WHERE Name = '" + foodName + "'";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				FId = rs.getInt(1);
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
		int MId = 0;
		
		query = "SELECT MAX(MId)  FROM meals_t WHERE Name = '" + mealName + "'";

		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				MId = rs.getInt(1);
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
		query = "INSERT INTO foodsinmeal_t VALUES ( " + FId + ", " + MId + ", " + serving + ");";
		
		try {
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		
	}

}
