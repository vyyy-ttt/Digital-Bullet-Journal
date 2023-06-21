package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.model.Json.BujoJson;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.LimitJson;
import cs3500.pa05.model.Json.TaskJson;
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
  DayJson[] days;

  @BeforeEach
  public void setup() {
    tasks =
        new TaskJson[] {new TaskJson("Get Apples", "Buy those apples!", Day.FRIDAY,
            false)};
    events =
        new EventJson[] {new EventJson("Fruit Convention",
            "All my homies love fruit.", Day.SATURDAY,
            new Time(2, 30), new Time(4,0))};
    DayJson day = new DayJson(new TaskJson[2], new EventJson[2]);
    days = new DayJson[] {day, day, day, day, day, new DayJson(tasks, new EventJson[3]),
        new DayJson(new TaskJson[1], events)};

    expectedBujo = new BujoJson(days, null, null, ThemeType.PINKGREEN, null);

    bujo = new BulletJournal(Path.of("bujoModel.bujo"), new FileReader(),
        new FileWriter(Path.of("bujoModelTest.bujo").toFile()));
  }

  @Test
  public void addRemoveEventTest() {
    bujo.setEventLimit(10);
    ArrayList<EventJson> expectedEvents = new ArrayList<>(List.of(events));

    EventJson fruitConvention = new EventJson("Fruit Convention",
        "All my homies love fruit.", Day.SATURDAY, new Time(2, 30),
        new Time(4,0));
    bujo.addEvent(fruitConvention);
    bujo.saveBulletJournal();

    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedEvents, fr.getEvents());

    bujo.removeEvent(fruitConvention);
    bujo.saveBulletJournal();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(0, fr.getEvents().size());
  }

  @Test
  public void addRemoveTaskTest() {
    bujo.setTaskLimit(10);
    ArrayList<TaskJson> expectedTasks = new ArrayList<>(List.of(tasks));

    TaskJson getApples = new TaskJson("Get Apples",
        "Buy those apples!", Day.FRIDAY, false);
    bujo.addTask(getApples);
    bujo.saveBulletJournal();

    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedTasks, fr.getTasks());

    bujo.removeTask(getApples);
    bujo.saveBulletJournal();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(0, fr.getTasks().size());
  }

  @Test
  public void sortTasksPriorityTest() {
    bujo.setTaskLimit(10);

    TaskJson getApples = new TaskJson("Get Apples",
        "Buy those apples!", Day.FRIDAY, false);
    TaskJson getBananas = new TaskJson("Get Bananas",
        "Buy those bananas!", Day.TUESDAY, false);
    TaskJson getPears = new TaskJson("Get Pears",
        "Buy those pears!", Day.MONDAY, false);
    bujo.addTask(getApples);
    bujo.addTask(getBananas);
    bujo.addTask(getPears);

    ArrayList<TaskJson> expectedTasks = new ArrayList<>();
    expectedTasks.add(getPears);
    expectedTasks.add(getBananas);
    expectedTasks.add(getApples);

    assertEquals(expectedTasks, bujo.sortTasksPriority());
  }

  @Test
  public void sortTasksNameDurationTest() {
    bujo.setTaskLimit(10);

    TaskJson getApples = new TaskJson("Apples",
        "Buy those apples!", Day.FRIDAY, false);
    TaskJson getBananas = new TaskJson("Bananas",
        "Buy those bananas!", Day.TUESDAY, false);
    TaskJson getPears = new TaskJson("Pears",
        "Buy those pears!", Day.MONDAY, false);
    bujo.addTask(getApples);
    bujo.addTask(getBananas);
    bujo.addTask(getPears);

    // Sort by name
    ArrayList<TaskJson> expectedTasksName = new ArrayList<>();
    expectedTasksName.add(getApples);
    expectedTasksName.add(getBananas);
    expectedTasksName.add(getPears);

    assertEquals(expectedTasksName, bujo.sortTasksNameCompletion(true));

    // Sort by duration
    ArrayList<TaskJson> expectedTasksDuration = new ArrayList<>();
    expectedTasksDuration.add(getBananas);
    expectedTasksDuration.add(getApples);
    expectedTasksDuration.add(getPears);

    assertEquals(expectedTasksDuration, bujo.sortTasksNameCompletion(false));
  }

  @Test
  public void sortEventsNameDurationTest() {
    bujo.setEventLimit(10);

    EventJson fruitConvention = new EventJson("Fruit Convention",
        "All my homies love fruit.", Day.SATURDAY, new Time(2, 30),
        new Time(4,0));
    EventJson veggieConvention = new EventJson("Veggie Convention",
        "All my homies love veggies.", Day.WEDNESDAY,
        new Time(4, 44), new Time(5,55));
    EventJson meatConvention = new EventJson("Meat Convention",
        "All my homies love meat.", Day.THURSDAY,
        new Time(10, 0), new Time(1,23));
    bujo.addEvent(fruitConvention);
    bujo.addEvent(veggieConvention);
    bujo.addEvent(meatConvention);

    // Sort by name
    ArrayList<EventJson> expectedEventsName = new ArrayList<>();
    expectedEventsName.add(fruitConvention);
    expectedEventsName.add(meatConvention);
    expectedEventsName.add(veggieConvention);

    assertEquals(expectedEventsName, bujo.sortEventsNameDuration(true));

    // Sort by duration
    ArrayList<EventJson> expectedEventsDuration = new ArrayList<>();
    expectedEventsDuration.add(meatConvention);
    expectedEventsDuration.add(fruitConvention);
    expectedEventsDuration.add(veggieConvention);

    assertEquals(expectedEventsDuration, bujo.sortEventsNameDuration(false));
  }

  @Test
  public void checkLimitViolationTest() {
    // When task and event limits are null
    assertFalse(bujo.checkLimitViolation(true));
    assertFalse(bujo.checkLimitViolation(false));

    // Check task limit
    bujo.setTaskLimit(2);
    assertFalse(bujo.checkLimitViolation(true));

    TaskJson getApples = new TaskJson("Apples",
        "Buy those apples!", Day.FRIDAY, false);
    TaskJson getBananas = new TaskJson("Bananas",
        "Buy those bananas!", Day.TUESDAY, false);
    bujo.addTask(getApples);
    bujo.addTask(getBananas);
    assertTrue(bujo.checkLimitViolation(true));

    // Check event limit
    bujo.setEventLimit(2);
    assertFalse(bujo.checkLimitViolation(false));

    EventJson fruitConvention = new EventJson("Fruit Convention",
        "All my homies love fruit.", Day.SATURDAY, new Time(2, 30),
        new Time(4,0));
    EventJson veggieConvention = new EventJson("Veggie Convention",
        "All my homies love veggies.", Day.WEDNESDAY,
        new Time(4, 44), new Time(5,55));
    bujo.addEvent(fruitConvention);
    bujo.addEvent(veggieConvention);
    assertTrue(bujo.checkLimitViolation(false));
  }

  @Test
  public void setTaskLimitTest() {
    LimitJson expectedLimit = new LimitJson(-1, 10);
    bujo.setTaskLimit(10);
    bujo.saveBulletJournal();

    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedLimit, fr.getBujo().limits());

    expectedLimit = new LimitJson(-1, 20);
    bujo.setTaskLimit(20);
    bujo.saveBulletJournal();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedLimit, fr.getBujo().limits());
  }

  @Test
  public void setEventLimitTest() {
    LimitJson expectedLimit = new LimitJson(10, -1);
    bujo.setEventLimit(10);
    bujo.saveBulletJournal();

    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedLimit, fr.getBujo().limits());

    expectedLimit = new LimitJson(20, -1);
    bujo.setEventLimit(20);
    bujo.saveBulletJournal();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(expectedLimit, fr.getBujo().limits());
  }

  @Test
  public void setWeekNameTest() {
    FileReader fr = new FileReader();
    bujo.setWeekName("Cheese Week");
    bujo.saveBulletJournal();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals("Cheese Week", fr.getBujo().weekName());
  }

  @Test
  public void chooseThemeTest() {
    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(ThemeType.PINKGREEN, fr.getBujo().theme());

    bujo.chooseTheme(ThemeType.BLUE);
    bujo.saveBulletJournal();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(ThemeType.BLUE, fr.getBujo().theme());
  }

  @Test
  public void getWeekTest() {
    FileReader fr = new FileReader();
    fr.readFile(Path.of("bujoModelTest.bujo"));
    assertEquals(fr.getBujo(), bujo.getWeek());
  }
}