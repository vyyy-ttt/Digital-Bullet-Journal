package cs3500.pa05.view;

import cs3500.pa05.controller.GuiController;
import javafx.fxml.FXMLLoader;

public class TaskPopup {

  private FXMLLoader loader;

  public TaskPopup(GuiController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("taskPopup.fxml"));
    this.loader.setController(controller);
  }
}
