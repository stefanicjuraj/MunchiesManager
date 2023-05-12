package log;

import java.time.LocalDate;

public class ExerciseLog extends Log {

  private String exerciseName;
  private double duration;

  public ExerciseLog(LocalDate localDate, LogType type, String exerciseName, double duration) {
    super(localDate, type);
    this.exerciseName = exerciseName;
    this.duration = duration;
  }

  public String getExerciseName() {
    return exerciseName;
  }

  public double getDuration() {
    return duration;
  }

  @Override
  public String getData() {
    return this.exerciseName + " for " + this.duration + " minute(s)";
  }

  @Override
  public String toString() {
    return super.toString() + "," + this.exerciseName + "," + this.duration;

  }

}