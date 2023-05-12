package model;

public class BasicFood extends Food {

  private double calories;
  private double fat;
  private double carbs;
  private double protein;

  public BasicFood(String foodName, double calories, double fat, double carbs, double protein, double quantity) {
    super(foodName, quantity);
    this.calories = calories;
    this.fat = fat;
    this.carbs = carbs;
    this.protein = protein;
  }

  public double getCalories() {
    return calories;
  }

  public double getFat() {
    return fat;
  }

  public double getCarbs() {
    return carbs;
  }

  public double getProtein() {
    return protein;
  }

  public String toString() {
    return "b," + super.getName() + "," + this.calories + "," + this.fat + "," + this.carbs + "," + this.protein;
  }

}