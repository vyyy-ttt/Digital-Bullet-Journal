package cs3500.pa05.model;

import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.LimitJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Json.BujoJson;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bullet journal.
 */
public class BulletJournal implements IBulletJournal{
  private final Path bujoFile;
  private final FileWriter fileWriter;
  private ArrayList<TaskJson> tasks;
  private ArrayList<EventJson> events;
  private LimitJson limits;
  private BujoJson week;

  /**
   * Instantiates a new bullet journal.
   *
   * @param file the file to save the bullet journal on
   * @param fileReader the file reader to read the file
   * @param fileWriter the file writer to write to the file
   */
  public BulletJournal(Path file, FileReader fileReader, FileWriter fileWriter){
    bujoFile = file;
    this.fileWriter = fileWriter;

    if(fileReader.readFile(file)){
      week = fileReader.getBujo();
      tasks = fileReader.getTasks();
      events = fileReader.getEvents();
    } else{
      week = new BujoJson(new DayJson[7],null,ThemeType.CLASSIC);
      tasks = new ArrayList<>();
      events = new ArrayList<>();
    }
    limits = week.limits();
  }
  @Override
  public void addEvent(EventJson event) {
    if (!checkLimitViolation(false)) {
      events.add(event);
    }
  }

  @Override
  public void addTask(TaskJson task) {
    if (!checkLimitViolation(true)) {
      tasks.add(task);
    }
  }

  @Override
  public List<TaskJson> sortTasks() {
    ArrayList<TaskJson> sortedTasks = new ArrayList<>();
    for (Day d : Day.values()) {
      for (TaskJson currTask : tasks) {
        if (currTask.day().equals(d)) {
          sortedTasks.add(currTask);
        }
      }
    }
    return sortedTasks;
  }

  @Override
  public boolean checkLimitViolation(boolean isTask) {
    if (isTask) {
      return tasks.size() + 1 >= limits.maxTasks();
    } else {
      return events.size() + 1 >= limits.maxEvents();
    }
  }

  @Override
  public void setTaskLimit(int newLimit) {
    if (limits == null) {
      limits = new LimitJson(-1, newLimit);
    } else{
      limits = new LimitJson(limits.maxEvents(), newLimit);
    }
  }

  @Override
  public void setEventLimit(int newLimit) {
    if(limits == null){
      limits = new LimitJson(newLimit, -1);
    } else{
      limits = new LimitJson(newLimit, limits.maxTasks());
    }
  }

  @Override
  public void chooseTheme(ThemeType theme) {

  }

  @Override
  public void saveBulletJournal() {

  }

  @Override
  public BujoJson getWeek() {
    return week;
  }
}
