package littlepeople.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LoginResponseDto {
    private Long userId;
    private String userToken;
    private String email;
    private String username;
    private String phone;
    private String firstName;
    private String surname;
    private Boolean isAdmin;
    private String city;
    private long hospitalId;
}
