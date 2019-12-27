package littlepeople.application.service;

import littlepeople.application.dto.UserUpdateRequestDto;
import littlepeople.application.model.User;
import littlepeople.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MailService mailService;


    public void addUser(User user) {
        final String password = UUID.randomUUID().toString().replace("-","");
        user.setEmail(user.getEmail());
        user.setPassword(password);
        userRepository.save(user);
        mailService.sendEmail(user.getEmail(), MailService.MAIL_SUBJECT, MailService.MAIL_MESSAGE + password);
    }

    @Transactional
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long id, UserUpdateRequestDto userUpdateRequestDto) {
        User user = this.userRepository.findById(id).get();
        user.setUsername(userUpdateRequestDto.getUsername());
        user.setPassword(userUpdateRequestDto.getPassword());
        user.setPhone(userUpdateRequestDto.getPhone());
        user.setFirstName(userUpdateRequestDto.getFirstName());
        user.setSurname(userUpdateRequestDto.getSurname());
        user.setCity(userUpdateRequestDto.getCity());
    }

    public User getUserById(long userId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new Exception("Invalid user id!");
        }

        return optionalUser.get();
    }

    @Transactional
    public void updateUserPassword(long userId, String newPassword) throws Exception {
        User user = this.getUserById(userId);
        user.setPassword(newPassword);
    }
}
