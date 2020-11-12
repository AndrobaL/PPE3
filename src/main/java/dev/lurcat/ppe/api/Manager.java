package dev.lurcat.ppe.api;

import lombok.Getter;

import java.lang.reflect.Method;

@Getter
public class Manager {

    private final Title title;

    public Manager(Title title) {
        this.title = title;
    }

    protected final String format = "Methode '%s': %s";

    public StringBuilder getData() {
        final StringBuilder sb = new StringBuilder(title.data + "\n");
        for (Method method : this.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo annotation = method.getAnnotation(MethodInfo.class);
                sb.append(String.format(format, method.getName(), annotation.info() + "\n"));
            }
        }
        return sb;
    }

}
