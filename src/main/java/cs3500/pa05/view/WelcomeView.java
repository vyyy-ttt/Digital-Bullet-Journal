package cs3500.pa05.view;

import cs3500.pa05.controller.WelcomeController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Represents the welcome page GUI.
 */
public class WelcomeView {

  private final FXMLLoader loader;

  /**
   * Constructs a Welcome View.
   *
   * @param controller a GuiController
   */
  public WelcomeView(WelcomeController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("welcScreen.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads the bullet journal's welcome page's scene.
   *
   * @return the welcome page scene
   */
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to load welcome layout, sorry!");
    }
  }
}
