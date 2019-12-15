package littlepeople.application.service;

import littlepeople.application.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VolunteerService {

    @Autowired
    VolunteerRepository volunteerRepository;

    void addVolunteer() {

    }

    void deleteVolunteer() {

    }

    void updateVolunteer(){

    }
}
