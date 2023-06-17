package cs3500.pa05.controller;

import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.view.BujoView;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
  private TextField taskName;
  @FXML
  private TextField taskDescrip;
  @FXML
  private TextField day;
  @FXML
  private RadioButton statusRadio;
  @FXML
  private Label prompt;
  @FXML
  private Button save;
  @FXML
  private Button addTask;
  @FXML
  private Button addEvent;
  @FXML
  private Stage stage;
  private BujoView bujoView = new BujoView();
  private BulletJournal bulletJournal;

  public GuiController(Stage stage) {
    goButton = new Button();
    save = new Button();
    addTask = new Button();
    addEvent = new Button();
    bujoFileField = new TextField();
    prompt = new Label();
    this.stage = stage;
  }

  /**
   * Handles the button that commences into a bullet journal scene.
   */
  private void handleGoButton() {
    this.stage.setScene(bujoView.bujoLoad());
  }

  private void handleSaveButton() {
    //TODO implement
  }

  /**
   * Loads new task popup scene.
   */
  private void handleTaskButton() {
    try {
      FXMLLoader.load(
          Objects.requireNonNull(getClass().getClassLoader().getResource("TaskPopup.fxml")));
    } catch (IOException e) {
      System.out.println("oh no");
    }
  }

  private void handleEventButton(EventJson event) {
    //TODO implement.
  }

  /**
   * Handles the user input in the textField for the bujo file path.
   */
  private void handleBujoField() {
    String input = bujoFileField.getText();
    if (input.endsWith(".bujo")) {
      handleGoButton();
    } else {
      prompt.setText("Oops! That wasn't a valid bujo file, please try again.");
    }
  }

  /**
   * Initializes the event handlers for controls of the Gui.
   */
  public void run() {
    goButton.setOnAction(event -> handleBujoField());
    addTask.setOnAction(event -> handleTaskButton());
  }
}
