/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blackhole;
/**
  * A simple email sender class.
  */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SimpleMail
{
String d_userid = "vicmertens@gmail.com",
d_email = "vicmertens@gmail.com",
d_password = "h4pvt600",
d_host = "smtp.gmail.com",
d_port = "465",
m_to = "vic.mertens@telenet.be",
m_subject = "Testing",
m_text = "Hey, this is the testing email.";


public SimpleMail(String d_email, String d_host, String d_port, String m_to, String m_subject, String m_text, String d_userid, String d_password )
{
Properties props = new Properties();
props.put("mail.smtp.user", d_email);
props.put("mail.smtp.host", d_host);
props.put("mail.smtp.port", d_port);
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.auth", "true");
//props.put("mail.smtp.debug", "true");
props.put("mail.smtp.socketFactory.port", d_port);
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");

SecurityManager security = System.getSecurityManager();

try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
//session.setDebug(true);

MimeMessage msg = new MimeMessage(session);
msg.setText(m_text);
msg.setSubject(m_subject);
msg.setFrom(new InternetAddress(d_email));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
Transport.send(msg);
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


        SimpleMail mySender = new SimpleMail(from, smtpServer, d_port, to, subject, body, username, password);
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