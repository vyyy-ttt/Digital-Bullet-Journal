package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.model.Json.BujoJson;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BulletJournalTest {

  BulletJournal bujo;
  BujoJson expectedBujo;
  TaskJson[] tasks;
  EventJson[] events;

  @BeforeEach
  public void setup() {
    tasks =
        new TaskJson[] {new TaskJson("Get Apples", "Buy those apples!", Day.FRIDAY, Status.INCOMPLETE, "1h0m")};
    events =
        new EventJson[] {new EventJson("Fruit Convention", "All my homies love fruit.",
            Day.SATURDAY, new Time(2, 30).toString(), "4h0m")};
    DayJson day = new DayJson(new TaskJson[2], new EventJson[2]);
    DayJson[] days = new DayJson[] {day, day, day, day, day, new DayJson(tasks, new EventJson[3]),
        new DayJson(new TaskJson[1], events)};

    expectedBujo = new BujoJson(days, null, ThemeType.PINKGREEN, null);

    bujo = new BulletJournal(Path.of("bujoModel.bujo"), new FileReader(),
        new FileWriter(Path.of("bujoModelTest.bujo").toFile()));
  }

  @Test
  public void addEventTest() {
    bujo.setEventLimit(1);
    ArrayList<EventJson> expectedEvents = new ArrayList<>(List.of(events));

    EventJson fruitConvention = new EventJson("Fruit Convention",
        "All my homies love fruit.", Day.SATURDAY, new Time(2, 30).toString(), "4h0m");
    bujo.addEvent(fruitConvention);
    bujo.saveBulletJournal();

    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedEvents, fr.getEvents());

//    try{
//      assertEquals(expectedBujo.toString(), Files.readString(Path.of("bujoModelTest.bujo")));
//    } catch (IOException e) {
//      e.printStackTrace();
//      System.err.println("File could not be read as string.");
//    }

//    int eventCount = 0;
//    for (EventJson e : bujo.getWeek().week()[6].events()) {
//      System.out.println(e);
//      if (e != null) {
//        eventCount++;
//      }
//    }
//    assertEquals(1, eventCount);
  }

  @Test
  public void addTaskTest() {

  }

  @Test
  public void removeEventTest() {

  }

  @Test
  public void
  removeTaskTest() {

  }

  @Test
  public void sortTasksPriorityTest() {

  }

  @Test
  public void convertToMinutesTest() {

  }

  @Test
  public void sortTasksNameDurationTest() {

  }

  @Test
  public void sortEventsNameDurationTest() {

  }

  @Test
  public void checkLimitViolationTest() {

  }

  @Test
  public void setTaskLimitTest() {

  }

  @Test
  public void setEventLimitTest() {

  }

  @Test
  public void chooseThemeTest() {

  }

  @Test
  public void saveBulletJournalTest() {

  }

  @Test
  public void getWeekTest() {
//    assertEquals(bujo.)
  }
}