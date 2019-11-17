package littlepeople.application.service;

import littlepeople.application.model.Hospital;
import littlepeople.application.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Hospital getById(Long hospitalId){
        return  hospitalRepository.findById(hospitalId).get();
    }
}
