package util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

public class FXMLLoaderFactory {

  private FXMLLoaderFactory() {
  }

  public static FXMLLoader load(String fxmlFileName, Object controller) {

    FXMLLoader loader = new FXMLLoader();

    try {
      URL fxmlUrl = new File("lib/" + fxmlFileName).toURI().toURL();
      loader.setLocation(fxmlUrl);
      loader.setController(controller);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return loader;
  }

}