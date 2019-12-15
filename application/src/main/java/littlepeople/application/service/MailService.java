package littlepeople.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    public static final String MAIL_SUBJECT = "Welcome to Little People!";
    public static final String MAIL_MESSAGE = "Hello, \n in this email you will find attached a password and a link.\n"
            + "Link: littlepeople.com/login \n Password:";

    private JavaMailSender javaMailSender;

    public void sendEmail(String receiver, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);
    }
}
