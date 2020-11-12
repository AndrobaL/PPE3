package dev.lurcat.ppe.api;

public enum Title {

    COMMANDE_MANAGER("Gestion des commandes"),
    SQL_MANAGER("Gestion de la base de données"),
    CLIENT_MANAGER("Gestion des clients"),
    PLUGIN_MANAGER("Gestion des plugins");

    public String data;

    Title(String t) {
        this.data = t;
    }

}
