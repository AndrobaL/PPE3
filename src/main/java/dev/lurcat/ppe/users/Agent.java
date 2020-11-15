package dev.lurcat.ppe.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Agent {

    private String name, password, firstname, mail, number, profile;

    public String getInformations() {
        StringBuilder sb = new StringBuilder("Informations agent\n");
        sb.append("Identifiant: " + name + "\n");
        sb.append("Mot de pass: " + password + "\n");
        sb.append("Prénom: " + firstname + "\n");
        sb.append("Mail: " + mail + "\n");
        sb.append("Numéro de téléphone: " + number + "\n");
        sb.append("Profile: " + profile + "\n");
        return sb.toString();
    }

}