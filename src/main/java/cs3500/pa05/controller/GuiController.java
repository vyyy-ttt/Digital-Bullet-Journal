package cs3500.pa05.controller;


import cs3500.pa05.model.BulletJournal;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
  private Button changeThemePG;
  @FXML
  private Button sortByNameTPG;
  @FXML
  private Button sortByDurationTPG;
  @FXML
  private Button sortByNameEPG;
  @FXML
  private Button sortByDurationEPG;
  @FXML
  private Label sunPane;
  @FXML
  private Label monPane;
  @FXML
  private Label tuePane;
  @FXML
  private Label wedPane;
  @FXML
  private Label thursPane;
  @FXML
  private Label friPane;
  @FXML
  private Label satPane;
  @FXML
  private Button cancel;
  @FXML
  private Button cancelEvent;
  private Stage stage;
  private Popup popup;
  private TextField name;
  private TextField description;
  private TextField hoursDigit;
  private TextField minutesDigit;
  private Label hoursLabel;
  private Label minutesLabel;
  private Button addTask;
  private TextField day;
  private TextField duration;
  private BulletJournal bulletJournal;

  public GuiController(Stage stage) {
    this.stage = stage;
    this.popup = new Popup();
  }

  /**
   * Makes the GUI elements of a task popup.
   */
  private void makeTaskPopUp() {
    Rectangle background = new Rectangle();
    background.setHeight(160);
    background.setWidth(180);
    background.setFill(Color.valueOf("#E7EACD"));
    background.setArcHeight(20);
    background.setArcWidth(20);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#E7EACD"));
    vBox.getChildren().add(padding);
    name = new TextField("task name...");
    description = new TextField("description...");
    vBox.getChildren().add(name);
    vBox.getChildren().add(description);
    HBox hBox = new HBox(5);
    hoursDigit = new TextField("___");
    hoursDigit.setPrefWidth(30);
    hoursLabel = new Label("H");
    minutesDigit = new TextField("___");
    minutesDigit.setPrefWidth(30);
    minutesLabel = new Label("M");
    hBox.getChildren().add(hoursDigit);
    hBox.getChildren().add(hoursLabel);
    hBox.getChildren().add(minutesDigit);
    hBox.getChildren().add(minutesLabel);
    vBox.getChildren().add(hBox);
    HBox buttonRow = new HBox(5);
    addTask = new Button("add task");
    addTask.setOnAction(event -> addToGridPane(name.getText()));
    cancel = new Button("cancel");
    cancel.setOnAction(event -> popup.hide());
    buttonRow.getChildren().add(addTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    popup.getContent().add(background);
    popup.getContent().add(vBox);
  }

  /**
   * Makes the GUI elements of an event popup.
   */
  private void makeEventPopUp() {
    Rectangle background = new Rectangle();
    background.setHeight(220);
    background.setWidth(180);
    background.setFill(Color.valueOf("#E7EACD"));
    background.setArcHeight(20);
    background.setArcWidth(20);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#E7EACD"));
    vBox.getChildren().add(padding);
    name = new TextField("event name...");
    description = new TextField("description...");
    day = new TextField("day...");
    duration = new TextField("duration...");
    vBox.getChildren().add(name);
    vBox.getChildren().add(description);
    vBox.getChildren().add(day);
    vBox.getChildren().add(duration);
    HBox hBox = new HBox(5);
    hoursDigit = new TextField("___");
    hoursDigit.setPrefWidth(30);
    hoursLabel = new Label("H");
    minutesDigit = new TextField("___");
    minutesDigit.setPrefWidth(30);
    minutesLabel = new Label("M");
    hBox.getChildren().add(hoursDigit);
    hBox.getChildren().add(hoursLabel);
    hBox.getChildren().add(minutesDigit);
    hBox.getChildren().add(minutesLabel);
    vBox.getChildren().add(hBox);
    HBox buttonRow = new HBox(5);
    addTask = new Button("add event");
    addTask.setOnAction(event -> addToGridPane(name.getText()));
    cancel = new Button("cancel");
    cancel.setOnAction(event -> popup.hide());
    buttonRow.getChildren().add(addTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    popup.getContent().add(background);
    popup.getContent().add(vBox);
  }

  /**
   * Adds a task or event to the week gridpane.
   */
  public void addToGridPane(String name) {
    monPane.setText(name);
    //TODO implement so that depending on the day the person chooses,
    // it will add the task to the necessary pane.
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
  private void handleSortTasksByName() {
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
    makeTaskPopUp();
    addEventPG.setOnAction(event -> makePopup());
    makeEventPopUp();
    savePG.setOnAction(event -> handleSaveButton());
    setLimitPG.setOnAction(event -> handleSetLimit());
    changeThemePG.setOnAction(event -> handleChangeTheme());
    sortByNameTPG.setOnAction(event -> handleSortTasksByName());
    sortByDurationTPG.setOnAction(event -> handleSortTasksByDuration());
  }
}
