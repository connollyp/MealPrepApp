package mealPrep;

import java.sql.SQLException;
import java.util.Scanner;

public class MealPlan extends Meal {

	private int PId;

	private int Calories;

	private double Protein;

	private double Carbs;

	private double Fat;

	private double Sugar;

	private boolean Vegan;

	private boolean Vegetarian;

	private int[] Meals;

	/**
	 * Default constructor for the class MealPlan
	 */
	public MealPlan() {

		this.PId = 1;

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;

		this.Sugar = 0;

		this.Vegan = true;

		this.Vegetarian = true;

		this.Meals = new int[0];
	}

	/**
	 * Custom constructor for the class MealPlan
	 * 
	 * @param Calories
	 *            Total calories in the meal plan
	 * @param Protein
	 *            Total amount of protein in the meal plan
	 * @param Carbs
	 *            Total amount of carbs in the meal plan
	 * @param Fat
	 *            Total amount of fat in the meal plan
	 * @param Sugar
	 *            Total amount of sugar in the meal plan
	 * @param Vegan
	 *            Boolean value of whether or not the meal plan is vegan
	 * @param Vegetarian
	 *            Boolean value of whether or the meal plan is vegetarian
	 * @param Meals
	 */
	public MealPlan(int PId, int Calories, double Protein, double Carbs, double Fat, double Sugar, boolean Vegan,
			boolean Vegetarian, int[] Meals) {

		this.PId = PId;

		this.Calories = Calories;

		this.Protein = Protein;

		this.Carbs = Carbs;

		this.Fat = Fat;

		this.Sugar = Sugar;

		this.Vegan = Vegan;

		this.Vegetarian = Vegetarian;

		this.Meals = Meals;
	}

	/**
	 * Gets the PId of MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's PId is being sought
	 * @return the PId of MealPlan
	 */
	public static int getPId(MealPlan MealPlan) {
		return MealPlan.PId;
	}

	/**
	 * Returns the number of calories in MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's calories are being sought
	 * @return The number of calories in MealPlan
	 */
	public static int getCalories(MealPlan MealPlan) {
		return MealPlan.Calories;
	}

	/**
	 * Returns the number of grams of protein in MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's protein is being sought
	 * @return The amount of protein in MealPlan
	 */
	public static double getProtein(MealPlan MealPlan) {
		return MealPlan.Protein;
	}

	/**
	 * Returns the number of grams of carbs in MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's carbs are being sought
	 * @return The amount of carbs in MealPlan
	 */
	public static double getCarbs(MealPlan MealPlan) {
		return MealPlan.Carbs;
	}

	/**
	 * Returns the number of grams of carbs in MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's fat is being sought
	 * @return The amount of fat in MealPlan
	 */
	public static double getFat(MealPlan MealPlan) {
		return MealPlan.Fat;
	}

	/**
	 * Returns the number of grams of sugar in MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's fat is being sought
	 * @return The amount of sugar in MealPlan
	 */
	public static double getSugar(MealPlan MealPlan) {
		return MealPlan.Sugar;
	}

	/**
	 * Returns true if MealPlan is vegan, false otherwise
	 * 
	 * @param MealPlan
	 *            The MealPlan who's vegan status is being sought
	 * @return The boolean value of whether MealPlan is vegan
	 */
	public static boolean getVegan(MealPlan MealPlan) {
		return MealPlan.Vegan;
	}

	/**
	 * Returns true if MealPlan is vegetarian, false otherwise
	 * 
	 * @param MealPlan
	 *            The MealPlan who's vegetarian status is being sought
	 * @return The boolean value of whether MealPlan is vegetarian
	 */
	public static boolean getVegetarian(MealPlan MealPlan) {
		return MealPlan.Vegetarian;
	}

	/**
	 * Returns an array containing the MId's of the meals contained in MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan who's meals is being sought
	 * @return An integer array that contains the MId's of the meals contained in
	 *         MealPlan
	 */
	public static int[] getMeals(MealPlan MealPlan) {
		return MealPlan.Meals;
	}

