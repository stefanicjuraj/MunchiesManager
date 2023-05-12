package view;

import util.FXMLLoaderFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;

import javafx.scene.control.Button;

import javafx.scene.layout.VBox;

public class FoodAndActivityView extends VBox implements ComponentView {

  @FXML
  private Button activityLevelsButton;

  @FXML
  private Button foodConsumptionButton;

  @FXML
  private VBox foodAndActivityVbox;

  public FoodAndActivityView() {
    Parent root = FXMLLoaderFactory.load("foodAndActivityVbox.fxml", this).getRoot();
    this.getChildren().add(root);
  }

  public void handleActivityLevelsButton(EventHandler<ActionEvent> eventHandler) {
    activityLevelsButton.setOnAction(eventHandler);
  }

  public void handleFoodConsumptionButton(EventHandler<ActionEvent> eventHandler) {
    foodConsumptionButton.setOnAction(eventHandler);
  }
}