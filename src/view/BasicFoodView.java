package view;

import util.FXMLLoaderFactory;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BasicFoodView implements View {

  @FXML
  private TextField caloriesTextField;

  @FXML
  private TextField carbsTextField;

  @FXML
  private TextField fatsTextField;

  @FXML
  private TextField foodNameTextField;

  @FXML
  private TextField proteinsTextField;

  @FXML
  private Button goToRecipeScreenButton;

  @FXML
  private Button submitNewFoodItemButton;

  @FXML
  private Button backToHomeButtonFromItem;

  private Stage basicFoodStage;

  public BasicFoodView() {
    basicFoodStage = new Stage();
    AnchorPane basicFoodRoot = FXMLLoaderFactory.load("newBasicFoodScreen.fxml", this).getRoot();
    Scene basicFoodScene = new Scene(basicFoodRoot);
    basicFoodStage.setScene(basicFoodScene);
  }

  public void clear() {
    foodNameTextField.clear();
    caloriesTextField.clear();
    carbsTextField.clear();
    fatsTextField.clear();
    proteinsTextField.clear();
  }

  public void show() {
    basicFoodStage.show();
  }

  public void close() {
    basicFoodStage.close();
  }

  public String getFoodName() {
    return foodNameTextField.getText();
  }

  public String getCalories() {
    return caloriesTextField.getText();
  }

  public String getCarbs() {
    return carbsTextField.getText();
  }

  public String getFats() {
    return fatsTextField.getText();
  }

  public String getProteins() {
    return proteinsTextField.getText();
  }

  public void handleGoToRecipeScreenButton(EventHandler<ActionEvent> event) {
    goToRecipeScreenButton.setOnAction(event);
  }

  public void handleBackToHomeButtonFromItem(EventHandler<ActionEvent> event) {
    backToHomeButtonFromItem.setOnAction(event);
  }

  public void handleSubmitNewBasicFoodButton(EventHandler<ActionEvent> event) {
    submitNewFoodItemButton.setOnAction(event);
  }
}