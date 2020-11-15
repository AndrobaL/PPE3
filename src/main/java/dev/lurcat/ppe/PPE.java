package dev.lurcat.ppe;

import dev.lurcat.ppe.form.AdminForm;
import dev.lurcat.ppe.manager.ClientManager;
import dev.lurcat.ppe.manager.CommandeManager;
import dev.lurcat.ppe.manager.PluginManager;
import dev.lurcat.ppe.manager.SQLManager;
import lombok.Getter;

@Getter
public class PPE {

    private final SQLManager sqlManager;
    private final ClientManager clientManager;
    private final CommandeManager commandeManager;
    private final PluginManager pluginManager;
    public static PPE INSTANCE;

    public PPE() {
        PPE.INSTANCE = this;
        this.sqlManager = new SQLManager();
        this.clientManager = new ClientManager(sqlManager);
        this.commandeManager = new CommandeManager(sqlManager);
        this.pluginManager = new PluginManager(sqlManager);


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

}
