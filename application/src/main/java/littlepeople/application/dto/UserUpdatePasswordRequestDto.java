package littlepeople.application.dto;

import lombok.Data;

@Data
public class UserUpdatePasswordRequestDto {
    private String newPassword;
}
