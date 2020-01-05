package littlepeople.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.ActivityDto;
import littlepeople.application.dto.ProposalDto;
import littlepeople.application.mapper.ActivityDtoMapper;
import littlepeople.application.model.Activity;
import littlepeople.application.model.Hospital;
import littlepeople.application.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static littlepeople.application.controller.UserController.LEADER_ENDPOINT;

/**
 * @author Xps 9560
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;
    @Autowired
    ActivityDtoMapper activityDtoMapper;

    @ApiOperation("Receive ActivityByCity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get all activities from a city api",
            value = {"/getActivitiesByCity"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public List<ActivityDto> getAllActivitiesFromCity(@RequestParam(value = "city") String city) {
        return activityDtoMapper.convertModelsToDtos(activityService.getAllActivitiesFromCity(city));
    }

    @ApiOperation("Receive ActivityByHospital signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get all activities from a hospital api",
            value = {"/getActivitiesByHospital"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public List<ActivityDto> getAllActivitiesFromHospital(@RequestParam(value = "hospitalId") Long hospitalId) {
        return activityDtoMapper.convertModelsToDtos(activityService.getAllActivitiesFromHospital(hospitalId));
    }

    @ApiOperation("Receive ActivityById signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get activity by id api",
            value = {"/getActivityById"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ActivityDto getActivityById(@RequestParam(value = "activityId") Long activityId) {
        return activityDtoMapper.convertModelToDto(this.activityService.getActivityById(activityId));
    }

    @ApiOperation("Receive Add Activity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add Activity api",
            value = {LEADER_ENDPOINT + "/add"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ActivityDto addActivity(@RequestHeader("AUTHORIZATION") String userToken, @RequestBody ActivityDto activityDto) throws Exception {
        return this.activityDtoMapper.convertModelToDto(this.activityService.addActivity(this.activityDtoMapper.convertDtoToModel(activityDto)));
    }

    @ApiOperation("Receive Update Activity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add Activity api",
            value = {LEADER_ENDPOINT + "/update"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ActivityDto updateActivity(@RequestHeader("AUTHORIZATION") String userToken, @RequestBody ActivityDto activityDto) throws Exception {
        return this.activityDtoMapper.convertModelToDto(this.activityService.updateActivity(this.activityDtoMapper.convertDtoToModel(activityDto)));
    }

    @ApiOperation("Receive Delete Activity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Delete Activity api",
            value = {LEADER_ENDPOINT + "/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteActivity(@RequestParam(value = "activityId") Long activityId) {
        activityService.deleteActivityById(activityId);
    }
}
