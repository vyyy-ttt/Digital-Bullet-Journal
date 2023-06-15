package cs3500.pa05.model.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Status;

/**
 * Represents a task that the user needs to remember.
 *
 * @param name the name of the task
 * @param description a description of the task
 * @param day the day the task needs to be done by
 * @param status the current status of the task
 */
public record TaskJson(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("day") Day day,
                       @JsonProperty("completion")Status status) {
  //TODO: New Tasks should be marked as not complete by default. Descriptions are optional.
}
