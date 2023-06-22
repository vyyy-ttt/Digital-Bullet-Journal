package cs3500.pa05.model;

/**
 * Represents a theme for the GUI.
 */
public class Theme {
  private final ThemeType GREEN = ThemeType.PINKGREEN;
  private final ThemeType YELLOW = ThemeType.YELLOW;
  private final ThemeType BLUE = ThemeType.BLUE;
  private final ThemeType PURPLE = ThemeType.PURPLE;

  public Theme(String colorOne, String colorTwo, String font, String face) {

  }

  /**
   * Gets color one depending on which theme is active.
   *
   * @param theme the current theme
   * @return the value of the color
   */
  public String getColorOne(ThemeType theme) {
    if (theme == GREEN) {
      return "#a9bc89";
    } else if (theme == YELLOW) {
      return "#f7dba1";
    } else if (theme == BLUE) {
      return "#e6f1fc";
    } else if (theme == PURPLE) {
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
    if (theme == GREEN) {
      return "#555e3a";
    } else if (theme == YELLOW) {
      return "#a18570";
    } else if (theme == BLUE) {
      return "#484e54";
    } else if (theme == PURPLE) {
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
    if (theme == GREEN) {
      return "-fx-font-family: 'BM JUA OTF'";
    } else if (theme == YELLOW) {
      return "-fx-font-family: 'Avenir Next'";
    } else if (theme == BLUE) {
      return "-fx-font-family: 'Apple Symbols'";
    } else if (theme == PURPLE) {
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
    if (theme == GREEN) {
      return "(O_O)";
    } else if (theme == YELLOW) {
      return "(-_- )";
    } else if (theme == BLUE) {
      return "(^ - ^ )";
    } else if (theme == PURPLE) {
      return "(; - ; )";
    } else {
      return null;
    }
  }

}
