package view;

import log.Log;
import log.LogType;
import util.FXMLLoaderFactory;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.scene.text.Text;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;

public class MainView {

  @FXML
  private Button activityLevelsButton;

  @FXML
  private TextField calorieGoalText;

  @FXML
  private Text calorieIntakeText;

  @FXML
  private Text caloriesBurntText;

  @FXML
  private ProgressIndicator caloriesProgressIndicator;

  @FXML
  private TableColumn<Log, String> dataColumn;

  @FXML
  private TableColumn<Log, Date> dateColumn;

  @FXML
  private DatePicker datePicker;

  @FXML
  private Button foodConsumptionButton;

  @FXML
  private TableColumn<Log, LogType> logTypeColumn;

  @FXML
  private Text netCaloriesText;

  @FXML
  private Text goalNetDifferenceText;

  @FXML
  private TableView<Log> tableView;

  @FXML
  private Button updateCaloriesButton;

  @FXML
  private Button updateWeightButton;

  @FXML
  private TextField weightText;

  @FXML
  private VBox foodAndActivityVbox;

  private Stage stage;

  public MainView() {
    Parent root = FXMLLoaderFactory.load("landingScreen.fxml", this).getRoot();
    Scene scene = new Scene(root);
    this.stage = new Stage();
    stage.setScene(scene);
    stage.show();
  };

  public void load(ComponentView componentView, List<Log> logs, LocalDate date, double calories,
      double weight, double totalCalorieIntake, double totalCaloriesBurnt, double netCalories,
      double goalNetDifference, double caloriesProgress) {
    loadLogs(logs);
    displayComponentView(componentView);
    setDatePickerDate(date);
    setDefaultCaloriesGoal(calories);
    setDefaultWeight(weight);
    updateCalorieIntake(totalCalorieIntake);
    updateCaloriesBurnt(totalCaloriesBurnt);
    updateNetCalories(netCalories);
    updategoalNetDifference(goalNetDifference);
    updateCaloriesProgressIndicator(caloriesProgress);
  }

  public void setDefaultCaloriesGoal(double calories) {
    calorieGoalText.setText(String.valueOf(calories));
  }

  public void setDefaultWeight(double weight) {
    weightText.setText(String.valueOf(weight));
  }

  public void setDatePickerDate(LocalDate date) {
    datePicker.setValue(date);
  }

  public LocalDate getSelectedDate() {
    return datePicker.getValue();
  }

  public String getCalories() {
    return calorieGoalText.getText();
  }

  public String getWeight() {
    return weightText.getText();
  }

  public void show() {
    stage.show();
  }

  public void close() {
    stage.close();
  }

  public void loadLogs(List<Log> logs) {

    ObservableList<Log> data = FXCollections.observableArrayList();
    data.addAll(logs);

    dateColumn.setCellValueFactory(new PropertyValueFactory<>("localDate"));
    logTypeColumn.setCellValueFactory(new PropertyValueFactory<>("logType"));
    dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
    tableView.setItems(data);
  }

  public void updateTableView(List<Log> logs) {
    loadLogs(logs);
  }

  public void handleTableView(EventHandler<MouseEvent> eventHandler) {
    tableView.setOnMouseClicked(eventHandler);
  }

  public void handleDatePicker(EventHandler<ActionEvent> eventHandler) {
    datePicker.setOnAction(eventHandler);
  }

  public void handleUpdateCaloriesButton(EventHandler<ActionEvent> eventHandler) {
    updateCaloriesButton.setOnAction(eventHandler);
  }

  public void handleUpdateWeightButton(EventHandler<ActionEvent> eventHandler) {
    updateWeightButton.setOnAction(eventHandler);
  }

  public void handleRowDoubleClick(EventHandler<MouseEvent> eventHandler) {
    tableView.setOnMouseClicked(eventHandler);
  }

  public Log getSelectedLog() {
    return this.tableView.getSelectionModel().getSelectedItem();
  }

  public void displayComponentView(ComponentView componentView) {
    foodAndActivityVbox.getChildren().clear();
    foodAndActivityVbox.getChildren().add((VBox) componentView);
  }

  public void updateCalorieIntake(double totalCalories) {
    calorieIntakeText.setText(String.valueOf(totalCalories));
  }

  public void updateTotalCalorieIntakeGoalTextField(double totalCalorieIntake) {
    calorieGoalText.setText(String.valueOf(totalCalorieIntake));
  }

  public void updateWeightTextField(double weight) {
    weightText.setText(String.valueOf(weight));
  }

  public void updateCaloriesBurnt(double caloriesBurnt) {
    caloriesBurntText.setText(String.valueOf(caloriesBurnt));
  }

  public void updateNetCalories(double netCalories) {
    netCaloriesText.setText(String.valueOf(netCalories));
  }

  public void updategoalNetDifference(double goalNetDifference) {
    goalNetDifferenceText.setText(String.valueOf(goalNetDifference));
  }

  public void updateCaloriesProgressIndicator(double progress) {
    caloriesProgressIndicator.setProgress(progress);
  }
}