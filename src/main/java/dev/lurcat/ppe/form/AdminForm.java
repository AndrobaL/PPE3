package dev.lurcat.ppe.form;

import dev.lurcat.ppe.PPE;
import dev.lurcat.ppe.form.impl.AjouterForm;
import dev.lurcat.ppe.form.impl.ModifierForm;
import dev.lurcat.ppe.manager.ClientManager;
import dev.lurcat.ppe.manager.CommandeManager;
import dev.lurcat.ppe.manager.PluginManager;
import dev.lurcat.ppe.shop.Commande;
import dev.lurcat.ppe.shop.Plugin;
import dev.lurcat.ppe.users.Client;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AdminForm extends JFrame {

    public AdminForm(){
        setTitle("Accueil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        Search = new javax.swing.JTextField();
        Chercher = new javax.swing.JButton();
        jTabbedData = new javax.swing.JTabbedPane();
        jPanelPlugins = new javax.swing.JPanel();
        jScrollPanePlugins = new javax.swing.JScrollPane();
        jListPlugins = new javax.swing.JList<>();
        Bukkit = new javax.swing.JRadioButton();
        Spigot = new javax.swing.JRadioButton();
        jLabelPluginsSize = new javax.swing.JLabel();
        jLabelPlugins = new javax.swing.JLabel();
        jPanelCommandes = new javax.swing.JPanel();
        jScrollPaneCommandes = new javax.swing.JScrollPane();
        jListCommandes = new javax.swing.JList<>();
        jLabeCommandes = new javax.swing.JLabel();
        jLabelCommandesSize = new javax.swing.JLabel();
        jPanelClients = new javax.swing.JPanel();
        jScrollPaneClients = new javax.swing.JScrollPane();
        jListClients = new javax.swing.JList<>();
        jLabelClients = new javax.swing.JLabel();
        jLabelClientsSize = new javax.swing.JLabel();
        Supprimer = new javax.swing.JButton();
        Editer = new javax.swing.JButton();
        Ajouter = new javax.swing.JButton();
        jToggleButtonQuit = new javax.swing.JToggleButton();
        jLabelAccount = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(100, 426));

        Search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Search.setText("Rechercher");
        Search.setPreferredSize(new java.awt.Dimension(30, 30));
        Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                //SearchFocusLost(evt);
            }
        });
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                //SearchKeyPressed(evt);
            }
        });

        Chercher.setText("Chercher");
        Chercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChercherMouseClicked(evt);
            }
        });
        Chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChercherActionPerformed(evt);
            }
        });

        jTabbedData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedDataMouseClicked(evt);
            }
        });
        jListPlugins.setName("Plugins");
        jListPlugins.setModel(new DefaultListModel());
        DefaultListModel model = (DefaultListModel) jListPlugins.getModel();
        for (Plugin plugin : PPE.INSTANCE.getPluginManager().findAll()) {
            model.addElement(plugin.getId() + " - " + plugin.getName() + " - " + plugin.getPrice() + " - " + plugin.getPluginType().name());
        }
        jScrollPanePlugins.setViewportView(jListPlugins);

        buttonGroup1.add(Bukkit);
        Bukkit.setText("Bukkit");
        Bukkit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BukkitActionPerformed(evt);
            }
        });

        buttonGroup1.add(Spigot);
        Spigot.setText("Spigot");
        Spigot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpigotActionPerformed(evt);
            }
        });

        jLabelPluginsSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        int size = jListPlugins.getModel().getSize();
        jLabelPluginsSize.setText(size <= 0 ? "Aucun" : "Total " + size);

        jLabelPlugins.setText("Nombre des plugins");

        javax.swing.GroupLayout jPanelPluginsLayout = new javax.swing.GroupLayout(jPanelPlugins);
        jPanelPlugins.setLayout(jPanelPluginsLayout);
        jPanelPluginsLayout.setHorizontalGroup(
                jPanelPluginsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPluginsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelPluginsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPanePlugins)
                                        .addGroup(jPanelPluginsLayout.createSequentialGroup()
                                                .addComponent(jLabelPlugins)
                                                .addGap(24, 24, 24)
                                                .addComponent(Spigot)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Bukkit)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelPluginsSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelPluginsLayout.setVerticalGroup(
                jPanelPluginsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPluginsLayout.createSequentialGroup()
                                .addGroup(jPanelPluginsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelPluginsLayout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addGroup(jPanelPluginsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelPluginsLayout.createSequentialGroup()
                                                                .addComponent(jLabelPlugins)
                                                                .addGap(5, 5, 5))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPluginsLayout.createSequentialGroup()
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jLabelPluginsSize))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPluginsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Spigot))
                                        .addGroup(jPanelPluginsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Bukkit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPanePlugins, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedData.addTab("Plugins", jPanelPlugins);

        jListCommandes.setModel(new DefaultListModel());
        jListCommandes.setName("Commandes");
        model = (DefaultListModel) jListCommandes.getModel();
        for (Commande commande : PPE.INSTANCE.getCommandeManager().findAll()) {
            model.addElement(commande.getId_commande() + " - " + commande.getTransation().toString() + " - " + commande.getState() + " - " + commande.getId_client() + " - " + commande.getId_agent());
        }
        jScrollPaneCommandes.setViewportView(jListCommandes);

        jLabeCommandes.setText("Nombre des commandes");

        jLabelCommandesSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCommandesSize.setText("Aucune");

        javax.swing.GroupLayout jPanelCommandesLayout = new javax.swing.GroupLayout(jPanelCommandes);
        jPanelCommandes.setLayout(jPanelCommandesLayout);
        jPanelCommandesLayout.setHorizontalGroup(
                jPanelCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCommandesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneCommandes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(jPanelCommandesLayout.createSequentialGroup()
                                                .addComponent(jLabeCommandes)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelCommandesSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelCommandesLayout.setVerticalGroup(
                jPanelCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCommandesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabeCommandes)
                                        .addComponent(jLabelCommandesSize))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneCommandes, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedData.addTab("Commandes", jPanelCommandes);

        jListClients.setModel(new DefaultListModel());
        jListClients.setName("Clients");
        model = (DefaultListModel) jListClients.getModel();
        for (Client client : PPE.INSTANCE.getClientManager().findAll()) {
            model.addElement(client.getId_client() + " - " + client.getName() + " - " + client.getMail() + " - " + client.getNumber());
        }
        jScrollPaneClients.setViewportView(jListClients);

        jLabelClients.setText("Nombre des clients");

        jLabelClientsSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        size = jListClients.getModel().getSize();
        jLabelClientsSize.setText(size <= 0 ? "Aucun" : "Total " + size);

        javax.swing.GroupLayout jPanelClientsLayout = new javax.swing.GroupLayout(jPanelClients);
        jPanelClients.setLayout(jPanelClientsLayout);
        jPanelClientsLayout.setHorizontalGroup(
                jPanelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClientsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneClients, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(jPanelClientsLayout.createSequentialGroup()
                                                .addComponent(jLabelClients)
                                                .addGap(154, 154, 154)
                                                .addComponent(jLabelClientsSize, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelClientsLayout.setVerticalGroup(
                jPanelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClients)
                                        .addComponent(jLabelClientsSize))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneClients, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedData.addTab("Clients", jPanelClients);


        Supprimer.setText("Supprimer");
        Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprimerMouseClicked(evt);
            }
        });
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
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
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        jToggleButtonQuit.setText("Quitter");
        jToggleButtonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonQuitActionPerformed(evt);
            }
        });

        jLabelAccount.setText("Compte: AndrobaL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jToggleButtonQuit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Chercher))
                                        .addComponent(jTabbedData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Editer)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Chercher)
                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jToggleButtonQuit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAccount)
                                .addGap(7, 7, 7)
                                .addComponent(jTabbedData, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Editer)
                                        .addComponent(Supprimer)
                                        .addComponent(Ajouter))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rainbow();
        setSize( 380, 400);
        this.getContentPane().setLayout(layout);
        center();
    }

    public void center() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    public void rainbow() {
        new Thread(() -> {
            long offstes = 2000L;
            float fade= 1F;

            while (isEnabled()) {
                float hue = (float)(System.nanoTime() + offstes) / 1.0E10F % 1.0F;
                long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 0.05F, 1.0F)).intValue()),16);
                Color c = new Color((int)color);
                Color couleur = new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
                getContentPane().setBackground(couleur);
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void update() {
        switch (currentTitle) {
            case "Clients": {
                DefaultListModel model = (DefaultListModel) jListClients.getModel();
                model.clear();
                for (Client client : PPE.INSTANCE.getClientManager().findAll()) {
                    model.addElement(client.getId_client() + " - " + client.getName() + " - " + client.getMail() + " - " + client.getNumber());
                }
                int size = jListClients.getModel().getSize();
                jLabelClientsSize.setText(size <= 0 ? "Aucun" : "Total " + size);
                break;
            }
            case "Commandes": {
                DefaultListModel model = (DefaultListModel) jListCommandes.getModel();
                model.clear();
                for (Commande commande : PPE.INSTANCE.getCommandeManager().findAll()) {
                    model.addElement(commande.getId_commande() + " - " + commande.getTransation().toString() + " - " + commande.getState() + " - " + commande.getId_client() + " - " + commande.getId_agent());
                }
                int size = jListCommandes.getModel().getSize();
                jLabelCommandesSize.setText(size <= 0 ? "Aucune" : "Total " + size);
                break;
            }
            case "Plugins": {
                DefaultListModel model = (DefaultListModel) jListCommandes.getModel();
                model.clear();
                for (Plugin plugin : PPE.INSTANCE.getPluginManager().findAll()) {
                    model.addElement(plugin.getId() + " - " + plugin.getName() + " - " + plugin.getPrice() + " - " + plugin.getPluginType().name());
                }
                int size = jListCommandes.getModel().getSize();
                jLabelCommandesSize.setText(size <= 0 ? "Aucune" : "Total " + size);
                break;
            }
        }
    }

    private void ChercherMouseClicked(java.awt.event.MouseEvent evt) {
        //DefaultListModel leModel = (DefaultListModel) jList1.getModel();
        //leModel.clear();

        /*
        final DefaultListModel leModel = (DefaultListModel) jList1.getModel();
        leModel.addElement("test");
        */

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
        if (currentTitle == null) {
            return;
        }
        JList<String> list = getModel(currentTitle);
        if (list.getSelectedValue() == null) {
            return;
        }
        Map<String, String> map = new HashMap<>();
        switch (currentTitle) {
            case "Clients": {
                String clientName = list.getSelectedValue().split(" - ")[1];
                ClientManager clientManager = PPE.INSTANCE.getClientManager();
                for (Client client : clientManager.findAll()) {
                    if (client.getName().equalsIgnoreCase(clientName)) {
                        map.put("Name", client.getName());
                        map.put("Mail", client.getMail());
                        map.put("Number", String.valueOf(client.getNumber()));
                        new ModifierForm(client.getId_client(), map, this).setVisible(true);
                        return;
                    }
                }
                break;
            }
            case "Commandes": {
                JOptionPane.showMessageDialog(this,"Impossible de modifier cette commande","Modication Failed", JOptionPane.ERROR_MESSAGE);
                /*int commandeID = Integer.parseInt(list.getSelectedValue().split(" - ")[0]);
                System.out.println("commandeID: " + commandeID);

                CommandeManager commandManager = PPE.INSTANCE.getCommandeManager();
                for (Commande commande : commandManager.findAll()) {
                    if (commande.getId_commande() == commandeID) {
                        map.put("ID Agent", String.valueOf(commande.getId_agent()));
                        map.put("ID Client", String.valueOf(commande.getId_client()));
                        new ModifierForm(commande.getId_commande(), map, this).setVisible(true);
                        return;
                    }
                }*/
                break;
            }
            case "Plugins": {
                String pluginName = list.getSelectedValue().split(" - ")[1];
                PluginManager pluginManager = PPE.INSTANCE.getPluginManager();
                for (Plugin plugin : pluginManager.findAll()) {
                    if (plugin.getName().equalsIgnoreCase(pluginName)) {
                        map.put("Name", plugin.getName());
                        map.put("Price", String.valueOf(plugin.getPrice()));
                        map.put("Popularity", String.valueOf(plugin.getPopularity()));
                        map.put("Stock", String.valueOf(plugin.getStock()));
                        new ModifierForm(plugin.getId(), map, this).setVisible(true);
                        return;
                    }
                }
                break;
            }
        }


        // TODO add your handling code here:
    }

    private void AjouterMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void SpigotActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BukkitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentTitle == null) {
            return;
        }
        JList<String> list = getModel(currentTitle);
        if (list.getSelectedValue() == null) {
            return;
        }
        switch (currentTitle) {
            case "Clients": {
                ClientManager clientManager = PPE.INSTANCE.getClientManager();
                for (Client client : clientManager.findAll()) {
                    for (String item : list.getSelectedValuesList()) {
                        if (client.getName().equalsIgnoreCase(item.split(" - ")[1])) {
                            clientManager.removeClient(client);
                            ((DefaultListModel)list.getModel()).removeElement(item);
                        }
                    }
                }
                break;
            }
            case "Commandes": {
                CommandeManager commandManager = PPE.INSTANCE.getCommandeManager();
                for (Commande commande : commandManager.findAll()) {
                    for (String item : list.getSelectedValuesList()) {
                        if (commande.getId_commande() == Integer.parseInt(item.split(" - ")[0])) {
                            commandManager.removeCommande(commande);
                            ((DefaultListModel)list.getModel()).removeElement(item);
                        }
                    }
                }
                break;
            }
        }
        list.clearSelection();
        int size = jListClients.getModel().getSize();
        jLabelClientsSize.setText(size <= 0 ? "Aucun" : "Total " + size);
    }

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentTitle == null) {
            return;
        }
        Map<String, String> map = new HashMap<>();
        switch (currentTitle) {
            case "Clients": {
                map.put("Name", "Client name");
                map.put("Mail", "Mail");
                map.put("Number", "0");
                new AjouterForm(map, this).setVisible(true);
                break;
            }
            case "Commandes": {
                map.put("Transation", "transation name");
                map.put("State", "None");
                map.put("ID Agent", "1");
                map.put("ID Client", "1");
                new AjouterForm(map, this).setVisible(true);
                JOptionPane.showMessageDialog(this,"Impossible d'ajouter cette commande","Add Failed", JOptionPane.ERROR_MESSAGE);
                break;
            }
            case "Plugins": {
                map.put("Name", "plugin name");
                map.put("Price", "0");
                map.put("Popularity", "5");
                map.put("Stock", "0");
                new AjouterForm(map, this).setVisible(true);
                break;
            }
        }
        int size = jListClients.getModel().getSize();
        jLabelClientsSize.setText(size <= 0 ? "Aucun" : "Total " + size);
    }

    private void jToggleButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {
        this.disable();
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    public String currentTitle;

    private void jTabbedDataMouseClicked(java.awt.event.MouseEvent evt) {
        System.out.println("TG" + jTabbedData.getTitleAt(jTabbedData.getSelectedIndex()));
        currentTitle = jTabbedData.getTitleAt(jTabbedData.getSelectedIndex());
    }

    public JList<String> getModel(String name) {
        for (JList<String> model : Arrays.asList(jListClients, jListCommandes, jListPlugins)) {
            if (model.getName().equalsIgnoreCase(name)) {
                return model;
            }
        }
        return null;
    }


    // Variables declaration - do not modify
    private javax.swing.JButton Ajouter;
    private javax.swing.JRadioButton Bukkit;
    private javax.swing.JButton Chercher;
    private javax.swing.JButton Editer;
    private javax.swing.JTextField Search;
    private javax.swing.JRadioButton Spigot;
    private javax.swing.JButton Supprimer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabeCommandes;
    private javax.swing.JLabel jLabelAccount;
    private javax.swing.JLabel jLabelClients;
    private javax.swing.JLabel jLabelClientsSize;
    private javax.swing.JLabel jLabelCommandesSize;
    private javax.swing.JLabel jLabelPlugins;
    private javax.swing.JLabel jLabelPluginsSize;
    private javax.swing.JList<String> jListClients;
    private javax.swing.JList<String> jListCommandes;
    private javax.swing.JList<String> jListPlugins;
    private javax.swing.JPanel jPanelClients;
    private javax.swing.JPanel jPanelCommandes;
    private javax.swing.JPanel jPanelPlugins;
    private javax.swing.JScrollPane jScrollPaneClients;
    private javax.swing.JScrollPane jScrollPaneCommandes;
    private javax.swing.JScrollPane jScrollPanePlugins;
    private javax.swing.JTabbedPane jTabbedData;
    private javax.swing.JToggleButton jToggleButtonQuit;
    // End of variables declaration
}
