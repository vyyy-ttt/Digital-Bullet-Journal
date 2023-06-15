package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON format of this record:
 * <p>
 * <code>
 * {
 * "week": "week",
 * }
 * </code>
 * </p>
 *
 * @param week DayJson[] of the week
 */
public record WeekJson(
    @JsonProperty("week") DayJson[] week
) {
}
