package cs3500.pa05.view;

import cs3500.pa05.controller.GuiController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Represents the welcome page GUI.
 */
public class GuiView {

  private final FXMLLoader loader;
  private Parent root;


  /**
   * Constructs a Welcome View.
   *
   * @param controller a GuiController
   */
  public GuiView(GuiController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("welcScreen.fxml"));
    this.loader.setController(controller);
  }

  public Scene changeScene(String fxmlFile) throws IOException {
    this.loader.setLocation(getClass().getClassLoader().getResource(fxmlFile));
    return loader.load();
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
      throw new IllegalStateException("Unable to load layout, sorry!");
    }
  }
}
