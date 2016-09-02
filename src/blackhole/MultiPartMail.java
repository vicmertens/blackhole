/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blackhole;

/**
 *
 * @author be02927
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MultiPartMail {

String d_userid = "vicmertens@gmail.com",
d_email = "vicmertens@gmail.com",
d_password = "h4pvt600",
d_host = "smtp.gmail.com",
d_port = "465",
m_to = "vic.mertens@telenet.be",
m_subject = "Testing",
m_text = "Hey, this is the testing email.",
attachment = "";

public MultiPartMail(String d_email, String d_host, String d_port, String m_to, String m_subject, String m_text, String d_userid, String d_password, String attachment )
{

    // Get system properties
    Properties props = System.getProperties();

    // Setup mail server
    props.put("mail.smtp.host", d_host);
    props.put("mail.smtp.user", d_email);
    props.put("mail.smtp.port", d_port);
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.auth", "true");
    // props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.socketFactory.port", d_port);
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");

SecurityManager security = System.getSecurityManager();

try
{
Authenticator auth = new SMTPAuthenticator();
    // Get session
    Session session = Session.getInstance(props, auth);

    // Define message
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(d_email));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
    message.setSubject(m_subject);

    // Create the message part
    BodyPart messageBodyPart = new MimeBodyPart();

    // Fill the message
    messageBodyPart.setText(m_text);

    // Create a Multipart
    Multipart multipart = new MimeMultipart();

    // Add part one
    multipart.addBodyPart(messageBodyPart);

    //
    // Part two is attachment
    //

    // Create second body part
    messageBodyPart = new MimeBodyPart();

    // Get the attachment
    DataSource source = new FileDataSource(attachment);

    // Set the data handler to the attachment
    messageBodyPart.setDataHandler(new DataHandler(source));

    // Set the filename
    messageBodyPart.setFileName(attachment);

    // Add part two
    multipart.addBodyPart(messageBodyPart);

    // Put parts in message
    message.setContent(multipart);

    // Send the message
    Transport.send(message);
}
catch (Exception mex)
{
mex.printStackTrace();
}


}


public static void main(String[] args)
{

    //System.out.println(args);

    try {
        String smtpServer = args[0];
        String to = args[1];
        String from = args[2];
        String subject = args[3];
        String body = args[4];
        String username = args[5];
        String password = args[6];
        String d_port = args[7];
        String attachment = args[8];


        MultiPartMail myMailSender = new MultiPartMail(from, smtpServer, d_port, to, subject, body, username, password, attachment);
    } catch (Exception e) {
    }
//public void Sendit(String d_email, String d_host, String d_port, String m_to, String m_subject, String m_text, String d_userid, String d_password )

}




private class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(d_email, d_password);
}
}
}

