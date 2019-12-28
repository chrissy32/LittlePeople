package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.ReportDto;
import littlepeople.application.mapper.ReportDtoMapper;
import littlepeople.application.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static littlepeople.application.controller.UserController.LEADER_ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    ReportService reportService;
    @Autowired
    ReportDtoMapper reportDtoMapper;

    @ApiOperation("Receive Add Report signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add Report api",
            value = {"/add"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ReportDto addReport(@RequestBody ReportDto reportDto) {
        return reportDtoMapper.convertModelToDto(reportService.addReport(reportDtoMapper.convertDtoToModel(reportDto)));
    }

    @ApiOperation("Receive Update Report signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add Report api",
            value = {"/update"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ReportDto updateReport(@RequestBody ReportDto reportDto) {
        return reportDtoMapper.convertModelToDto(reportService.updateReport(reportDtoMapper.convertDtoToModel(reportDto)));
    }

    @ApiOperation("Receive Delete Report signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Delete Report api",
            value = {LEADER_ENDPOINT + "/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteReport(@RequestParam(value = "reportId") Long reportId) {
        reportService.deleteReport(reportId);
    }


    @ApiOperation("Receive Get Report signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get Report api",
            value = {"/getReportById"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ReportDto getReportByActivityId(@RequestParam(value = "activityId") Long activityId) {
        return reportDtoMapper.convertModelToDto(reportService.getReportByActivityId(activityId));
    }

}
