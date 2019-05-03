package mealPrep;

public class Food {

	private String Name;

	private int Calories;

	private int Protein;

	private int Carbs;

	private int Fat;

	private boolean Vegan;

	private boolean Vegetarian;

	/**
	 * Default Constructor of the food object
	 */
	public Food() {

		this.Name = "Food";

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;

		this.Vegan = false;

		this.Vegetarian = false;
	}

	/**
	 * 
	 * @param name
	 *            Name of the food
	 * @param Calories
	 *            Calories contained in 1 serving of the food
	 * @param Protein
	 *            Protein contained in 1 serving of the food
	 * @param Carbs
	 *            Carbs contained in 1 serving of the food
	 * @param Fat
	 *            Fat contained in 1 serving of the food
	 * @param Vegan
	 *            Whether or not the food is Vegan
	 * @param Vegetarian
	 *            Whether or not the food is Vegetarian
	 */
	public Food(String name, int Calories, int Protein, int Carbs, int Fat, boolean Vegan, boolean Vegetarian) {

		this.Name = name;

		this.Calories = Calories;

		this.Protein = Protein;

		this.Carbs = Carbs;

		this.Fat = Fat;

		this.Vegan = Vegan;

		this.Vegetarian = Vegetarian;

	}

	// Returns the name of the food
	public static String getName(Food food) {
		return food.Name;
	}

	// Returns the amount of calories in a given serving of the food
	public static int getCalories(Food food, int serving) {
		return food.Calories * serving;
	}

	// Returns the sum of calories in the individual servings of two foods
	public static int getCaloriesSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Calories * serving1) + (food2.Calories * serving2);
	}

	// Returns the amount of protein in a given serving of the food
	public static int getProtein(Food food, int serving) {
		return food.Protein * serving;
	}

	// Returns the amount of protein in the individual servings of two foods
	public static int getProteinSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Protein * serving1) + (food2.Protein * serving2);
	}

	// Returns the amount of carbs in a given serving of the food
	public static int getCarbs(Food food, int serving) {
		return food.Carbs * serving;
	}

	// Returns the amount of carbs in the individual servings of two foods
	public static int getCarbsSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Carbs * serving1) + (food2.Carbs * serving2);
	}

	// Returns the amount of fat in a given serving of the food
	public static int getFat(Food food, int serving) {
		return food.Fat * serving;
	}

	// Returns the amount of fat in the individual servings of two foods
	public static int getFatSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Fat * serving1) + (food2.Fat * serving2);
	}

	// Returns a boolean value of whether the given food is Vegan
	public static boolean getVegan(Food food) {
		return food.Vegan;
	}

	// Returns a boolean value of whether both foods are Vegan
	public static boolean getVeganSum(Food food1, Food food2) {
		if (food1.Vegan && food2.Vegan) {
			return true;
		} else {
			return false;
		}
	}

	// Returns a boolean value of whether the given food is Vegetarian
	public static boolean getVegetarian(Food food) {
		return food.Vegetarian;
	}

	// Returns a boolean value of whether both foods are Vegetarian
	public static boolean getVegetarianSum(Food food1, Food food2) {
		if (food1.Vegetarian && food2.Vegetarian) {
			return true;
		} else {
			return false;
		}
	}

	// Prints the nutrition information for the given serving of the food
	public static void printFood(Food food, int serving) {

		System.out.println();

		System.out.println(getName(food));

		System.out.println("Calories: " + getCalories(food, serving));

		System.out.println("Protein: " + getProtein(food, serving));

		System.out.println("Carbohydrates: " + getCarbs(food, serving));

		System.out.println("Fat: " + getFat(food, serving));

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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
