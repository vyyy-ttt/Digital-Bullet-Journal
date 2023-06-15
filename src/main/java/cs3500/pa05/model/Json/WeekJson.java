package cs3500.pa05.model.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.ThemeType;

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
    @JsonProperty("week") DayJson[] week,
    @JsonProperty("limits") LimitJson limits,
    @JsonProperty("theme") ThemeType theme
    ) {
}
