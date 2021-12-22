package schedulardto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class RecordDto {
    int breaks;
    String currency;
    DateDto dateDto;
    int hours;
    int id;
    String timeFrom;
   String timeTo;
    String title;
    double totalSalary;
    String type;
    int wage;

}
