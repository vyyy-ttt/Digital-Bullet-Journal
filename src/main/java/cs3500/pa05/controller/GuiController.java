package cs3500.pa05.controller;


import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.view.PopupView;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Represents the controller for GUI elements.
 */
public class GuiController {
  @FXML
  private Button addTask;
  @FXML
  private Button addEvent;
  @FXML
  private Button setLimit;
  @FXML
  private Button save;
  @FXML
  private Button changeTheme;
  @FXML
  private Button sortByNameTask;
  @FXML
  private Button sortByDurationTask;
  @FXML
  private Button sortByNameEvent;
  @FXML
  private Button sortByDurationEvent;
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
  private Rectangle headerRect;
  @FXML
  private Rectangle changeThemeRect;
  @FXML
  private Label weekNameLabel;
  @FXML
  private Label sunLabel;
  @FXML
  private Label monLabel;
  @FXML
  private Label tueLabel;
  @FXML
  private Label wedLabel;
  @FXML
  private Label thuLabel;
  @FXML
  private Label friLabel;
  @FXML
  private Label satLabel;
  @FXML
  private Rectangle addTaskRect;
  @FXML
  private Rectangle addEventRect;
  @FXML
  private Rectangle setLimitRect;
  @FXML
  private Rectangle saveRect;
  @FXML
  private Label quotesLabel;
  @FXML
  private Label sortTasksLabel;
  @FXML
  private Label sortEventsLabel;
  @FXML
  private Rectangle tasksNameRect;
  @FXML
  private Rectangle tasksDurRect;
  @FXML
  private Rectangle eventNameRect;
  @FXML
  private Rectangle eventDurRect;
  @FXML
  private Label taskQueueLabel;
  @FXML
  private Label headerLabel;
  private Button cancel;
  private final Stage stage;
  private final Popup taskPopup;
  private final Popup eventPopup;
  private final Popup limitPopup;
  private TextField taskName;
  private TextField taskDay;
  private TextField hoursDigit;
  private TextField minutesDigit;
  private Label hoursLabel;
  private Label minutesLabel;
  private Button finalizeTask;
  private Button finalizeEvent;
  private TextField eventName;
  private TextField eventDescription;
  private TextField eventDay;
  private Label eventDuration;
  private TextField taskDescription;
  private Label taskDuration;
  private CheckBox complete;
  private TextField startTime;
  private TextField taskLimit;
  private TextField eventLimit;
  private Button saveLimit;
  private Button cancelLimit;
  private Label limitPrompt;
  private ArrayList<String> taskList;
  private BulletJournal bulletJournal;
  private PopupView popupView;

  public GuiController(Stage stage) {
    this.stage = stage;
    this.taskPopup = new Popup();
    this.eventPopup = new Popup();
    this.limitPopup = new Popup();
    popupView = new PopupView();
  }

  //TODO task and event cant share text fields

