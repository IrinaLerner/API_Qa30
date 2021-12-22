package schedulardto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ErrorDto {
    int code;
    String details;
    String message;
}
