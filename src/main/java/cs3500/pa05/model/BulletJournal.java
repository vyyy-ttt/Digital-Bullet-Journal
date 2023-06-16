package cs3500.pa05.model;

import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.LimitJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Json.WeekJson;
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
  private WeekJson week;

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
      week = fileReader.getWeek();
      tasks = fileReader.getTasks();
      events = fileReader.getEvents();
    } else{
      week = new WeekJson(new DayJson[7],null,ThemeType.CLASSIC);
      tasks = new ArrayList<>();
      events = new ArrayList<>();
    }
    limits = week.limits();
  }
  @Override
  public void addEvent(EventJson event) {
    //check to see if the max num of events is exceeded
    if (events.size() + 1 <= limits.maxEvents()) {
      events.add(event);
    }
  }

  @Override
  public void addTask(TaskJson task) {
    //check if the max num of tasks is exceeded
    if (tasks.size() + 1 <= limits.maxTasks()) {
      tasks.add(task);
    }
  }

  @Override
  public boolean checkLimitViolation(int limit) {
    // TODO: implement - determines if the given limit will be surpassed
    return false;
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
}
