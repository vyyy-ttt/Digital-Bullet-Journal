package cs3500.pa05.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

/**
 * Represents the JavaFx for a popup.
 */
public class PopupView {

  /**
   * Sets up a GUI background for popups.
   *
   * @param height popup height
   * @param width popup width
   */
  public Rectangle createPopupBackground(int height, int width) {
    Rectangle background = new Rectangle();
    background.setHeight(height);
    background.setWidth(width);
    background.setFill(Color.valueOf("#E7EACD"));
    background.setArcHeight(20);
    background.setArcWidth(20);
    return background;
  }
}