package util;

import java.time.LocalDate;

import log.CaloriesLog;
import log.ExerciseLog;
import log.FoodLog;
import log.Log;
import log.LogType;
import log.WeightLog;

public class LogFactory {

  private LogFactory() {
  }

  public static Log createLog(LocalDate localDate, LogType type, double value, String... foodName) {
    switch (type) {
      case W:
        return new WeightLog(localDate, type, value);

      case C:
        return new CaloriesLog(localDate, type, value);

      case F:
        return new FoodLog(localDate, type, foodName[0], value);

      case E:
        return new ExerciseLog(localDate, type, foodName[0], value);

      default:
        return null;
    }
  }
  
}