package dev.lurcat.ppe.api;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dev.lurcat.ppe.users.Client;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Facture {

    /**
     *
     * @param panier
     * @param PrixTotale
     * @param idCommande
     * @param leClient
     */

    public Facture(List<String> panier, String PrixTotale, Integer idCommande , Client leClient){
        ArrayList columnTitle = new ArrayList<String>();
        columnTitle.add("Id_Produit");
        columnTitle.add("Libelle");
        columnTitle.add("Quantité");
        columnTitle.add("Prix Unitaire HT");
        columnTitle.add("Prix Totale");
        Document unDocument = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(unDocument, new FileOutputStream("C:\\Users\\Killyan\\Desktop\\Facture_"+leClient.getName()+"_"+idCommande+".pdf"));
            unDocument.addAuthor(leClient.getName());
            unDocument.addTitle("Facturation_"+ leClient.getId_client());
            unDocument.open();

            Paragraph p = new Paragraph("Bon de commande (ID: " + idCommande + ")", FontFactory.getFont(FontFactory.defaultEncoding,24, Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);

            Paragraph emetteur = new Paragraph("\n \n PPE Killyan \n 23 rue de L'avenur,\n 66000 PERPIGNAN \n\n",
                    FontFactory.getFont(FontFactory.defaultEncoding,13));


            Paragraph destinataire = new Paragraph(leClient.getName()+" \n"+leClient.getMail()+"\n"+leClient.getNumber()+" \n\n");
            destinataire.setAlignment(Element.ALIGN_RIGHT);

            Paragraph test = new Paragraph("\n LISTE DES PRODUITS:",
                    FontFactory.getFont(FontFactory.defaultEncoding,13));

            PdfPTable table = new PdfPTable(5);
            PdfPCell c1;

            for (int i = 0; i < 5; i++) {
                c1 = new PdfPCell(new Phrase((String) columnTitle.get(i)));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
            }
            table.setHeaderRows(1);

            for (String string : panier) {
                table.addCell(string);
            }

            table.setTotalWidth(PageSize.A4.getWidth()-100);
            table.setLockedWidth(true);

            Paragraph Totale = new Paragraph("PrixTotale = "+PrixTotale);
            Totale.setAlignment(Element.ALIGN_RIGHT);

            unDocument.add(p);
            unDocument.add(emetteur);
            unDocument.add(destinataire);
            unDocument.add(test);
            unDocument.add(table);
            unDocument.add(Totale);

        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        unDocument.close();
    }

}
