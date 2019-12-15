package littlepeople.application.service;

import littlepeople.application.model.User;
import littlepeople.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    void addUser() {

    }

    void deleteUser() {

    }

    void updateUser(){

    }

    public User getUserById(long userId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new Exception("Invalid user id!");
        }

        return optionalUser.get();
    }
}
