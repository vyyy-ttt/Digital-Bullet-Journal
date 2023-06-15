package cs3500.pa05.model;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Json.WeekJson;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a file reader.
 */
public class FileReader implements BujoReader{
  private final ObjectMapper mapper = new ObjectMapper();
  private WeekJson week;

  /**
   * Reads the file and parses the week from the file.
   *
   * @param file the file to be read.
   */
  public void readFile(Path file) {
    try {
      JsonParser parser = this.mapper.getFactory().createParser(file.toFile());
      week = parser.readValueAs(WeekJson.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  @Override
  public WeekJson getWeek() {
    return week;
  }

  @Override
  public List<EventJson> getEvents() {
    List<EventJson> events = new ArrayList<>();
    for(DayJson day : week.week()){
      for(EventJson event : day.events()){
        if(event != null){
          events.add(event);
        }
      }
    }
    return events;
  }

  @Override
  public List<TaskJson> getTasks() {
    List<TaskJson> tasks = new ArrayList<>();
    for(DayJson day : week.week()){
      for(TaskJson task : day.tasks()){
        if(task != null){
          tasks.add(task);
        }
      }
    }
    return tasks;
  }
}
