package listener;

import model.ExerciseModel;
import model.FoodModel;
import model.LogModel;
import view.ActivityLevels;
import view.BasicFoodView;
import view.ExerciseView;
import view.FoodConsumption;
import view.FoodAndActivityView;
import view.IngredientComponent;
import view.MainView;
import view.RecipeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AllIngredientComponentsRemoveButtonListener extends Listener implements EventHandler<ActionEvent> {

  public AllIngredientComponentsRemoveButtonListener(FoodModel foodModel, LogModel logModel,
      ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {
    Button source = (Button) event.getSource();
    GridPane component = (GridPane) source.getParent();

    this.getRecipeView().removeIngredientComponent((IngredientComponent) component.getParent());
  }

}