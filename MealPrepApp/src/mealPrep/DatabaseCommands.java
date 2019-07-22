package mealPrep;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

public class DatabaseCommands {

	/**
	 * Creates and returns a connection to the a database specified in the config
	 * file
	 * 
	 * @return Connection to the database
	 * @throws SQLException
	 */
	private static Connection getConnection() throws SQLException {
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
			// System.out.println("Connected to Database!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Prints the meta data for a given table
	 * 
	 * @param rs
	 *            The ResultSet who's meta data is being sought
	 * @throws SQLException
	 */
	private static void printMetaData(ResultSet rs) throws SQLException {

		int colNum = rs.getMetaData().getColumnCount();

		int i = 1;

		System.out.println();
		while (i <= colNum) {
			System.out.print(rs.getMetaData().getColumnName(i) + "\t");

			i++;
		}
		System.out.println();
	}

	/**
	 * Prints a Food or Meal table to the console
	 * 
	 * @param Table
	 *            The table that is being printed
	 * @throws SQLException
	 */
	@SuppressWarnings("unused")
	private static void viewFoodOrMealTable(String Table) throws SQLException {
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
						Id + "\t" + Name + "\t" + Calories + "\t" + Protein + "\t" + Carbs + "\t" + Fat + "\t" + Sugar
								+ "\t" + Vegan + "\t" + Vegetarian + "\t" + StandardServing + "\t" + ServingUnit);
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

	/**
	 * Returns the name of an element from a table based on the Id passed to the
	 * method
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Id
	 *            The Id for the element that is being sought
	 * @return The name of the element
	 * @throws SQLException
	 */
	public static String getName(String table, int Id) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		String query = "";

		if (table == "foods_t") {
			query = "SELECT Name FROM " + table + " WHERE FId = " + Id;
		} else if (table == "meals_t") {
			query = "SELECT Name FROM " + table + " WHERE MId = " + Id;
		}

		String Name = "";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Name = rs.getString(1);
				return Name;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return Name;
	}