	/**
	 * Prints the nutrition and meal information for MealPlan
	 * 
	 * @param MealPlan
	 *            The MealPlan that is being printed
	 * @throws SQLException
	 */
	public static void printMealPlan(MealPlan MealPlan) throws SQLException {

		System.out.println();
		
		System.out.println("PId: " + getPId(MealPlan));

		System.out.println("Calories: " + getCalories(MealPlan));

		System.out.println("Protein: " + getProtein(MealPlan));

		System.out.println("Carbs: " + getCarbs(MealPlan));

		System.out.println("Fat: " + getFat(MealPlan));

		System.out.println("Sugar: " + getSugar(MealPlan));

		if (getVegan(MealPlan)) {
			System.out.println("Vegan: Yes");
		} else {
			System.out.println("Vegan: No");
		}

		if (getVegetarian(MealPlan)) {
			System.out.print("Vegetarian: Yes");
		} else {
			System.out.print("Vegetarian: No");
		}

		System.out.println();

		System.out.println("Meals in meal plan: ");

		for (int i = 0; i < MealPlan.Meals.length; i++) {
			System.out.println(getName("meals_t", MealPlan.Meals[i]));
		}
	}

	/**
	 * Recursively calculates the factorial of num
	 * 
	 * @param num
	 *            The number who's factorial is being sought
	 * @return The factorial of num
	 */
	public static int factorial(int num) {
		if (num == 0) {
			return 1;
		}

		return num * factorial(num - 1);
	}

	/**
	 * Calculates the number of possible combinations of numbers
	 * 
	 * @param numOptions
	 *            The numbers that will be combined
	 * @param numSelected
	 *            The length of the combination
	 * @return The number of possible combinations of numOptions of numSelected
	 *         length
	 */
	public static int getNumCombo(int numOptions, int numSelected) {
		return (factorial(numOptions) / (factorial(numOptions - numSelected) * factorial(numSelected)));
	}

	/**
	 * Generates a matrix that contains all possible combinations of MId's
	 * 
	 * @param Combo
	 *            Matrix containing combinations
	 * @param Meals
	 *            Array containing MId's
	 * @param Data
	 *            Array containing current combination
	 * @param Start
	 *            Starting index of Meals
	 * @param End
	 *            Ending index of Meals
	 * @param Index
	 *            Current index of Data
	 * @param numMeals
	 *            Number of meals to be selected
	 * @return A matrix containing all possible combinations of Meals of numMeals
	 *         length
	 */
	public static int[][] generateCombinations(int Combo[][], int Meals[], int Data[], int Start, int End, int Index,
			int numMeals) {

		if (Index == numMeals) {
			for (int i = 0; i < getNumCombo(Meals.length, numMeals); i++) {
				if (Combo[i][0] == 0) {
					for (int j = 0; j < numMeals; j++) {
						Combo[i][j] = Data[j];
					}
					return Combo;
				}
			}
		}

		for (int i = Start; i <= End && End - i + 1 >= numMeals - Index; i++) {
			Data[Index] = Meals[i];
			Combo = generateCombinations(Combo, Meals, Data, i + 1, End, Index + 1, numMeals);
		}

		return Combo;
	}

