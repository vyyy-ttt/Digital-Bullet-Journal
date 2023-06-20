package cs3500.pa05.model;

import cs3500.pa05.model.Json.BujoJson;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.JsonUtils;
import cs3500.pa05.model.Json.LimitJson;
import cs3500.pa05.model.Json.TaskJson;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bullet journal.
 */
public class BulletJournal implements IBulletJournal {
  private final Path bujoFile;
  private final FileWriter fileWriter;
  private ArrayList<TaskJson> tasks;
  private ArrayList<EventJson> events;
  private LimitJson limits;
  private BujoJson week;
  private ThemeType theme;
  private String note;
  static final int NUM_MINS_IN_HOUR = 60;

  /**
   * Instantiates a new bullet journal.
   *
   * @param file       the file to save the bullet journal on
   * @param fileReader the file reader to read the file
   * @param fileWriter the file writer to write to the file
   */
  public BulletJournal(Path file, FileReader fileReader, FileWriter fileWriter) {
    bujoFile = file;
    this.fileWriter = fileWriter;

    if (fileReader.readFile(file)) {
      week = fileReader.getBujo();
      tasks = fileReader.getTasks();
      events = fileReader.getEvents();
    } else {
      week = new BujoJson(new DayJson[7], null, ThemeType.PINKGREEN, "");
      tasks = new ArrayList<>();
      events = new ArrayList<>();
      this.theme = ThemeType.PINKGREEN;
    }
    limits = week.limits();
  }

  @Override
  public void addEvent(EventJson event) {
    if (!checkLimitViolation(false)) {
      events.add(event);
    }
    System.out.println("size is " + events.size());
    for (EventJson e : events) {
      System.out.println(e);
    }
  }

  @Override
  public void addTask(TaskJson task) {
    if (!checkLimitViolation(true)) {
      tasks.add(task);
    }
  }

  @Override
  public void removeEvent(EventJson event) {
    events.removeIf(currEvent -> currEvent.equals(event));
  }

  @Override
  public void removeTask(TaskJson task) {
    tasks.removeIf(currTask -> currTask.equals(task));
  }

  @Override
  public List<TaskJson> sortTasksPriority() {
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
  public int convertToMinutes(String duration) {
    int finalConversion = 0;
    int indexOfHours = duration.indexOf('h');
    int indexOfMinutes = duration.indexOf('m');
    finalConversion += Integer.parseInt(duration.substring(0, indexOfHours)) * NUM_MINS_IN_HOUR;
    finalConversion += Integer.parseInt(duration.substring(indexOfHours + 1, indexOfMinutes));
    return finalConversion;
  }

  @Override
  public List<TaskJson> sortTasksNameDuration(boolean isName) {
    ArrayList<TaskJson> sortedTasks = new ArrayList<>();
    if (isName) { // Sorts by name
      for (TaskJson currTask : tasks) {
        if (sortedTasks.isEmpty()) {
          sortedTasks.add(currTask);
        } else {
          for (TaskJson currSortedTask : sortedTasks) {
            // If the current task's name comes alphabetically before or is equal to the current
            // sorted task's name
            if (currTask.name().compareTo(currSortedTask.name()) <= 0) {
              sortedTasks.add(sortedTasks.indexOf(currSortedTask), currTask);
              break;
            }
          }
          // Adds the current task to sortedTasks if it hasn't been added yet, being that its
          // name comes alphabetically after every other task's name already sorted
          if (!sortedTasks.contains(currTask)) {
            sortedTasks.add(currTask);
          }
        }
      }
    } else { // Sorts by duration
      for (TaskJson currTask : tasks) {
        if (sortedTasks.isEmpty()) {
          sortedTasks.add(currTask);
        } else {
          for (TaskJson currSortedTask : sortedTasks) {
            if (convertToMinutes(currTask.duration()) <
                convertToMinutes(currSortedTask.duration())) {
              sortedTasks.add(sortedTasks.indexOf(currSortedTask), currTask);
              break;
            }
          }
          // Adds the current task to sortedTasks if it hasn't been added yet, being that its
          // duration is greater than every other task's duration already sorted
          if (!sortedTasks.contains(currTask)) {
            sortedTasks.add(currTask);
          }
        }
      }
    }
    return sortedTasks;
  }

  @Override
  public List<EventJson> sortEventsNameDuration(boolean isName) {
    ArrayList<EventJson> sortedEvents = new ArrayList<>();
    if (isName) { // Sorts by name
      for (EventJson currEvent : events) {
        if (sortedEvents.isEmpty()) {
          sortedEvents.add(currEvent);
        } else {
          for (EventJson currSortedEvent : sortedEvents) {
            // If the current event's name comes alphabetically before or is equal to the current
            // sorted event's name
            if (currEvent.name().compareTo(currSortedEvent.name()) <= 0) {
              sortedEvents.add(sortedEvents.indexOf(currSortedEvent), currEvent);
              break;
            }
          }
          // Adds the current event to sortedEvents if it hasn't been added yet, being that its
          // name comes alphabetically after every other event's name already sorted
          if (!sortedEvents.contains(currEvent)) {
            sortedEvents.add(currEvent);
          }
        }
      }
    } else { // Sorts by duration
      for (EventJson currEvent : events) {
        if (sortedEvents.isEmpty()) {
          sortedEvents.add(currEvent);
        } else {
          for (EventJson currSortedEvent : sortedEvents) {
            if (convertToMinutes(currEvent.duration()) <
                convertToMinutes(currSortedEvent.duration())) {
              sortedEvents.add(sortedEvents.indexOf(currSortedEvent), currEvent);
              break;
            }
          }
          // Adds the current event to sortedEvents if it hasn't been added yet, being that its
          // duration is greater than every other event's duration already sorted
          if (!sortedEvents.contains(currEvent)) {
            sortedEvents.add(currEvent);
          }
        }
      }
    }
    return sortedEvents;
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
    } else {
      limits = new LimitJson(limits.maxEvents(), newLimit);
    }
  }

