package littlepeople.application.service;

import littlepeople.application.model.User;
import littlepeople.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LeaderService {
    private UserRepository userRepository;
    private MailService mailService;
    private static final String MAIL_SUBJECT = "Welcome to Little People!";
    private static final String MAIL_MESSAGE = "Hello, \n in this email you will find attached a password and a link.\n"
            + "Link: littlepeople.com/login \n Password:";

    public LeaderService(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public void addNewVolunteer(User user) {
        final String password = UUID.randomUUID().toString().replace("-", "");
        user.setPassword(password);
        System.out.println(user.toString());
        userRepository.save(user);
        mailService.sendEmail(user.getEmail(), MAIL_SUBJECT, MAIL_MESSAGE + password);
    }
}
