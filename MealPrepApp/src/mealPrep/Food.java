package mealPrep;

import java.sql.SQLException;
import java.util.Scanner;

public class Food extends DatabaseCommands {

	private String Name;

	private int Calories;

	private double Protein;

	private double Carbs;

	private double Fat;

	private double Sugar;

	private boolean Vegan;

	private boolean Vegetarian;

	private int StandardServing;

	private String ServingUnit;

	/**
	 * Default Constructor of the food object
	 */
	public Food() {

		this.Name = "Food";

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;

		this.Sugar = 0;

		this.Vegan = false;

		this.Vegetarian = false;

		this.StandardServing = 1;

		this.ServingUnit = "Grams";
	}

	/**
	 * Sets the class variables for the food based on the information stored about
	 * the food associated with the given String name on a remote SQL server defined
	 * in the config file
	 * 
	 * @param name Name of the food
	 */
	public Food(String name) throws SQLException {

		this.Name = name;

		this.Calories = getCalories("foods_t", name);

		this.Protein = getProtein("foods_t", name);

		this.Carbs = getCarbs("foods_t", name);

		this.Fat = getFat("foods_t", name);

		this.Sugar = getSugar("foods_t", name);

		this.Vegan = getVegan("foods_t", name);

		this.Vegetarian = getVegetarian("foods_t", name);

		this.StandardServing = getStandardServing("foods_t", name);

		this.ServingUnit = getServingUnit("foods_t", name);

	}
	
	public static Food getFood(String name) throws SQLException {
		
		Food Food = new Food();

		Food.Name = name;

		Food.Calories = getCalories("foods_t", name);

		Food.Protein = getProtein("foods_t", name);

		Food.Carbs = getCarbs("foods_t", name);

		Food.Fat = getFat("foods_t", name);

		Food.Sugar = getSugar("foods_t", name);

		Food.Vegan = getVegan("foods_t", name);

		Food.Vegetarian = getVegetarian("foods_t", name);

		Food.StandardServing = getStandardServing("foods_t", name);

		Food.ServingUnit = getServingUnit("foods_t", name);
		
		return Food;

	}

	/**
	 * Returns the name of food
	 * 
	 * @param food the food who's name is being sought
	 * @return the food's name as a string
	 */
	public static String getName(Food food) {
		return food.Name;
	}

	/**
	 * Returns the number of calories in food
	 * 
	 * @param food    the food who's calories are being sought
	 * @param serving the number of servings of food
	 * @return the number of calories in the given number of servings of the food
	 */
	public static int getCalories(Food food, double serving) {
		return (int) Math.round(food.Calories * serving);
	}

	/**
	 * Returns the number of calories in foods 1 and 2
	 * 
	 * @param food1    the first food being used
	 * @param serving1 the serving of food1
	 * @param food2    the second food being used
	 * @param serving2 the serving of food2
	 * @return the sum of the calories in the servings of foods 1 and 2
	 */
	public static int getCaloriesSum(Food food1, double serving1, Food food2, double serving2) {
		return (int) Math.round((food1.Calories * serving1) + (food2.Calories * serving2));
	}

	/**
	 * Returns the number of grams of protein in food
	 * 
	 * @param food    the food who's protein is being sought
	 * @param serving the serving of food
	 * @return the number of grams of protein in food
	 */
	public static double getProtein(Food food, double serving) {
		return food.Protein * serving;
	}

	/**
	 * Returns the number of grams of protein in foods 1 and 2
	 * 
	 * @param food1    the first food being used
	 * @param serving1 the serving of food1
	 * @param food2    the second food being used
	 * @param serving2 the serving of food2
	 * @return the sum of the amount of protein in the servings of foods 1 and 2
	 */
	public static double getProteinSum(Food food1, double serving1, Food food2, double serving2) {
		return (food1.Protein * serving1) + (food2.Protein * serving2);
	}

	/**
	 * Returns the number of grams of carbs in food
	 * 
	 * @param food    the food who's carbs are being sought
	 * @param serving the serving of food
	 * @return the number of grams of carbs in food
	 */
	public static double getCarbs(Food food, double serving) {
		return food.Carbs * serving;
	}

	/**
	 * Returns the number of grams of carbs in foods 1 and 2
	 * 
	 * @param food1    the first food being used
	 * @param serving1 the serving of food1
	 * @param food2    the second food being used
	 * @param serving2 the serving of food2
	 * @return the sum of the amount of carbs in foods 1 and 2
	 */
	public static double getCarbsSum(Food food1, double serving1, Food food2, double serving2) {
		return (food1.Carbs * serving1) + (food2.Carbs * serving2);
	}

