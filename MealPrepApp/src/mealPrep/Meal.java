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

	private boolean Vegan;

	private boolean Vegitarian;

	public Meal() {

		this.Name = "Meal";

		this.Calories = 0;

		this.Protein = 0;

		this.Carbs = 0;

		this.Fat = 0;

		this.Vegan = false;

		this.Vegitarian = false;
	}

	public Meal(ArrayList<Food> Foods, ArrayList<Integer> Servings) {
		for (int i = 0; i < Foods.size(); i++) {

			this.Calories += getCalories(Foods.get(i), Servings.get(i));

			this.Protein += getProtein(Foods.get(i), Servings.get(i));

			this.Carbs += getCarbs(Foods.get(i), Servings.get(i));

			this.Fat += getFat(Foods.get(i), Servings.get(i));

			if (0 < i) {
				if (this.Vegan) {
					if (getVegan(Foods.get(i))) {
						this.Vegan = true;
					} else {
						this.Vegan = false;
					}
				}

				if (this.Vegitarian) {
					if (getVegitarian(Foods.get(i))) {
						this.Vegitarian = true;
					} else {
						this.Vegitarian = false;
					}
				}
				
			} else {
				if (getVegan(Foods.get(i))) {
					this.Vegan = true;
				} else {
					this.Vegan = false;
				}

				if (getVegitarian(Foods.get(i))) {
					this.Vegitarian = true;
				} else {
					this.Vegitarian = false;
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
