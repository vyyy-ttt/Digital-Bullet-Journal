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

}