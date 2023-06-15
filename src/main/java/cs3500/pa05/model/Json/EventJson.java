package cs3500.pa05.model.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Time;

/**
 * Represents an event created for a certain day.
 *
 * @param name name of the event
 * @param description description of what the event is
 * @param day the day of the week the event is on
 * @param time the start time for the event
 * @param duration how long the event will last
 */
public record EventJson(@JsonProperty("name") String name,
                        @JsonProperty("description") String description,
                        @JsonProperty("day") Day day,
                        @JsonProperty("start_time") Time time,
                        @JsonProperty("duration") String duration) {
  //TODO: description is optional, everything else is mandatory
}
