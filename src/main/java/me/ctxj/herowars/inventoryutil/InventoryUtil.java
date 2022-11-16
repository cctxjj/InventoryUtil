package me.ctxj.herowars.inventoryutil;

import gnu.trove.impl.sync.TSynchronizedShortByteMap;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryUtil extends JavaPlugin {


    /*

    InventoryAPI funktioniert wie folgt:
    Zur Nutzung der InventoryAPI muss ein ModifiedInventory instanziiert werden. Hierbei muss entweder ein bestehendes Inventar übergeben oder Attribute zur Erstellung genannt werden.
    Mit der Erstellung des Objektes kann man nun auf die Funktionen zugreifen.

    Genaue Erklärungen zu der konkreten Funktionsweise der Methoden finden sich über ihnen.

    Des Weiteren beinhaltet dieses Plugin ein ItemUtil, welches mithilfe der Instanziierung eines ModifiedItem genutzt werden kann.
    Auch hierbei lassen sich die Funktionen über das Objekt abrufen. Die Methoden befassen sich im Grunde mit allen ItemMeta-Features, für die der normale Mensch zu faul ist,
    jedes mal die Meta zu getten, setten und modifizieren.

     */


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(" ");
        System.out.println("InventoryUtil enabled");
        System.out.println(" ");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
