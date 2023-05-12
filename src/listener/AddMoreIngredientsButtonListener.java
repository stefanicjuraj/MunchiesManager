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

public class AddMoreIngredientsButtonListener extends Listener implements EventHandler<ActionEvent> {

  public AddMoreIngredientsButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {
    super.getRecipeView().addIngredientComponent(super.getFoodModel().getFoodNames(),
        new AllIngredientComponentsRemoveButtonListener(super.getFoodModel(), super.getLogModel(),
            super.getExerciseModel(), super.getMainView(),
            super.getBasicFoodView(), super.getRecipeView(), super.getExerciseView(), super.getFoodConsumption(),
            super.getActivityLevels(), super.getFoodAndActivityView()));
  }

}