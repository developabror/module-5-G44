package uz.app.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSenderService {
    private Properties properties = new Properties();

    {
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "false");
    }

    String senderMail = "mailtrapuser";

    private Session getSession() {

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, "mailtrap-password");
            }
        });
        session.setDebug(false);
        return session;
    }

    public void sendMessage(String to, String code) {
        try {
            Message message = new MimeMessage(getSession());
            message.setSubject("Confirmation code");
            String text = String.format("Hello there! here is your confirmation code %s. Please do not share this code with anyone!", code);
            message.setText(text);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            Transport.send(message);
            System.out.println("sent to " + to);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    private static MailSenderService mailSenderService;

    public static MailSenderService getInstance() {
        if (mailSenderService == null) {
            mailSenderService = new MailSenderService();
        }
        return mailSenderService;
    }
}
