package cs3500.pa05.view;

import cs3500.pa05.controller.GuiController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class WelcomeView {

  private final FXMLLoader loader;

  public WelcomeView(GuiController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("welcScreen.fxml"));
    this.loader.setController(controller);
  }

  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to load layout, sorry!");
    }
  }
}
