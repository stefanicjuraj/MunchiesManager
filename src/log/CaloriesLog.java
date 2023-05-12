package log;

import java.time.LocalDate;

public class CaloriesLog extends Log {
  private double calories;

  public CaloriesLog(LocalDate date, LogType type, double calories) {
    super(date, type);
    this.calories = calories;
  }

  public double getCalories() {
    return calories;
  }

  @Override
  public String getData() {
    return String.valueOf(this.calories);
  }

  @Override
  public String toString() {
    return super.toString() + "," + this.calories;
  }

}