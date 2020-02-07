package littlepeople.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateResponseDto {
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
