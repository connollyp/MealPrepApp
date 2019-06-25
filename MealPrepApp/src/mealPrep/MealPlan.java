package mealPrep;

import java.sql.SQLException;
import java.util.Scanner;


public class MealPlan extends Meal{

	private int Calories;

	private double Protein;

	private double Carbs;

	private double Fat;

	private double Sugar;

	private boolean Vegan;

	private boolean Vegetarian;
	
	private int[] Meals;

	
	public MealPlan() {
		
		this.Calories = 0;
		
		this.Protein = 0;
		
		this.Carbs = 0;
		
		this.Fat = 0;
		
		this.Sugar = 0;
		
		this.Vegan = true;
		
		this.Vegetarian = true;
		
		this.Meals = new int[0];
	}
	
	public MealPlan(int Calories, double Protein, double Carbs, double Fat, double Sugar, boolean Vegan, boolean Vegetarian, int[] Meals) {
		
		this.Calories = Calories;
		
		this.Protein = Protein;
		
		this.Carbs = Carbs;
		
		this.Fat = Fat;
		
		this.Sugar = Sugar;
		
		this.Vegan = Vegan;
		
		this.Vegetarian = Vegetarian;
		
		this.Meals = Meals;
	}
	
	public static int getCalories(MealPlan MealPlan) {
		return MealPlan.Calories;
	}
	
	public static double getProtein(MealPlan MealPlan) {
		return MealPlan.Protein;
	}
	
	public static double getCarbs(MealPlan MealPlan) {
		return MealPlan.Carbs;
	}
	
	public static double getFat(MealPlan MealPlan) {
		return MealPlan.Fat;
	}
	
	public static double getSugar(MealPlan MealPlan) {
		return MealPlan.Sugar;
	}
	
	public static boolean getVegan(MealPlan MealPlan) {
		return MealPlan.Vegan;
	}
	
	public static boolean getVegetarian(MealPlan MealPlan) {
		return MealPlan.Vegetarian;
	}
	
	public static int[] getMeals(MealPlan MealPlan) {
		return MealPlan.Meals;
	}
	
	public static void printMealPlan(MealPlan MealPlan) throws SQLException{
		
		System.out.println();
		
		System.out.println("Calories: " + getCalories(MealPlan));
		
		System.out.println("Protein: " + getProtein(MealPlan));
		
		System.out.println("Carbs: " + getCarbs(MealPlan));
		
		System.out.println("Fat: " + getFat(MealPlan));
		
		System.out.println("Sugar: " + getSugar(MealPlan));
		
		if(getVegan(MealPlan)) {
			System.out.println("Vegan: Yes");
		}else {
			System.out.println("Vegan: No");
		}
		
		if(getVegetarian(MealPlan)) {
			System.out.print("Vegetarian: Yes");
		}else {
			System.out.print("Vegetarian: No");
		}
		
		System.out.println();
		
		System.out.println("Meals in meal plan: ");
		
		for(int i = 0; i < MealPlan.Meals.length; i++) {
			System.out.println(getName("meals_t", MealPlan.Meals[i]));
		}
	}
	
	public static int factorial(int num) {
		if(num == 0) {
			return 1;
		}
		
		return num*factorial(num-1);
	}
	
	public static int getNumCombo(int numOptions, int numSelected) {
		return (factorial(numOptions)/(factorial(numOptions-numSelected)*factorial(numSelected)));
	}
	
	public static int[][] generateCombinations(int Combo[][], int Meals[], int Data[], int Start, int End, int Index, int numMeals){
		
		if(Index == numMeals) {
			for(int i = 0; i < getNumCombo(Meals.length, numMeals); i++) {
				if(Combo[i][0] == 0) {
					for(int j = 0; j < numMeals; j++) {
						Combo[i][j] = Data[j];
					}
					return Combo;
				}
			}
		}
		
		for(int i = Start; i <= End && End-i+1 >= numMeals-Index; i++) {
			Data[Index] = Meals[i];
			Combo = generateCombinations(Combo, Meals, Data, i+1, End, Index+1, numMeals);
		}
		
		
		return Combo;
	}
	
	public static MealPlan[] findValidMealPlans(int Calories, double Protein, int Combo[][], int numMeals, int numCombo) throws SQLException{
		MealPlan validMealPlans[] = new MealPlan[numCombo];
		
		int validIndex = 0;
		
		for(int i = 0; i < numCombo; i++) {
			int mealPlanCalories = 0;
			
			double mealPlanProtein = 0;
			
			double mealPlanCarbs = 0;
			
			double mealPlanFat = 0;
			
			double mealPlanSugar = 0;
			
			boolean mealPlanVegan = true;
			
			boolean mealPlanVegetarian = true;
			
			int mealPlanMeals[] = new int[numMeals];
			
			for(int j = 0; j < numMeals; j++) {
				mealPlanCalories += getCalories("meals_t", getName("meals_t", Combo[i][j]));
				
				mealPlanProtein += getProtein("meals_t", getName("meals_t", Combo[i][j]));
				
				mealPlanCarbs += getCarbs("meals_t", getName("meals_t", Combo[i][j]));
				
				mealPlanFat = getFat("meals_t", getName("meals_t", Combo[i][j]));;
				
				mealPlanSugar = getSugar("meals_t", getName("meals_t", Combo[i][j]));
				
				if(mealPlanVegan && getVegan("meals_t", getName("meals_t", Combo[i][j]))) {
					mealPlanVegan = true;
				}else {
					mealPlanVegan = false;
				}
				
				if(mealPlanVegetarian && getVegetarian("meals_t", getName("meals_t", Combo[i][j]))) {
					mealPlanVegetarian = true;
				}else {
					mealPlanVegetarian = false;
				}
				
				mealPlanMeals[j] = Combo[i][j];
			}
			
			if((mealPlanCalories <= Calories) && ((Protein - (.05*Protein)) <= mealPlanProtein)) {
				
				MealPlan MealPlan = new MealPlan(mealPlanCalories, mealPlanProtein, mealPlanCarbs, mealPlanFat, mealPlanSugar, mealPlanVegan, mealPlanVegetarian, mealPlanMeals);
				
				validMealPlans[validIndex] = MealPlan;
				
				validIndex++;
			}
		}
		
		return validMealPlans;
	}
	


	public static void createMealPlan() throws SQLException {
		
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
		
		for(int i = 0; i <= Meals.length - 1; i++) {
			Meals[i] = i+1;
		}
		
		int numCombo = getNumCombo(Meals.length, numMeals);
		
		int Combo[][] = new int[numCombo][numMeals];
		
		int Data[] = new int[numMeals];
		
		Combo = generateCombinations(Combo, Meals, Data, 0, Meals.length-1, 0, numMeals);
		
		MealPlan validMealPlans[] = findValidMealPlans(Calories, Protein, Combo, numMeals, numCombo);
		
		for(int i = 0; i < validMealPlans.length; i++) {
			if(validMealPlans[i] != null) {
				printMealPlan(validMealPlans[i]);
			}
		}
		
		/*
		for (int i = 0; i < numCombo; i++) {
			for(int j = 0; j < numMeals; j++) {
				System.out.print(Combo[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		
		
	}
	
	public static void main(String[] args) throws SQLException{

		createMealPlan();

	}

}
