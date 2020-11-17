package dev.lurcat.ppe.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Commande {

    private int id_commande;
    private String transation;
    private String state;
    private int id_agent, id_client;

}
