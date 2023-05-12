package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipe extends Food {
    private List<Food> ingredients;

    public Recipe(String recipeName, double quantity) {
        super(recipeName, quantity);
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Food food) {
        ingredients.add(food);
    }

    public void removeIngredient(Food food) {
        ingredients.remove(food);
    }

    public List<Food> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    @Override
    public double getCalories() {
        return ingredients.stream().mapToDouble(Food::getCalories).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("r,").append(super.getName());
        for (Food food : ingredients) {
            sb.append(",").append(food.getName()).append(",").append(food.getQuantity());
        }
        return sb.toString();
    }
    
}