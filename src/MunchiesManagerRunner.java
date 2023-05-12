package mm;

import controller.MunchiesManagerController;
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
import javafx.application.Application;
import javafx.stage.Stage;

public class MunchiesManagerRunner extends Application {
  @Override
  public void start(Stage stage) {

    new MunchiesManagerController(new FoodModel("foods.csv"), new LogModel("log.csv"),
        new ExerciseModel("exercise.csv"),
        new MainView(), new BasicFoodView(),
        new RecipeView(), new ExerciseView(), new FoodConsumption(), new ActivityLevels(), new FoodAndActivityView());
  }

  public static void main(String[] args) {
    launch(args);
  }

}