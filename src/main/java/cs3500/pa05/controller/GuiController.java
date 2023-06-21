package cs3500.pa05.controller;

import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.view.PopupView;
import cs3500.pa05.view.ThemeView;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
  private VBox sunPane;
  @FXML
  private VBox monPane;
  @FXML
  private VBox tuePane;
  @FXML
  private VBox wedPane;
  @FXML
  private VBox thuPane;
  @FXML
  private VBox friPane;
  @FXML
  private VBox satPane;
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
  private Rectangle changeTitleRect;
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
  @FXML
  private Button changeTitle;
  @FXML
  private TextArea quotesArea;
  @FXML
  private RadioButton am;
  @FXML
  private RadioButton pm;
  @FXML
  private Text taskQueueText;
  private Button cancel;
  private final Stage stage;
  private final Popup taskPopup;
  private final Popup eventPopup;
  private final Popup limitPopup;
  private final Popup changeThemePopup;
  private final Popup titlePopup;
  private final Popup fileTitlePopup;
  private TextField taskName;
  private TextField taskDay;
  private TextField hoursDigit;
  private TextField minutesDigit;
  private Label hoursLabel;
  private Label minutesLabel;
  private TextField eventName;
  private TextField eventDay;
  private Button finalizeTask;
  private TextField hourDigit;
  private TextField minDigit;
  private ArrayList<String> taskList;
  private BulletJournal bulletJournal;
  private final PopupView popupView;
  private final ThemeView themeView;
  private final UserController userController;

  /**
   * Constructs a GUIController.
   *
   * @param stage the stage of the GUI
   */
  public GuiController(Stage stage) {
    this.stage = stage;
    this.taskPopup = new Popup();
    this.eventPopup = new Popup();
    this.limitPopup = new Popup();
    this.changeThemePopup = new Popup();
    this.titlePopup = new Popup();
    this.fileTitlePopup = new Popup();
    popupView = new PopupView();
    themeView = new ThemeView();
    monPane = new VBox(3);
    tuePane = new VBox(3);
    wedPane = new VBox(3);
    thuPane = new VBox(3);
    friPane = new VBox(3);
    satPane = new VBox(3);
    sunPane = new VBox(3);
    userController = new UserController();
  }

  public void makeFileNamePopup() {
    Rectangle background = popupView.createPopupBackground(50, 180);
    HBox hBox = new HBox(6);
    TextField fileName = new TextField("name your bujo file!");
    Button goButton = new Button("go!");
    goButton.setOnAction(event -> {
      if (fileName.getText().endsWith(".bujo")) {
        userController.handlePath(fileName.getText());
        fileTitlePopup.hide();
      }
    });
    hBox.getChildren().add(fileName);
    hBox.getChildren().add(goButton);
    fileTitlePopup.getContent().add(background);
    fileTitlePopup.getContent().add(hBox);
  }

  /**
   * Makes the GUI elements of a task popup.
   */
  private void makeTaskPopUp() {
    Rectangle background = popupView.createPopupBackground(240, 180);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#ffffff"));
    vBox.getChildren().add(padding);
    taskName = new TextField("task name...");
    TextField taskDescription = new TextField("description...");
    taskDay = new TextField("day...");
    CheckBox complete = new CheckBox("task complete?");
    Label taskDuration = new Label("duration:");
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
//    finalizeTask.setOnAction(event -> addToGridPane(taskName.getText()));
    cancel = new Button("cancel");
    cancel.setOnAction(event -> taskPopup.hide());
    buttonRow.getChildren().add(finalizeTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    taskPopup.getContent().add(background);
    taskPopup.getContent().add(vBox);
  }

  /**
   * Makes the GUI elements of an event popup.
   */
  private void makeEventPopUp() {
    Rectangle background = popupView.createPopupBackground(260, 180);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#ffffff"));
    vBox.getChildren().add(padding);
    eventName = new TextField("event name...");
    TextField eventDescription = new TextField("description...");
    eventDay = new TextField("day...");
    Label startTime = new Label("start time...");
    Label eventDuration = new Label("duration:");
    vBox.getChildren().add(eventName);
    vBox.getChildren().add(eventDescription);
    vBox.getChildren().add(eventDay);
    vBox.getChildren().add(startTime);
    HBox startTimeRow = new HBox(5);
    hourDigit = new TextField("___");
    Label colon = new Label(":");
    colon.setPrefWidth(10);
    hourDigit.setPrefWidth(30);
    minDigit = new TextField("___");
    minDigit.setPrefWidth(30);
    ToggleGroup amOrPm = new ToggleGroup();
    am = new RadioButton("AM");
    pm = new RadioButton("PM");
    am.setToggleGroup(amOrPm);
    am.setSelected(true);
    pm.setToggleGroup(amOrPm);
    startTimeRow.getChildren().add(hourDigit);
    startTimeRow.getChildren().add(colon);
    startTimeRow.getChildren().add(minDigit);
    startTimeRow.getChildren().add(am);
    startTimeRow.getChildren().add(pm);
    vBox.getChildren().add(startTimeRow);
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
    Button finalizeEvent = new Button("add event");
    finalizeEvent.setOnAction(event ->
    {
      //TODO work this out so events are not duplicated and added like a list
      taskList = new ArrayList<>();
      if (!taskList.contains(eventName.getText()) || !eventName.getText().equals("event name...")) {
        taskList.add(eventName.getText());
        VBox eventBox = createEventBox(eventName.getText(),
            eventDescription.getText(),
            hourDigit.getText(),
            minDigit.getText(),
            hoursDigit.getText(),
            minutesDigit.getText());
        addToGridPane(eventBox);
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

  private VBox createEventBox(String name, String description, String hourTime, String minuteTime,
                              String hourDur, String minDur) {
    VBox eventBox = new VBox(8);
    Text textName = new Text(name);
    Text textDescription = new Text(description);
    Text textHour = new Text(hourTime + ":");
    Text textMinute;
    if (am.isSelected()) {
      textMinute = new Text(minuteTime + "AM");
    } else {
      textMinute = new Text(minuteTime + "PM");
    }
    Text textDurHour = new Text(hourDur);
    Text textDurMin = new Text(minDur);
    HBox timeRow = new HBox();
    timeRow.getChildren().add(textHour);
    timeRow.getChildren().add(textMinute);
    HBox durationRow = new HBox();
    durationRow.getChildren().add(textDurHour);
    durationRow.getChildren().add(textDurMin);
    eventBox.getChildren().add(textName);
    eventBox.getChildren().add(textDescription);
    eventBox.getChildren().add(timeRow);
    eventBox.getChildren().add(durationRow);
    return eventBox;
  }

  private boolean verifyEventName() {
    // TODO implement
    return false;
  }

  private boolean verifyTaskName() {
    // TODO implement
    return true;
  }

  /**
   * Creates popup for the user to set a limit of tasks and/or events for a day.
   */
  private void makeLimitPopup() {
    Rectangle background = popupView.createPopupBackground(180, 260);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("ffffff"));
    vBox.getChildren().add(padding);
    Label limitPrompt = new Label("Please enter the limits you would like to set:");
    TextField taskLimit = new TextField("task limit...");
    TextField eventLimit = new TextField("event limit...");
    HBox buttonRow = new HBox();
    Button saveLimit = new Button("save");
//    saveLimit.setOnAction(event -> ha);
    Button cancelLimit = new Button("cancel");
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
   * Makes a popup for the user to change the titles of the bullet journal spread.
   */
  private void makeTitlePopup() {
    Rectangle background = popupView.createPopupBackground(120, 260);
    VBox vBox = new VBox(8);
    TextField fileName = new TextField("name your file");
    TextField weekName = new TextField("name your week");
    String fileTitle = fileName.getText();
    String weekTitle = weekName.getText();
    HBox fileRow = new HBox(5);
    HBox weekRow = new HBox(5);
    Button saveTitle = new Button("save file title");
    Button saveWeekName = new Button("save week title");
    saveTitle.setOnAction(event -> headerLabel.setText(fileTitle));
    saveWeekName.setOnAction(event -> weekNameLabel.setText(weekTitle));
    Button cancelTitle = new Button("cancel");
    cancelTitle.setOnAction(event -> titlePopup.hide());
    fileRow.getChildren().add(fileName);
    fileRow.getChildren().add(saveTitle);
    weekRow.getChildren().add(weekName);
    weekRow.getChildren().add(saveWeekName);
    vBox.getChildren().add(fileRow);
    vBox.getChildren().add(weekRow);
    vBox.getChildren().add(cancelTitle);
    titlePopup.getContent().add(background);
    titlePopup.getContent().add(vBox);
  }

  /**
   * Adds a task or event to the week gridpane.
   *
   * @param event the event to display
   */
  public void addToGridPane(VBox event) {
    if (taskDay.getText().equalsIgnoreCase("monday")
        || eventDay.getText().equalsIgnoreCase("monday")) {
      monPane.getChildren().add(event);
    } else if (taskDay.getText().equalsIgnoreCase("tuesday")
        || eventDay.getText().equalsIgnoreCase("tuesday")) {
      tuePane.getChildren().add(event);
    } else if (taskDay.getText().equalsIgnoreCase("wednesday")
        || eventDay.getText().equalsIgnoreCase("wednesday")) {
      wedPane.getChildren().add(event);
    } else if (taskDay.getText().equalsIgnoreCase("thursday")
        || eventDay.getText().equalsIgnoreCase("thursday")) {
      thuPane.getChildren().add(event);
    } else if (taskDay.getText().equalsIgnoreCase("friday")
        || eventDay.getText().equalsIgnoreCase("friday")) {
      friPane.getChildren().add(event);
    } else if (taskDay.getText().equalsIgnoreCase("saturday")
        || eventDay.getText().equalsIgnoreCase("saturday")) {
      satPane.getChildren().add(event);
    } else if (taskDay.getText().equalsIgnoreCase("sunday")
        || eventDay.getText().equalsIgnoreCase("sunday")) {
      sunPane.getChildren().add(event);
    } else {
      System.out.println("oops"); // TODO make this display smt
    }
  }

  /**
   * Saves the current bullet jouranl spread.
   */
  private void handleSaveButton() {
    bulletJournal.saveBulletJournal();
  }

  /**
   *
   */
  public void showFileTitlePopUp() {
    this.fileTitlePopup.show(this.stage);
  }

  /**
   * Shows a popup for changing the title on the stage.
   */
  public void showTitlePopup() {
    this.titlePopup.show(this.stage);
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
   * Handles button that sorts tasks and events by name.
   */
  private void handleSortEventsByName() {
    //TODO implement
  }

  /**
   * Handles button that sorts tasks and events by duration.
   */
  private void handleSortEventsByDuration() {
    //TODO implement
  }


  /**
   * Changes the bullet journal's GUI to the specified colors and fonts.
   *
   * @param colorOne color to use for buttons or headers
   * @param colorTwo color to use for text
   * @param font     font to use for text
   */
  private void changeTheme(String colorOne, String colorTwo, String font) {
    headerRect.setFill(Color.valueOf(colorOne));
    headerLabel.setStyle(font);
    headerLabel.setTextFill(Color.valueOf(colorTwo));
    changeThemeRect.setFill(Color.valueOf(colorOne));
    changeTitleRect.setFill(Color.valueOf(colorOne));
    weekNameLabel.setTextFill(Color.valueOf(colorTwo));
    weekNameLabel.setStyle(font);
    quotesLabel.setTextFill(Color.valueOf(colorTwo));
    quotesLabel.setStyle(font);
    quotesArea.setStyle(font);
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
    taskQueueText.setStyle(font);
  }

  /**
   * Makes a popup for the user to change the theme of the bullet journal spread.
   */
  private void makeThemePopup() {
    Rectangle background = popupView.createPopupBackground(180, 100);
    VBox vbox = new VBox(8);
    Button green = new Button("Green");
    Button yellow = new Button("Yellow");
    Button blue = new Button("Blue");
    Button purple = new Button("Purple");
    green.setOnAction(event -> changeTheme(
        "#a9bc89", "#555e3a", "-fx-font-family: 'BM JUA OTF'"));
    yellow.setOnAction(event -> changeTheme(
        "#f7dba1", "#a18570", "-fx-font-family: 'Avenir Next'"));
    blue.setOnAction(event -> changeTheme(
        "#e6f1fc", "#484e54", "-fx-font-family: 'Apple Symbols'"));
    purple.setOnAction(event -> changeTheme(
        "#bdb5d0", "#323236", "-fx-font-family: 'BM DoHyeon OTF'"));
    Button cancelChange = new Button("cancel");
    cancelChange.setOnAction(event -> changeThemePopup.hide());
    vbox.getChildren().add(green);
    vbox.getChildren().add(yellow);
    vbox.getChildren().add(purple);
    vbox.getChildren().add(blue);
    vbox.getChildren().add(cancelChange);
    changeThemePopup.getContent().add(background);
    changeThemePopup.getContent().add(vbox);
  }

  /**
   * Initializes controls of the GUI.
   */
  public void run() {
    addTask.setOnAction(event -> this.taskPopup.show(this.stage));
    makeTaskPopUp();
    addEvent.setOnAction(event -> this.eventPopup.show(this.stage));
    makeEventPopUp();
    setLimit.setOnAction(event -> this.limitPopup.show(this.stage));
    makeLimitPopup();
    changeTheme.setOnAction(event -> this.changeThemePopup.show(this.stage));
    makeThemePopup();
    save.setOnAction(event -> handleSaveButton());
    sortByNameTask.setOnAction(event -> handleSortTasksByName());
    sortByDurationTask.setOnAction(event -> handleSortTasksByDuration());
    sortByNameEvent.setOnAction(event -> handleSortEventsByName());
    sortByDurationEvent.setOnAction(event -> handleSortEventsByDuration());
    makeFileNamePopup();
    showFileTitlePopUp();
  }
}
