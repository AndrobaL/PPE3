package dev.lurcat.ppe.manager;

import dev.lurcat.ppe.api.Manager;
import dev.lurcat.ppe.api.MethodInfo;
import dev.lurcat.ppe.api.PluginType;
import dev.lurcat.ppe.api.Title;
import dev.lurcat.ppe.shop.Plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginManager extends Manager {

    private final List<Plugin> plugins = new ArrayList<>();
    private final SQLManager sqlManager;

    public PluginManager(SQLManager sqlManager) {
        super(Title.PLUGIN_MANAGER);
        this.sqlManager = sqlManager;
        //addPlugin("TestPluginBukkit", 190f, 5f, 10, 1);
        //addPlugin("TestPluginSpigot", 20f, 7f, 3, 0);
    }
    @MethodInfo(info = "Ajouter un client à la bdd")
    public Plugin addPlugin(String name, float price, float popularity, int stock, int id_categorie) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            int i = 0;
            String request = String.format("INSERT INTO Plugins (name, price, stock, picture, popularity, id_categorie) VALUES ('%s', %f, %d, %d, %f, %d)", name, price, stock, i, popularity, id_categorie);
            DataAccessObject.getInstance().requete(request);

            request = String.format("SELECT * FROM Plugins WHERE name = '%s' AND id_categorie = %d", name, id_categorie);
            ResultSet r = DataAccessObject.getInstance().requeteSelection(request);
            if (r.last()) {
                return new Plugin(r.getInt("id_plugin"), r.getString("name"), r.getFloat("price"), r.getFloat("popularity"), PluginType.values()[r.getInt("id_categorie")], r.getInt("stock"));
            }
            this.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Avoir une Commande de la bdd")
    public Plugin getPlugin(int id) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            ResultSet r = DataAccessObject.getInstance().requeteSelection(String.format("SELECT * FROM Commande WHERE id_commande = %d", id));
            if (r.next()) {
                return new Plugin(r.getInt("id_plugin"), r.getString("name"), r.getFloat("price"), r.getFloat("popularity"), PluginType.values()[r.getInt("id_categorie")], r.getInt("stock"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Modifier un plugin à la bdd")
    public void editPlugin(Plugin plugin) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return;
        }
        String request = String.format("UPDATE Plugins SET name = '%s', price = %f, popularity = %f, stock = %d, id_categorie = %d WHERE id_client = '%s'", plugin.getName(), plugin.getPrice(), plugin.getPopularity(), plugin.getStock(), plugin.getPluginType().ordinal());
        DataAccessObject.getInstance().requete(request);
        this.findAll();
    }

    @MethodInfo(info = "Supprimer un plugin à la bdd")
    public void removePlugin(Plugin plugin) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée ddd !");
            return;
        }
        DataAccessObject.getInstance().requeteAction("DELETE FROM Plugins WHERE id_plugin = " + plugin.getId());
        this.findAll();
    }

    @MethodInfo(info = "Récupérer tout les plugins de la bdd")
    public List<Plugin> findAll() {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        List<Plugin> plugins = new ArrayList();
        try {
            ResultSet r = DataAccessObject.getInstance().requeteSelection("SELECT * FROM Plugins");
            while (r.next()) {
                plugins.add(new Plugin(r.getInt("id_plugin"), r.getString("name"), r.getFloat("price"), r.getFloat("popularity"), PluginType.values()[r.getInt("id_categorie")], r.getInt("stock")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plugins;
    }


}
