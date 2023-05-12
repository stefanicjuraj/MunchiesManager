package model;

import java.util.List;

import util.CSVFileHandler;

public abstract class Model {

  private String fileName;
  private List<String> data;

  protected Model(String fileName) {
    this.fileName = fileName;
    load();
  }

  public void load() {
    data = CSVFileHandler.read(fileName);
  }

  public abstract void parse();

  protected List<String> getData() {
    return data;
  }

  public abstract void reload();

}