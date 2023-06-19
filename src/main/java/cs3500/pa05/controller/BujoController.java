package cs3500.pa05.controller;

import cs3500.pa05.model.BulletJournal;
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
  private Button savePG;
  @FXML
  private Button addTaskPG;
  @FXML
  private Button addEventPG;
  @FXML
  private Stage stage;
  @FXML
  private Button sortByNamePG;
  @FXML
  private Button sortByDurationPG;
  @FXML
  private TextField startTime;
  @FXML
  private TextField duration;
  @FXML
  private Button finalizeTask;
  @FXML
  private Button finalizeEvent;
  @FXML
  private Button cancelEvent;
  @FXML
  private Button cancel;
  @FXML
  private Button changeThemePG;
  @FXML
  private Button setLimitPG;
  @FXML
  private Popup popup;
  private BujoView bujoView;
  private UserController userController;
  private BulletJournal bulletJournal;

  public BujoController(Stage stage) {
    addTaskPG = new Button();
    addEventPG = new Button();
    savePG = new Button();
    setLimitPG = new Button();
    changeThemePG = new Button();
    sortByNamePG = new Button();
    sortByDurationPG = new Button();
    cancel = new Button();
    this.stage = stage;
    savePG = new Button();
    bujoView = new BujoView(this);
    userController = new UserController();
  }

  /**
   * Loads new task popup scene.
   */
  private void handleTaskButton() {
    System.out.println("is this being called?");
    try {
      makePopup();
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("taskPopup.fxml"));
      loader.setController(this);
      Scene scene = loader.load();
      popup.getContent().add(scene.getRoot());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Loads new event popup scene.
   */
  private void handleEventButton(EventJson event) {
    try {
      makePopup();
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("EventPopup.fxml"));
      loader.setController(this);
      Scene scene = loader.load();
      popup.getContent().add(scene.getRoot());
      this.stage.setScene(scene);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Saves the current bullet jouranl spread.
   */
  private void handleSaveButton() {
    bulletJournal.saveBulletJournal();
  }

  /**
   * Shows a popup on the stage.
   */
  private void makePopup() {
    this.popup.show(this.stage);
  }

  /**
   * Handles button that sorts tasks and events by name.
   */
  private void handleSortByName() {
    //TODO implement
  }

  /**
   * Handles button that sorts tasks and events by duration.
   */
  private void handleSortTasksByDuration() {
    //TODO implement
  }

  /**
   * Handles button that changes the bullet journal's GUI theme.
   */
  private void handleChangeTheme() {
    //TODO implement
  }

  private void handleSetLimit() {
    //TODO implement
  }

  /**
   * Initializes event handlers for controls of the bujo GUI.
   */
  public void run() {
    addEventPG.setOnAction(event -> System.out.println("is this working?"));
    savePG.setOnAction(event -> System.out.println("is this working??"));
    addTaskPG.setOnAction(event -> handleTaskButton());
    sortByNamePG.setOnAction(event -> handleSortByName());
    sortByDurationPG.setOnAction(event -> handleSortTasksByDuration());
    changeThemePG.setOnAction(event -> handleChangeTheme());
    setLimitPG.setOnAction(event -> handleSetLimit());
    cancel.setOnAction(event -> popup.hide());
  }
}
