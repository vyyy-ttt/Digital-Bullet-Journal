package cs3500.pa05.view;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.WelcomeController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the bullet journal spread GUI.
 */
public class BujoView {

  private final FXMLLoader loader;

  /**
   * Constructs a BujoView.
   *
   * @param controller a BujoController
   */
  public BujoView(BujoController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("bujo.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads the bullet journal's scene.
   *
   * @return the bullet journal spread scene.
   */
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to load the bujo layout, sorry!");
    }
  }
}
