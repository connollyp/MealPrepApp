package mealPrep;

import java.util.ArrayList;

public class Meal extends Food {

	private String Name;

	private ArrayList<Food> Foods = new ArrayList<Food>();

	private ArrayList<Integer> Servings = new ArrayList<Integer>();

	private int Calories;

	private int Protein;

	private int Carbs;

	private int Fat;
	
	private int Sugar;

	private boolean Vegan;

	private boolean Vegetarian;
	
	private int StandardServing;
	
	private String ServingUnit;

	public Meal() {

		this.Name = "Meal";

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;
		
		this.Sugar = 0;

		this.Vegan = false;

		this.Vegetarian = false;
	}

	public Meal(ArrayList<Food> Foods, ArrayList<Integer> Servings) {
		for (int i = 0; i < Foods.size(); i++) {

			this.Calories += getCalories(Foods.get(i), Servings.get(i));

			this.Protein += getProtein(Foods.get(i), Servings.get(i));

			this.Carbs += getCarbs(Foods.get(i), Servings.get(i));

			this.Fat += getFat(Foods.get(i), Servings.get(i));
			
			this.Sugar += getSugar(Foods.get(i), Servings.get(i));

			if (0 < i) {
				if (this.Vegan) {
					if (getVegan(Foods.get(i))) {
						this.Vegan = true;
					} else {
						this.Vegan = false;
					}
				}

				if (this.Vegetarian) {
					if (getVegetarian(Foods.get(i))) {
						this.Vegetarian = true;
					} else {
						this.Vegetarian = false;
					}
				}
				
			} else {
				if (getVegan(Foods.get(i))) {
					this.Vegan = true;
				} else {
					this.Vegan = false;
				}

				if (getVegetarian(Foods.get(i))) {
					this.Vegetarian = true;
				} else {
					this.Vegetarian = false;
				}
			}

		}
	}
	
	public static String getName(Meal Meal) {
		return Meal.Name;
	}
	
	public static int getCalories(Meal Meal, int Serving) {
		return Meal.Calories * Serving;
	}
	
	public static int getProtein(Meal Meal, int Serving) {
		return Meal.Protein * Serving;
	}
	
	public static int getCarbs(Meal Meal, int Serving) {
		return Meal.Carbs * Serving;
	}
	
	public static int getFat(Meal Meal, int Serving) {
		return Meal.Fat * Serving;
	}
	
	public static int getSugar(Meal Meal, int Serving) {
		return Meal.Sugar * Serving;
	}
	
	public static boolean getVegan(Meal Meal) {
		return Meal.Vegan;
	}
	
	public static boolean getVegetarian(Meal Meal) {
		return Meal.Vegetarian;
	}
	
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
	
	

	public static void main(String[] args) {

	}

}
