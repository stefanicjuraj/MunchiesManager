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

//Created
public class ActivityLevels extends VBox implements ComponentView {

  @FXML
  private Hyperlink addNewExerciseHyperlink;

  @FXML
  private Button backHomeFromActivityButton;

  @FXML
  private Button buttonSelectExercise;

  @FXML
  private ComboBox<String> dailyActivityExerciseComboBox;

  @FXML
  private TextField dailyActivityTimeTextField;

  public ActivityLevels() {
    Parent root = FXMLLoaderFactory.load("activityLevels.fxml", this).getRoot();
    this.getChildren().add(root);
  }

  public void clear() {
    dailyActivityExerciseComboBox.setValue("");
    dailyActivityTimeTextField.clear();
  }

  public void handleButtonBackToHomeFromActivity(EventHandler<ActionEvent> eventHandler) {
    backHomeFromActivityButton.setOnAction(eventHandler);
  }

  public void loadExerciseNames(List<String> exerciseNames) {
    dailyActivityExerciseComboBox.setItems(FXCollections.observableArrayList(exerciseNames));
  }

  public void handleButtonSelectExercise(EventHandler<ActionEvent> eventHandler) {
    buttonSelectExercise.setOnAction(eventHandler);
  }

  public String getSelectedExercise() {
    return dailyActivityExerciseComboBox.getValue();
  }

  public String getExerciseDuration() {
    return dailyActivityTimeTextField.getText();
  }

  public void handleAddNewExerciseHyperlink(EventHandler<ActionEvent> eventHandler) {
    addNewExerciseHyperlink.setOnAction(eventHandler);
  }
}