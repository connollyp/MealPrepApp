package mealPrep;

import java.sql.SQLException;
import java.util.Scanner;

public class Meal extends Food {

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
	 * Default constructor of the meal class
	 */
	public Meal() {

		this.Name = "Meal";

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;

		this.Sugar = 0;

		this.Vegan = true;

		this.Vegetarian = true;

		this.StandardServing = 1;

		this.ServingUnit = "Grams";
	}

	/**
	 * Sets the class variables for the meal based on the information stored about
	 * the meal associated with the given String name on a remote SQL server defined
	 * in the config file
	 * 
	 * @param Name Name of the meal being constructed
	 * @throws SQLException
	 */
	public Meal(String Name) throws SQLException {

		this.Name = Name;

		this.Calories = getCalories("meals_t", Name);

		this.Protein = getProtein("meals_t", Name);

		this.Carbs = getCarbs("meals_t", Name);

		this.Fat = getFat("meals_t", Name);

		this.Sugar = getSugar("meals_t", Name);

		this.Vegan = getVegan("meals_t", Name);

		this.Vegetarian = getVegetarian("meals_t", Name);

		this.StandardServing = getStandardServing("meals_t", Name);

		this.ServingUnit = getServingUnit("meals_t", Name);

	}

	/**
	 * Returns the name of meal
	 * 
	 * @param Meal the meal who's name is being sought 
	 * @return Name the meal's name as a string
	 */
	public static String getName(Meal Meal) {
		return Meal.Name;
	}

	/**
	 * Returns the number of calories in meal
	 * 
	 * @param Meal the meal who's calories are being sought 
	 * @param Serving the number of servings of meal
	 * @return the number of calories as an int 
	 */
	public static int getCalories(Meal Meal, int Serving) {
		return Meal.Calories * Serving;
	}

	/**
	 * Returns the number of grams of protein in meal
	 * 
	 * @param Meal the meal who's protein is being sought
	 * @param Serving the number of servings of meal
	 * @return the number of grams of protein as an int 
	 */
	public static double getProtein(Meal Meal, int Serving) {
		return Meal.Protein * Serving;
	}

	/**
	 * Returns the number of grams of carbs in meal
	 * 
	 * @param Meal the meal who's carbs are being sought
	 * @param Serving the number of servings of meal
	 * @return the number of grams of carbs in meal
	 */
	public static double getCarbs(Meal Meal, int Serving) {
		return Meal.Carbs * Serving;
	}

	/**
	 * Returns the number of grams of fat in meal
	 * 
	 * @param Meal the meal who's fat is being sought 
	 * @param Serving the number of servings of meal 
	 * @return the number of grams of fat in meal
	 */
	public static double getFat(Meal Meal, int Serving) {
		return Meal.Fat * Serving;
	}

	/**
	 * Returns the number of grams of sugar in meal
	 * @param Meal the meal who's sugar is being sought 
	 * @param Serving the number of servings of meal 
	 * @return the number of grams of sugar in meal 
	 */
	public static double getSugar(Meal Meal, int Serving) {
		return Meal.Sugar * Serving;
	}

	/**
	 * Returns true if the meal is vegan, false otherwise 
	 * 
	 * @param Meal the meal who's vegan status is sought
	 * @return the boolean value of whether meal is vegan or not
	 */
	public static boolean getVegan(Meal Meal) {
		return Meal.Vegan;
	}

	/**
	 * Returns true if the meal is vegetarian, false otherwise
	 * 
	 * @param Meal the meal who's vegetarian status is sought 
	 * @return the boolean value of whether meal is vegetarian or not
	 */
	public static boolean getVegetarian(Meal Meal) {
		return Meal.Vegetarian;
	}

	/**
	 * Returns the amount of meal in a standard serving
	 * 
	 * @param Meal the meal who's serving is being sought 
	 * @return how much food is in a standard serving 
	 */
	public static int getStandardServing(Meal Meal) {
		return Meal.StandardServing;
	}

	/**
	 * Returns the string value of the unit used to measure meal
	 * 
	 * @param Meal the meal who's measurement unit is being sought
	 * @return the unit used to measure the amount of food
	 */
	public static String getServingUnit(Meal Meal) {
		return Meal.ServingUnit;
	}

