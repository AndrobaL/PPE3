package dev.lurcat.ppe.manager;

import dev.lurcat.ppe.api.Manager;
import dev.lurcat.ppe.api.MethodInfo;
import dev.lurcat.ppe.api.Title;
import dev.lurcat.ppe.shop.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        //testPlugin();
    }

    @MethodInfo(info = "Tester (exemple)")
    public void testPlugin() {
        addPlugin(new Plugin("Test", null));
    }

    @MethodInfo(info = "Ajouter un client à la bdd")
    public void addPlugin(Plugin plugin) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return;
        }
        try {
            //PreparedStatement statement = connection.prepareStatement("INSERT INTO Clients (name, mail, phone_number) VALUES ('" + name + "','" + email + "','" + phone_number+ "')");
            //statement.executeUpdate();
            this.findAll();
        } catch (Throwable e) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @MethodInfo(info = "Supprimer un plugin à la bdd")
    public void removePlugin(Plugin plugin) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return;
        }
        DataAccessObject.getInstance().requeteSelection("REMOVE * FROM Plugins WHERE ? = (?) VALUES ('name'," + plugin.getName() +")");
        this.findAll();
    }

    @Override
    public StringBuilder getData() {
        return super.getData();
    }

    @MethodInfo(info = "Récupérer tout les plugins de la bdd")
    public List<Plugin> findAll() {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            ResultSet result = DataAccessObject.getInstance().requeteSelection("SELECT * FROM Plugins");
            Plugin plugin;
            while (result.next()) {
                plugin = new Plugin(result.getString("name"), null);
                System.out.println(plugin.getName());
                if (!plugins.contains(plugin)) {
                    plugins.add(plugin);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plugins;
    }


}
