package schedulardto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class AuthResponseDto {
    boolean registration;
    String status;
    String token;


}
