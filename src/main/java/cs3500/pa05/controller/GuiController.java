package cs3500.pa05.controller;

import static java.lang.Thread.sleep;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Json.BujoJson;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.model.Json.TaskJson;
import cs3500.pa05.model.Time;
import cs3500.pa05.view.PopupView;
import cs3500.pa05.view.ThemeView;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
  private List<Label> weekLabels =
      List.of(sunLabel, monLabel, tueLabel, wedLabel, thuLabel, friLabel, satLabel);
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
  @FXML
  private TextField weekNameText;
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
  private final Popup splashScreen;
  private final Popup fileTitlePopup;
  private TextField taskName;
  private TextField taskDay;
  private TextField hoursDigit;
  private TextField minutesDigit;
  private Label hoursLabel;
  private Label minutesLabel;
  private TextField eventName;
  private Button finalizeTask;
  private TextField hourDigit;
  private TextField minDigit;
  private CheckBox complete;
  private RadioButton mon;
  private RadioButton tue;
  private RadioButton wed;
  private RadioButton thu;
  private RadioButton fri;
  private RadioButton sat;
  private RadioButton sun;
  private ArrayList<String> taskList;
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
    this.splashScreen = new Popup();
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

  public void makeFileGui(BujoJson bujo) {
    for (DayJson dayJson : bujo.week()) {
      for (TaskJson task : dayJson.tasks()) {
        addToGridPane(createTaskBox(task.name(), task.description()), task.day());
      }
      for (EventJson event : dayJson.events()) {
        addToGridPane(
            createEventBox(event.name(), event.description(), event.time(), event.duration()),
            event.day());
      }
    }
  }

  /**
   * Creates a popup for getting the user's specified file path, or lets them name a new one.
   */
  public void makeFileNamePopup() {
    Rectangle background = popupView.createPopupBackground(907, 1290);
    VBox vBox = new VBox(8);
    vBox.setAlignment(Pos.CENTER);
    vBox.setPrefWidth(1290);
    vBox.setPrefHeight(907);
    HBox hBox = new HBox(6);
    hBox.setAlignment(Pos.CENTER);
    Text welcome = new Text("Welcome! (^-^)" + System.lineSeparator()
        + "Please enter an existing bujo file path, or name a new one!");
    welcome.setTextAlignment(TextAlignment.CENTER);
    welcome.setStyle("-fx-font-family: 'BM Jua'");
    welcome.setFill(Color.valueOf("#555e3a"));
    TextField fileName = new TextField();
    Button goButton = new Button("go!");
    goButton.setOnAction(event -> {
      if (fileName.getText().endsWith(".bujo")) {
        makeFileGui(userController.handlePath(fileName.getText()));
        fileTitlePopup.hide();
      } else {
        fileName.clear();
        welcome.setText("Your file must end in \".bujo\" to be valid! (-o- )");
      }
    });
    vBox.getChildren().add(welcome);
    hBox.getChildren().add(fileName);
    hBox.getChildren().add(goButton);
    vBox.getChildren().add(hBox);
    fileTitlePopup.getContent().add(background);
    fileTitlePopup.getContent().add(vBox);
  }


