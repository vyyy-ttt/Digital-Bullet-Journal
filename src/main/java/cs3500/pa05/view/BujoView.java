package cs3500.pa05.view;

import cs3500.pa05.controller.GuiController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the GUI for a Bullet Journal spread.
 */
public class BujoView {

  private final FXMLLoader loader;

  /**
   * Constructs a BujoView.
   */
  public BujoView(GuiController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("bujo.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads the bullet journal's scene.
   *
   * @return the bullet journal's scene
   */
  public Scene bujoLoad() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("cant do this rn ooman");
    }
  }
}
