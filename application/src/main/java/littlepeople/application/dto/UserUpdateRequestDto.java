package littlepeople.application.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private String username;

    private String password;

    private String phone;

    private String firstName;

    private String surname;

    private String city;

    private Long hospitalId;
}
