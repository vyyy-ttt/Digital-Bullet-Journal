package cs3500.pa05.model;

import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BulletJournalTest {

  BulletJournal bujo;

  @BeforeEach
  public void setup() {
    bujo = new BulletJournal(Path.of("practice.bujo"), new FileReader(),
        new FileWriter(Path.of("bujoTest.bujo").toFile()));
  }

  @Test
  public void addEventTest() {

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

  }
}