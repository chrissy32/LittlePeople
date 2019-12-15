package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.AddUserDto;
import littlepeople.application.dto.ReportDto;
import littlepeople.application.mapper.ReportDtoMapper;
import littlepeople.application.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addReport(@RequestBody ReportDto reportDto) {
        reportService.addReport(reportDtoMapper.convertDtoToModel(reportDto));
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
    public void updateReport(@RequestBody ReportDto reportDto){
        reportService.updateReport(reportDtoMapper.convertDtoToModel(reportDto));
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
            value = {"/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteReport(@RequestParam(value = "reportId",required = true) Long reportId){
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
            value = {""},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ReportDto getReportByActivityId(@RequestParam(value = "activityId",required = true) Long activityId){
        return reportDtoMapper.convertModelToDto(reportService.getReportByActivityId(activityId));
    }

}
