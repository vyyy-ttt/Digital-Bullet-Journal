package cs3500.pa05;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.WelcomeController;
import cs3500.pa05.view.WelcomeView;
import java.io.IOException;
import java.util.Objects;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents a bullet journal application.
 */
public class MainStage extends Application {

  /**
   * Starts the GUI for a bullet journal.
   *
   * @param stage the primary stage for this application, onto which
   *              the application scene can be set.
   *              Applications may create other stages, if needed, but they will not be
   *              primary stages.
   */
  @Override
  public void start(Stage stage) {
    stage.setTitle("dvb bujo!");
    WelcomeController welcomeController = new WelcomeController(stage);
    WelcomeView welcomeView = new WelcomeView(welcomeController);
    BujoController bujoController = new BujoController(stage);
    try {
      stage.setScene(welcomeView.load());
      stage.show();
      welcomeController.run();
      bujoController.run();
      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load, I'm sorry!");
    }
  }

  /**
   * Entry point for a bullet journal.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch();
  }
}
