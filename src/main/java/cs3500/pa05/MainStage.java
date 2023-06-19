package cs3500.pa05;

import cs3500.pa05.controller.GuiController;
import cs3500.pa05.view.WelcomeView;
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
    GuiController guiController = new GuiController(stage);
    WelcomeView welcomeView = new WelcomeView(guiController);
    try {
      stage.setScene(welcomeView.load());
      guiController.run();
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
