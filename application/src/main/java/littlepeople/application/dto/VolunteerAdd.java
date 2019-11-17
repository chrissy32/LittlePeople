package littlepeople.application.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VolunteerAdd {
    private String email;
    private Long hospitalId;
}
