package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.*;
import littlepeople.application.mapper.AddUserDtoMapper;
import littlepeople.application.mapper.UserDtoMapper;
import littlepeople.application.model.User;
import littlepeople.application.service.LoginService;
import littlepeople.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AddUserDtoMapper addUserDtoMapper;
    @Autowired
    LoginService loginService;
    @Autowired
    UserDtoMapper userDtoMapper;

    protected static final String LEADER_ENDPOINT = "/leader";

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
            value = {LEADER_ENDPOINT + "/add"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void addUser(@RequestBody AddUserDto addUserDto) {
            userService.addUser(addUserDtoMapper.convertDtoToModel(addUserDto));
    }

    @ApiOperation("Receive Delete User signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Delete User api",
            value = {LEADER_ENDPOINT + "/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteUser(@RequestParam(value = "userId") long userId) {
        userService.deleteUser(userId);
    }

    @ApiOperation("Receive Edit User signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Update User api",
            value = {"/edit"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )

    public UserUpdateResponseDto updateUser(@RequestHeader("AUTHORIZATION") String userToken, @RequestBody UserUpdateRequestDto userDto) throws Exception {
        Long userId = loginService.getUserSession(userToken).getUserId();
        userService.updateUser(userId, userDto);

        User userInformation = userService.getUserById(userId);
        long hospitalId = -1;
        if (!userInformation.getIsAdmin()) {
            hospitalId = userInformation.getHospital().getId();
        }

        return UserUpdateResponseDto.builder()
                .userToken(userToken)
                .email(userInformation.getEmail())
                .username(userInformation.getUsername())
                .phone(userInformation.getPhone())
                .firstName(userInformation.getFirstName())
                .surname(userInformation.getSurname())
                .isAdmin(userInformation.getIsAdmin())
                .city(userInformation.getCity())
                .hospitalId(hospitalId)
                .build();
    }


    @ApiOperation("Receive Update User Password signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Update User Password api",
            value = {"/update_password"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void updateUserPassword(@RequestHeader("AUTHORIZATION") String userToken,
                                   @RequestBody UserUpdatePasswordRequestDto userUpdatePasswordRequestDto) throws Exception {
        long userId = loginService.getUserSession(userToken).getUserId();
        userService.updateUserPassword(userId, userUpdatePasswordRequestDto.getNewPassword());
    }

    @ApiOperation("Receive VolunteersByCity signal.")
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Signal received and processed successfully."
    ), @ApiResponse(
            code = 400,
            message = "Bad Request | Signal received but could not be processed correctly."
    )})
    @RequestMapping(
            name = "Get all volunteers from a city api",
            value = {LEADER_ENDPOINT + "/getVolunteersByCity"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    public List<UserDto> getAllVolunteersFromCity(@RequestParam(value = "city") String city) {
        return userDtoMapper.convertModelsToDtos(userService.getAllVolunteersFromCity(city));
    }
}

