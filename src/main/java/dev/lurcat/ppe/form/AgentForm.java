package dev.lurcat.ppe.form;

import javax.swing.*;
import java.awt.*;

public class AgentForm extends JFrame {

    public AgentForm(){
        setTitle("Accueil");
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

        Search = new JTextField();
        Chercher = new JButton();
        jTabbedData = new JTabbedPane();
        jPanelNbHote = new JPanel();
        jPanelNbHote4 = new JPanel();
        jScrollPane5 = new JScrollPane();
        jList5 = new JList<>();
        jLabelNbHote4 = new JLabel();
        jLabelNbHoteText4 = new JLabel();
        jPanelNbHote1 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jList2 = new JList<>();
        jLabelNbHote1 = new JLabel();
        jLabelNbHoteText1 = new JLabel();
        jPanelNbHote2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        jList3 = new JList<>();
        jLabelNbHote2 = new JLabel();
        jLabelNbHoteText2 = new JLabel();
        Supprimer = new JButton();
        Editer = new JButton();
        Ajouter = new JButton();
        jProgressBar1 = new JProgressBar();

        setPreferredSize(new Dimension(100, 426));

        Search.setHorizontalAlignment(JTextField.LEFT);
        Search.setText("Rechercher");
        Search.setPreferredSize(new Dimension(30, 30));
        Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {

            }
        });
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {

            }
        });

        Chercher.setText("Chercher");
        Chercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

            }
        });
        Chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChercherActionPerformed(evt);
            }
        });

        jList5.setModel(new DefaultListModel());
        jScrollPane5.setViewportView(jList5);

        jLabelNbHote4.setText("Nombre des commandes");

        jLabelNbHoteText4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabelNbHoteText4.setText("Aucune");

        GroupLayout jPanelNbHote4Layout = new GroupLayout(jPanelNbHote4);
        jPanelNbHote4.setLayout(jPanelNbHote4Layout);
        jPanelNbHote4Layout.setHorizontalGroup(
                jPanelNbHote4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNbHote4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNbHote4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                        .addGroup(jPanelNbHote4Layout.createSequentialGroup()
                                                .addComponent(jLabelNbHote4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelNbHoteText4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelNbHote4Layout.setVerticalGroup(
                jPanelNbHote4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelNbHote4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNbHote4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNbHote4)
                                        .addComponent(jLabelNbHoteText4, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout jPanelNbHoteLayout = new GroupLayout(jPanelNbHote);
        jPanelNbHote.setLayout(jPanelNbHoteLayout);
        jPanelNbHoteLayout.setHorizontalGroup(
                jPanelNbHoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelNbHote4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNbHoteLayout.setVerticalGroup(
                jPanelNbHoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNbHoteLayout.createSequentialGroup()
                                .addComponent(jPanelNbHote4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedData.addTab("Plugins", jPanelNbHote);

        jList2.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(jList2);

        jLabelNbHote1.setText("Nombre des commandes");

        jLabelNbHoteText1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabelNbHoteText1.setText("Aucune");

        GroupLayout jPanelNbHote1Layout = new GroupLayout(jPanelNbHote1);
        jPanelNbHote1.setLayout(jPanelNbHote1Layout);
        jPanelNbHote1Layout.setHorizontalGroup(
                jPanelNbHote1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNbHote1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNbHote1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(jPanelNbHote1Layout.createSequentialGroup()
                                                .addComponent(jLabelNbHote1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelNbHoteText1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelNbHote1Layout.setVerticalGroup(
                jPanelNbHote1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelNbHote1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNbHote1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNbHote1)
                                        .addComponent(jLabelNbHoteText1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedData.addTab("Commandes", jPanelNbHote1);

        jList3.setModel(new DefaultListModel());
        jScrollPane3.setViewportView(jList3);

        jLabelNbHote2.setText("Nombre des clients");

        jLabelNbHoteText2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabelNbHoteText2.setText("Aucun");

        GroupLayout jPanelNbHote2Layout = new GroupLayout(jPanelNbHote2);
        jPanelNbHote2.setLayout(jPanelNbHote2Layout);
        jPanelNbHote2Layout.setHorizontalGroup(
                jPanelNbHote2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNbHote2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNbHote2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(jPanelNbHote2Layout.createSequentialGroup()
                                                .addComponent(jLabelNbHote2)
                                                .addGap(154, 154, 154)
                                                .addComponent(jLabelNbHoteText2, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelNbHote2Layout.setVerticalGroup(
                jPanelNbHote2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelNbHote2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNbHote2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNbHote2)
                                        .addComponent(jLabelNbHoteText2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedData.addTab("Clients", jPanelNbHote2);

        Supprimer.setText("Supprimer");
        Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprimerMouseClicked(evt);
            }
        });

        Editer.setText("Modifier");
        Editer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditerMouseClicked(evt);
            }
        });
        Editer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditerActionPerformed(evt);
            }
        });

        Ajouter.setText("Ajouter");
        Ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AjouterMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTabbedData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Search, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Chercher)
                                                .addGap(20, 20, 20))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(Supprimer, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Ajouter, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Editer)))
                                                .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Chercher)
                                        .addComponent(Search, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedData, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Editer)
                                        .addComponent(Supprimer)
                                        .addComponent(Ajouter))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        setSize( 380, 400);
        this.getContentPane().setLayout(layout);
        center();
    }// </editor-fold>

    public void center() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    private void SupprimerMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void ChercherActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void EditerMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void EditerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AjouterMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private JButton Ajouter;
    private JButton Chercher;
    private JButton Editer;
    private JTextField Search;
    private JButton Supprimer;
    private JLabel jLabelNbHote1;
    private JLabel jLabelNbHote2;
    private JLabel jLabelNbHote4;
    private JLabel jLabelNbHoteText1;
    private JLabel jLabelNbHoteText2;
    private JLabel jLabelNbHoteText4;
    private JList<String> jList2;
    private JList<String> jList3;
    private JList<String> jList5;
    private JPanel jPanelNbHote;
    private JPanel jPanelNbHote1;
    private JPanel jPanelNbHote2;
    private JPanel jPanelNbHote4;
    private JProgressBar jProgressBar1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane5;
    private JTabbedPane jTabbedData;
    // End of variables declaration
}
