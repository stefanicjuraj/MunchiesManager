package listener;

import model.Exercise;
import model.ExerciseModel;
import model.FoodModel;
import model.LogModel;
import view.ActivityLevels;
import view.BasicFoodView;
import view.ExerciseView;
import view.FoodConsumption;
import view.FoodAndActivityView;
import view.MainView;
import view.RecipeView;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;

public class SubmitNewExerciseButtonListener extends Listener implements EventHandler<ActionEvent> {

  public SubmitNewExerciseButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {

    String exerciseName = this.getExerciseView().getExerciseName();
    String burntCalories = this.getExerciseView().getBurntCalories();

    if (exerciseName.equals("")) {
      createErrorAlert("Missing Exercise Name", "Please enter a name for the exercise.");
      return;
    }

    if (burntCalories.equals("")) {
      createErrorAlert("Missing Burnt Calories", "Please enter the number of calories burnt by the exercise.");
      return;
    }

    if (super.getExerciseModel().getExercisesNames().contains(exerciseName)) {
      createErrorAlert("Food Name Already Exists",
          "An exercise with the name " + exerciseName + " already exists.");
      return;
    }

    Exercise exercise = new Exercise(exerciseName, Double.parseDouble(burntCalories));
    this.getExerciseModel().addExercise(exercise);
    this.getExerciseModel().reload();
    this.getExerciseView().close();

    this.getActivityLevels().loadExerciseNames(this.getExerciseModel().getExercisesNames());

    this.getExerciseView().clear();
  }

}