	/**
	 * Returns the number of grams of fat in food
	 * 
	 * @param food    the food who's fat is being sought
	 * @param serving the serving of food
	 * @return the number of grams of fat in food
	 */
	public static double getFat(Food food, double serving) {
		return food.Fat * serving;
	}

	/**
	 * Returns the number of grams of fat in foods 1 and 2
	 * 
	 * @param food1    the first food being used
	 * @param serving1 the serving of food1
	 * @param food2    the second food being used
	 * @param serving2 the serving of food2
	 * @return the sum of the amount of fat in foods 1 and 2
	 */
	public static double getFatSum(Food food1, double serving1, Food food2, double serving2) {
		return (food1.Fat * serving1) + (food2.Fat * serving2);
	}

	/**
	 * Returns the number of grams of sugar in food
	 * 
	 * @param food    the food who's sugar is being sought
	 * @param serving the serving of food
	 * @return the number of grams of sugar in food
	 */
	public static double getSugar(Food food, double serving) {
		return food.Sugar;
	}

	/**
	 * Returns the number of grams of sugar in foods 1 and 2
	 * 
	 * @param food1    the first food being used
	 * @param serving1 the serving of food1
	 * @param food2    the second food being used
	 * @param serving2 the serving of food2
	 * @return the number of grams of sugar in foods 1 and 2
	 */
	public static double getSugarSum(Food food1, double serving1, Food food2, double serving2) {
		return (food1.Sugar * serving1) + (food2.Sugar * serving2);
	}

	/**
	 * Returns true if food is vegan, false otherwise
	 * 
	 * @param food the food who's vegan status is being sought
	 * @return the boolean value of whether the food is vegan or not
	 */
	public static boolean getVegan(Food food) {
		return food.Vegan;
	}

