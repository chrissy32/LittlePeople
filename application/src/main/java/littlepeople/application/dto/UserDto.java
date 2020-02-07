package littlepeople.application.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto extends BaseDto{

    private String username;

    private String password;

    private String email;

    private String phone;

    private String firstName;

    private String surname;

    private Boolean isAdmin;

    private String city;

    private Long hospitalId;
}
