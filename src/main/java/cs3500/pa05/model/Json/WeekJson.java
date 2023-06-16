package cs3500.pa05.model.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Json.DayJson;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.ThemeType;

/**
 *
 * @param week an array of the days of the week
 * @param limits the limits for events and tasks per day
 * @param theme the theme for the bullet journal
 */
public record WeekJson(
    @JsonProperty("week") DayJson[] week,
    @JsonProperty("limits") LimitJson limits,
    @JsonProperty("theme") ThemeType theme
    ) {

}