//  /**
//   * Makes a splash screen.
//   */
//  public void makeSplashScreen() {
//    Rectangle background = popupView.createPopupBackground(907,1290);
//    HBox hbox = new HBox();
//    Text welcome = new Text("Ready to Journal? (^-^)");
//    welcome.setStyle("-fx-font-family: 'BM DoHyeon OTF'");
//    hbox.getChildren().add(welcome);
//    hbox.setAlignment(Pos.CENTER);
//    splashScreen.getContent().add(background);
//    splashScreen.getContent().add(welcome);
//  }
//
//  public void showSplashScreen() {
//    this.splashScreen.show(this.stage);
//    PauseTransition pause = new PauseTransition(Duration.seconds(3));
//    pause.setOnFinished(event -> splashScreen.hide());
//  }

  /**
   * Creates a popup for the user to enter details of a task.
   */
  private void makeTaskPopUp() {
    Rectangle background = popupView.createPopupBackground(240, 180);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#ffffff"));
    vBox.getChildren().add(padding);
    Label nameLabel = new Label("name: ");
    taskName = new TextField();
    Label descripLabel = new Label("description");
    TextField taskDescription = new TextField();
    Label dayLabel = new Label("day: ");
    HBox dayRow = createWeekRadios();
    vBox.getChildren().addAll(nameLabel, taskName, descripLabel, taskDescription, dayLabel, dayRow);
    HBox buttonRow = new HBox(5);
    finalizeTask = new Button("add task");
    finalizeTask.setOnAction(event -> {
      VBox taskBox =
          createTaskBox(taskName.getText(), taskDescription.getText());
      if (whatDay() == null) {
        //TODO: get valid input from the user
      }
      addToGridPane(taskBox, whatDay());
      userController.handleTask(
          new TaskJson(taskName.getText(), taskDescription.getText(),
              whatDay(),
              complete.isSelected()));
    });
    cancel = new Button("cancel");
    cancel.setOnAction(event -> taskPopup.hide());
    buttonRow.getChildren().add(finalizeTask);
    buttonRow.getChildren().add(cancel);
    vBox.getChildren().add(buttonRow);
    taskPopup.getContent().add(background);
    taskPopup.getContent().add(vBox);
  }

