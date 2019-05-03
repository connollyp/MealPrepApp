package mealPrep;

public class Food {

	private String Name;

	private int Calories;

	private int Protein;

	private int Carbs;

	private int Fat;

	private boolean Vegan;

	private boolean Vegitarian;

	public Food() {

		this.Name = "Food";

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;

		this.Vegan = false;

		this.Vegitarian = false;
	}

	public Food(String name, int Calories, int Protein, int Carbs, int Fat, boolean Vegan, boolean Vegitarian) {

		this.Name = name;

		this.Calories = Calories;

		this.Protein = Protein;

		this.Carbs = Carbs;

		this.Fat = Fat;

		this.Vegan = Vegan;

		this.Vegitarian = Vegitarian;

	}

	public static String getName(Food food) {
		return food.Name;
	}

	public static int getCalories(Food food, int serving) {
		return food.Calories * serving;
	}

	public static int getCaloriesSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Calories * serving1) + (food2.Calories * serving2);
	}

	public static int getProtein(Food food, int serving) {
		return food.Protein * serving;
	}

	public static int getProteinSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Protein * serving1) + (food2.Protein * serving2);
	}

	public static int getCarbs(Food food, int serving) {
		return food.Carbs * serving;
	}

	public static int getCarbsSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Carbs * serving1) + (food2.Carbs * serving2);
	}

	public static int getFat(Food food, int serving) {
		return food.Fat * serving;
	}

	public static int getFatSum(Food food1, int serving1, Food food2, int serving2) {
		return (food1.Fat * serving1) + (food2.Fat * serving2);
	}

	public static boolean getVegan(Food food) {
		return food.Vegan;
	}

	public static boolean getVeganSum(Food food1, Food food2) {
		if (food1.Vegan && food2.Vegan) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean getVegitarian(Food food) {
		return food.Vegitarian;
	}

	public static boolean getVegitarianSum(Food food1, Food food2) {
		if (food1.Vegitarian && food2.Vegitarian) {
			return true;
		} else {
			return false;
		}
	}

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

		if (getVegitarian(food)) {
			System.out.println("Vegitarian: Yes");
		} else {
			System.out.println("Vegitarian: No");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
