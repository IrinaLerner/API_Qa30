package schedulardto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class DateDto {
    int dayOfMonth;
    String dayOfWeek;
    String month;
    String year;

}
