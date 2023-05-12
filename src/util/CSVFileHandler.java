package util;

import java.io.*;
import java.util.*;

public class CSVFileHandler {

  private CSVFileHandler() {
  }

  public static List<String> read(String fileName) {
    Scanner scn = null;

    try {
      scn = new Scanner(new FileReader(new File(fileName)));

      List<String> data = new ArrayList<>();
      while (scn.hasNextLine()) {
        data.add(scn.nextLine());
      }
      return data;

    } catch (FileNotFoundException e) {

      e.printStackTrace();
    } finally {
      if (scn != null)
        scn.close();
    }

    return Collections.emptyList();
  }

  public static void write(String fileName, String data) {
    PrintWriter pw = null;

    try {
      pw = new PrintWriter(new FileWriter(new File(fileName), true));
      pw.println(data);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (pw != null) {
        pw.close();
      }
    }
  }

  public static void removeLine(String fileName, String log) {
    List<String> data = read(fileName);
    data.remove(log);
    PrintWriter pw = null;

    try {
      pw = new PrintWriter(new FileWriter(new File(fileName), false));
      for (String line : data) {
        pw.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (pw != null) {
        pw.close();
      }
    }
  }

}