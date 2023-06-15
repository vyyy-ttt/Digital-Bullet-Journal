package cs3500.pa05.model;

/**
 * Represents a timestamp
 */
public class Time {
  private static final int MAX_MILITARY_HOURS = 24;
  private static final int MAX_MINUTES = 59;
  private int hour;
  private int minute;
  private RegularTimeMarkers marker = null;

  /**
   * Instantiates a new timestamp in military time.
   *
   * @param hour the hour of the timestamp
   * @param minute the minute of the timestamp
   */
  public Time(int hour, int minute){
    if(hour > MAX_MILITARY_HOURS || hour < 0){
      throw new IllegalArgumentException("Hour given is out of bounds.");
    }
    if(minute > MAX_MINUTES || minute < 0){
      throw new IllegalArgumentException("Minutes given is out of bounds.");
    }
  }

  /**
   * Instantiates a new timestamp in regular time.
   *
   * @param hour the hour of the timestamp
   * @param minute the minute of the timestamp
   * @param marker the marker for the timestamp
   */
  public Time(int hour, int minute, RegularTimeMarkers marker){
    this(hour, minute);
    if(hour > 12 || hour < 0){
      throw new IllegalArgumentException("Hour given is out of bounds.");
    }
    this.marker = marker;
  }

  @Override
  public String toString(){
    if(marker != null){
      return  String.format("%d:%d %s", hour, minute, marker.toString().toLowerCase());
    }
    return String.format("%d:%d", hour, minute);
  }
}
