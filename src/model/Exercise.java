package model;

public class Exercise {
  private String exerciseName;
  private double caloriesBurnedByHour;

  public Exercise(String exerciseName, double caloriesBurnedByHour) {
    this.exerciseName = exerciseName;
    this.caloriesBurnedByHour = caloriesBurnedByHour;
  }

  public String getExerciseName() {
    return exerciseName;
  }

  public double getCaloriesBurnedByHour() {
    return caloriesBurnedByHour;
  }

  public String toString() {
    return "e," + this.exerciseName + "," + this.caloriesBurnedByHour;
  }

}