package listener;

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
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TableViewListener extends Listener implements EventHandler<MouseEvent> {

  public TableViewListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(MouseEvent event) {
    if (event.getClickCount() == 2 && this.getMainView().getSelectedLog() != null) {
      Log selectedLog = this.getMainView().getSelectedLog();
      getLogModel().removeRow(selectedLog.toString());
      this.getLogModel().reload();
      this.getMainView().updateTableView(this.getLogModel().getLogsByDate(this.getMainView().getSelectedDate()));
      updateStats();
    }
  }

}