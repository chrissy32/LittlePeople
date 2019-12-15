package littlepeople.application.service;

import littlepeople.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    void addUser() {

    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    void updateUser(){

    }
}
