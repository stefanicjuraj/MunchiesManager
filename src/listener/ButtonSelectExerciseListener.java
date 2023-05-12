package listener;

import java.time.LocalDate;

import log.ExerciseLog;
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

//create
public class ButtonSelectExerciseListener extends Listener implements EventHandler<ActionEvent> {

  public ButtonSelectExerciseListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {
    LocalDate dateSelected = this.getMainView().getSelectedDate();

    String exerciseName = this.getActivityLevels().getSelectedExercise();
    double timeSpent = Double.parseDouble(this.getActivityLevels().getExerciseDuration());
    this.getLogModel().addLog(new ExerciseLog(dateSelected, LogType.E, exerciseName, timeSpent));
    this.getLogModel().reload();
    this.getMainView().loadLogs(this.getLogModel().getLogsByDate(this.getMainView().getSelectedDate()));
    updateStats();
    this.getActivityLevels().clear();
  }

}