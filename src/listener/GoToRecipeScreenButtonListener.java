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
import javafx.event.EventHandler;

import javafx.event.ActionEvent;

public class GoToRecipeScreenButtonListener extends Listener implements EventHandler<ActionEvent> {

    public GoToRecipeScreenButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
            MainView mainView,
            BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView,
            FoodConsumption foodConsumption,
            ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
        super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
                activityLevels, foodAndActivityView);
    }

    @Override
    public void handle(ActionEvent event) {
        this.getBasicFoodView().close();
        this.getRecipeView().show();
    }

}