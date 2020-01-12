package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.*;
import littlepeople.application.mapper.ActivityDtoMapper;
import littlepeople.application.mapper.ProposalDtoMapper;
import littlepeople.application.mapper.ProposalLocationDtoMapper;
import littlepeople.application.model.Proposal;
import littlepeople.application.service.LoginService;
import littlepeople.application.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static littlepeople.application.controller.UserController.LEADER_ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/proposal")
public class ProposalController {
    @Autowired
    ProposalService proposalService;

    @Autowired
    ProposalDtoMapper proposalDtoMapper;

    @Autowired
    ProposalLocationDtoMapper proposalLocationDtoMapper;

    @Autowired
    ActivityDtoMapper activityDtoMapper;

    @Autowired
    LoginService loginService;

    @ApiOperation("Receive Add Proposal signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add Proposal api",
            value = {"/add"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ProposalLocationDto addProposal(@RequestHeader("AUTHORIZATION") String userToken, @RequestBody ProposalDto proposalDto) throws Exception {
        proposalDto.setProposedBy(loginService.getUserSession(userToken).getUsername());
        return proposalLocationDtoMapper.convertModelToDto(proposalService.addProposal(proposalDtoMapper.convertDtoToModel(proposalDto)));
    }

    @ApiOperation("Receive Update Proposal signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add Proposal api",
            value = {"/update"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ProposalDto updateProposal(@RequestHeader("AUTHORIZATION") String userToken, @RequestBody ProposalDto proposalDto) throws Exception {
        proposalDto.setProposedBy(loginService.getUserSession(userToken).getUsername());
        return proposalDtoMapper.convertModelToDto(proposalService.updateProposal(proposalDtoMapper.convertDtoToModel(proposalDto)));
    }

    @ApiOperation("Receive Delete Proposal signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Delete Proposal api",
            value = {"/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteProposal(@RequestParam(value = "proposalId") Long proposalId) {
        proposalService.deleteProposalById(proposalId);
    }


    @ApiOperation("Receive Get Proposal signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get Proposal api",
            value = {"/getProposalById"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ProposalDto getProposalById(@RequestParam(value = "proposalId") Long proposalId) {
        return proposalDtoMapper.convertModelToDto(proposalService.getProposalById(proposalId));
    }
    @ApiOperation("Receive All proposals, optionally with specific status signal and possibly only from current week")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get All Proposal api",
            value = {"/getProposalOptionalWithStatus"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<ProposalLocationDto>> getAllProposalsOptionalWithStatus(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "currentWeek") Boolean fromCurrentWeek) {
        Optional<String> optionalStatus = Optional.ofNullable(status);
        List<Proposal> proposalList;

        if (fromCurrentWeek) {
            proposalList = proposalService.getAllProposalsFromCurrentWeekWithOptionalStatus(optionalStatus);
        }
        else {
            proposalList = proposalService.getAllProposalsWithOptionalStatus(optionalStatus);
        }

        List<ProposalLocationDto> responseProposalsList = new ArrayList<>(proposalLocationDtoMapper.convertModelsToDtos(proposalList));
        return new ResponseEntity<List<ProposalLocationDto>>(responseProposalsList, HttpStatus.OK);
    }

    @ApiOperation("Receive Accept Proposal signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Accept Proposal api",
            value = {LEADER_ENDPOINT + "/acceptProposal"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public AcceptProposalResponseDto acceptProposal(@RequestParam(value = "proposalId") Long proposalId) {
        ProposalDto proposalDto = proposalDtoMapper.convertModelToDto(proposalService.getProposalById(proposalId));
        ActivityDto activityDto = activityDtoMapper.convertModelToDto(proposalService.acceptProposal(proposalId));
        return new AcceptProposalResponseDto(proposalDto, activityDto);
    }

    @ApiOperation("Receive Reject Proposal signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Reject Proposal api",
            value = {LEADER_ENDPOINT + "/rejectProposal"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ProposalDto rejectProposal(@RequestParam(value = "proposalId") Long proposalId) {
        return proposalDtoMapper.convertModelToDto(proposalService.rejectProposal(proposalId));
    }

}

