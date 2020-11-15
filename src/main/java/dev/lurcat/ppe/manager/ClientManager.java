package dev.lurcat.ppe.manager;

import dev.lurcat.ppe.api.Manager;
import dev.lurcat.ppe.api.MethodInfo;
import dev.lurcat.ppe.api.Title;
import dev.lurcat.ppe.users.Agent;
import dev.lurcat.ppe.users.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientManager extends Manager {

    private final SQLManager sqlManager;

    public ClientManager(SQLManager sqlManager) {
        super(Title.CLIENT_MANAGER);
        this.sqlManager = sqlManager;
        testLogin();
    }

    @MethodInfo(info = "Tester (exemple)")
    public void testLogin() {
        Agent agent = sqlManager.login("admin", "test");
        if (agent == null) {
            System.out.println("Erreur de connexion");
        } else {
            System.out.println(agent.getInformations());
        }
        Client client = addClient("test" + ThreadLocalRandom.current().nextInt(100, 2000), "email de test", ThreadLocalRandom.current().nextInt(1000, 2000));
        //new Facture(Arrays.asList(), "100,3€", 2541351, client);
    }

    @MethodInfo(info = "Ajouter un client à la bdd")
    public Client addClient(String name, String email, int phone_number) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            String request = String.format("INSERT INTO Clients (name, mail, phone_number) VALUES ('%s', '%s', %d)", name, email, phone_number);
            DataAccessObject.getInstance().requete(request);

            request = String.format("SELECT * FROM Clients WHERE name = '%s' AND mail = '%s' AND phone_number = %d", name, email, phone_number);
            ResultSet r = DataAccessObject.getInstance().requeteSelection(request);
            if (r.last()) {
                return new Client(r.getInt("id_client"), r.getString("name"), r.getString("mail"), r.getInt("phone_number"));
            }
            this.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Modifier un client à la bdd")
    public void editClient(Client client) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return;
        }
        String request = String.format("UPDATE Clients SET name = '%s', mail = '%s', phone_number = %d WHERE id_client = '%s'", client.getName(), client.getMail(), client.getNumber(), client.getId_client());
        DataAccessObject.getInstance().requete(request);
        this.findAll();
    }

    @MethodInfo(info = "Supprimer un client à la bdd")
    public void removeClient(Client client) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée ddd !");
            return;
        }
        DataAccessObject.getInstance().requeteAction("DELETE FROM Clients WHERE id_client = " + client.getId_client());
        this.findAll();
    }

    @MethodInfo(info = "Avoir un client de la bdd")
    public Client getClient(int id) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            ResultSet r = DataAccessObject.getInstance().requeteSelection(String.format("SELECT * FROM Clients WHERE id_client = %d", id));
            if (r.next()) {
                return new Client(r.getInt("id_client"), r.getString("name"), r.getString("mail"), r.getInt("phone_number"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Récupérer tout les clients de la bdd")
    public List<Client> findAll() {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        List<Client> clients = new ArrayList();
        try {
            ResultSet r = DataAccessObject.getInstance().requeteSelection("SELECT * FROM Clients");
            while (r.next()) {
                clients.add(new Client(r.getInt("id_client"), r.getString("name"), r.getString("mail"), r.getInt("phone_number")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    }

}
