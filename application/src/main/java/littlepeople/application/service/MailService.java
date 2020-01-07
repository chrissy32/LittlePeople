package littlepeople.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${mail.login.link}")
    private String loginLink;

    public static final String MAIL_SUBJECT = "Welcome to Little People!";
    public static final String MAIL_MESSAGE = "Hello, \n in this email you will find attached an automatically generated password for your account, and a link where you can log-in with your e-mail and the given password.\n"
            + "Link: %s" + "\nPassword: %s";


    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String receiver, String password) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(MAIL_SUBJECT);
        simpleMailMessage.setText(String.format(MAIL_MESSAGE, loginLink, password));

        javaMailSender.send(simpleMailMessage);
    }
}
