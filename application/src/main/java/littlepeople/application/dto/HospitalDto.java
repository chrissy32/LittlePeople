package littlepeople.application.dto;

import littlepeople.application.model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalDto {
    private String name;
    private String city;
    private String address;

    public static HospitalDto toDto(Hospital hospital) {
        return new HospitalDto(hospital.getName(),
                hospital.getCity(),
                hospital.getAddress());
    }
}
