package littlepeople.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;

    public void sendEmail(String receiver, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);
    }
}