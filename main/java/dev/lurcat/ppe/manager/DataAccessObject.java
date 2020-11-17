package dev.lurcat.ppe.manager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObject {

    private static String nomServeur = "10.0.10.138"; //10.0.10.138
    private static String port = "3306";
    private static String nomBdd = "ppe";
    private static String nomUtilisateur = "root";
    private static String motDePasse = "root";
    private static String chaineConnexion;

    private Connection connexion;
    private static DataAccessObject monDao = null;

    /**
     * Constructeur privé ! pour construire un objet, il faut utiliser la
     * méthode publique statique getDaoSIO
     *
     */
    private DataAccessObject() {
        try {
            //Définition de l'emplacement de la BDD
            DataAccessObject.chaineConnexion = "jdbc:mysql://" + DataAccessObject.nomServeur + ":" + DataAccessObject.port + "/" + DataAccessObject.nomBdd;

            //Création de la connexion à la BDD
            this.connexion = DriverManager.getConnection(DataAccessObject.chaineConnexion, DataAccessObject.nomUtilisateur, DataAccessObject.motDePasse);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Permet d'obtenir l'objet instancié
     * @return un Objet DaoSIO avec connexion active ... pour une certaine durée
     */
    public static DataAccessObject getInstance() {
        if (DataAccessObject.monDao == null) {
            DataAccessObject.monDao = new DataAccessObject();
        } else {
            if(!DataAccessObject.monDao.isConnected()){
                DataAccessObject.monDao = new DataAccessObject();
            }
        }
        return DataAccessObject.monDao;
    }

    public boolean isConnected() {
        try {
            if (this.connexion.isClosed()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    /**
     *
     * @param sql, comportera un ordre selec
     * @return
     */
    public ResultSet requeteSelection(String sql){
        try {
            Statement requete = new DataAccessObject().connexion.createStatement();
            return requete.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /**
     *
     * @param sql, comportera un ordre insert, update, select, alter, etc.
     * @return le nombre de lignes impactées par la requête action
     *
     */
    public Integer requeteAction(String sql){

        try {
            Statement requete = new DataAccessObject().connexion.createStatement();
            return requete.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * @param sql, comportera un ordre insert, update, select, alter, etc.
     * @return le nombre de lignes impactées par la requête action
     *
     */
    public void requete(String sql){

        try {
            Statement requete = new DataAccessObject().connexion.createStatement();
            requete.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
