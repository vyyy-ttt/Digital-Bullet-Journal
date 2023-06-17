package cs3500.pa05.model;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Json.BujoJson;
import java.util.List;

/**
 * Represents the functionality needed for a bullet journal.
 */
public interface IBulletJournal {
  /**
   * Adds an event to the bullet journal.
   *
   * @param event the event to be added
   */
  void addEvent(EventJson event);

  /**
   * Adds a task to the bullet journal.
   *
   * @param task the task to be added
   */
  void addTask(TaskJson task);

  /**
   * Removes an event from the bullet journal.
   *
   * @param event the event to be removed
   */
  void removeEvent(EventJson event);

  /**
   * Removes a task from the bullet journal.
   *
   * @param task the task to be removed
   */
  void removeTask(TaskJson task);

  /**
   * Sorts all tasks by their priority deadline.
   *
   * @return a list of all tasks sorted from the closest upcoming date to the furthest date
   */
  List<TaskJson> sortTasks();

  /**
   * Returns whether the task or event limit will be exceeded after adding another task or event.
   *
   * @param isTask if the task limit is being checked, otherwise the event limit will be checked
   * @return if the limit will be violated
   */
  boolean checkLimitViolation(boolean isTask);

  /**
   * Sets the limit to the number of tasks per day.
   *
   * @param limit the limit
   */
  void setTaskLimit(int limit);

  /**
   * Sets the limit to the number of events per day.
   *
   * @param limit the limit
   */
  void setEventLimit(int limit);

  /**
   * Changes the theme of the bullet journal.
   *
   * @param theme the specified theme
   */
  void chooseTheme(ThemeType theme);

  /**
   * Saves the bullet journal to a .bujo file.
   */
  void saveBulletJournal();

  /**
   * Retrieves the week.
   *
   * @return the week
   */
  BujoJson getWeek();
}
