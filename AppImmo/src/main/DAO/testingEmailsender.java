package main.DAO;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class testingEmailsender {
      public static void sendEmail(String recipientEmail, String subject, String body) {
        // Sender's email ID needs to be mentioned
        String from = "imessaoudenealdjia@gmail.com"; // Replace with your email

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com"; // or your SMTP server

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // You might need to change the port if it's different
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Get the Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("imessaoudenealdjia@gmail.com", "aldjia123"); // Replace with your email and password
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        String recipientEmail = "recipient@example.com"; // Replace with recipient's email
        String subject = "Test Email";
        String body = "This is a test email sent from Java.";

        sendEmail(recipientEmail, subject, body);
    }
}
