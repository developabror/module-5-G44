package uz.app.service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailSenderService {
    private Properties properties = new Properties();

    {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    String senderMail = "email";

    private Session getSession() {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, "pass");
            }
        });
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

    public void sendMedia(String to) {
        try {
            Message message = new MimeMessage(getSession());
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("test image sender");
            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();
            multipart.addBodyPart(bodyPart);
            FileDataSource fileDataSource = new FileDataSource("D:\\image.jpg");
            bodyPart.setDataHandler(new DataHandler(fileDataSource));

            bodyPart.setFileName("image.jpg");
            message.setContent(multipart);
            Transport.send(message);

        } catch (MessagingException e) {
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
