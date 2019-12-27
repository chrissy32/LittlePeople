package littlepeople.application.mapper;

import littlepeople.application.dto.HospitalDto;
import littlepeople.application.model.Hospital;
import org.springframework.stereotype.Component;

@Component
public class HospitalDtoMapper extends AbstractMapper<Hospital, HospitalDto> {

    @Override
    public Hospital convertDtoToModel(HospitalDto hospitalDto) {
        return null;
    }

    @Override
    public HospitalDto convertModelToDto(Hospital hospital) {
        HospitalDto hospitalDto = new HospitalDto();
        hospitalDto.setId(hospital.getId());
        hospitalDto.setAddress(hospital.getAddress());
        hospitalDto.setCity(hospital.getCity());
        hospitalDto.setName(hospital.getName());
        return hospitalDto;
    }
}
