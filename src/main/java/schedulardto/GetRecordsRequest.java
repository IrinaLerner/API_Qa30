package schedulardto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class GetRecordsRequest {
    int monthFrom;
    int monthTo;
    int yearFrom;
    int yearTo;
}
