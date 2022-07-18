package com.bitirmeprojesi.eticaret.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class MailService {
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    private Properties props = mailSender.getJavaMailProperties();
    @Value("${mail.template.path}")
    private String HTMLTEMPLATEPATH;

    public  MailService() {
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("kkubitirmetest@gmail.com");
        mailSender.setPassword("********");
        // ------------------------------------------------------
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    public void sendEmailHtml(String to, String subject, HashMap<String, String> model) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        InputStream io =new ClassPathResource(HTMLTEMPLATEPATH).getInputStream();
        String html = new String(io.readAllBytes(), StandardCharsets.UTF_8);
        for (Map.Entry<String,String> entry : model.entrySet()) {
            html  =  html.replace("${"+entry.getKey()+"}",entry.getValue());
        }
        helper.setTo(to);
        helper.setFrom("kkubitirmetest@gmail.com");
        helper.setSubject(subject);
        helper.setText(html, true);
        mailSender.send(message);
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("kkubitirmetest@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
