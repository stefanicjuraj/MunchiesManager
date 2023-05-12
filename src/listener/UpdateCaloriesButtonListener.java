package listener;

import log.CaloriesLog;
import log.LogType;
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

import java.time.LocalDate;
import javafx.event.ActionEvent;

public class UpdateCaloriesButtonListener extends Listener implements EventHandler<ActionEvent> {

    public UpdateCaloriesButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
            MainView mainView,
            BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView,
            FoodConsumption foodConsumption,
            ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
        super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
                activityLevels, foodAndActivityView);
    }

    @Override
    public void handle(ActionEvent event) {
        double calories = Double.parseDouble(this.getMainView().getCalories());
        LocalDate date = this.getMainView().getSelectedDate();
        this.getLogModel().addLog(new CaloriesLog(date, LogType.C, calories));
        this.getLogModel().reload();
        this.getMainView().loadLogs(this.getLogModel().getLogsByDate(this.getMainView().getSelectedDate()));
        updateStats();
    }

}