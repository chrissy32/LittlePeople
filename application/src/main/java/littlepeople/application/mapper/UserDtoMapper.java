package littlepeople.application.mapper;

import littlepeople.application.dto.UserDto;
import littlepeople.application.model.User;
import littlepeople.application.service.HospitalService;
import littlepeople.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper extends AbstractMapper<User, UserDto> {

    @Autowired
    UserService userService;
    @Autowired
    HospitalService hospitalService;

    @Override
    public User convertDtoToModel(UserDto userDto) {
            User user = userService.getUserById(userDto.getId());
            user.setId(userDto.getId());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            user.setFirstName(userDto.getFirstName());
            user.setSurname(userDto.getSurname());
            user.setIsAdmin(userDto.getIsAdmin());
            user.setCity(userDto.getCity());
            user.setHospital(hospitalService.getById(userDto.getHospitalId()));
            return user;
    }

    @Override
    public UserDto convertModelToDto(User user) {
        return null;
    }
}