	/**
	 * Prints the nutrition information for the given serving of meal
	 * 
	 * @param Meal the meal that is being printed 
	 * @param Serving the serving of meal 
	 */
	public static void printMeal(Meal Meal, int Serving) {
		System.out.println();

		System.out.println(getName(Meal));

		System.out.println("Calories: " + getCalories(Meal, Serving));

		System.out.println("Protein: " + getProtein(Meal, Serving));

		System.out.println("Carbohydrates: " + getCarbs(Meal, Serving));

		System.out.println("Fat: " + getFat(Meal, Serving));

		if (getVegan(Meal)) {
			System.out.println("Vegan: Yes");
		} else {
			System.out.println("Vegan: No");
		}

		if (getVegetarian(Meal)) {
			System.out.println("Vegetarian: Yes");
		} else {
			System.out.println("Vegetarian: No");
		}
	}
	
	/**
	 * Prints the nutrition information for meal
	 * 
	 * @param Meal the meal who's nutrition information is being sought 
	 */
	public static void printMealNutritionInformation(Meal Meal) {
		System.out.println();

		System.out.println(getName(Meal));

		System.out.println("Calories: " + getCalories(Meal, 1));

		System.out.println("Protein: " + getProtein(Meal, 1));

		System.out.println("Carbohydrates: " + getCarbs(Meal, 1));

		System.out.println("Fat: " + getFat(Meal, 1));

		if (getVegan(Meal)) {
			System.out.println("Vegan: Yes");
		} else {
			System.out.println("Vegan: No");
		}

		if (getVegetarian(Meal)) {
			System.out.println("Vegetarian: Yes");
		} else {
			System.out.println("Vegetarian: No");
		}
	}

	/**
	 * Allows the user to create an instance of meal with user defined variables and
	 * adds this meal to the database
	 * 
	 * @return the meal that is created 
	 * @throws SQLException
	 */
	public static Meal createMeal() throws SQLException {
		Meal Meal = new Meal();

		Scanner input = new Scanner(System.in);

		System.out.print("What is the name of the Meal?: ");
		Meal.Name = input.nextLine();

		System.out.println();

		System.out.print("How many foods are in " + Meal.Name + "?: ");
		int foodNum = input.nextInt();

		System.out.println();

		Food[] foods = new Food[foodNum];
		double[] foodServings = new double[foodNum];

		String foodName;
		double foodServing = 0;

		for (int i = 0; i < foodNum; i++) {
			input.nextLine();

			System.out.print("Enter the name of a food in " + Meal.Name + ": ");
			foodName = input.nextLine();

			System.out.println();

			System.out.print("How many servings of " + foodName + " are in " + Meal.Name + "?: ");
			foodServing = input.nextDouble();

			System.out.println();

			foods[i] = getFood(foodName);
			foodServings[i] = foodServing;
		}

		for (int i = 0; i < foodNum; i++) {
			Meal.Calories += getCalories(foods[i], foodServings[i]);

			Meal.Protein += getProtein(foods[i], foodServings[i]);

			Meal.Carbs += getCarbs(foods[i], foodServings[i]);

			Meal.Fat += getFat(foods[i], foodServings[i]);

			Meal.Sugar += getSugar(foods[i], foodServings[i]);

			if (getVegan(foods[i]) && Meal.Vegan) {
				Meal.Vegan = true;
			} else {
				Meal.Vegan = false;
			}

			if (getVegetarian(foods[i]) && Meal.Vegetarian) {
				Meal.Vegetarian = true;
			} else {
				Meal.Vegetarian = false;
			}

		}

		try {
			inputMeal(Meal.Name, Meal.Calories, Meal.Protein, Meal.Carbs, Meal.Fat, Meal.Sugar, Meal.Vegan,
					Meal.Vegetarian);
		} catch (SQLException e) {
			System.out.println(e);
		}

		try {
			for (int i = 0; i < foodNum; i++) {
				updateFoodsInMeal(Meal.Name, getName(foods[i]), foodServings[i], getServingUnit(foods[i]));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		input.close();

		return Meal;

	}

	public static void main(String[] args) throws SQLException {

		createMeal();
	}

}
