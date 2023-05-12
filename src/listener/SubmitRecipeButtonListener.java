package listener;

import model.ExerciseModel;
import model.Food;
import model.FoodModel;
import model.LogModel;
import model.Recipe;
import view.ActivityLevels;
import view.BasicFoodView;
import view.ExerciseView;
import view.FoodAndActivityView;
import view.FoodConsumption;
import view.MainView;
import view.RecipeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SubmitRecipeButtonListener extends Listener implements EventHandler<ActionEvent> {

  public SubmitRecipeButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {
    String recipeName = super.getRecipeView().getRecipeName();
    int numOfIngredients = super.getRecipeView().getNumberOfIngredients();
    Recipe recipe = new Recipe(recipeName, 1);

    if (numOfIngredients == 0) {
      createErrorAlert("No Ingredients", "Please add at least one ingredient.");
      return;
    }

    for (int i = 0; i < numOfIngredients; i++) {
      String ingredientName = super.getRecipeView().getIngredientName(i);

      if (ingredientName == null) {
        createErrorAlert("Missing Ingredient Name in Ingredient #" + (i + 1),
            "Please enter a name for the ingredient.");
        return;
      }

      String ingredientAmount = super.getRecipeView().getServings(i);

      if (ingredientAmount.equals("")) {
        createErrorAlert("Missing Ingredient Amount in Ingredient #" + (i + 1),
            "Please enter an amount for the ingredient.");
        return;
      }

      Food ingredient = super.getFoodModel().findFood(ingredientName);
      ingredient.setQuantity(Double.parseDouble(ingredientAmount));
      recipe.addIngredient(ingredient);
    }

    if (recipeName.equals("")) {
      createErrorAlert("Missing Recipe Name", "Please enter a name for the recipe.");
      return;
    }

    if (super.getFoodModel().getFoodNames().contains(recipeName)) {
      createErrorAlert("Recipe Name Already Exists",
          "A recipe with the name " + recipeName + " already exists.");
      return;
    }

    super.getFoodModel().addFood(recipe);
    super.getFoodModel().reload();
    super.getFoodConsumption().loadFoodItems(super.getFoodModel().getFoodNames());
    super.getRecipeView().close();
  }

}