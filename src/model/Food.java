package model;

import java.util.*;

public abstract class Food {
  private String name;
  private double quantity;

  protected Food(String name, double quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public abstract double getCalories();

}