package com.mphasis.task.pages.client;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import static com.mphasis.task.pages.common.EmailTaskRelatedConstants.*;

public class TrivialSmtpMailClient {

    public void sendEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", DEFAULT_SMTP_HOST);
        props.put("mail.smtp.port", DEFAULT_SMTP_PORT);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(DEFAULT_SENDER_LOGIN, DEFAULT_SENDER_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(DEFAULT_SENDER_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(DEFAULT_RECIPIENT_EMAIL));
            message.setSubject("You are awesome!");
            message.setText(DEFAULT_MESSAGE);

            Transport.send(message);

            System.out.println("Message sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
