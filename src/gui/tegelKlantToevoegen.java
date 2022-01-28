/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.DocumentException;
import dao.AdressenDAO;
import dao.KlantenDAO;
import db.Adressen;
import db.Klanten;
import db.Werknemers;
import domain.PDFKlantenKaart;
import domain.VerstuurKlantenKaart;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Kevin
 */
public class tegelKlantToevoegen extends javax.swing.JFrame {

    private final DefaultListModel<Klanten> mdlKlanten;
    private final DefaultListModel<Adressen> mdlAdressen;
    private static final Logger LOG = Logger.getLogger(tegelKlantToevoegen.class.getName());

    /**
     * Creates new form tegelKlantToevoegen
     */
    public tegelKlantToevoegen() {
        initComponents();
        mdlKlanten = new DefaultListModel<>();
        mdlAdressen = new DefaultListModel<>();
        txtNaam.requestFocus();
        updateListKlanten();
    }

    tegelKlantToevoegen(Werknemers w) {
        mdlKlanten = new DefaultListModel<>();
        mdlAdressen = new DefaultListModel<>();
        initComponents();
        setTitle(w.getNaam());
        updateListKlanten();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnHoofdMenu = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        pnlToevoegen = new javax.swing.JPanel();
        pnlKlanten = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnNieuweKlantToevoegen = new javax.swing.JButton();
        btnKlantVerwijderen = new javax.swing.JButton();
        btnVeldenLeegmaken = new javax.swing.JButton();
        txtTelefoon = new javax.swing.JFormattedTextField();
        btnSelectieOpheffen = new javax.swing.JButton();
        btnPDFAfdrukken = new javax.swing.JButton();
        btnKlantOpzoeken = new javax.swing.JButton();
        pnlKlantenlijst = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstKlanten = new javax.swing.JList<>();
        pnlAdressen = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtStraat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnNieuwAdresToevoegen = new javax.swing.JButton();
        btnAdresVerwijderen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAdressen = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 720));

        btnHoofdMenu.setText("terug naar hoofdmenu");
        btnHoofdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoofdMenuActionPerformed(evt);
            }
        });

        lblMessage.setText(" ");

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHoofdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHoofdMenu)
                    .addComponent(lblMessage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlToevoegen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Klanten:");

        jLabel2.setText("Naam:");

        jLabel3.setText("Tel nr:");

        jLabel4.setText("E-mail:");

        btnNieuweKlantToevoegen.setText("Klant Opslaan");
        btnNieuweKlantToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNieuweKlantToevoegenActionPerformed(evt);
            }
        });
        btnNieuweKlantToevoegen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNieuweKlantToevoegenKeyPressed(evt);
            }
        });

        btnKlantVerwijderen.setText("Klant verwijderen");
        btnKlantVerwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlantVerwijderenActionPerformed(evt);
            }
        });

        btnVeldenLeegmaken.setText("Velden leegmaken");
        btnVeldenLeegmaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeldenLeegmakenActionPerformed(evt);
            }
        });

        try {
            txtTelefoon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##.##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSelectieOpheffen.setText("Selectie opheffen");
        btnSelectieOpheffen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectieOpheffenActionPerformed(evt);
            }
        });

        btnPDFAfdrukken.setText("Kaart afdrukken en doorsturen");
        btnPDFAfdrukken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFAfdrukkenActionPerformed(evt);
            }
        });

        btnKlantOpzoeken.setText("Klant opzoeken");
        btnKlantOpzoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlantOpzoekenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKlantenLayout = new javax.swing.GroupLayout(pnlKlanten);
        pnlKlanten.setLayout(pnlKlantenLayout);
        pnlKlantenLayout.setHorizontalGroup(
            pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKlantenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlKlantenLayout.createSequentialGroup()
                            .addComponent(btnNieuweKlantToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnKlantVerwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addComponent(btnKlantOpzoeken, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlKlantenLayout.createSequentialGroup()
                            .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(41, 41, 41)
                            .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail)
                                .addComponent(txtTelefoon)
                                .addComponent(txtNaam, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                    .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnPDFAfdrukken, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlKlantenLayout.createSequentialGroup()
                            .addComponent(btnVeldenLeegmaken, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSelectieOpheffen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlKlantenLayout.setVerticalGroup(
            pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKlantenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefoon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKlantOpzoeken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNieuweKlantToevoegen)
                    .addComponent(btnKlantVerwijderen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnPDFAfdrukken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKlantenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVeldenLeegmaken)
                    .addComponent(btnSelectieOpheffen))
                .addContainerGap())
        );

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Lijst klanten:");

        lstKlanten.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstKlanten.setToolTipText("");
        lstKlanten.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lstKlanten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstKlantenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstKlanten);

        javax.swing.GroupLayout pnlKlantenlijstLayout = new javax.swing.GroupLayout(pnlKlantenlijst);
        pnlKlantenlijst.setLayout(pnlKlantenlijstLayout);
        pnlKlantenlijstLayout.setHorizontalGroup(
            pnlKlantenlijstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKlantenlijstLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKlantenlijstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        pnlKlantenlijstLayout.setVerticalGroup(
            pnlKlantenlijstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKlantenlijstLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setText("Straat:");

        jLabel6.setText("Stad:");

        jLabel7.setText("Type adres:");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Woonadres", "Factuuradres" }));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Adressen per klant:");

        btnNieuwAdresToevoegen.setText("Adres toevoegen");
        btnNieuwAdresToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNieuwAdresToevoegenActionPerformed(evt);
            }
        });

        btnAdresVerwijderen.setText("Adres verwijderen");
        btnAdresVerwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdresVerwijderenActionPerformed(evt);
            }
        });

        lstAdressen.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAdressen.setToolTipText("");
        lstAdressen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lstAdressen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAdressenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstAdressen);

        javax.swing.GroupLayout pnlAdressenLayout = new javax.swing.GroupLayout(pnlAdressen);
        pnlAdressen.setLayout(pnlAdressenLayout);
        pnlAdressenLayout.setHorizontalGroup(
            pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdressenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdressenLayout.createSequentialGroup()
                        .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtStad)
                                .addComponent(txtStraat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAdressenLayout.createSequentialGroup()
                        .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAdressenLayout.createSequentialGroup()
                                .addComponent(btnNieuwAdresToevoegen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdresVerwijderen)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlAdressenLayout.setVerticalGroup(
            pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdressenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStraat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdressenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNieuwAdresToevoegen)
                    .addComponent(btnAdresVerwijderen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout pnlToevoegenLayout = new javax.swing.GroupLayout(pnlToevoegen);
        pnlToevoegen.setLayout(pnlToevoegenLayout);
        pnlToevoegenLayout.setHorizontalGroup(
            pnlToevoegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToevoegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlToevoegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlKlantenlijst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlToevoegenLayout.createSequentialGroup()
                        .addComponent(pnlKlanten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdressen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 539, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlToevoegenLayout.setVerticalGroup(
            pnlToevoegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToevoegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlToevoegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlAdressen, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlKlanten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlKlantenlijst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlToevoegen, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHoofdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoofdMenuActionPerformed
        LOG.trace("knop terugNaarHoofdmenu ingedrukt");
        hoofdMenu a = new hoofdMenu();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHoofdMenuActionPerformed

    private void btnNieuweKlantToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNieuweKlantToevoegenActionPerformed
        LOG.trace("knop nieuweKlantToevoegen ingedrukt");
        String naam = txtNaam.getText();
        String tel = txtTelefoon.getText();
        String email = txtEmail.getText();
        String straat = txtStraat.getText();
        String stad = txtStad.getText();
        String type = (String) cmbType.getSelectedItem();
        //testen of alle velden ingevuld zijn
        if (((naam.isEmpty() || (tel.isEmpty()) || email.isEmpty()) || straat.isEmpty()) || stad.isEmpty()) {
            message("Geen van de velden mag leeg zijn.", false);
            LOG.info("klant niet toegevoegd, een veld was leeg");
            //testen of er een @ in de email staat
        } else if (!email.contains("@")) {
            message(email + " is geen geldig emailadres.", false);
            LOG.info("klant niet toegevoegd, geen geldig emailadres");
            //proberen klant toe te voegen
        } else {
            LOG.info("Klant proberen toevoegen");
            KlantenDAO klantdb = new KlantenDAO();
            // als zoekKlant null teruggeeft, niet naar getnaam zoeken
            Klanten testNaam = klantdb.zoekKlant(naam);
            String gevondenNaam;
            if (testNaam != null) {
                gevondenNaam = testNaam.getNaam();
            } else {
                gevondenNaam = "";
            }
            //testen of klant al bestaat
            if (!gevondenNaam.equals(naam)) {

                Klanten eenKlant = new Klanten();
                Adressen adres = new Adressen();
                eenKlant.setNaam(naam);
                eenKlant.setGsm(tel);
                eenKlant.setEmail(email);
                adres.setStraat(straat);
                adres.setStad(stad);
                adres.setType(type);
                adres.setKlanten(eenKlant);

                klantdb.VoegKlantToe(eenKlant, adres);
                updateListKlanten();
                //zoekKlant is gefixt maar updateListadressen mislukt nog steeds bij nieuwe klant..
                int klantId = klantdb.zoekKlant(naam).getId();
                updateListAdressen(klantId);
                message("Klant " + naam + " toegevoegd.", true);
                LOG.info("klant " + naam + " toegevoegd.");
            }
            clearTextFields();
        }
      }//GEN-LAST:event_btnNieuweKlantToevoegenActionPerformed

    private void btnKlantVerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlantVerwijderenActionPerformed
        LOG.trace("knop klantVerwijderen ingedrukt");
        Klanten geselecteerdeKlant = lstKlanten.getSelectedValue();
        if (geselecteerdeKlant == null) {
            message("Selecteer een klant om deze te verwijderen.", false);
            LOG.info("geen klant geselecteerd om te verwijderen");
        } else {
            int id = geselecteerdeKlant.getId();
            KlantenDAO klantdb = new KlantenDAO();
            klantdb.VerwijderKlant(id);
            updateListKlanten();
            updateListAdressen(id);
            clearTextFields();
            message("Klant verwijderd.", true);
            LOG.info("klant verwijderd");
        }
    }//GEN-LAST:event_btnKlantVerwijderenActionPerformed

    private void lstKlantenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstKlantenMouseClicked
        Klanten klant = lstKlanten.getSelectedValue();
        clearTextFields();
        txtNaam.setText(klant.getNaam());
        txtTelefoon.setText(String.valueOf(klant.getGsm()));
        txtEmail.setText(klant.getEmail());
        updateListAdressen(klant.getId());
        message("Klant " + txtNaam.getText() + " geselecteerd.", true);
        LOG.trace(klant.getNaam() + " geselecteerd");
    }//GEN-LAST:event_lstKlantenMouseClicked

    private void lstAdressenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAdressenMouseClicked
        Adressen adres = lstAdressen.getSelectedValue();
        txtStraat.setText(adres.getStraat());
        txtStad.setText(adres.getStad());
        cmbType.setName(adres.getType());
        LOG.trace(adres.getStraat() + " geselecteerd");

    }//GEN-LAST:event_lstAdressenMouseClicked

    private void btnAdresVerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdresVerwijderenActionPerformed

        LOG.trace("knop adresVerwijderen ingedrukt");
        if (lstAdressen.getSelectedValue() != null) {
            int id = lstAdressen.getSelectedValue().getKlanten().getId();
            System.out.println(id);
            AdressenDAO adresdb = new AdressenDAO();
            adresdb.VerwijderAdres(id);
            updateListAdressen(id);
            message("Adres verwijderd.", true);
        } else {
            message("Selecteer een adres om dit te verwijderen.", false);
            LOG.debug("geen adres geselecteerd om te verwijderen");
        }
    }//GEN-LAST:event_btnAdresVerwijderenActionPerformed

    private void btnNieuwAdresToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNieuwAdresToevoegenActionPerformed
        LOG.trace("knop adresToevoegen ingedrukt");
        Klanten klant = lstKlanten.getSelectedValue();
        if (klant != null) {
            String straat = txtStraat.getText();
            String stad = txtStad.getText();
            String type = (String) cmbType.getSelectedItem();
            Adressen adres = new Adressen();
            adres.setStraat(straat);
            adres.setStad(stad);
            adres.setType(type);
            adres.setKlanten(klant);
            KlantenDAO nieuwAdres = new KlantenDAO();
            nieuwAdres.VoegKlantToe(klant, adres);
            updateListAdressen(klant.getId());
            message("Adres " + adres + " aan klant " + klant.getNaam() + " toegevoegd", true);
            LOG.info("adres toegevoegd aan klant " + klant.getNaam());
        } else {
            message("Selecteer een klant om dit adres aan toe te voegen.", false);
            LOG.debug("geen klant geselecteerd om dit adres aan toe te voegen");
        }
    }//GEN-LAST:event_btnNieuwAdresToevoegenActionPerformed

    private void btnNieuweKlantToevoegenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNieuweKlantToevoegenKeyPressed
        //deze doet niets maar ik kan hem niet meer verwijderen
    }//GEN-LAST:event_btnNieuweKlantToevoegenKeyPressed

    private void btnVeldenLeegmakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeldenLeegmakenActionPerformed
        LOG.trace("knop clearTextField ingedrukt");
        clearTextFields();
    }//GEN-LAST:event_btnVeldenLeegmakenActionPerformed

    private void btnSelectieOpheffenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectieOpheffenActionPerformed
        LOG.trace("knop SelectieOpheffen ingedrukt");
        selectieOpheffen();
    }//GEN-LAST:event_btnSelectieOpheffenActionPerformed

    private void btnPDFAfdrukkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFAfdrukkenActionPerformed
        LOG.trace("knop PDFafdrukken ingedrukt");
        Klanten gk = lstKlanten.getSelectedValue();
        Adressen ga = lstAdressen.getSelectedValue();
        if (gk != null && lstAdressen.getSelectedValue() != null) {
            PDFKlantenKaart k = new PDFKlantenKaart();
            try {
                k.klantenKaart(gk, ga);
                try {
                    LOG.info("Email proberen versturen naar klant " + gk.getNaam());
                    stuurMail(gk);
                } catch (Exception e) {
                    LOG.error("PDF niet verstuurd");
                }
            } catch (DocumentException ex) {
                LOG.error("PDF maken mislukt");
            }
            message("PDF van klant " + gk.getNaam() + " gemaakt", true);
            LOG.info("PDF van klant " + gk.getNaam() + " gemaakt");

        } else {
            message("Selecteer een klant en adres om hiervan een PDF af te drukken", false);
        }
    }//GEN-LAST:event_btnPDFAfdrukkenActionPerformed

    private void btnKlantOpzoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlantOpzoekenActionPerformed
        String naam = txtNaam.getText();
        KlantenDAO k = new KlantenDAO();
        List<Klanten> gevondenKlanten = new ArrayList();
        if (!naam.equals("")) {
            gevondenKlanten = k.zoekKlanten(naam);
            clearTextFields();
            message(gevondenKlanten.size() + " klanten gevonden met '" + naam + "' in de naam", true);
            mdlKlanten.clear();
            for (Klanten klant : gevondenKlanten) {
                mdlKlanten.addElement(klant);
            }
            lstKlanten.setModel(mdlKlanten);
        } else {
            message("Vul bij naam minstens 1 letter in", false);
        }
    }//GEN-LAST:event_btnKlantOpzoekenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tegelKlantToevoegen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tegelKlantToevoegen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tegelKlantToevoegen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tegelKlantToevoegen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tegelKlantToevoegen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdresVerwijderen;
    private javax.swing.JButton btnHoofdMenu;
    private javax.swing.JButton btnKlantOpzoeken;
    private javax.swing.JButton btnKlantVerwijderen;
    private javax.swing.JButton btnNieuwAdresToevoegen;
    private javax.swing.JButton btnNieuweKlantToevoegen;
    private javax.swing.JButton btnPDFAfdrukken;
    private javax.swing.JButton btnSelectieOpheffen;
    private javax.swing.JButton btnVeldenLeegmaken;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JList<Adressen> lstAdressen;
    private javax.swing.JList<Klanten> lstKlanten;
    private javax.swing.JPanel pnlAdressen;
    private javax.swing.JPanel pnlKlanten;
    private javax.swing.JPanel pnlKlantenlijst;
    private javax.swing.JPanel pnlToevoegen;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtStad;
    private javax.swing.JTextField txtStraat;
    private javax.swing.JFormattedTextField txtTelefoon;
    // End of variables declaration//GEN-END:variables

    private void updateListKlanten() {
        LOG.trace("updateListKlanten");
        try {
            mdlKlanten.removeAllElements();
            KlantenDAO klant = new KlantenDAO();
            List<Klanten> klantenLijst = klant.alleKlanten();
            for (Klanten s : klantenLijst) {
                mdlKlanten.addElement(s);
                lstKlanten.setModel(mdlKlanten);
            }
            LOG.info("klantenList geupdate");
        } catch (Exception e) {
            LOG.error("updateListKlanten mislukt");

        }

    }

    private void updateListAdressen(Integer id) {
        LOG.info("updateListAdressen");
        try {
            mdlAdressen.removeAllElements();
            AdressenDAO adres = new AdressenDAO();
            List<Adressen> AdressenLijst = adres.GetKlantById(id);
            for (Adressen a : AdressenLijst) {
                mdlAdressen.addElement(a);
                lstAdressen.setModel(mdlAdressen);
                LOG.info("adressenList geupdate");
            }
        } catch (Exception e) {
            LOG.error("updateListAdressen mislukt.");
        }
    }

    private void clearTextFields() {
        txtNaam.setText("");
        txtTelefoon.setText("");
        txtEmail.setText("");
        txtStraat.setText("");
        txtStad.setText("");
        LOG.info("tekstvelden leeg gemaakt");
    }

    private void message(String msg, boolean error) {
        if (error) {
            lblMessage.setForeground(Color.black);
        } else {
            lblMessage.setForeground(Color.red);
        }
        lblMessage.setText(msg);
    }

    private void selectieOpheffen() {
        lstAdressen.clearSelection();
        lstKlanten.clearSelection();
        updateListKlanten();
        LOG.info("lijsten gedeselecteerd");
    }

    private void stuurMail(Klanten klant) {
        VerstuurKlantenKaart mail = new VerstuurKlantenKaart();
        try {
            LOG.info("stuurMail naar: " + klant.getNaam());
            mail.stuurKaart(klant);
        } catch (Exception ex) {
            LOG.error("stuurMail mislukt");
        }
    }
}