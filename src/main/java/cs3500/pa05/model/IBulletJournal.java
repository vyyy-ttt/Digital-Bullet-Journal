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
  List<TaskJson> sortTasksPriority();

  /**
   * Given a string representing duration in an hours and minutes format, converts the duration to
   * only minutes and returns the conversion as an integer.
   *
   * @param duration the duration in "-h-m" format, where the - are digits
   * @return the conversion to minutes as an int
   */
  int convertToMinutes(String duration);

  /**
   * Sorts all tasks by their name or duration.
   *
   * @param byName if wanting to sort by name, otherwise will be sorted by duration
   * @return a list of TaskJsons sorted by the given flag
   */
  List<TaskJson> sortTasksNameDuration(boolean byName);

  /**
   * Sorts all events by their name or duration.
   *
   * @param byName if wanting to sort by name, otherwise will be sorted by duration
   * @return a list of EventJsons sorted by the given flag
   */
  List<EventJson> sortEventsNameDuration(boolean byName);

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
