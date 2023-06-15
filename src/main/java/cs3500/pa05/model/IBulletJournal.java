package cs3500.pa05.model;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;

public interface IBulletJournal {
  void addEvent(EventJson event);
  void addTask(TaskJson task);
  void setTaskLimit(int limit);
  void setEventLimit(int limit);
  void chooseTheme(ThemeType theme);
  void saveBulletJournal();
}
