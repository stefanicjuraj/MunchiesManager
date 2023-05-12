package view;

import util.FXMLLoaderFactory;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;

public class IngredientComponent extends GridPane {

  @FXML
  private ComboBox<String> ingredientComboBox;

  @FXML
  private Button removeIngredientButton;

  @FXML
  private TextField servingsTextField;

  public IngredientComponent(List<String> foods, EventHandler<ActionEvent> removeIngredientHandler) {
    super();
    GridPane pane = FXMLLoaderFactory.load("ingredientGridPane.fxml", this).getRoot();
    this.getChildren().add(pane);

    ObservableList<String> foodNames = FXCollections.observableArrayList(foods);
    ingredientComboBox.setItems(foodNames);
    handleRemoveIngredientButton(removeIngredientHandler);
  }

  public String getIngredientName() {
    return ingredientComboBox.getValue();
  }

  public String getServings() {
    return servingsTextField.getText();
  }

  public void handleRemoveIngredientButton(EventHandler<ActionEvent> handler) {
    removeIngredientButton.setOnAction(handler);
  }

  public void removeIngredientGridPane() {
    VBox parent = (VBox) this.getParent();
    parent.getChildren().remove(this);
  }

}