package listener;

import model.BasicFood;
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
import javafx.event.EventHandler;

import javafx.event.ActionEvent;

public class SubmitNewBasicFoodButtonListener extends Listener implements EventHandler<ActionEvent> {

  public SubmitNewBasicFoodButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
      MainView mainView,
      BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView, FoodConsumption foodConsumption,
      ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
    super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
        activityLevels, foodAndActivityView);
  }

  @Override
  public void handle(ActionEvent event) {

    String foodName = this.getBasicFoodView().getFoodName();
    String calories = this.getBasicFoodView().getCalories();
    String carbs = this.getBasicFoodView().getCarbs();
    String fats = this.getBasicFoodView().getFats();
    String proteins = this.getBasicFoodView().getProteins();

    if (foodName.equals("")) {
      createErrorAlert("Missing Food Name", "Please enter a name for the food item.");
      return;
    }

    if (calories.equals("")) {
      createErrorAlert("Missing Calories", "Please enter the number of calories in the food item.");
      return;
    }

    if (fats.equals("")) {
      createErrorAlert("Missing Fats", "Please enter the number of fats in the food item.");
      return;
    }

    if (carbs.equals("")) {
      createErrorAlert("Missing Carbs", "Please enter the number of carbs in the food item.");
      return;
    }

    if (proteins.equals("")) {
      createErrorAlert("Missing Proteins", "Please enter the number of proteins in the food item.");
      return;
    }

    if (super.getFoodModel().getFoodNames().contains(foodName)) {
      createErrorAlert("Food Name Already Exists",
          "A food item with the name " + foodName + " already exists.");
      return;
    }

    this.getFoodModel().addFood(new BasicFood(foodName, Double.parseDouble(calories), Double.parseDouble(fats),
        Double.parseDouble(carbs), Double.parseDouble(proteins), 1));
    super.getFoodModel().reload();
    super.getFoodConsumption().loadFoodItems(super.getFoodModel().getFoodNames());
    this.getBasicFoodView().close();
  }

}