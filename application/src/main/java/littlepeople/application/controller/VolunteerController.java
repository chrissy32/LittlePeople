package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/volunteer")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    public void addVolunteer() {

    }

    @ApiOperation("Receive Delete Node signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Delete Volunteer api",
            value = {"/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteVolunteer(@RequestParam(value = "volunteerId",required = true) long volunteerId) {
        volunteerService.deleteVolunteer(volunteerId);
    }

    public void updateVolunteer(){

    }
}


