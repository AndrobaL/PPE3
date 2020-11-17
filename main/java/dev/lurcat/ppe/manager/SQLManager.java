package dev.lurcat.ppe.manager;

import dev.lurcat.ppe.api.Manager;
import dev.lurcat.ppe.api.MethodInfo;
import dev.lurcat.ppe.api.Title;
import dev.lurcat.ppe.users.Agent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLManager extends Manager {

    public SQLManager() {
        super(Title.SQL_MANAGER);
    }

    @MethodInfo(info = "Retourner un User dans la bdd")
    public Agent login(String name, String password) {
        try {
            ResultSet resultSet = DataAccessObject.getInstance().requeteSelection("SELECT * FROM Agents WHERE name = '" + name + "' AND password = '" + password + "'");
            if (resultSet.next()) {
                return new Agent(name, password, resultSet.getString("firstname"), resultSet.getString("mail"), resultSet.getString("phone_number"), resultSet.getString("profile"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @MethodInfo(info = "Vérifier la connexion à la bdd")
    public boolean isConnected() {
        return DataAccessObject.getInstance().isConnected();
    }
}