	/**
	 * Returns true if both foods are vegan, false otherwise
	 * 
	 * @param food1 the first food being used
	 * @param food2 the second food being used
	 * @return the boolean value of whether both foods are vegan or not
	 */
	public static boolean getVeganSum(Food food1, Food food2) {
		if (food1.Vegan && food2.Vegan) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns true if food is vegetarian, false otherwise
	 * 
	 * @param food the food who's vegetarian status is being sought
	 * @return the boolean value of whether food is vegetarian
	 */
	public static boolean getVegetarian(Food food) {
		return food.Vegetarian;
	}

	/**
	 * Returns true if food is vegetarian, false otherwise
	 * 
	 * @param food1 the first food being used
	 * @param food2 the second food being used
	 * @return the boolean value of whether both foods are vegetarian
	 */
	public static boolean getVegetarianSum(Food food1, Food food2) {
		if (food1.Vegetarian && food2.Vegetarian) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns the amount of food in a standard serving
	 * 
	 * @param food the food who's standard serving is being sought
	 * @return how much food is in a standard serving
	 */
	public static int getStandardServing(Food food) {
		return food.StandardServing;
	}

	/**
	 * Returns the amount of food in the given serving
	 * 
	 * @param food    the food who's serving is being sought
	 * @param serving the number of servings of food
	 * @return the amount of food in the given serving
	 */
	public static int getServing(Food food, int serving) {
		return food.StandardServing * serving;
	}

	/**
	 * Returns the string value of the unit used to measure food
	 * 
	 * @param food the food who's measurement unit is being sought
	 * @return the unit used to measure the amount of food
	 */
	public static String getServingUnit(Food food) {
		return food.ServingUnit;
	}

	/**
	 * Prints the nutrition information for a given serving of food
	 * 
	 * @param food    the food who's nutrition information is being sought
	 * @param serving the number of servings of food
	 */
	public static void printFood(Food food, int serving) {

		System.out.println();

		System.out.println(getName(food));

		System.out.println("Servings: " + serving + " (" 
				+ getServing(food, serving) + " " + getServingUnit(food) + ")");

		System.out.println("Calories: " + getCalories(food, serving));

		System.out.println("Protein: " + getProtein(food, serving) + " Grams");

		System.out.println("Carbohydrates: " + getCarbs(food, serving) + " Grams");

		System.out.println("Fat: " + getFat(food, serving) + " Grams");

		System.out.println("Sugar: " + getSugar(food, serving) + " Grams");

		if (getVegan(food)) {
			System.out.println("Vegan: Yes");
		} else {
			System.out.println("Vegan: No");
		}

		if (getVegetarian(food)) {
			System.out.println("Vegetarian: Yes");
		} else {
			System.out.println("Vegetarian: No");
		}

		System.out.println("Standard Serving: " + getServing(food, 1) 
			+ " " + getServingUnit(food));
	}

	/**
	 * Prints the nutrition information for one serving of food
	 * 
	 * @param food the food who's nutrition information is being sought
	 */
	public static void printFoodNutritionInfo(Food food) {

		System.out.println();

		System.out.println(getName(food));

		System.out.println("Calories: " + getCalories(food, 1));

		System.out.println("Protein: " + getProtein(food, 1) + " Grams");

		System.out.println("Carbohydrates: " + getCarbs(food, 1) + " Grams");

		System.out.println("Fat: " + getFat(food, 1) + " Grams");

		System.out.println("Sugar: " + getSugar(food, 1) + " Grams");

		if (getVegan(food)) {
			System.out.println("Vegan: Yes");
		} else {
			System.out.println("Vegan: No");
		}

		if (getVegetarian(food)) {
			System.out.println("Vegetarian: Yes");
		} else {
			System.out.println("Vegetarian: No");
		}

		System.out.println("Standard Serving: " + getServing(food, 1) 
			+ " " + getServingUnit(food));
	}

	/**
	 * Allows the user to create an instance of food with user defined variables and
	 * adds this food to the database
	 * 
	 * @return Food instance created by user input
	 * @throws SQLException
	 */
	public static Food createFood() throws SQLException {
		Food food = new Food();

		Scanner input = new Scanner(System.in);

		System.out.print("What is the name of the food?: ");
		food.Name = input.nextLine();

		System.out.println();

		System.out.print("How many calories are in a " 
				+ "standard serving of " + food.Name + "?: ");
		food.Calories = input.nextInt();

		System.out.println();

		System.out.print("How many grams of protein are in a " 
				+ "standard serving of " + food.Name + "?: ");
		food.Protein = input.nextDouble();

		System.out.println();

		System.out.print("How many grams of carbs are in a " 
				+ "standard serving of " + food.Name + "?: ");
		food.Carbs = input.nextDouble();

		System.out.println();

		System.out.print("How many grams of fat are in a " 
				+ "standard sercing of " + food.Name + "?: ");
		food.Fat = input.nextDouble();

		System.out.println();

		System.out.print("How many grams of sugar are in a " 
				+ "standard serving of " + food.Name + "?: ");
		food.Sugar = input.nextDouble();

		System.out.println();

		System.out.print("Is " + food.Name + " vegan?: ");
		String VeganStatus;
		boolean Vegan = false;
		;

		do {
			VeganStatus = input.next();

			if (VeganStatus.equalsIgnoreCase("Yes")) {
				Vegan = true;
				break;
			} else if (VeganStatus.equalsIgnoreCase("No")) {
				Vegan = false;
				break;
			} else {
				System.out.println();
				System.out.println("Please only enter 'Yes' or 'No': ");
			}
		} while (VeganStatus.equalsIgnoreCase("Yes") == false || VeganStatus.equalsIgnoreCase("No") == false);

		food.Vegan = Vegan;

		System.out.println();

		System.out.print("Is " + food.Name + " vegetarian?: ");
		String VegStatus;
		boolean Vegetarian = false;

		do {
			VegStatus = input.next();

			if (VegStatus.equalsIgnoreCase("Yes")) {
				Vegetarian = true;
				break;
			} else if (VegStatus.equalsIgnoreCase("No")) {
				Vegetarian = false;
				break;
			} else {
				System.out.println("Please only enter 'Yes' or 'No'");
			}
		} while (VegStatus.equalsIgnoreCase("Yes") == false || VegStatus.equalsIgnoreCase("No") == false);

		food.Vegetarian = Vegetarian;

		System.out.println();

		System.out.print("What is the unit of the standard serving?: ");
		food.ServingUnit = input.next();

		System.out.println();

		System.out.print("How many " + food.ServingUnit 
				+ "s are in a standard serving?: ");
		food.StandardServing = input.nextInt();

		System.out.println();

		try {
			inputFood(food.Name, food.Calories, 
					food.Protein, food.Carbs, food.Fat, food.Sugar, 
					food.Vegan, food.Vegetarian, food.StandardServing,
					food.ServingUnit);
		}catch (SQLException e) {
			System.out.println(e);
		}

		input.close();

		return food;

	}

	public static void main(String[] args) throws SQLException {

		createFood();
	}

}
