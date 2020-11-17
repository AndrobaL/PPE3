package dev.lurcat.ppe.shop;

import dev.lurcat.ppe.api.PluginType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Plugin {

    private int id;
    private String name;
    private float price, popularity;
    private PluginType pluginType;
    private int stock;
}
