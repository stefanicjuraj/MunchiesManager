package controller;

import listener.*;
import model.*;
import view.*;

import java.time.LocalDate;

public class MunchiesManagerController {
        private FoodModel foodModel;
        private LogModel logModel;
        private ExerciseModel exerciseModel;
        private MainView mainView;
        private BasicFoodView basicFoodView;
        private RecipeView recipeView;
        private ExerciseView exerciseView;
        private FoodConsumption foodConsumption;
        private ActivityLevels activityLevels;
        private FoodAndActivityView foodAndActivityView;

        public MunchiesManagerController(FoodModel foodModel, LogModel logModel, ExerciseModel exerciseModel,
                        MainView mainView,
                        BasicFoodView basicFoodView,
                        RecipeView recipeView, ExerciseView exerciseView,
                        FoodConsumption foodConsumption,
                        ActivityLevels activityLevels, FoodAndActivityView foodAndActivityView) {
                this.foodModel = foodModel;
                this.logModel = logModel;
                this.mainView = mainView;
                this.basicFoodView = basicFoodView;
                this.recipeView = recipeView;
                this.exerciseModel = exerciseModel;
                this.exerciseView = exerciseView;
                this.foodConsumption = foodConsumption;
                this.activityLevels = activityLevels;
                this.foodAndActivityView = foodAndActivityView;

                LocalDate currentDate = LocalDate.now();

                double calorieIntake = this.foodModel.getTotalCalories(
                                this.logModel.getFoodsAndServingsByDate(currentDate));
                double caloriesBurnt = this.exerciseModel.getTotalCaloriesBurned(
                                logModel.getExercisesAndDurationsByDate(currentDate),
                                logModel.getWeight(currentDate));

                double netCalories = calorieIntake - caloriesBurnt;

                double calorieGoal = this.logModel.getCalorieGoal(currentDate);

                double goalNetDifference = this.logModel.getCalorieGoal(currentDate) - netCalories;

                this.mainView.load(this.foodAndActivityView, logModel.getLogsByDate(currentDate),
                                currentDate, calorieGoal,
                                logModel.getWeight(currentDate),
                                calorieIntake,
                                caloriesBurnt,
                                netCalories, goalNetDifference,
                                netCalories / calorieGoal);
                this.foodConsumption.handleAddNewRecipeHyperlink(
                                new AddNewRecipeHyperlinkListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.foodConsumption.handleAddNewBasicFoodHyperlink(
                                new AddNewBasicFoodHyperlinkListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.mainView.handleDatePicker(new DatePickerListener(foodModel, logModel, exerciseModel, mainView,
                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                activityLevels, foodAndActivityView));
                this.mainView.handleUpdateCaloriesButton(
                                new UpdateCaloriesButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.mainView.handleUpdateWeightButton(
                                new UpdateWeightButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.foodConsumption.handleButtonDailyConsumptionSelect(
                                new ButtonDailyConsumptionSelectListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.basicFoodView.handleGoToRecipeScreenButton(
                                new GoToRecipeScreenButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.basicFoodView.handleBackToHomeButtonFromItem(
                                new BackToHomeButtonFromBasicFoodListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.basicFoodView.handleSubmitNewBasicFoodButton(
                                new SubmitNewBasicFoodButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.recipeView.handleBackToHomeButtonFromRecipe(
                                new BackToHomeButtonFromRecipeListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.recipeView.handleSubmitRecipeButton(
                                new SubmitRecipeButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.recipeView.handleAddMoreIngredientsButton(
                                new AddMoreIngredientsButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.recipeView.handleClearButton(
                                new ClearButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.mainView.handleTableView(new TableViewListener(foodModel, logModel, exerciseModel, mainView,
                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                activityLevels, foodAndActivityView));
                this.foodAndActivityView.handleFoodConsumptionButton(new FoodConsumptionButtonListener(foodModel,
                                logModel,
                                exerciseModel, mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
                                activityLevels, foodAndActivityView));
                this.foodAndActivityView.handleActivityLevelsButton(
                                new ActivityLevelsButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.foodConsumption.handleButtonBackToHomeFromFoodConsumption(
                                new BackToHomeButtonFromFoodConsumptionListener(foodModel, logModel, exerciseModel,
                                                mainView, basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.activityLevels.handleButtonBackToHomeFromActivity(new BackToHomeButtonFromActivityListener(
                                foodModel, logModel, exerciseModel, mainView, basicFoodView, recipeView, exerciseView,
                                foodConsumption, activityLevels, foodAndActivityView));

                this.activityLevels.handleButtonSelectExercise(
                                new ButtonSelectExerciseListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.activityLevels.handleAddNewExerciseHyperlink(
                                new AddNewExerciseHyperlinkListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.exerciseView.handleSubmitNewExerciseButton(
                                new SubmitNewExerciseButtonListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
                this.exerciseView.handleBackToHomeButtonFromExercise(
                                new BackToHomeButtonFromExerciseListener(foodModel, logModel, exerciseModel, mainView,
                                                basicFoodView, recipeView, exerciseView, foodConsumption,
                                                activityLevels, foodAndActivityView));
        }
}