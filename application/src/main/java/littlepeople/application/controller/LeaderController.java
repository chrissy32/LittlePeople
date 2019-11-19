package littlepeople.application.controller;

import littlepeople.application.coverters.VolunteerAddConverter;
import littlepeople.application.dto.VolunteerAdd;
import littlepeople.application.model.User;
import littlepeople.application.service.LeaderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/leader")
public class LeaderController {
    private LeaderService leaderService;
    private VolunteerAddConverter  volunteerAddConverter;

    @PostMapping(path = "/add-volunteer", consumes = "application/json")
    public void addVolunteer(@RequestBody VolunteerAdd volunteerAdd){
        User user = volunteerAddConverter.fromDtotoEntity(volunteerAdd);
        leaderService.addNewVolunteer(user);
    }
    @GetMapping(value = "/get")
    public String getString(){
        return  "Hello";
    }
}
