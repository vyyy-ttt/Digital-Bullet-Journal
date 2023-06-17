package cs3500.pa05.controller;

import cs3500.pa05.view.BujoView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Represents the controller of a bullet journal's GUI.
 */
public class GuiController {
  @FXML
  private Button goButton;
  @FXML
  private TextField bujoFileField;
  @FXML
  private Stage stage;
  private BujoView bujoView = new BujoView();

  public GuiController(Stage stage) {
    goButton = new Button();
    this.stage = stage;
  }

  /**
   * Handles the button that commences into a bullet journal scene.
   */
  private void handleGoButton() {
    this.stage.setScene(bujoView.bujoLoad());
  }

  /**
   * Hanldes the user input in the textField for the bujo file path.
   */
  private void handleBujoField() {
    //TODO verify the bujo field here
  }

  /**
   * Initializes the event handlers for controls of the Gui.
   */
  public void run() {
    goButton.setOnAction(event -> handleGoButton());

  }
}
