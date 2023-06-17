package cs3500.pa05.model;

/**
 * Represents a timestamp
 */
public class Time {
  private static final int MAX_MILITARY_HOURS = 24;
  private static final int MAX_MINUTES = 59;
  private static final int MAX_REGULAR_HOURS = 12;
  private final int hour;
  private final int minute;
  private TimeMarkers marker = null;

  /**
   * Instantiates a new timestamp in military time.
   *
   * @param hour   the hour of the timestamp
   * @param minute the minute of the timestamp
   */
  public Time(int hour, int minute) {
    if (hour > MAX_MILITARY_HOURS || hour < 0) {
      throw new IllegalArgumentException("Hour given is out of bounds.");
    }
    if (minute > MAX_MINUTES || minute < 0) {
      throw new IllegalArgumentException("Minutes given is out of bounds.");
    }
    this.hour = hour;
    this.minute = minute;
  }

  /**
   * Instantiates a new timestamp in regular time.
   *
   * @param hour   the hour of the timestamp
   * @param minute the minute of the timestamp
   * @param marker the marker for the timestamp
   */
  public Time(int hour, int minute, TimeMarkers marker) {
    this(hour, minute);
    if (hour > MAX_REGULAR_HOURS || hour <= 0) {
      throw new IllegalArgumentException("Hour given is out of bounds.");
    }
    this.marker = marker;
  }

  @Override
  public String toString() {
    String min_tens_place = "";
    String hour_tens_place = "";
    if (minute < 10) {
      min_tens_place = "0";
    }
    if (hour < 10) {
      hour_tens_place = "0";
    }
    if (marker != null) {
      return String.format("%d:%s%d %s", hour, min_tens_place, minute,
          marker.toString().toLowerCase());
    }
    return String.format("%s%d:%s%d", hour_tens_place, hour, min_tens_place, minute);
  }
}