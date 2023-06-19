package cs3500.pa05.controller;


import cs3500.pa05.model.BulletJournal;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class GuiController {
  @FXML
  private Button addTaskPG;
  @FXML
  private Button addEventPG;
  @FXML
  private Button setLimitPG;
  @FXML
  private Button savePG;
  @FXML
  private Button cancel;
  @FXML
  private Button cancelEvent;
  private Stage stage;
  private Popup popup;
  private BulletJournal bulletJournal;

  public GuiController(Stage stage) {
    this.stage = stage;
    this.popup = new Popup();
  }

  public void handleTaskPopup() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("taskPop.fxml"));
      Scene scene = loader.load();
      popup.getContent().add(scene.getRoot());
      cancel = new Button();
      cancel.setOnAction(event -> popup.hide());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void handleEventPopup() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("eventPop.fxml"));
      Scene scene = loader.load();
      popup.getContent().add(scene.getRoot());
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

  public void run() {
    addTaskPG.setOnAction(event -> makePopup());
    handleTaskPopup();
    addEventPG.setOnAction(event -> makePopup());
    handleEventPopup();
    savePG.setOnAction(event -> handleSaveButton());
    setLimitPG.setOnAction(event -> handleSetLimit());
  }
}
