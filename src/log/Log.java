package log;

import java.time.LocalDate;

public abstract class Log {
  private LocalDate localDate;
  private LogType logType;

  protected Log(LocalDate localDate, LogType type) {
    this.localDate = localDate;
    this.logType = type;

  }

  public String toString() {

    int month = this.localDate.getMonthValue();
    int day = this.localDate.getDayOfMonth();

    return this.localDate.getYear() + "," + (month < 10 ? "0" + month : "" + month) + ","
        + (day < 10 ? "0" + day : "" + day) + ","
        + this.logType;
  }

  public LocalDate getLocalDate() {
    return this.localDate;
  }

  public LogType getLogType() {
    return this.logType;
  }

  public abstract String getData();

}