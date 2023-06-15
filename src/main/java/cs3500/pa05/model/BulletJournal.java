package cs3500.pa05.model;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import java.nio.file.Path;

/**
 * Represents a bullet journal.
 */
public class BulletJournal implements IBulletJournal{
  Path bujoFile;
  FileReader fileReader;
  FileWriter fileWriter;

  public BulletJournal(Path file, FileReader fileReader, FileWriter fileWriter){
    bujoFile = file;
    this.fileReader = fileReader;
    this.fileWriter = fileWriter;
  }
  @Override
  public void addEvent(EventJson event) {

  }

  @Override
  public void addTask(TaskJson task) {

  }

  @Override
  public void setTaskLimit(int limit) {

  }

  @Override
  public void setEventLimit(int limit) {

  }

  @Override
  public void chooseTheme(ThemeType theme) {

  }

  @Override
  public void saveBulletJournal() {

  }
}
