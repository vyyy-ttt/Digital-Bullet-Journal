package cs3500.pa05.controller;

import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.view.BujoView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
  @FXML
  private Button sortByDuration;
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
  private UserController userController;
  private BulletJournal bulletJournal;

  public BujoController(Stage stage) {
    addTask = new Button();
    addEvent = new Button();
    save = new Button();
    setLimit = new Button();
    changeTheme = new Button();
    sortByName = new Button();
    sortByDuration = new Button();
    this.stage = stage;
    save = new Button();
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
      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("taskPop.fxml"));
      loader.setController(this);
      Scene scene = loader.load();
      popup.getContent().add(scene.getRoot());
      cancel.setOnAction(event -> popup.hide());
      popup.getContent().add(cancel);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Loads new event popup scene.
   */
  private void handleEventButton(EventJson event) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("EventView.fxml"));
      Scene scene = loader.load();
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
    addEvent.setOnAction(event -> System.out.println("is this working?"));
    save.setOnAction(event -> System.out.println("is this working??"));
    addTask.setOnAction(event -> handleTaskButton());
    sortByName.setOnAction(event -> handleSortByName());
    sortByDuration.setOnAction(event -> handleSortTasksByDuration());
    changeTheme.setOnAction(event -> handleChangeTheme());
    setLimit.setOnAction(event -> handleSetLimit());
  }
}
