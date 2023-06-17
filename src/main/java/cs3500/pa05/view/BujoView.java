package cs3500.pa05.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class BujoView {

  private final FXMLLoader loader;

  public BujoView() {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("bujo.fxml"));
  }

  public Scene bujoLoad() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("cant do this rn ooman");
    }
  }
}
