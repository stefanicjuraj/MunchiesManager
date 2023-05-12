package listener;

import java.time.LocalDate;

import log.FoodLog;
import log.LogType;
import model.ExerciseModel;
import model.FoodModel;
import model.LogModel;
import view.ActivityLevels;
import view.BasicFoodView;
import view.ExerciseView;
import view.FoodConsumption;
import view.MainView;
import view.FoodAndActivityView;
import view.RecipeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonDailyConsumptionSelectListener extends Listener implements EventHandler<ActionEvent> {

  public ButtonDailyConsumptionSelectListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {

    String foodName = this.getFoodConsumption().getSelectedFood();
    String servings = this.getFoodConsumption().getServings();
    LocalDate dateSelected = this.getMainView().getSelectedDate();

    if (foodName == null) {
      createErrorAlert("Missing Food Name", "Please select a food to log.");
      return;
    }

    if (servings.equals("")) {
      createErrorAlert("Missing Servings", "Please enter the number of servings.");
      return;
    }

    this.getLogModel()
        .addLog(new FoodLog(dateSelected, LogType.F, foodName, Double.parseDouble(servings)));
    this.getLogModel().reload();
    this.getMainView().loadLogs(this.getLogModel().getLogsByDate(this.getMainView().getSelectedDate()));
    updateStats();
    this.getFoodConsumption().clear();
  }

}