	/**
	 * Finds combinations of meals that have fewer calories than requested and the
	 * amount of protein requested with a -5% margin of error
	 * 
	 * @param Calories
	 *            The number of calories to stay below
	 * @param Protein
	 *            The ideal amount of protein
	 * @param Combo
	 *            A matrix containing all possible combinations of meals
	 * @param numMeals
	 *            The number of meals in a combination
	 * @param numCombo
	 *            The total number of possible combinations
	 * @return An array of MealPlans that fit the given parameters
	 * @throws SQLException
	 */
	public static MealPlan[] findValidMealPlans(int Calories, double Protein, int Combo[][], int numMeals, int numCombo)
			throws SQLException {
		MealPlan validMealPlans[] = new MealPlan[numCombo];

		int validIndex = 0;

		for (int i = 0; i < numCombo; i++) {
			
			int mealPlanCalories = 0;

			double mealPlanProtein = 0;

			double mealPlanCarbs = 0;

			double mealPlanFat = 0;

			double mealPlanSugar = 0;

			boolean mealPlanVegan = true;

			boolean mealPlanVegetarian = true;

			int mealPlanMeals[] = new int[numMeals];

			for (int j = 0; j < numMeals; j++) {
				mealPlanCalories += getCalories("meals_t", getName("meals_t", Combo[i][j]));

				mealPlanProtein += getProtein("meals_t", getName("meals_t", Combo[i][j]));

				mealPlanCarbs += getCarbs("meals_t", getName("meals_t", Combo[i][j]));

				mealPlanFat = getFat("meals_t", getName("meals_t", Combo[i][j]));
				;

				mealPlanSugar = getSugar("meals_t", getName("meals_t", Combo[i][j]));

				if (mealPlanVegan && getVegan("meals_t", getName("meals_t", Combo[i][j]))) {
					mealPlanVegan = true;
				} else {
					mealPlanVegan = false;
				}

				if (mealPlanVegetarian && getVegetarian("meals_t", getName("meals_t", Combo[i][j]))) {
					mealPlanVegetarian = true;
				} else {
					mealPlanVegetarian = false;
				}

				mealPlanMeals[j] = Combo[i][j];
			}

			if ((mealPlanCalories <= Calories) && ((Protein - (.05 * Protein)) <= mealPlanProtein)) {

				MealPlan MealPlan = new MealPlan(validIndex+1, mealPlanCalories, mealPlanProtein, mealPlanCarbs, mealPlanFat,
						mealPlanSugar, mealPlanVegan, mealPlanVegetarian, mealPlanMeals);

				validMealPlans[validIndex] = MealPlan;

				validIndex++;
			}
			
		}

		return validMealPlans;
	}

	public static void createMealPlan() throws SQLException {

		clearTable("mealsinplan_t");
		
		clearTable("mealplan_t");
		
		Scanner input = new Scanner(System.in);

		System.out.print("How many meals do you want in the plan?: ");
		int numMeals = input.nextInt();

		System.out.println();

		System.out.print("How many calories do you want to consume?: ");
		int Calories = input.nextInt();

		System.out.println();

		System.out.print("How much protein do you want to consume?: ");
		double Protein = input.nextDouble();

		System.out.println();

		input.close();

		int Meals[] = new int[getNumberOfMeals()];

		for (int i = 0; i <= Meals.length - 1; i++) {
			Meals[i] = i + 1;
		}

		int numCombo = getNumCombo(Meals.length, numMeals);

		int Combo[][] = new int[numCombo][numMeals];

		int Data[] = new int[numMeals];

		Combo = generateCombinations(Combo, Meals, Data, 0, Meals.length - 1, 0, numMeals);

		MealPlan validMealPlans[] = findValidMealPlans(Calories, Protein, Combo, numMeals, 
				numCombo);

		
		for (int i = 0; i < validMealPlans.length; i++) {
			if (validMealPlans[i] != null) {
				inputMealPlan(i+1, getCalories(validMealPlans[i]), getProtein(validMealPlans[i]),
						getCarbs(validMealPlans[i]), getFat(validMealPlans[i]), 
						getSugar(validMealPlans[i]),getVegan(validMealPlans[i]), 
						getVegetarian(validMealPlans[i]), getMeals(validMealPlans[i]));

				//printMealPlan(validMealPlans[i]);
			}
		}
		
		
	}
	
	public static void pickRandomMealPlan() throws SQLException {
		int PId = getRandomMealPlan();
		
		int Calories = getMealPlanCalories(PId);
		
		double Protein = getMealPlanProtein(PId);
		
		double Carbs = getMealPlanCarbs(PId);
		
		double Fat = getMealPlanFat(PId);
		
		double Sugar = getMealPlanSugar(PId);
		
		boolean Vegan = getMealPlanVegan(PId);
		
		boolean Vegetarian = getMealPlanVegetarian(PId);
		
		int numMeals = getMealPlanNumberOfMeals(PId);
		
		int Meals[] = getMealPlanMeals(PId, numMeals);
		
		MealPlan MealPlan = new MealPlan(PId, Calories, Protein, Carbs, Fat, Sugar, Vegan, 
				Vegetarian, Meals);
		
		printMealPlan(MealPlan);
		
	}

	public static void main(String[] args) throws SQLException {
		//createMealPlan();

		pickRandomMealPlan();
	}

}
