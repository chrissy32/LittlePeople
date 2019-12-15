package littlepeople.application.service;

import littlepeople.application.model.User;
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

    public void updateUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }
}
