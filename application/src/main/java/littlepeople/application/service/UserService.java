package littlepeople.application.service;

import littlepeople.application.model.User;
import littlepeople.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MailService mailService;

    public void addUser(User user) {
        final String password = UUID.randomUUID().toString().replace("-","");
        user.setPassword(password);
        userRepository.save(user);
        mailService.sendEmail(user.getEmail(), MailService.MAIL_SUBJECT, MailService.MAIL_MESSAGE + password);
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
