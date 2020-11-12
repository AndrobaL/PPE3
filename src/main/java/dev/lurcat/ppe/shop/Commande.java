package dev.lurcat.ppe.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@AllArgsConstructor
@Getter
@Setter
public class Commande {

    private int id_commande;
    private Date transation;
    private String state;
    private int id_agent, id_client;

}