  @Override
  public void setEventLimit(int newLimit) {
    if (limits == null) {
      limits = new LimitJson(newLimit, -1);
    } else {
      limits = new LimitJson(newLimit, limits.maxTasks());
    }
  }

  @Override
  public void chooseTheme(ThemeType theme) {
    this.theme = theme;
  }

  @Override
  public void saveBulletJournal() {
    BujoJson updatedBujo = new BujoJson(getUpdatedDays(), limits, theme, note);
//    for (EventJson e : updatedBujo.week()[6].events()) {
//      System.out.println(e);
//    }
    try {
      fileWriter.writeToFile(JsonUtils.serializeRecord(updatedBujo).toString());
    } catch (IOException e) {
      throw new RuntimeException("Changes could not be saved.");
    }
  }

  /**
   * Retrieves the updated tasks and events for each day of the week.
   *
   * @return an array of each updated DayJson
   */
  private DayJson[] getUpdatedDays() {
    Day[] daysOfTheWeek = Day.values();
    DayJson[] newDays = new DayJson[7];
    int daysIndex = 0;
    while (daysIndex < newDays.length) {
      // Finds tasks scheduled for the given day
      ArrayList<TaskJson> tasksOfTheDayList = new ArrayList<>();
      for (TaskJson currTask : tasks) {
        if (currTask.day().equals(daysOfTheWeek[daysIndex])) {
          tasksOfTheDayList.add(currTask);
        }
      }
      // Converts the list of tasks into an array
      TaskJson[] tasksOfTheDayArray = new TaskJson[tasksOfTheDayList.size()];
      int index = 0;
      for (TaskJson t : tasksOfTheDayList) {
        tasksOfTheDayArray[index] = t;
        index++;
      }

      // Finds events scheduled for the given day
      ArrayList<EventJson> eventsOfTheDayList = new ArrayList<>();
      for (EventJson currEvent : events) {
        System.out.println(currEvent);
        if (currEvent.day().equals(daysOfTheWeek[daysIndex])) {
          eventsOfTheDayList.add(currEvent);
        }
      }
      // Converts the list of tasks into an array
      EventJson[] eventsOfTheDayArray = new EventJson[eventsOfTheDayList.size()];
      index = 0;
      for (EventJson e : eventsOfTheDayList) {
        eventsOfTheDayArray[index] = e;
        index++;
      }

      // Creates a new day with the events and the tasks for that day, and updates newDays
      newDays[daysIndex] = new DayJson(tasksOfTheDayArray, eventsOfTheDayArray);
      daysIndex++;
    }
//    for (EventJson e : newDays[6].events()) {
//      System.out.println(e);
//    }
    return newDays;
  }

  @Override
  public BujoJson getWeek() {
    return week;
  }
}