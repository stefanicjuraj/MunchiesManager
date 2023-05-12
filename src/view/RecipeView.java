package view;

import util.FXMLLoaderFactory;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;

import java.util.List;

public class RecipeView implements View {

  @FXML
  private Button addMoreIngredientsButton;

  @FXML
  private Button backToHomeButtonFromRecipe;

  @FXML
  private TextField recipeNameTextField;

  @FXML
  private Button clearButton;

  @FXML
  private VBox scrollpaneVbox;

  @FXML
  private Button submitRecipeButton;

  @FXML
  private ScrollPane scrollPane;

  private Stage recipeStage;

  public RecipeView() {
    recipeStage = new Stage();
    AnchorPane recipeRoot = FXMLLoaderFactory.load("newRecipeScreen.fxml", this).getRoot();
    Scene recipeScene = new Scene(recipeRoot);
    recipeStage.setScene(recipeScene);
  }

  public void clear() {
    recipeNameTextField.clear();
    scrollpaneVbox.getChildren().clear();
  }

  public void show() {
    recipeStage.show();
  }

  public void close() {
    recipeStage.close();
  }

  public void addIngredientComponent(List<String> list, EventHandler<ActionEvent> eventHandler) {
    scrollpaneVbox.getChildren().add(new IngredientComponent(list, eventHandler));
  }

  public int getNumberOfIngredients() {
    return scrollpaneVbox.getChildren().size();
  }

  public String getIngredientName(int i) {
    return ((IngredientComponent) scrollpaneVbox.getChildren().get(i)).getIngredientName();
  }

  public String getServings(int i) {
    return ((IngredientComponent) scrollpaneVbox.getChildren().get(i)).getServings();
  }

  public String getRecipeName() {
    return recipeNameTextField.getText();
  }

  public void handleBackToHomeButtonFromRecipe(EventHandler<ActionEvent> eventHandler) {
    backToHomeButtonFromRecipe.setOnAction(eventHandler);
  }

  public void handleSubmitRecipeButton(EventHandler<ActionEvent> eventHandler) {
    submitRecipeButton.setOnAction(eventHandler);
  }

  public void handleAddMoreIngredientsButton(EventHandler<ActionEvent> eventHandler) {
    addMoreIngredientsButton.setOnAction(eventHandler);
  }

  public void handleClearButton(EventHandler<ActionEvent> eventHandler) {
    clearButton.setOnAction(eventHandler);
  }

  public void removeIngredientComponent(IngredientComponent component) {
    component.removeIngredientGridPane();
  }

}