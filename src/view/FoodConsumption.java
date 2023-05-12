package view;

import java.util.List;

import util.FXMLLoaderFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FoodConsumption extends VBox implements ComponentView {

  @FXML
  private Hyperlink addNewBasicFoodHyperlink;

  @FXML
  private Hyperlink addNewRecipeHyperlink;

  @FXML
  private Button backHomeFromFoodConsumptionButton;

  @FXML
  private Button buttonDailyConsumptionSelect;

  @FXML
  private ComboBox<String> dailyConsumptionFoodComboBox;

  @FXML
  private TextField dailyConsumptionServingsTextField;

  public FoodConsumption() {
    Parent root = FXMLLoaderFactory.load("foodConsumption.fxml", this).getRoot();
    this.getChildren().add(root);
  }

  public void clear() {
    dailyConsumptionFoodComboBox.setValue("");
    dailyConsumptionServingsTextField.clear();
  }

  public void setDefaultServings(double servings) {
    dailyConsumptionServingsTextField.setText(String.valueOf(servings));
  }

  public String getSelectedFood() {
    return dailyConsumptionFoodComboBox.getValue();
  }

  public String getServings() {
    return dailyConsumptionServingsTextField.getText();
  }

  public void loadFoodItems(List<String> foodItems) {
    dailyConsumptionFoodComboBox.setItems(FXCollections.observableArrayList(foodItems));
  }

  public void handleAddNewRecipeHyperlink(EventHandler<ActionEvent> eventHandler) {
    addNewRecipeHyperlink.setOnAction(eventHandler);
  }

  public void handleAddNewBasicFoodHyperlink(EventHandler<ActionEvent> eventHandler) {
    addNewBasicFoodHyperlink.setOnAction(eventHandler);
  }

  public void handleFoodsComboBox(EventHandler<ActionEvent> eventHandler) {
    dailyConsumptionFoodComboBox.setOnAction(eventHandler);
  }

  public void handleButtonDailyConsumptionSelect(EventHandler<ActionEvent> eventHandler) {
    buttonDailyConsumptionSelect.setOnAction(eventHandler);
  }

  public void handleButtonBackToHomeFromFoodConsumption(EventHandler<ActionEvent> eventHandler) {
    backHomeFromFoodConsumptionButton.setOnAction(eventHandler);
  }
}
