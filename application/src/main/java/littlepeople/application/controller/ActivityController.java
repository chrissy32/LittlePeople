package littlepeople.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.model.Activity;
import littlepeople.application.model.User;
import littlepeople.application.repository.ActivityRepository;
import littlepeople.application.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Xps 9560
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @ApiOperation("Receive Activity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Delete User api",
            value = {"/delete"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public List<Activity> getAllActivitiesFromCity(@RequestHeader("AUTHORIZATION") String token, @RequestParam (value = "city",required = true) String city) {
        return activityService.getAllActivitiesFromCity(city);
    }
}
