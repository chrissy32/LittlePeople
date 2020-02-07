package littlepeople.application.mapper;

import littlepeople.application.dto.HospitalDto;
import littlepeople.application.dto.UserDto;
import littlepeople.application.model.Hospital;
import littlepeople.application.model.User;
import littlepeople.application.service.HospitalService;
import littlepeople.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper extends AbstractMapper<User, UserDto> {

    @Autowired
    UserService userService;
    @Autowired
    HospitalService hospitalService;

    @Override
    public User convertDtoToModel(UserDto userDto){
            User user = new User();
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
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        //userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setFirstName(user.getFirstName());
        userDto.setSurname(user.getSurname());
        userDto.setIsAdmin(user.getIsAdmin());
        userDto.setCity(user.getCity());
        userDto.setHospitalId(user.getHospital().getId());
        return userDto;
    }

    public List<UserDto> convertModelsToDtos(List<User> users) {
        return users.stream().map(this::convertModelToDto).collect(Collectors.toList());
    }
}
