package cs3500.pa05.controller;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.view.GuiView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
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
  @FXML
  private Button finalizeTask;
  @FXML
  private Button cancel;
  private Popup popup;
  private GuiView view;
  private UserController userController = new UserController();

  public GuiController(Stage stage) {
    goButton = new Button();
    save = new Button();
    addTask = new Button();
    addEvent = new Button();
    cancel = new Button();
    bujoFileField = new TextField();
    prompt = new Label();
    this.stage = stage;
    view = new GuiView(this);
  }

  /**
   * Handles the button that commences into a bullet journal scene.
   */
  private void handleGoButton() {
    System.out.println("HELLP");
    try {
//      FXMLLoader loader
//          = new FXMLLoader(getClass().getClassLoader().getResource("bujo.fxml"));
//      this.stage.setScene(loader.load());
      Scene scene = view.changeScene("bujo.fxml");
      this.stage.setScene(scene);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private void handleSaveButton() {
    //TODO implement
  }

  /**
   * Loads new task popup scene.
   */
  private void handleTaskButton() {
    System.out.println("HAIUWRHGIUAWHRIGU");
    try {
      Scene scene = view.changeScene("taskPop.fxml");
      this.stage.setScene(scene);
    } catch (IOException e) {
      System.out.println("oh no");
    }
  }

//  private void makePopup() {
//    this.popup.show(this.stage);
//  }

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
   * Initializes the event handlers for controls of the GUI.
   */
  public void run() {
    goButton.setOnAction(event -> handleBujoField());
    addEvent.setOnAction(event -> System.out.println("HELLPO"));
    save.setOnAction(event -> System.out.println("iqewarvie"));
    addTask.setOnAction(event -> System.out.println("hi"));
    cancel.setOnAction(event -> handleGoButton());
  }
}

