package cs3500.pa05;

import cs3500.pa05.controller.GuiController;
import cs3500.pa05.view.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainStage extends Application {
  @Override
  public void start(Stage stage) {
    GuiController guiController = new GuiController(stage);
    WelcomeView welcomeView = new WelcomeView(guiController);

    try {
      stage.setScene(welcomeView.load());
      stage.setTitle("dvb bujo!");
      stage.show();
      guiController.run();
      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load, I'm sorry!");
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
