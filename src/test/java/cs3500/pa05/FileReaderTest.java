package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.FileReader;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.JsonUtils;
import cs3500.pa05.model.Json.LimitJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Json.WeekJson;
import cs3500.pa05.model.Status;
import cs3500.pa05.model.ThemeType;
import cs3500.pa05.model.Time;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileReaderTest {
  TaskJson[] tasks = new TaskJson[] {new TaskJson("hi", "hello", Day.FRIDAY, Status.INCOMPLETE)};
  EventJson[] events =
      new EventJson[] {new EventJson("vy", "bella",
          Day.SATURDAY, new Time(2, 30).toString(), "4 hours")};
  DayJson day = new DayJson(new TaskJson[2], new EventJson[2]);
  DayJson[] days = new DayJson[] {day, day, day, day, day, new DayJson(tasks, new EventJson[3]),
      new DayJson(new TaskJson[1], events)};

  WeekJson test = new WeekJson(days, new LimitJson(0, 0), ThemeType.CLASSIC);
  FileReader reader;

  @BeforeEach
  public void setup() {
    reader = new FileReader();
    reader.readFile(Path.of("practice.bujo"));
  }

  @Test
  public void getWeekTest() {
    assertEquals(JsonUtils.serializeRecord(reader.getWeek()), JsonUtils.serializeRecord(test));
  }

  @Test
  public void getEventsTest() {
    ArrayList<EventJson> expected = new ArrayList<>(List.of(events));
    assertEquals(expected, reader.getEvents());
  }

  @Test
  public void getTasksTest() {
    ArrayList<TaskJson> expected = new ArrayList<>(List.of(tasks));
    assertEquals(expected, reader.getTasks());
  }
}
