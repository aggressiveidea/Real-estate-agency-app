package main.DAO;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

public class EmailSender {

    private Session newSession;
    private MimeMessage mimeMessage;

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }

    private MimeMessage draftEmail() throws AddressException, MessagingException, IOException {
        String[] emailRecipients = {"sabrine.a.fatma@gmail.com", "Khadidja.daouadi06@gmail.com", "biba99riko@gmail.com"};
        String emailSubject = "Test Mail";
        String emailBody = "Test Body of my email";
        mimeMessage = new MimeMessage(newSession);
        for (Integer i=0; i<emailRecipients.length; i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients[i]) );
        }
        mimeMessage.setSubject(emailSubject);

        // Create MimeBodyPart for the message body
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html");

        // Create MimeMultipart and add the body part
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);

        // Set the multiPart as content of MimeMessage
        mimeMessage.setContent(multiPart);

        return mimeMessage;
    }

    private void sendEmail() throws MessagingException {
        String fromUser = "imessaoudenealdjia@gmail.com";
        String fromUserPassword = "aldjia123";
        String emailHost = "smtp.gmail.com";

        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();

        System.out.println("Email successfully sent!!");
    }

    public static void main(String args[]) throws AddressException, MessagingException, IOException {
        EmailSender emailSender = new EmailSender();
        emailSender.setupServerProperties();
        emailSender.draftEmail();
        emailSender.sendEmail();
    }
}


