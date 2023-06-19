package cs3500.pa05.controller;

import cs3500.pa05.model.Json.EventJson;
import cs3500.pa05.view.BujoView;
import cs3500.pa05.view.WelcomeView;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
public class WelcomeController {
  @FXML
  private Button goButton;
  @FXML
  private TextField bujoFileField;
  @FXML
  private Label prompt;
  private Stage stage;
  private Popup popup;
  private Scene scene;
  private Parent root;
  private WelcomeView welcomeView;
  private BujoView bujoView;
  private UserController userController = new UserController();

  /**
   *
   *
   * @param stage
   */
  public WelcomeController(Stage stage) {
    goButton = new Button();
    bujoFileField = new TextField();
    prompt = new Label();
    this.stage = stage;
    welcomeView = new WelcomeView(this);
  }

  /**
   * Handles the button that commences into a bullet journal scene.
   */
  private void handleGoButton() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("bujo.fxml"));
      Scene scene = loader.load();
      stage.setScene(scene);
    } catch (IOException e) {
      System.out.println("oh no");
    }
  }

  /**
   * Handles the user input in the textField for the bujo file path.
   */
  private void handleBujoField() {
    String input = bujoFileField.getText();
    if (input.endsWith(".bujo")) {
      userController.handlePath(input);
      handleGoButton();
    } else {
      prompt.setText("Oops! That wasn't a valid bujo file, please try again.");
    }
  }

  /**
   * Initializes the event handlers for controls of the welcome GUI.
   */
  public void run() {
    goButton.setOnAction(event -> handleBujoField());
  }
}

