package listener;

import java.time.LocalDate;
import java.util.List;

import log.Log;
import model.ExerciseModel;
import model.FoodModel;
import model.LogModel;
import view.ActivityLevels;
import view.BasicFoodView;
import view.ExerciseView;
import view.FoodAndActivityView;
import view.FoodConsumption;
import view.MainView;
import view.RecipeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DatePickerListener extends Listener implements EventHandler<ActionEvent> {

  public DatePickerListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {

    LocalDate dateSelected = this.getMainView().getSelectedDate();
    List<Log> logs = this.getLogModel().getLogsByDate(dateSelected);
    this.getMainView().updateTableView(logs);

    double totalCalorieIntakeGoal = this.getLogModel().getCalorieGoal(dateSelected);

    this.getMainView().updateTotalCalorieIntakeGoalTextField(totalCalorieIntakeGoal);

    double weight = this.getLogModel().getWeight(dateSelected);

    this.getMainView().updateWeightTextField(weight);
    updateStats();
    this.getActivityLevels().clear();
    this.getFoodConsumption().clear();
  }

}