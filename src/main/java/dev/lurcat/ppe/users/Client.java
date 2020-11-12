package dev.lurcat.ppe.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Client {

    private int id_client;
    private String name, mail;
    private int number;

    public String getInformations() {
        StringBuilder sb = new StringBuilder("Informations client\n");
        sb.append("ID: " + id_client + "\n");
        sb.append("Identifiant: " + name + "\n");
        sb.append("Mail: " + mail + "\n");
        sb.append("Numéro de téléphone: " + number + "\n");
        return sb.toString();
    }

}
