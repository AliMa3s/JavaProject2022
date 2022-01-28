/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import db.Klanten;
import java.util.Properties;
import java.util.logging.Level;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.log4j.Logger;

/**
 *
 * @author jalma
 */
public class VerstuurKlantenKaart {

    private static final Logger LOG = Logger.getLogger(VerstuurKlantenKaart.class);

    public boolean stuurKaart(Klanten klant) throws Exception {
        LOG.info("stuurKaart aangeroepen");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                LOG.info("Properties initialiseren");
                try {
                    Properties prop = new Properties();
                    prop.put("mail.smtp.host", "smtp.gmail.com");
                    prop.put("mail.smtp.auth", "true");
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
                    LOG.info("data naar prepareMessage");
                    Message message = prepareMessage(session, mymail, mymail, klant);
                    LOG.info("message teruggekregen van prepareMesagge");
                    //pas hieronder loopt het fout
                    Transport.send(message);
                    LOG.info("Klantenkaart verstuurd naar " + klant.getNaam());
                } catch (MessagingException ex) {
                    LOG.error("mail sturen mislukt");
                    java.util.logging.Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        return true;
    }

    public Message prepareMessage(Session session, String mymail, String recipient, Klanten klant) {
        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(mymail));
            LOG.info("sender: " + mymail);
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            LOG.info("Recipient: " + recipient);
            msg.setSubject("Welkom " + klant.getNaam() + ".");

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("Proficiat " + klant.getNaam() + ",\n\n"
                    + "Vanaf vandaag begint u uw nieuwe leven als klant bij ons, --CompanyNameMissing--.\n"
                    + "Bijgevoegd bij deze email vind u uw gepersonalieerde klantenkaartje.\n");

            BodyPart messageBodyPart2 = new MimeBodyPart();
            messageBodyPart2.setText("\n\n\nVoor meer info mag uw altijd onze winkel contacteren."
                    + "\nOnze telefoon nummer is : 123456789, Email: wink@winkle.be, Adress: Henkleykaai 84, 9000 Gent.");

            MimeBodyPart BodyPartAttachment = new MimeBodyPart();
            String path = "C:\\_weg\\" + klant.getNaam() + ".pdf";
            String bestandsnaam = klant.getNaam() + ".pdf";
            DataSource source = new FileDataSource(path);
            BodyPartAttachment.setDataHandler(new DataHandler(source));
            BodyPartAttachment.setFileName(bestandsnaam);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(BodyPartAttachment);

            msg.setContent(multipart);
            LOG.info("Bericht: " + msg);
            return msg;
        } catch (MessagingException ex) {
            LOG.error("Opbouwen email mislukt");
        }
        return null;
    }

}
