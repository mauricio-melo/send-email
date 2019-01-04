package io.sysmap.m2m.sendmail.service;

import io.sysmap.m2m.sendmail.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void serviceSendMail(Email email) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email.getToEmail());
        helper.setText("Segue o token 123456");
        helper.setSubject("TOKEN M2M");

        javaMailSender.send(message);
    }
}
