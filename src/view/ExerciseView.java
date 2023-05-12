package view;

import util.FXMLLoaderFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExerciseView implements View {

  @FXML
  private TextField burntCaloriesTextField;

  @FXML
  private Button backToHomeButtonFromExercise;

  @FXML
  private TextField exerciseNameTextField;

  @FXML
  private Button submitNewExerciseButton;

  private Stage exerciseStage;

  public ExerciseView() {
    exerciseStage = new Stage();
    AnchorPane exerciseRoot = FXMLLoaderFactory.load("newExercise.fxml", this).getRoot();
    Scene exerciseScene = new Scene(exerciseRoot);
    exerciseStage.setScene(exerciseScene);
  }

  @Override
  public void show() {
    exerciseStage.show();
  }

  @Override
  public void close() {
    exerciseStage.close();
  }

  public void clear() {
    exerciseNameTextField.clear();
    burntCaloriesTextField.clear();
  }

  public String getExerciseName() {
    return exerciseNameTextField.getText();
  }

  public String getBurntCalories() {
    return burntCaloriesTextField.getText();
  }

  public void handleSubmitNewExerciseButton(EventHandler<ActionEvent> eventHandler) {
    submitNewExerciseButton.setOnAction(eventHandler);
  }

  public void handleBackToHomeButtonFromExercise(EventHandler<ActionEvent> eventHandler) {
    backToHomeButtonFromExercise.setOnAction(eventHandler);
  }

}
