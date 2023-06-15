package cs3500.pa05.model;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;

/**
 * Represents the functionality needed for a bullet journal.
 */
public interface IBulletJournal {
  /**
   * Adds an event to the bullet journal.
   *
   * @param event the event
   */
  void addEvent(EventJson event);

  /**
   * Adds a task to the bullet journal.
   *
   * @param task the task
   */
  void addTask(TaskJson task);

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
}
