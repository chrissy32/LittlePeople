package littlepeople.application.controller;

import littlepeople.application.coverters.VolunteerAddConverter;
import littlepeople.application.dto.VolunteerAdd;
import littlepeople.application.model.User;
import littlepeople.application.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/adminnn")
public class LeaderController {
    private LeaderService leaderService;
    private VolunteerAddConverter  volunteerAddConverter;

    @Autowired
    public LeaderController(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @PostMapping(path = "/addvolunteer", consumes = "application/json")
    public void addVolunteer(@RequestBody VolunteerAdd volunteerAdd){
        User user = volunteerAddConverter.fromDtotoEntity(volunteerAdd);
        leaderService.addNewVolunteer(user);
    }
    @GetMapping(path = "/get")
    public String getString(){
        return  "Hello";
    }
}
