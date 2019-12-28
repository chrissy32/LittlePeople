package littlepeople.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.ActivityDto;
import littlepeople.application.mapper.ActivityDtoMapper;
import littlepeople.application.model.Activity;
import littlepeople.application.model.Hospital;
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
}
