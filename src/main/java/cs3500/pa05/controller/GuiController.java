package cs3500.pa05.controller;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GuiController {

  @FXML
  private Button goButton;
  @FXML
  private Button addTaskPG;
  private Stage stage;

  public GuiController(Stage stage) {
    this.stage = stage;
  }

  public void handleGoButton() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("bujo.fxml"));
      stage.setScene(loader.load());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void handleAddTask() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("taskPop.fxml"));
      stage.setScene(loader.load());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
  public void run() {
    goButton.setOnAction(event -> handleGoButton());
    addTaskPG.setOnAction(event -> handleAddTask());
  }
}
