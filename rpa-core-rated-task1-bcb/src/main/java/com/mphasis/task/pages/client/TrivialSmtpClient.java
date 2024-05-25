package com.mphasis.task.pages.client;

import com.mphasis.task.exception.ExceptionWrapper;
import com.mphasis.task.pages.dto.EmailClientConfigDto;
import com.mphasis.task.pages.dto.EmailMessageDto;
import com.workfusion.component.mail.smtp.EmailSmtpSender;
import com.workfusion.component.mail.smtp.EmailSmtpSenderConfig;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Collections;

public class TrivialSmtpClient {

    //    static String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
//    static String SMTP_SENDER = "sniezko@yahoo.com";
//    static String SMTP_PASSWORD = "password";
//    static String SMTP_PORT = "587";
    private final EmailSmtpSenderConfig clientConfig;

    public TrivialSmtpClient(EmailClientConfigDto config) {
        this.clientConfig = new EmailSmtpSenderConfig();
        clientConfig.setSmtpHost(config.getHost());
        clientConfig.setUser(config.getUsername());
        clientConfig.setPassword(config.getPassword());
        clientConfig.setSmtpPort(String.valueOf(config.getPort()));
    }

    public void sendEmail(EmailMessageDto message) {
        EmailSmtpSender emailSmtpSender = new EmailSmtpSender(clientConfig);
        try{
            MimeMessage email = emailSmtpSender.createEmail(
                    this.clientConfig.getUser(),
                    Collections.singletonList(message.getRecipient()),
                    null,
                    null,
                    "One-two, one-two, it's just a test!",
                    message.getBody(),
                    null);
            emailSmtpSender.send(email);

        } catch (MessagingException | IOException e) {
            throw new ExceptionWrapper("Error while sending email", e);
        }
    }
}
