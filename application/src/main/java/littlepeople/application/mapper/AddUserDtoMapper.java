package littlepeople.application.mapper;

import littlepeople.application.dto.AddUserDto;
import littlepeople.application.model.User;
import littlepeople.application.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserDtoMapper extends  AbstractMapper<User, AddUserDto> {

    @Autowired
    HospitalService hospitalService;
    @Override
    public User convertDtoToModel(AddUserDto addUserDto) {
        User user = new User();
        user.setEmail(addUserDto.getEmail());
        user.setHospital(hospitalService.getById(addUserDto.getHospitalId()));
        return user;
    }

    @Override
    public AddUserDto convertModelToDto(User user) {
        return null;
    }
}
