/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import db.Orderlijnen;
import db.Orders;
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
public class EmailService {

    public boolean confirmReservatie(String NaarKlant, Orders orders) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
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
                    Message message = prepareMessage(session, mymail, NaarKlant, orders);
                    Transport.send(message);
                } catch (Exception ex) {
                    Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        thread.setDaemon(true);
        thread.start();

        return true;
    }

    public Message prepareMessage(Session session, String mymail, String recipient, Orders orders) {
        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(mymail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            msg.setSubject("Order bevestiging");

            StringBuilder builder = new StringBuilder();
            builder.append("Beste "+ orders.getKlant().getNaam() + ", <br/> Bedankt voor de bestelling bij Onze Winkel. "
                    + "Uw bestelling met order id: <b>" + orders.getOrdernummer() + "</b> werd bevestigd. <br/><br/> ");

            builder.append("Bestelling Overzicht: <br/>");
            for (Orderlijnen orderlijnen : orders.getOrderlijnenList()) {
                
                builder.append("Article: ").append(orderlijnen.getArtikel().getNaam()).append(" - ");
                builder.append("Aantal: ").append(orderlijnen.getAantal()).append(" - ");
                
                builder.append("Prijs: ").append(orderlijnen.getPrijs()).append(" - ");
                builder.append("Status: ").append(orderlijnen.getStatus()).append(" <br/>");

            }
            builder.append("<br/><br/><br/> Voor meer info mag uw altijd onze winkel contacteren.");
            builder.append("<br/><br/> Onze telefoon nummer is : 123456789, <br/> Email: wink@winkle.be <br/> Adress: Henkleykaai 84, 9000 Gent. ");

            msg.setContent(builder.toString(), "text/html");
            return msg;
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
