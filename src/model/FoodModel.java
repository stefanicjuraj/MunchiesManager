package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import log.FoodLog;
import util.CSVFileHandler;

public class FoodModel extends Model {
  private List<Food> foodData;

  public FoodModel(String fileName) {
    super(fileName);
    foodData = new ArrayList<>();
    parse();
  }

  @Override
  public void parse() {
    foodData.clear();

    for (String line : getData()) {
      String[] tokens = line.split(",");

      if (tokens[0].equals("r")) {
        Recipe recipe = new Recipe(tokens[1], 1);

        for (int i = 2; i < tokens.length; i += 2) {
          Food ingredient = findFood(tokens[i]);
          double ingredientQuantity = Double.parseDouble(tokens[i + 1]);
          ingredient.setQuantity(ingredientQuantity);

          recipe.addIngredient(ingredient);
        }

        foodData.add(recipe);
      } else {
        foodData.add(new BasicFood(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),
            Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), 1));
      }
    }
  }

  public List<Food> getFoodData() {
    return Collections.unmodifiableList(foodData);
  }

  public Food findFood(String foodName) {
    for (Food food : foodData) {
      if (food.getName().equals(foodName)) {
        return food;
      }
    }
    return null;
  }

  public void addFood(Food food) {
    CSVFileHandler.write("foods.csv", food.toString());
  }

  public List<String> getFoodNames() {
    List<String> foodNames = new ArrayList<>();
    for (Food food : foodData) {
      foodNames.add(food.getName());
    }
    return foodNames;
  }

  public double getTotalCalories(List<FoodLog> foodLogs) {
    double totalCalories = 0;
    for (FoodLog foodLog : foodLogs) {
      totalCalories += findFood(foodLog.getFoodName()).getCalories() * foodLog.getServings();
    }
    return totalCalories;
  }

  public void reload() {
    this.load();
    getData();
    parse();
  }

}