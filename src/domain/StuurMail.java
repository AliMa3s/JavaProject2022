/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author alima
 */
public class StuurMail {

    public static void StuurEmail(String NaarKlant, int id) throws Exception {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.transport.protocl", "smtp");

        String mymail = "jproject134@gmail.com";
        String pass = "2021java";
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mymail, pass);
            }

        });
        Message message = prepareMessage(session, mymail, NaarKlant, id);
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String mymail, String recipient, int orderid) {
        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(mymail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            msg.setSubject("Order bevestiging");
            String bericht = "Beste, <br/> Uw Order met order id: <b>" + orderid + "</b> werd bevestigd. <br/> Voor meer info mag uw altijd onze winkel contacteren."
                    + "<br/><br/><br/> Onze telefoon nummer is : 123456789, <br/> Email: wink@winkle.be <br/> Adress: Henkleykaai 84, 9000 Gent. ";
            msg.setContent(bericht,"text/html");
            return msg;
        } catch (MessagingException ex) {
            Logger.getLogger(StuurMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        try {
            StuurMail.StuurEmail("jproject134@gmail.com", 2);
        } catch (Exception ex) {
            Logger.getLogger(StuurMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
