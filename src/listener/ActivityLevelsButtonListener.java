package listener;

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

//Create
public class ActivityLevelsButtonListener extends Listener implements EventHandler<ActionEvent> {

  public ActivityLevelsButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {
    super.getMainView().displayComponentView(super.getActivityLevels());
    super.getActivityLevels().loadExerciseNames(super.getExerciseModel().getExercisesNames());
  }
  
}