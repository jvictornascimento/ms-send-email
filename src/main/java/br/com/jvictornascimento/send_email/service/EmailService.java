package br.com.jvictornascimento.send_email.service;

import br.com.jvictornascimento.send_email.dto.Email;
import br.com.jvictornascimento.send_email.enums.StatusEmail;
import br.com.jvictornascimento.send_email.models.EmailModel;
import br.com.jvictornascimento.send_email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private EmailRepository repository;
    @Value(value = "${spring.mail.username}")
    private String email;



    public EmailService(JavaMailSender mailSender, EmailRepository repository) {
        this.mailSender = mailSender;
        this.repository = repository;
    }

    public EmailModel sendMail(EmailModel emailModel) {
        try {
            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setEmailfrom(email);

            var message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailfrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            mailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SEND);
        } catch (MailException e){
        emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally{
            return repository.save(emailModel);
        }
    }
}
