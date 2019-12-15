package littlepeople.application.controller;


import littlepeople.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    void addUser() {

    }

    void deleteUser() {

    }

    void updateUser(){

    }
}
