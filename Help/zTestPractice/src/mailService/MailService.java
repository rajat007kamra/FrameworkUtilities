package mailService;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties props = new Properties();
        props.put("mail.smtp.host", "10.125.1.35");
        // this mandates authentication at the mailserver
        //props.put("mail.smtp.auth", "true");
        
        // this is for printing debugs
        //props.put("mail.debug", "true");


        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ppj@innodata.com","5tgb%TGB");
                }
            });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ppj@innodata.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("AKapoor1@innodata.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Friend," + "\n\n This is a Second Test mail!");

            Transport.send(message);



        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}
