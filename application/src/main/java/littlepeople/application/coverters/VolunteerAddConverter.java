package littlepeople.application.coverters;

import littlepeople.application.dto.VolunteerAdd;
import littlepeople.application.model.Hospital;
import littlepeople.application.model.User;
import littlepeople.application.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VolunteerAddConverter {
    private HospitalService hospitalService;

    @Autowired
    public VolunteerAddConverter(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public User fromDtotoEntity(VolunteerAdd dto){
        Hospital hospital = hospitalService.getById(dto.getHospitalId());
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setHospital( hospital);
        return  user;
    }
}
