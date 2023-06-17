package cs3500.pa05.controller;

import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.FileReader;
import cs3500.pa05.model.FileWriter;
import cs3500.pa05.model.Json.BujoJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.ThemeType;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * Represents the controller for the user.
 */
public class UserController {

  private BulletJournal bujo;

  /**
   * Handles when the user enters the specified file they want to have the bullet journal on.
   *
   * @param file the file that the user enters.
   * @return the loaded bujo information.
   */
  protected BujoJson handlePath(String file) {
    File f = Path.of(file).toFile();
    this.bujo = new BulletJournal(f.toPath(), new FileReader(), new FileWriter(f));
    return bujo.getWeek();
  }

  /**
   * Handles when the user enters a new event.
   *
   * @param event the event that the user entered.
   * @return true if the user has exceeded their limits, false otherwise
   */
  protected boolean handleEvent(EventJson event) {
    bujo.addEvent(event);
    return bujo.checkLimitViolation(false);
  }

  /**
   * Handles when the user enters a new task.
   *
   * @param task the new task that the user has entered
   * @return true if the user has exceeded their limits, false otherwise
   */
  protected boolean handleTask(TaskJson task) {
    bujo.addTask(task);
    return bujo.checkLimitViolation(true);
  }

  /**
   * Handles when the user enters a new limit.
   *
   * @param limit       maximum number of events or tasks
   * @param isTaskLimit true if the limit is for tasks, false if the limit is for events.
   */
  protected void handleLimit(int limit, boolean isTaskLimit) {
    if (isTaskLimit) {
      bujo.setTaskLimit(limit);
    } else {
      bujo.setEventLimit(limit);
    }
  }

  /**
   * Handles when the user wants to remove a task.
   *
   * @param task the task to be removed
   */
  protected void handleRemoveTask(TaskJson task) {

  }

  /**
   * Handles when the user wants to remove an event.
   *
   * @param event the event to be removed
   */
  protected void handleRemoveEvent(EventJson event) {

  }

  /**
   * Handles when the user wants to change the theme.
   *
   * @param theme the new theme for the bullet journal
   */
  protected void handleTheme(ThemeType theme) {
    bujo.chooseTheme(theme);
  }

  /**
   * Handles when the user wants to save the bullet journal to a file.
   */
  protected void handleSave() {
    bujo.saveBulletJournal();
  }

  /**
   * Handles when the sidebar of tasks needs to be created.
   *
   * @return a sorted list of tasks sorted by urgency
   */
  protected List<TaskJson> getTaskQueue() {
    return bujo.sortTasks();
  }
}
