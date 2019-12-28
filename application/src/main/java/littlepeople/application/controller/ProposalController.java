package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.AcceptProposalResponseDto;
import littlepeople.application.dto.ActivityDto;
import littlepeople.application.dto.ProposalDto;
import littlepeople.application.mapper.ActivityDtoMapper;
import littlepeople.application.mapper.ProposalDtoMapper;
import littlepeople.application.service.LoginService;
import littlepeople.application.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ProposalDto addProposal(@RequestHeader("AUTHORIZATION") String userToken, @RequestBody ProposalDto proposalDto) throws Exception {
        proposalDto.setProposedBy(loginService.getUserSession(userToken).getUsername());
        return proposalDtoMapper.convertModelToDto(proposalService.addProposal(proposalDtoMapper.convertDtoToModel(proposalDto)));
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

