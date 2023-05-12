package model;

import java.util.ArrayList;
import java.util.List;

import log.ExerciseLog;
import util.CSVFileHandler;

public class ExerciseModel extends Model {

  private List<Exercise> exercises;

  public ExerciseModel(String fileName) {
    super(fileName);
    exercises = new ArrayList<>();
    parse();
  }

  @Override
  public void parse() {
    exercises.clear();

    for (String line : getData()) {
      String[] tokens = line.split(",");

      exercises.add(new Exercise(tokens[1], Double.parseDouble(tokens[2])));
    }
  }

  public List<String> getExercisesNames() {
    List<String> names = new ArrayList<>();
    for (Exercise e : exercises) {
      names.add(e.getExerciseName());
    }
    return names;
  }

  public void addExercise(Exercise exercise) {
    CSVFileHandler.write("exercise.csv", exercise.toString());
  }

  @Override
  public void reload() {
    this.load();
    getData();
    parse();
  }

  public double getTotalCaloriesBurned(List<ExerciseLog> exercises, double weight) {
    double totalCaloriesBurned = 0;
    for (ExerciseLog e : exercises) {
      Exercise ex = getExerciseByName(e.getExerciseName());
      totalCaloriesBurned += ex.getCaloriesBurnedByHour() * e.getDuration() / 60 * weight;
    }
    return Math.ceil(totalCaloriesBurned);

  }

  public Exercise getExerciseByName(String name) {
    for (Exercise e : exercises) {
      if (e.getExerciseName().equals(name)) {
        return e;
      }
    }
    return null;
  }

}