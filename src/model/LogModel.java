package model;

import java.time.LocalDate;
import java.util.*;

import log.Log;
import log.LogType;
import util.LogFactory;
import log.CaloriesLog;
import log.ExerciseLog;
import log.FoodLog;
import log.WeightLog;
import util.CSVFileHandler;

public class LogModel extends Model {
  private List<Log> logData;

  public LogModel(String fileName) {
    super(fileName);
    logData = new ArrayList<>();
    parse();
  }

  @Override
  public void parse() {
    logData.clear();

    for (String line : getData()) {
      String[] tokens = line.split(",");
      String year = tokens[0];
      String month = tokens[1].length() == 1 ? "0" + tokens[1] : tokens[1];
      String day = tokens[2].length() == 1 ? "0" + tokens[2] : tokens[2];
      String date = year + "-" + month + "-" + day;

      if (tokens.length == 6) {
        logData.add(LogFactory.createLog(LocalDate.parse(date), LogType.valueOf(tokens[3].toUpperCase()),
            Double.parseDouble(tokens[5]), tokens[4]));
      } else {
        logData.add(LogFactory.createLog(LocalDate.parse(date), LogType.valueOf(tokens[3].toUpperCase()),
            Double.parseDouble(tokens[4])));
      }

    }
  }

  public List<Log> getLogData() {
    return Collections.unmodifiableList(logData);
  }

  public void addLog(Log log) {
    CSVFileHandler.write("log.csv", log.toString());
  }

  public double getCalorieGoal(LocalDate dateSelected) {
    for (int i = logData.size() - 1; i >= 0; i--) {
      if (logData.get(i).getLocalDate().equals(dateSelected) && logData.get(i).getLogType() == LogType.C) {
        CaloriesLog cl = (CaloriesLog) logData.get(i);
        return cl.getCalories();
      }
    }

    Log lastLog = logData.get(logData.size() - 1);
    if (lastLog.getLogType() == LogType.C) {
      CaloriesLog cl = (CaloriesLog) lastLog;
      return cl.getCalories();
    }
    return 2000.0;
  }

  public double getWeight(LocalDate dateSelected) {
    for (int i = logData.size() - 1; i >= 0; i--) {
      if (logData.get(i).getLocalDate().equals(dateSelected) && logData.get(i).getLogType() == LogType.W) {
        WeightLog wl = (WeightLog) logData.get(i);
        return wl.getWeight();
      }
    }

    Log lastLog = logData.get(logData.size() - 1);

    if (lastLog.getLogType() == LogType.W) {
      WeightLog wl = (WeightLog) lastLog;
      return wl.getWeight();
    }

    return 68.0;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Log log : logData) {
      sb.append(log.toString() + "\n");
    }
    return sb.toString();
  }

  public List<Log> getLogsByDate(LocalDate localDate) {
    List<Log> logs = new ArrayList<>();
    for (Log log : logData) {
      if (log.getLocalDate().equals(localDate)) {
        logs.add(log);
      }
    }

    return logs;
  }

  public void reload() {
    this.load();
    getData();
    parse();
  }

  public List<FoodLog> getFoodsAndServingsByDate(LocalDate date) {
    List<FoodLog> foods = new ArrayList<>();

    for (Log log : logData) {
      if (log.getLocalDate().equals(date) && log.getLogType() == LogType.F) {
        FoodLog fl = (FoodLog) log;
        foods.add(fl);
      }
    }
    return foods;

  }

  public void removeRow(String log) {
    CSVFileHandler.removeLine("log.csv", log);
  }

  public List<ExerciseLog> getExercisesAndDurationsByDate(LocalDate selectedDate) {
    List<ExerciseLog> exercises = new ArrayList<>();

    for (Log log : logData) {
      if (log.getLocalDate().equals(selectedDate) && log.getLogType() == LogType.E) {
        exercises.add((ExerciseLog) log);
      }
    }
    return exercises;
  }

}