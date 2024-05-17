package com.garcia.testshop.email;

import com.garcia.testshop.execeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 * The type Send mail service.
 */
@Service
public class SendMailService {
    @Autowired
     private JavaMailSender mailSender;

    /**
     * Execute send email.
     *
     * @param email   the email
     * @param subject the subject
     * @param body    the body
     */
    public void executeSendEmail(String email, String subject, String body){
      try {
          SimpleMailMessage message =new SimpleMailMessage();
          message.setFrom("lsc.luisgarcia.0790@gmail.com");
          message.setTo(email);
          message.setText(body);
          message.setSubject(subject);
          mailSender.send(message);
          System.out.println("Mail Send...");
     }catch (Exception ex){
        throw new ResourceNotFoundException("NO SE PUEDE ENVIAR EL CORREO");
      }

    }
}
