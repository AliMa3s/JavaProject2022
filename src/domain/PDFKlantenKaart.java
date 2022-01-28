/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;
import db.Adressen;
import db.Klanten;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.log4j.Logger;

/**
 *
 * @author jalma
 */
public class PDFKlantenKaart {

    private static final Logger LOG = Logger.getLogger(PDFKlantenKaart.class);

    public Chunk createBGChunk(String s, Font font) {
        Chunk chunk = new Chunk(s, font);
        return chunk;
    }

    public boolean klantenKaart(Klanten klant, Adressen adres) throws DocumentException {
        Rectangle size = new Rectangle(300, 200);
        size.setBackgroundColor(BaseColor.DARK_GRAY);

        Document document = new Document();
        document.setPageSize(size);

        try {
            LOG.info("PDF maken");
            PdfWriter.getInstance(document, new FileOutputStream("C:/_weg/" + klant.getNaam() + ".pdf"));
            document.open();

            Font gg = new Font(FontFamily.COURIER, 18, Font.BOLD, BaseColor.YELLOW);
            Font gk = new Font(FontFamily.COURIER, 12, Font.NORMAL, BaseColor.YELLOW);

            Paragraph p = new Paragraph("");
            p.add(createBGChunk(klant.getNaam(), gg));
            p.add(createBGChunk("\nTelnr: " + klant.getGsm() + "\nEmail: " + klant.getEmail() + "\nAdres: ", gk));
            p.add(createBGChunk("\n" + adres.getStraat() + " " + adres.getStad(), gk));

            document.add(p);

            LOG.info("PDF gemaakt");
            return true;

        } catch (FileNotFoundException ex) {
            LOG.info("Pdf niet gemaakt");
            return false;
        } finally {
            document.close();
        }
    }
}
