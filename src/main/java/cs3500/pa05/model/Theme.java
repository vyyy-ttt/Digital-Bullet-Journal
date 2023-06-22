package cs3500.pa05.model;

import cs3500.pa05.controller.GuiController;
import java.lang.reflect.Array;

/**
 * Represents a theme for the GUI.
 */
public class Theme {
  /**
   * Gets color one depending on which theme is active.
   *
   * @param theme the current theme
   * @return the value of the color
   */
  public String getColorOne(ThemeType theme) {
    if (theme == ThemeType.PINKGREEN) {
      return "#a9bc89";
    } else if (theme == ThemeType.YELLOW) {
      return "#f7dba1";
    } else if (theme == ThemeType.BLUE) {
      return "#e6f1fc";
    } else if (theme == ThemeType.PURPLE) {
      return "#bdb5d0";
    } else {
      return null;
    }
  }

  /**
   * Gets color two depending on which theme is active.
   *
   * @param theme the current theme
   * @return the value of the color
   */
  public String getColorTwo(ThemeType theme) {
    if (theme == ThemeType.PINKGREEN) {
      return "#555e3a";
    } else if (theme == ThemeType.YELLOW) {
      return "#a18570";
    } else if (theme == ThemeType.BLUE) {
      return "#484e54";
    } else if (theme == ThemeType.PURPLE) {
      return "#323236";
    } else {
      return null;
    }
  }

  /**
   * Gets font depending on which theme is active.
   *
   * @param theme the current theme
   * @return the value of the color
   */
  public String getFont(ThemeType theme) {
    if (theme == ThemeType.PINKGREEN) {
      return "-fx-font-family: 'BM JUA OTF'";
    } else if (theme == ThemeType.YELLOW) {
      return "-fx-font-family: 'Avenir Next'";
    } else if (theme == ThemeType.BLUE) {
      return "-fx-font-family: 'Apple Symbols'";
    } else if (theme == ThemeType.PURPLE) {
      return "-fx-font-family: 'BM DoHyeon OTF'";
    } else {
      return null;
    }
  }

  /**
   * Gets face depending on which theme is active.
   *
   * @param theme the current theme
   * @return the value of the color
   */
  public String getFace(ThemeType theme) {
    if (theme == ThemeType.PINKGREEN) {
      return "(O_O)";
    } else if (theme == ThemeType.YELLOW) {
      return "(-_- )";
    } else if (theme == ThemeType.BLUE) {
      return "(^ - ^ )";
    } else if (theme == ThemeType.PURPLE) {
      return "(; - ; )";
    } else {
      return null;
    }
  }
}
