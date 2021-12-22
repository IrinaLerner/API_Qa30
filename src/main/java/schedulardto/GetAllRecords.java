package schedulardto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class GetAllRecords {

    List<RecordDto> list;
}
