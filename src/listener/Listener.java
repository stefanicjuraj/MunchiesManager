package listener;

import model.*;
import view.BasicFoodView;
import view.ExerciseView;
import view.FoodAndActivityView;
import view.MainView;
import view.RecipeView;
import view.ActivityLevels;
import view.FoodConsumption;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Listener {
  private FoodModel foodModel;
  private LogModel logModel;
  private ExerciseModel exerciseModel;
  private MainView mainView;
  private BasicFoodView basicFoodView;
  private RecipeView recipeView;
  private ExerciseView exerciseView;
  private ActivityLevels activityLevels;
  private FoodConsumption foodConsumption;
  private FoodAndActivityView foodAndActivityView;

  protected Listener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel, MainView mainView,
      BasicFoodView basicFoodView,
      RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    this.foodModel = foodModel;
    this.logModel = logModel;
    this.exerciseModel = exerciseModel;
    this.mainView = mainView;
    this.basicFoodView = basicFoodView;
    this.recipeView = recipeView;
    this.exerciseView = exerciseView;
    this.activityLevels = activityLevels;
    this.foodConsumption = foodConsumption;
    this.foodAndActivityView = foodAndActivityView;
  }

  protected FoodModel getFoodModel() {
    return foodModel;
  }

  protected LogModel getLogModel() {
    return logModel;
  }

  protected MainView getMainView() {
    return mainView;
  }

  protected BasicFoodView getBasicFoodView() {
    return basicFoodView;
  }

  protected RecipeView getRecipeView() {
    return recipeView;
  }

  protected ExerciseModel getExerciseModel() {
    return exerciseModel;
  }

  protected ExerciseView getExerciseView() {
    return exerciseView;
  }

  protected ActivityLevels getActivityLevels() {
    return activityLevels;
  }

  protected FoodConsumption getFoodConsumption() {
    return foodConsumption;
  }

  protected FoodAndActivityView getFoodAndActivityView() {
    return foodAndActivityView;
  }

  protected void createErrorAlert(String headerText, String contentText) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("ERROR");
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);
    alert.showAndWait();
  }

  protected void updateStats() {

    double caloriesGoal = this.getLogModel().getCalorieGoal(this.getMainView().getSelectedDate());

    double calorieIntake = this.getFoodModel().getTotalCalories(
        this.getLogModel().getFoodsAndServingsByDate(this.getMainView().getSelectedDate()));

    double caloriesBurnt = getExerciseModel().getTotalCaloriesBurned(
        this.getLogModel().getExercisesAndDurationsByDate(this.getMainView().getSelectedDate()),
        this.getLogModel().getWeight(this.getMainView().getSelectedDate()));

    double netCalories = calorieIntake - caloriesBurnt;

    double weight = this.getLogModel().getWeight(this.getMainView().getSelectedDate());

    this.getMainView().updateWeightTextField(weight);
    this.getMainView().updateTotalCalorieIntakeGoalTextField(caloriesGoal);
    this.getMainView().updateCalorieIntake(calorieIntake);
    this.getMainView().updateCaloriesBurnt(caloriesBurnt);
    this.getMainView().updateNetCalories(netCalories);
    this.getMainView().updategoalNetDifference(caloriesGoal - netCalories);
    this.getMainView().updateCaloriesProgressIndicator(netCalories / caloriesGoal);
  }

}