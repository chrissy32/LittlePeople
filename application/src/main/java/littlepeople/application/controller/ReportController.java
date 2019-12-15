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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    ReportService reportService;
    @Autowired
    ReportDtoMapper reportDtoMapper;

    @ApiOperation("Receive Add User signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add User api",
            value = {"/add"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void addReport(@RequestBody ReportDto reportDto) {
        reportService.addReport(reportDtoMapper.convertDtoToModel(reportDto));
    }

    public void updateReport(){}
    public void deleteReport(){}
    public ReportDto getReportByActivityId(Long activityId){}

}
