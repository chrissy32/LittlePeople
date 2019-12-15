package littlepeople.application.controller;


import littlepeople.application.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    void addVolunteer() {

    }

    void deleteVolunteer() {

    }

    void updateVolunteer(){

    }
}
