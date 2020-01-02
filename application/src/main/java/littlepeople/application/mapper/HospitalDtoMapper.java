package littlepeople.application.mapper;

import littlepeople.application.dto.ActivityDto;
import littlepeople.application.dto.HospitalDto;
import littlepeople.application.model.Activity;
import littlepeople.application.model.Hospital;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HospitalDtoMapper extends AbstractMapper<Hospital, HospitalDto> {

    @Override
    public Hospital convertDtoToModel(HospitalDto hospitalDto) {
        Hospital hospital = new Hospital();
        hospital.setAddress(hospitalDto.getAddress());
        hospital.setCity(hospitalDto.getCity());
        hospital.setName(hospitalDto.getCity());
        hospital.setId(hospitalDto.getId());
        return hospital;
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

    public List<HospitalDto> convertModelsToDtos(List<Hospital> hospitals) {
        return hospitals.stream().map(this::convertModelToDto).collect(Collectors.toList());
    }
}
