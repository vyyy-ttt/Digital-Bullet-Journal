package cs3500.pa05;

import cs3500.pa05.view.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainStage extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    WelcomeView welcomeView = new WelcomeView();

    try {
      primaryStage.setScene(welcomeView.load());
      primaryStage.setTitle("dvb bujo!");
      primaryStage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load, I'm sorry!");
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
