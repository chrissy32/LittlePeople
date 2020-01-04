package littlepeople.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.ActivityDto;
import littlepeople.application.dto.HospitalDto;
import littlepeople.application.mapper.HospitalDtoMapper;
import littlepeople.application.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hospital")

public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @Autowired
    HospitalDtoMapper hospitalDtoMapper;

    @ApiOperation("Receive HospitalByCity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get all hospitals from a city api",
            value = {"/getHospitalsByCity"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public List<HospitalDto> getAllActivitiesFromCity(@RequestParam(value = "city") String city) {
        return hospitalDtoMapper.convertModelsToDtos(hospitalService.getAllHospitalsFromCity(city));
    }
}
