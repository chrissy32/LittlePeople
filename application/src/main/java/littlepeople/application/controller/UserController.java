package littlepeople.application.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import littlepeople.application.dto.AddUserDto;
import littlepeople.application.dto.UserDto;
import littlepeople.application.mapper.AddUserDtoMapper;
import littlepeople.application.mapper.UserDtoMapper;
import littlepeople.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserDtoMapper userDtoMapper;
    @Autowired
    AddUserDtoMapper addUserDtoMapper;

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
            value = {"/delete"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public void deleteUser(@RequestParam(value = "userId",required = true) long userId) {
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
    public void updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDtoMapper.convertDtoToModel(userDto));
    }
}
