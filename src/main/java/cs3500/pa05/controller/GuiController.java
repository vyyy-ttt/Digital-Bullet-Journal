package cs3500.pa05.controller;


import cs3500.pa05.model.BulletJournal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
  private final Stage stage;
  private final Popup taskPopup;
  private final Popup eventPopup;
  private final Popup limitPopup;
  private TextField name;
  private TextField description;
  private TextField hoursDigit;
  private TextField minutesDigit;
  private Label hoursLabel;
  private Label minutesLabel;
  private Button addTask;
  private TextField day;
  private Label duration;
  private CheckBox complete;
  private TextField startTime;
  private TextField taskLimit;
  private TextField eventLimit;
  private Button saveLimit;
  private Button cancelLimit;
  private Label limitPrompt;
  private BulletJournal bulletJournal;

  public GuiController(Stage stage) {
    this.stage = stage;
    this.taskPopup = new Popup();
    this.eventPopup = new Popup();
    this.limitPopup = new Popup();
  }

  /**
   * Makes the GUI elements of a task popup.
   */
  private void makeTaskPopUp() {
    Rectangle background = new Rectangle();
    background.setHeight(240);
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
    day = new TextField("day...");
    complete = new CheckBox("task complete?");
    duration = new Label("duration:");
    vBox.getChildren().add(name);
    vBox.getChildren().add(description);
    vBox.getChildren().add(day);
    vBox.getChildren().add(complete);
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
    addTask = new Button("add task");
    addTask.setOnAction(event -> addToGridPane(name.getText()));
    cancel = new Button("cancel");
    cancel.setOnAction(event -> taskPopup.hide());
    buttonRow.getChildren().add(addTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    taskPopup.getContent().add(background);
    taskPopup.getContent().add(vBox);
  }

  /**
   * Makes the GUI elements of an event popup.
   */
  private void makeEventPopUp() {
    Rectangle background = new Rectangle();
    background.setHeight(260);
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
    startTime = new TextField("start time...");
    duration = new Label("duration:");
    vBox.getChildren().add(name);
    vBox.getChildren().add(description);
    vBox.getChildren().add(day);
    vBox.getChildren().add(startTime);
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
    cancel.setOnAction(event -> eventPopup.hide());
    buttonRow.getChildren().add(addTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    eventPopup.getContent().add(background);
    eventPopup.getContent().add(vBox);
  }

  private void makeLimitPopup() {
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
    limitPrompt = new Label("Please enter the limits you would like to set:");
    taskLimit = new TextField("task limit...");
    eventLimit = new TextField("event limit...");
    HBox buttonRow = new HBox();
    saveLimit = new Button("save");
//    saveLimit.setOnAction(event -> );
    cancelLimit = new Button("cancel");
    cancelLimit.setOnAction(event -> limitPopup.hide());
    vBox.getChildren().add(limitPrompt);
    vBox.getChildren().add(taskLimit);
    vBox.getChildren().add(eventLimit);
    buttonRow.getChildren().add(saveLimit);
    buttonRow.getChildren().add(cancelLimit);
    vBox.getChildren().add(buttonRow);
    limitPopup.getContent().add(background);
    limitPopup.getContent().add(vBox);
  }

  /**
   * Adds a task or event to the week gridpane.
   *
   * @param name the name of the task to display
   */
  public void addToGridPane(String name) {
    if (day.getText().startsWith("M") || day.getText().startsWith("m")) {
      monPane.setText(name);
    } else if (day.getText().startsWith("Tu") || day.getText().startsWith("tu")) {
      tuePane.setText(name);
    } else if (day.getText().startsWith("W") || day.getText().startsWith("w")) {
      wedPane.setText(name);
    } else if (day.getText().startsWith("Th") || day.getText().startsWith("th")) {
      thursPane.setText(name);
    } else if (day.getText().startsWith("F") || day.getText().startsWith("f")) {
      friPane.setText(name);
    } else if (day.getText().startsWith("Sa") || day.getText().startsWith("sa")) {
      satPane.setText(name);
    } else if (day.getText().startsWith("Su") || day.getText().startsWith("su")) {
      sunPane.setText(name);
    } else {
      System.out.println("oops");
    }
  }

  /**
   * Saves the current bullet jouranl spread.
   */
  private void handleSaveButton() {
    bulletJournal.saveBulletJournal();
  }

  /**
   * Shows a task popup on the stage.
   */
  private void showTaskPopup() {
    this.taskPopup.show(this.stage);
  }

  private void showEventPopup() {
    this.eventPopup.show(this.stage);
  }

  private void showLimitPopup() {
    this.limitPopup.show(this.stage);
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

  }

  private void handleSetLimit() {
    //TODO implement
  }

  /**
   * Initializes controls of the GUI.
   */
  public void run() {
    addTaskPG.setOnAction(event -> showTaskPopup());
    makeTaskPopUp();
    addEventPG.setOnAction(event -> showEventPopup());
    makeEventPopUp();
    setLimitPG.setOnAction(event -> showLimitPopup());
    makeLimitPopup();
    changeThemePG.setOnAction(event -> handleChangeTheme());
    savePG.setOnAction(event -> handleSaveButton());
    setLimitPG.setOnAction(event -> handleSetLimit());
    changeThemePG.setOnAction(event -> handleChangeTheme());
    sortByNameTPG.setOnAction(event -> handleSortTasksByName());
    sortByDurationTPG.setOnAction(event -> handleSortTasksByDuration());
  }
}
