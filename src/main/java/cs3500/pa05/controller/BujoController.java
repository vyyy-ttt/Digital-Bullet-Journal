package cs3500.pa05.controller;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.view.BujoView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BujoController {

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
  @FXML
  private Button sortByName;
  @FXML Button sortByDuration;
  @FXML
  private Button finalizeTask;
  @FXML
  private Button cancel;
  @FXML
  private Button changeTheme;
  @FXML
  private Button setLimit;
  @FXML
  private Popup popup;
  private BujoView bujoView;

  public BujoController(Stage stage) {
    addTask = new Button();
    addEvent = new Button();
    save = new Button();
    setLimit = new Button();
    this.stage = stage;
    save = new Button();
    bujoView = new BujoView(this);
  }

  /**
   * Loads new task popup scene.
   */
  private void handleTaskButton() {
    System.out.println("is this being called?");
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("TaskView.fxml"));
      Scene scene = loader.load();
      this.stage.setScene(scene);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Loads new event popup scene.
   */
  private void handleEventButton(EventJson event) {
    //TODO implement.
  }

  /**
   * Saves the current bullet jouranl spread.
   */
  private void handleSaveButton() {
    //TODO implement
  }

  /**
   * Shows a popup on the stage.
   */
  private void makePopup() {
    this.popup.show(this.stage);
  }

  /**
   * Initializes event handlers for controls of the bujo GUI.
   */
  public void run() {
    addEvent.setOnAction(event -> System.out.println("is this working?"));
    save.setOnAction(event -> System.out.println("is this working??"));
    addTask.setOnAction(event -> System.out.println("is this working??"));
  }
}
