package littlepeople.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.HospitalDto;
import littlepeople.application.mapper.HospitalDtoMapper;
import littlepeople.application.model.Vote;
import littlepeople.application.service.HospitalService;
import littlepeople.application.service.LoginService;
import littlepeople.application.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vote")

public class VoteController {
    @Autowired
    VoteService voteService;

    @Autowired
    LoginService loginService;

    @ApiOperation("Receive addVote signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Add vote api",
            value = {"/addVote"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void addVote(@RequestHeader("AUTHORIZATION") String userToken,
                        @RequestParam(value = "proposalId") Long proposalId) throws Exception {
        long userId = loginService.getUserSession(userToken).getUserId();
        voteService.addVote(userId, proposalId);
    }

    @ApiOperation("Receive removeVote signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Remove vote api",
            value = {"/removeVote"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void removeVote(@RequestHeader("AUTHORIZATION") String userToken,
                        @RequestParam(value = "proposalId") Long proposalId) throws Exception {
        long userId = loginService.getUserSession(userToken).getUserId();
        voteService.removeVote(userId, proposalId);
    }
}
