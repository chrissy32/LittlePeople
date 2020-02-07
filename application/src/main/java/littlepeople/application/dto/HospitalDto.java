package littlepeople.application.dto;

import littlepeople.application.model.Hospital;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalDto extends BaseDto{
    private String name;
    private String city;
    private String address;

    public static HospitalDto toDto(Hospital hospital) {
        return new HospitalDto(hospital.getName(),
                hospital.getCity(),
                hospital.getAddress());
    }
}