	/**
	 * Returns the number of Calories in an element from a table based on the Id
	 * passed to the method
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The number of Calories in the element
	 * @throws SQLException
	 */
	public static int getCalories(String table, String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		String query = "SELECT Calories FROM " + table + " WHERE Name = '" + name + "'";

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

	/**
	 * Returns the amount of Protein in an element from a table based on the Id
	 * passed to the method
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The amount of Protein in the element
	 * @throws SQLException
	 */
	public static double getProtein(String table, String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		String query = "SELECT Protein FROM " + table + " WHERE Name = '" + name + "'";

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

	/**
	 * Returns the amount of Carbs in an element from a table based on the Id passed
	 * to the method
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The amount of Carbs in the element
	 * @throws SQLException
	 */
	public static double getCarbs(String table, String Name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Carbs = 0;

		String query = "SELECT Carbs FROM " + table + " WHERE Name = '" + Name + "'";
		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Carbs = rs.getDouble("Carbs");

				return Carbs;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Carbs;
	}

	/**
	 * Returns the amount of Fat in an element from a table based on the Id passed
	 * to the method
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The amount of Fat in the element
	 * @throws SQLException
	 */
	public static double getFat(String table, String Name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Fat = 0;

		String query = "SELECT Fat FROM " + table + " WHERE Name = '" + Name + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Fat = rs.getDouble("Fat");

				return Fat;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Fat;
	}

	/**
	 * Returns the amount of Sugar in an element from a table based on the Id passed
	 * to the method
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The amount of Sugar in the element
	 * @throws SQLException
	 */
	public static double getSugar(String table, String Name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Sugar = 0;

		String query = "SELECT Sugar FROM " + table + " WHERE Name = '" + Name + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Sugar = rs.getDouble("Sugar");

				return Sugar;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Sugar;
	}

	/**
	 * Returns whether the element in table is Vegan or not
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The boolean value of whether or not the element is Vegan
	 * @throws SQLException
	 */
	public static boolean getVegan(String table, String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		boolean Vegan = false;

		String query = "SELECT Vegan FROM " + table + " WHERE Name = '" + name + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Vegan = rs.getBoolean("Vegan");

				return Vegan;
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Vegan;
	}

	/**
	 * Returns whether the element in table is Vegetarian or not
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param Name
	 *            The name of the element being sought
	 * @return The boolean value of whether or not the element is Vegetarian
	 * @throws SQLException
	 */
	public static boolean getVegetarian(String table, String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		boolean Vegetarian = false;

		String query = "SELECT Vegetarian FROM " + table + " WHERE Name = '" + name + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Vegetarian = rs.getBoolean("Vegetarian");

				return Vegetarian;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return Vegetarian;
	}

	/**
	 * Returns the standard serving for an element based on its name
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param name
	 *            the name of the element being sought
	 * @return The standard serving of the element
	 * @throws SQLException
	 */
	public static int getStandardServing(String table, String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int StandardServing = 1;

		String query = "SELECT StandardServing FROM " + table + " WHERE Name = '" + name + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				StandardServing = rs.getInt("StandardServing");

				return StandardServing;
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return StandardServing;
	}

	/**
	 * Returns the unit of the standard serving for an element based on its name
	 * 
	 * @param table
	 *            The table that the element is contained in
	 * @param name
	 *            the name of the element being sought
	 * @return The unit of the standard serving of the element
	 * @throws SQLException
	 */
	public static String getServingUnit(String table, String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		String ServingUnit = "";

		String query = "SELECT ServingUnit FROM " + table + " WHERE Name = '" + name + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ServingUnit = rs.getString("ServingUnit");

				return ServingUnit;
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return ServingUnit;
	}

	/**
	 * Inputs a Food into the Food table of the database
	 * 
	 * @param Name
	 *            The name of the Food
	 * @param Calories
	 *            The amount of Calories in Food
	 * @param Protein
	 *            The amount of Protein in Food
	 * @param Carbs
	 *            The amount of Carbs in Food
	 * @param Fat
	 *            The amount of Fat in Food
	 * @param Sugar
	 *            The amount of Sugar in Food
	 * @param Vegan
	 *            Whether Food is Vegan or not
	 * @param Vegetarian
	 *            Whether Food is Vegetarian or not
	 * @param StandardServing
	 *            The Standard Serving of Food
	 * @param ServingUnit
	 *            The Unit of the Standard Serving of Food
	 * @throws SQLException
	 */
	public static void inputFood(String Name, int Calories, double Protein, double Carbs, double Fat, double Sugar,
			boolean Vegan, boolean Vegetarian, int StandardServing, String ServingUnit) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int ID = 0;

		String query = "SELECT MAX(FId) FROM foods_t";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ID = rs.getInt(1) + 1;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		query = "INSERT INTO foods_t VALUES (" + ID + ", '" + Name + "', " + Calories + ", " + Protein + ", " + Carbs
				+ ", " + Fat + ", " + Sugar + ", " + Vegan + ", " + Vegetarian + ", " + StandardServing + ", '"
				+ ServingUnit + "');";

		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * Inputs a Meal into the Meal table in the database
	 * 
	 * @param Name
	 *            The name of the Meal
	 * @param Calories
	 *            The amount of Calories in Meal
	 * @param Protein
	 *            The amount of Protein in Meal
	 * @param Carbs
	 *            The amount of Carbs in Meal
	 * @param Fat
	 *            The amount of Fat in Meal
	 * @param Sugar
	 *            The amount of Sugar in Meal
	 * @param Vegan
	 *            Whether Meal is Vegan or not
	 * @param Vegetarian
	 *            Whether Meal is Vegetarian or not
	 * @throws SQLException
	 */
	public static void inputMeal(String Name, int Calories, double Protein, double Carbs, double Fat, double Sugar,
			boolean Vegan, boolean Vegetarian) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int ID = 0;

		String query = "SELECT MAX(MId) FROM meals_t";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ID = rs.getInt(1) + 1;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		query = "INSERT INTO meals_t VALUES (" + ID + ", '" + Name + "', " + Calories + ", " + Protein + ", " + Carbs
				+ ", " + Fat + ", " + Sugar + ", " + Vegan + ", " + Vegetarian + ");";

		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * Clears a table of all elements
	 * 
	 * @param name
	 *            The name of the table to be cleared
	 * @throws SQLException
	 */
	public static void clearTable(String name) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		String query = "DELETE FROM " + name;

		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * Inputs Food and Meal Ids into Foods in Meal table with the number of servings
	 * of Food
	 * 
	 * @param mealName
	 *            The Name of the Meal that is being inputed
	 * @param foodName
	 *            The Name of the Food that is being inputed
	 * @param serving
	 *            The number of servings of Food
	 * @throws SQLException
	 */
	public static void updateFoodsInMeal(String mealName, String foodName, double serving) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int FId = 0;

		String query = "SELECT MAX(FId) FROM foods_t WHERE Name = '" + foodName + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				FId = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		int MId = 0;

		query = "SELECT MAX(MId)  FROM meals_t WHERE Name = '" + mealName + "'";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				MId = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		query = "INSERT INTO foodsinmeal_t VALUES ( " + FId + ", " + MId + ", " + serving + ");";

		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * Returns the number of Meals in the Meal table
	 * 
	 * @return The number of Meals in the Meal table
	 * @throws SQLException
	 */
	public static int getNumberOfMeals() throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int MId = 0;

		String query = "SELECT MAX(MId) FROM meals_t";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				MId = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return MId;
	}

	/**
	 * Inputs a Meal Plan into the Meal Plan table
	 * 
	 * @param PId
	 *            The PId for the Meal Plan
	 * @param Calories
	 *            The number of Calories in the Meal Plan
	 * @param Protein
	 *            The amount of Protein in the Meal Plan
	 * @param Carbs
	 *            The amount of Carbs in the Meal Plan
	 * @param Fat
	 *            The amount of Fat in the Meal Plan
	 * @param Sugar
	 *            The amount of Sugar in the Meal Plan
	 * @param Vegan
	 *            Whether Meal Plan is Vegan or not
	 * @param Vegetarian
	 *            Whether Meal Plan is Vegetarian or not
	 * @param Meals
	 *            An array of the MIds of the Meals in Meal Plan
	 * @throws SQLException
	 */
	public static void inputMealPlan(int PId, int Calories, double Protein, double Carbs, double Fat, double Sugar,
			boolean Vegan, boolean Vegetarian, int[] Meals) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		String query = "INSERT INTO mealplan_t VALUES (" + PId + ", " + Calories + ", " + Protein + ", " + Carbs + ", "
				+ Fat + ", " + Sugar + ", " + Vegan + ", " + Vegetarian + ");";

		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		try {
			stmt = conn.createStatement();

			for (int i = 0; i < Meals.length; i++) {
				query = "INSERT INTO mealsinplan_t VALUES (" + Meals[i] + ", " + PId + ");";

				stmt.executeUpdate(query);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * Picks a random Meal Plan from the Meal Plan table
	 * 
	 * @return The PId for the Meal Plan that is selected
	 * @throws SQLException
	 */
	public static int getRandomMealPlan() throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		Random rand = new Random();

		int maxPId = 1;

		String query = "SELECT MAX(PId) FROM mealplan_t";

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				maxPId = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		int PId = rand.nextInt(maxPId) + 1;

		return PId;
	}

	/**
	 * Returns the number of Calories in a Meal Plan based on its PId
	 * 
	 * @param PId
	 *            The PId for the meal plan who's Calories are being sought
	 * @return The number of Calories in the Meal Plan
	 * @throws SQLException
	 */
	public static int getMealPlanCalories(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int Calories = 0;

		String query = "SELECT calories FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Calories = rs.getInt(1);
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

	/**
	 * Returns the amount of Protein in a Meal Plan based on its PId
	 * 
	 * @param PId
	 *            The PId of the Meal Plan who's Protein is being sought
	 * @return The amount of Protein in the Meal Plan
	 * @throws SQLException
	 */
	public static double getMealPlanProtein(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Protein = 0;

		String query = "SELECT protein FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Protein = rs.getDouble(1);
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

	/**
	 * Returns the amount of Carbs in a Meal Plan based on its PId
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's Carbs are being sought
	 * @return
	 * @throws SQLException
	 */
	public static double getMealPlanCarbs(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Carbs = 0;

		String query = "SELECT carbs FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Carbs = rs.getDouble(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return Carbs;
	}

	/**
	 * Returns the amount of Fat in a Meal Plan based on its PId
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's Fat is being sought
	 * @return The amount of Fat in the Meal Plan
	 * @throws SQLException
	 */
	public static double getMealPlanFat(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Fat = 0;

		String query = "SELECT fat FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Fat = rs.getDouble(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return Fat;
	}

	/**
	 * Returns the amount of Sugar in a Meal Plan based on its PId
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's Sugar is being sought
	 * @return The amount of Sugar in the Meal Plan
	 * @throws SQLException
	 */
	public static double getMealPlanSugar(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		double Sugar = 0;

		String query = "SELECT sugar FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Sugar = rs.getDouble(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return Sugar;
	}

	/**
	 * Returns whether a Meal Plan is Vegan based on its PId
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's Vegan status is being sought
	 * @return The boolean value of the Meal Plan's Vegan status
	 * @throws SQLException
	 */
	public static boolean getMealPlanVegan(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		boolean Vegan = false;

		String query = "SELECT vegan FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Vegan = rs.getBoolean(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return Vegan;
	}

	/**
	 * Returns whether a Meal Plan is Vegetarian based on its PId
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's Vegetarian status is being sought
	 * @return The boolean value of the Meal Plan's Vegetarian status
	 * @throws SQLException
	 */
	public static boolean getMealPlanVegetarian(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		boolean Vegetarian = false;

		String query = "SELECT vegetarian FROM mealplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Vegetarian = rs.getBoolean(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return Vegetarian;
	}

	/**
	 * Returns the number of Meals in a Meal Plan
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's number of Meals is being sought
	 * @return The number of Meals in the Meal Plan
	 * @throws SQLException
	 */
	public static int getMealPlanNumberOfMeals(int PId) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int numMeals = 0;

		String query = "SELECT COUNT(Mid) FROM mealsinplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				numMeals = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return numMeals;
	}

	/**
	 * Returns an array that contains the MIds for the Meals contained in a Meal
	 * Plan
	 * 
	 * @param PId
	 *            The PId for the Meal Plan who's Meals are being sought
	 * @param numMeals
	 *            The number of Meals in the Meal Plan
	 * @return An array of MIds of the Meals contained in the Meal Plan
	 * @throws SQLException
	 */
	public static int[] getMealPlanMeals(int PId, int numMeals) throws SQLException {
		Connection conn = getConnection();

		Statement stmt = null;

		int meals[] = new int[numMeals];

		String query = "SELECT Mid FROM mealsinplan_t WHERE Pid = " + PId;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			int i = 0;

			while (rs.next()) {

				meals[i] = rs.getInt(1);

				i++;

			}

			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return meals;
	}

}