  /**
   * Makes the GUI elements of a task popup. //TODO change this
   */
  private void makeTaskPopUp() {
    Rectangle background = popupView.createPopupBackground(240, 180);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#E7EACD"));
    vBox.getChildren().add(padding);
    taskName = new TextField("task name...");
    taskDescription = new TextField("description...");
    taskDay = new TextField("day...");
    complete = new CheckBox("task complete?");
    taskDuration = new Label("duration:");
    vBox.getChildren().add(taskName);
    vBox.getChildren().add(taskDescription);
    vBox.getChildren().add(taskDay);
    vBox.getChildren().add(complete);
    vBox.getChildren().add(taskDuration);
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
    finalizeTask = new Button("add task");
    finalizeTask.setOnAction(event -> addToGridPane(taskName.getText()));
    cancel = new Button("cancel");
    cancel.setOnAction(event -> taskPopup.hide());
    buttonRow.getChildren().add(finalizeTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    taskPopup.getContent().add(background);
    taskPopup.getContent().add(vBox);
  }

  /**
   * Makes the GUI elements of an event popup. //TODO change this
   */
  private void makeEventPopUp() {
    Rectangle background = popupView.createPopupBackground(260, 180);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#E7EACD"));
    vBox.getChildren().add(padding);
    eventName = new TextField("event name...");
    eventDescription = new TextField("description...");
    eventDay = new TextField("day...");
    startTime = new TextField("start time...");
    eventDuration = new Label("duration:");
    vBox.getChildren().add(eventName);
    vBox.getChildren().add(eventDescription);
    vBox.getChildren().add(eventDay);
    vBox.getChildren().add(startTime);
    vBox.getChildren().add(eventDuration);
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
    finalizeEvent = new Button("add event");
    finalizeEvent.setOnAction(event ->
    {
      //TODO work this out so events are not duplicated and added like a list
      taskList = new ArrayList<>();
      if (!taskList.contains(eventName.getText()) || !eventName.equals("event name...")) {
        taskList.add(eventName.getText());
        addToGridPane(eventName.getText());
      }
    });
    cancel = new Button("cancel");
    cancel.setOnAction(event -> eventPopup.hide());
    buttonRow.getChildren().add(finalizeEvent);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    eventPopup.getContent().add(background);
    eventPopup.getContent().add(vBox);
  }

  /**
   * Creates popup for the user to set a limit of tasks and/or events for a day.
   */
  private void makeLimitPopup() {
    Rectangle background = popupView.createPopupBackground(180, 260);
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
    if (taskDay.getText().equalsIgnoreCase("monday")
        || eventDay.getText().equalsIgnoreCase("monday")) {
      monPane.setText(name);
    } else if (taskDay.getText().equalsIgnoreCase("tuesday")
        || eventDay.getText().equalsIgnoreCase("tuesday")) {
      tuePane.setText(name);
    } else if (taskDay.getText().equalsIgnoreCase("wednesday")
        || eventDay.getText().equalsIgnoreCase("wednesday")) {
      wedPane.setText(name);
    } else if (taskDay.getText().equalsIgnoreCase("thursday")
        || eventDay.getText().equalsIgnoreCase("thursday")) {
      thursPane.setText(name);
    } else if (taskDay.getText().equalsIgnoreCase("friday")
        || eventDay.getText().equalsIgnoreCase("friday")) {
      friPane.setText(name);
    } else if (taskDay.getText().equalsIgnoreCase("saturday")
        || eventDay.getText().equalsIgnoreCase("saturday")) {
      satPane.setText(name);
    } else if (taskDay.getText().equalsIgnoreCase("sunday")
        || eventDay.getText().equalsIgnoreCase("sunday")) {
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

  // BLUE
  // "#e6f1fc" colour one
  // "#484e54" colour two
  // "-fx-font-family: Apple Symbols" font
  private void handleChangeTheme(String colorOne, String colorTwo, String font) {
    headerRect.setFill(Color.valueOf(colorOne));
    headerLabel.setStyle(font);
    headerLabel.setTextFill(Color.valueOf(colorTwo));
    changeThemeRect.setFill(Color.valueOf(colorOne));
    weekNameLabel.setTextFill(Color.valueOf(colorTwo));
    weekNameLabel.setStyle(font);
    quotesLabel.setTextFill(Color.valueOf(colorTwo));
    quotesLabel.setStyle(font);
    sunLabel.setTextFill(Color.valueOf(colorTwo));
    sunLabel.setStyle(font);
    monLabel.setTextFill(Color.valueOf(colorTwo));
    monLabel.setStyle(font);
    tueLabel.setTextFill(Color.valueOf(colorTwo));
    tueLabel.setStyle(font);
    wedLabel.setTextFill(Color.valueOf(colorTwo));
    wedLabel.setStyle(font);
    thuLabel.setTextFill(Color.valueOf(colorTwo));
    thuLabel.setStyle(font);
    friLabel.setTextFill(Color.valueOf(colorTwo));
    friLabel.setStyle(font);
    satLabel.setTextFill(Color.valueOf(colorTwo));
    satLabel.setStyle(font);
    sortTasksLabel.setTextFill(Color.valueOf(colorTwo));
    sortTasksLabel.setStyle(font);
    sortEventsLabel.setTextFill(Color.valueOf(colorTwo));
    sortEventsLabel.setStyle(font);
    taskQueueLabel.setTextFill(Color.valueOf(colorTwo));
    taskQueueLabel.setStyle(font);
    addEventRect.setFill(Color.valueOf(colorOne));
    addTaskRect.setFill(Color.valueOf(colorOne));
    setLimitRect.setFill(Color.valueOf(colorOne));
    saveRect.setFill(Color.valueOf(colorOne));
    tasksNameRect.setFill(Color.valueOf(colorOne));
    tasksDurRect.setFill(Color.valueOf(colorOne));
    eventDurRect.setFill(Color.valueOf(colorOne));
    eventNameRect.setFill(Color.valueOf(colorOne));
  }

  /**
   * Handles the button that is used to set a limit of tasks and/or events.
   */
  private void handleSetLimit() {
    //TODO implement
  }

  /**
   * Initializes controls of the GUI.
   */
  public void run() {
    addTask.setOnAction(event -> showTaskPopup());
    makeTaskPopUp();
    addEvent.setOnAction(event -> showEventPopup());
    makeEventPopUp();
    setLimit.setOnAction(event -> showLimitPopup());
    makeLimitPopup();
//    changeTheme.setOnAction(event -> handleChangeTheme());
    save.setOnAction(event -> handleSaveButton());
    sortByNameTask.setOnAction(event -> handleSortTasksByName());
    sortByDurationTask.setOnAction(event -> handleSortTasksByDuration());
  }
}
