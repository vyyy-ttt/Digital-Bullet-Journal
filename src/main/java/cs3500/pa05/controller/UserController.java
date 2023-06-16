package cs3500.pa05.controller;

import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.FileReader;
import cs3500.pa05.model.FileWriter;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Json.BujoJson;
import cs3500.pa05.model.ThemeType;
import java.nio.file.Path;
import java.util.List;

/**
 * Represents the controller for the user.
 */
public class UserController {

  private BulletJournal bujo;

  protected BujoJson handlePath(Path file){
    this.bujo = new BulletJournal(file, new FileReader(), new FileWriter(file.toFile()));
    return bujo.getWeek();
  }
  protected boolean handleEvent(EventJson event){
    bujo.addEvent(event);
    return false;
  }

  protected boolean handleTask(TaskJson task) {
    bujo.addTask(task);
    return false;
  }

  protected void handleLimit(int limit, boolean isTaskLimit){
    if(isTaskLimit){
      bujo.setTaskLimit(limit);
    } else{
      bujo.setEventLimit(limit);
    }
  }

  protected void handleTheme(ThemeType theme){
    bujo.chooseTheme(theme);
  }

  protected void handleSave(){
    bujo.saveBulletJournal();
  }

  protected List<TaskJson> getTaskQueue(){
    return null;
  }
}
