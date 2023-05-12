package listener;

import log.LogType;
import log.WeightLog;
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
import java.time.LocalDate;

public class UpdateWeightButtonListener extends Listener implements EventHandler<ActionEvent> {

    public UpdateWeightButtonListener(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
            MainView mainView,
            BasicFoodView basicFoodView, RecipeView recipeView, ExerciseView exerciseView,
            FoodConsumption foodConsumption,
            ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
        super(foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
                activityLevels, foodAndActivityView);
    }

    @Override
    public void handle(ActionEvent event) {
        double weight = Double.parseDouble(this.getMainView().getWeight());
        LocalDate date = this.getMainView().getSelectedDate();
        this.getLogModel().addLog(new WeightLog(date, LogType.W, weight));
        this.getLogModel().reload();
        this.getMainView().loadLogs(this.getLogModel().getLogsByDate(this.getMainView().getSelectedDate()));
        updateStats();
    }

}