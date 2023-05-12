package log;

import java.time.LocalDate;

public class WeightLog extends Log {
  private double weight;

  public WeightLog(LocalDate date, LogType type, double weight) {
    super(date, type);
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return super.toString() + "," + this.weight;
  }

  @Override
  public String getData() {
    return String.valueOf(this.weight);
  }

}