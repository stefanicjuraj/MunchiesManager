package log;

import java.time.LocalDate;

public class FoodLog extends Log {
  private String foodName;

  private double servings;

  public FoodLog(LocalDate date, LogType type, String foodName, double servings) {
    super(date, type);
    this.foodName = foodName;
    this.servings = servings;
  }

  public double getServings() {
    return servings;
  }

  public String getFoodName() {
    return foodName;
  }

  @Override
  public String getData() {
    return this.servings + " x " + this.foodName;
  }

  @Override
  public String toString() {
    return super.toString() + "," + this.foodName + "," + this.servings;
  }

}
