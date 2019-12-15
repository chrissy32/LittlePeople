package littlepeople.application.controller;

import com.mysql.cj.log.Log;
import littlepeople.application.dto.LoginRequestDto;
import littlepeople.application.dto.LoginResponseDto;
import littlepeople.application.model.User;
import littlepeople.application.service.LoginService;
import littlepeople.application.service.UserService;
import littlepeople.application.session.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            Session newUserSession = loginService.loginUser(loginRequestDto);
            User userLoggedIn = userService.getUserById(newUserSession.getUserId());


            long hospitalId = -1;
            if (!userLoggedIn.getIsAdmin()) {
                hospitalId = userLoggedIn.getHospital().getId();
            }

            return new ResponseEntity<LoginResponseDto>(LoginResponseDto.builder()
                    .userToken(newUserSession.getUserToken())
                    .username(userLoggedIn.getUsername())
                    .phone(userLoggedIn.getPhone())
                    .firstName(userLoggedIn.getFirstName())
                    .surname(userLoggedIn.getSurname())
                    .isAdmin(userLoggedIn.getIsAdmin())
                    .city(userLoggedIn.getCity())
                    .hospitalId(hospitalId)
                    .build(),
                    HttpStatus.OK);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<LoginResponseDto>(LoginResponseDto.builder()
                    .build(),
                    HttpStatus.UNAUTHORIZED);
        }


    }


}