//  private Day translateStringToDay(RadioButton day) {
//    return switch (day.isSelected()) {
//      case mon -> Day.MONDAY;
//      case tue -> Day.TUESDAY;
//      case wed -> Day.WEDNESDAY;
//      case thu -> Day.THURSDAY;
//      case fri -> Day.FRIDAY;
//      case sat -> Day.SATURDAY;
//      case sun -> Day.SUNDAY;
//      default -> null;
//    };
//  }

  private Day whatDay() {
    if (mon.isSelected()) {
      return Day.MONDAY;
    } else if (tue.isSelected()) {
      return Day.TUESDAY;
    } else if (wed.isSelected()) {
      return Day.WEDNESDAY;
    } else if (thu.isSelected()) {
      return Day.THURSDAY;
    } else if (fri.isSelected()) {
      return Day.FRIDAY;
    } else if (sat.isSelected()) {
      return Day.SATURDAY;
    } else if (sun.isSelected()) {
      return Day.SUNDAY;
    } else {
      return null;
    }
  }

  /**
   * Creates a formatted representation of a task to display in the week view.
   *
   * @param name        the name of the task
   * @param description the description of the task
   * @return taskBox a box-like representaion of a task
   */
  private VBox createTaskBox(String name, String description) {
    VBox taskBox = new VBox(8);
    Text taskName = new Text(name);
    Text taskDescription = new Text(description);
    CheckBox complete = new CheckBox();
    taskBox.getChildren()
        .addAll(new Text("Task:"), taskName, taskDescription, complete);
    return taskBox;
  }

  public HBox createWeekRadios() {
    HBox dayRow = new HBox(5);
    ToggleGroup chosenDay = new ToggleGroup();
    RadioButton sun = new RadioButton("Sun");
    sun.setToggleGroup(chosenDay);
    sun.setSelected(true);
    RadioButton mon = new RadioButton("Mon");
    mon.setToggleGroup(chosenDay);
    RadioButton tue = new RadioButton("Tue");
    tue.setToggleGroup(chosenDay);
    RadioButton wed = new RadioButton("Wed");
    wed.setToggleGroup(chosenDay);
    RadioButton thu = new RadioButton("Thu");
    thu.setToggleGroup(chosenDay);
    RadioButton fri = new RadioButton("Fri");
    fri.setToggleGroup(chosenDay);
    RadioButton sat = new RadioButton("Sat");
    sat.setToggleGroup(chosenDay);
    dayRow.getChildren().addAll(sun, mon, tue, wed, thu, fri, sat);
    return dayRow;
  }

  /**
   * Creates a popup for a user to enter the details of an event.
   */
  private void makeEventPopUp() {
    Rectangle background = popupView.createPopupBackground(260, 180);
    VBox vBox = new VBox(8);
    Rectangle padding = new Rectangle(180, 10);
    padding.setFill(Color.valueOf("#ffffff"));
    Label nameLabel = new Label("name: ");
    eventName = new TextField();
    Label descripLabel = new Label("description: ");
    TextField eventDescription = new TextField();
    Label dayLabel = new Label("day: ");
    HBox dayRow = createWeekRadios();
    Label startTime = new Label("start time...");
    Label eventDuration = new Label("duration: ");
    HBox startTimeRow = new HBox(5);
    hourDigit = new TextField();
    Label colon = new Label(":");
    colon.setPrefWidth(10);
    hourDigit.setPrefWidth(30);
    minDigit = new TextField();
    minDigit.setPrefWidth(30);
    ToggleGroup amOrPm = new ToggleGroup();
    am = new RadioButton("AM");
    pm = new RadioButton("PM");
    am.setToggleGroup(amOrPm);
    am.setSelected(true);
    pm.setToggleGroup(amOrPm);
    startTimeRow.getChildren().addAll(hourDigit, colon, minDigit, am, pm);
    HBox hBox = new HBox(5);
    hoursDigit = new TextField();
    hoursDigit.setPrefWidth(30);
    hoursLabel = new Label("H");
    minutesDigit = new TextField();
    minutesDigit.setPrefWidth(30);
    minutesLabel = new Label("M");
    hBox.getChildren().addAll(hoursDigit, hoursLabel, minutesDigit, minutesLabel);
    vBox.getChildren()
        .addAll(padding, nameLabel, eventName, descripLabel, eventDescription, dayLabel, dayRow,
            startTime, startTimeRow,
            eventDuration, hBox);
    HBox buttonRow = new HBox(5);
    Button finalizeEvent = new Button("add event");
    finalizeEvent.setOnAction(event ->
    {
      //TODO work this out so events are not duplicated and added like a list
      taskList = new ArrayList<>();
      if (!taskList.contains(eventName.getText()) || !eventName.getText().equals("event name...")) {
        Time time;
        try {
          time =
              new Time(Integer.parseInt(hourDigit.getText()), Integer.parseInt(minDigit.getText()));
        } catch (NumberFormatException e) {
          time = null;
        }
        Time duration;
        try {
          duration = new Time(Integer.parseInt(hoursDigit.getText()),
              Integer.parseInt(minutesDigit.getText()));
        } catch (NumberFormatException e) {
          duration = null;
        }

        taskList.add(eventName.getText());
        VBox eventBox =
            createEventBox(eventName.getText(), eventDescription.getText(), time, duration);
        if (whatDay() != null) {
          //TODO: get valid input from the user
          addToGridPane(eventBox, whatDay());
        }
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
   * Creates a formatted representation of an event to display in a week view.
   *
   * @param name        the name of the event
   * @param description the description of the event
   * @return eventBox a box-like representation of an event
   */
  private VBox createEventBox(String name, String description, Time startTime, Time duration) {
    VBox eventBox = new VBox(8);
    Text textName = new Text(name);
    Text textDescription = new Text(description);
    Text textStartTime;
    if (startTime == null) {
      textStartTime = new Text("No start time");
    } else {
      textStartTime = new Text(startTime.toString());
    }
    Text textDuration;
    if (duration == null) {
      textDuration = new Text("No duration specified");
    } else {
      textDuration =
          new Text(String.format("%dhr and %dmin", duration.getHour(), duration.getMinute()));
    }
//    HBox timeRow = new HBox();
//    timeRow.getChildren().add(textStartTime);
//    HBox durationRow = new HBox();
//    durationRow.getChildren().add(textDuration);
    eventBox.getChildren()
        .addAll(new Text("Event:"), textName, textDescription, textStartTime, textDuration);
    return eventBox;
  }

  /**
   * Creates a popup for the user to set a limit of tasks and/or events for a day.
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
    saveLimit.setOnAction(
        event -> userController.handleLimit(taskLimit.getText(), eventLimit.getText()));
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
   * Adds a task or event to the week view's grid pane.
   *
   * @param event the event to display
   */
  public void addToGridPane(VBox event, Day day) {
    switch (day) {
      case FRIDAY -> friPane.getChildren().add(event);
      case MONDAY -> monPane.getChildren().add(event);
      case SUNDAY -> sunPane.getChildren().add(event);
      case TUESDAY -> tuePane.getChildren().add(event);
      case SATURDAY -> satPane.getChildren().add(event);
      case THURSDAY -> thuPane.getChildren().add(event);
      case WEDNESDAY -> wedPane.getChildren().add(event);
    }
  }

  /**
   *
   */
  public void showFileTitlePopUp() {
    this.fileTitlePopup.show(this.stage);
  }

  /**
   * Handles button that sorts tasks and events by name.
   */
  private void handleSortTasksByName() {
    List<TaskJson> tasks = userController.sortTasks(true);
  }

  /**
   * Handles button that sorts tasks and events by duration.
   */
  private void handleSortTasksByDuration() {
    List<TaskJson> tasks = userController.sortTasks(false);

  }

  /**
   * Handles button that sorts tasks and events by name.
   */
  private void handleSortEventsByName() {
    List<EventJson> events = userController.sortEvents(true);
  }

  /**
   * Handles button that sorts tasks and events by duration.
   */
  private void handleSortEventsByDuration() {
    List<EventJson> events = userController.sortEvents(false);
  }

  private void changeLabelTheme(Label label, String textFill, String font) {
    label.setTextFill(Color.valueOf(textFill));
    label.setStyle(font);
  }


  /**
   * Changes the bullet journal's GUI to the specified colors and fonts.
   *
   * @param colorOne color to use for buttons or headers
   * @param colorTwo color to use for text
   * @param font     font to use for text
   */
  private void changeTheme(String colorOne, String colorTwo, String font, String face) {
    headerRect.setFill(Color.valueOf(colorOne));
    headerLabel.setText(face);
    changeLabelTheme(headerLabel, colorTwo, font);
    changeThemeRect.setFill(Color.valueOf(colorOne));
    weekNameText.setBackground(Background.fill(Color.valueOf("#ffffff")));
    weekNameText.setStyle("-fx-text-fill: " + colorTwo);
    weekNameText.setStyle(font);
    changeLabelTheme(quotesLabel, colorTwo, font);
    quotesArea.setStyle(font);
    for (Label day : weekLabels) {
      changeLabelTheme(day, colorTwo, font);
    }
    changeLabelTheme(sortTasksLabel, colorTwo, font);
    changeLabelTheme(sortEventsLabel, colorTwo, font);
    changeLabelTheme(taskQueueLabel, colorTwo, font);
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
        "#a9bc89", "#555e3a",
        "-fx-font-family: 'BM JUA OTF'", "(O_O)"));
    yellow.setOnAction(event -> changeTheme(
        "#f7dba1", "#a18570",
        "-fx-font-family: 'Avenir Next'", "(-_- )"));
    blue.setOnAction(event -> changeTheme(
        "#e6f1fc", "#484e54",
        "-fx-font-family: 'Apple Symbols'", "(^ - ^ )"));
    purple.setOnAction(event -> changeTheme(
        "#bdb5d0", "#323236",
        "-fx-font-family: 'BM DoHyeon OTF'", "(; - ; )"));
    Button cancelChange = new Button("cancel");
    cancelChange.setOnAction(event -> changeThemePopup.hide());
    vbox.getChildren().addAll(green, yellow, purple, blue, cancelChange);
    changeThemePopup.getContent().addAll(background, vbox);
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
    //TODO:Make a label or popup to notify the user that their bujo has been saved
    save.setOnAction(event -> userController.handleSave());
    sortByNameTask.setOnAction(event -> handleSortTasksByName());
    sortByDurationTask.setOnAction(event -> handleSortTasksByDuration());
    sortByNameEvent.setOnAction(event -> handleSortEventsByName());
    sortByDurationEvent.setOnAction(event -> handleSortEventsByDuration());
    makeFileNamePopup();
    showFileTitlePopUp();
  }
}
