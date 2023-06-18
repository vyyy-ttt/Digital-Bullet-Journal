package cs3500.pa05;

import cs3500.pa05.controller.GuiController;
import cs3500.pa05.view.GuiView;
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
    GuiController guiController = new GuiController(stage);
    GuiView view = new GuiView(guiController);
    try {
      stage.setScene(view.load());
      stage.setTitle("dvb bujo!");
      guiController.sceneOneRun();
      guiController.sceneTwoRun();
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
