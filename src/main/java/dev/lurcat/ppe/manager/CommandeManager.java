package dev.lurcat.ppe.manager;

import dev.lurcat.ppe.api.Manager;
import dev.lurcat.ppe.api.MethodInfo;
import dev.lurcat.ppe.api.Title;
import dev.lurcat.ppe.shop.Commande;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandeManager extends Manager {

    private final SQLManager sqlManager;

    public CommandeManager(SQLManager sqlManager) {
        super(Title.COMMANDE_MANAGER);
        this.sqlManager = sqlManager;
    }

    @MethodInfo(info = "Ajouter d'une commande à la bdd")
    public Commande addCommande(Commande commande) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            String request = String.format("INSERT INTO Commande (transaction, state, id_agent, id_client) VALUES (%s, %s, %s, %s)", commande.getTransation(), commande.getState(), commande.getId_agent(), commande.getId_client());
            DataAccessObject.getInstance().requeteSelection(request);

            request = String.format("SELECT * FROM Commande WHERE transaction = %s AND state = %s AND id_agent = %s AND id_client = %s", commande.getTransation(), commande.getState(), commande.getId_agent(), commande.getId_client());
            ResultSet r = DataAccessObject.getInstance().requeteSelection(request);
            if (r.last()) {
                return new Commande(r.getInt("id_commande"), r.getString("transaction"), r.getString("state"), r.getInt("id_agent"), r.getInt("id_client"));
            }
            this.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Avoir une Commande de la bdd")
    public Commande getCommande(int id) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        try {
            ResultSet r = DataAccessObject.getInstance().requeteSelection(String.format("SELECT * FROM Commande WHERE id_commande = %d", id));
            if (r.next()) {
                return new Commande(r.getInt("id_commande"), r.getString("transaction"), r.getString("state"), r.getInt("id_agent"), r.getInt("id_client"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Modifier un commande à la bdd")
    public void editCommand(Commande commande) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return;
        }
        String request = String.format("UPDATE Commande SET transaction = %s, state = %s, id_agent = %d, id_client = %d WHERE id_commande = %d", commande.getTransation().toString(), commande.getState(), commande.getId_agent(), commande.getId_client(), commande.getId_commande());
        DataAccessObject.getInstance().requete(request);
        this.findAll();
    }

    @MethodInfo(info = "Supprimer une commande à la bdd")
    public void removeCommande(Commande commande) {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return;
        }
        DataAccessObject.getInstance().requeteAction("DELETE FROM Commande WHERE id_commande = " + commande.getId_commande());
        this.findAll();
    }


    @MethodInfo(info = "Récupérer tout les commandes de la bdd")
    public List<Commande> findAll() {
        if (!sqlManager.isConnected()) {
            System.out.println("Erreur: La base de donnée est pas connectée !");
            return null;
        }
        List<Commande> commandes = new ArrayList<>();
        try {
            ResultSet r = DataAccessObject.getInstance().requeteSelection("SELECT * FROM Commande");
            commandes.clear();
            while (r.next()) {
                Commande commande = new Commande(r.getInt("id_commande"), r.getString("transaction"), r.getString("state"), r.getInt("id_agent"), r.getInt("id_client"));
                commandes.add(commande);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commandes;
    }


}
