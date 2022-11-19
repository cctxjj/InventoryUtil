package me.ctxj.herowars.inventoryutil.api;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ModifiedInventory {

    private Inventory inventory;



    /*
    Übernimmt bei der Instanziierung ein bestehendes Inventar. Dieses muss einen Wert haben!
     */
    public ModifiedInventory(Inventory inventory) {
        this.inventory = inventory;
        if(inventory == null) {
            throw new NullPointerException();
        }
    }

    /*
    Erstellt bei der Instanziierung ein neues Inventar basierend auf den Parametern
     */
    public ModifiedInventory(String name, int rows) {
        inventory = Bukkit.createInventory(null, rows*9, name);

    }



    /*
    Folgende Funktionen fügen an Seiten (links, rechts) eine Border hinzu.
     */
    public ModifiedInventory addVerticalBorders(Material m) {
        for (int i = 0; i < inventory.getSize() / 9; i++) {
            inventory.setItem(i * 9, new ModifiedItem(m).clearItem().getItemStack());
            inventory.setItem(i * 9 + 8, new ModifiedItem(m).clearItem().getItemStack());
        }
        return this;
    }

    public ModifiedInventory addVerticalBorders(Material left, Material right) {
        for(int i = 0; i < inventory.getSize()/9; i++) {
            inventory.setItem(i*9, new ModifiedItem(left).clearItem().getItemStack());
            inventory.setItem(i*9+8, new ModifiedItem(right).clearItem().getItemStack());
        }
        return this;
    }

    public ModifiedInventory addVerticalBorders() {
        for(int i = 0; i < inventory.getSize()/9; i++) {
            inventory.setItem(i*9, new ModifiedItem(Material.STAINED_GLASS_PANE).clearItem().getItemStack());
            inventory.setItem(i*9+8, new ModifiedItem(Material.STAINED_GLASS_PANE).clearItem().getItemStack());
        }
        return this;
    }





    /*
    Folgende Funktionen fügen an Seiten (oben, unten) eine Border hinzu.
     */
    public ModifiedInventory addHorizontalBorders() {
        for(int i = 0; i < inventory.getSize(); i++) {
            if(i<=8) {
                inventory.setItem(i, new ModifiedItem(Material.STAINED_GLASS_PANE).clearItem().getItemStack());
            } else if(i>=(inventory.getSize()/9-1)*9) {
                inventory.setItem(i, new ModifiedItem(Material.STAINED_GLASS_PANE).clearItem().getItemStack());
            }
        }
        return this;
    }

    public ModifiedInventory addHorizontalBorders(Material m) {
        for(int i = 0; i < inventory.getSize(); i++) {
            if(i<=8) {
                inventory.setItem(i, new ModifiedItem(m).clearItem().getItemStack());
            } else if(i>=(inventory.getSize()/9-1)*9) {
                inventory.setItem(i, new ModifiedItem(m).clearItem().getItemStack());
            }
        }
        return this;
    }

    public ModifiedInventory addHorizontalBorders(Material top, Material bottom) {
        for(int i = 0; i < inventory.getSize(); i++) {
            if(i<=8) {
                inventory.setItem(i, new ModifiedItem(top).clearItem().getItemStack());
            } else if(i>=(inventory.getSize()/9-1)*9) {
                inventory.setItem(i, new ModifiedItem(bottom).clearItem().getItemStack());
            }
        }
        return this;
    }




     /*
    Folgende Funktionen fügen in angegebener Reihe eine horizontale Border hinzu. Reihen verfügbar: 0-8
     */
    public ModifiedInventory addHorizontalBorder(Material material, int row) {
        for(int i = 0; i < inventory.getSize(); i++) {
            if(i>=row*9 && i <= row*9+8) {
                inventory.setItem(i, new ModifiedItem(material).clearItem().getItemStack());
            }
        }
        return this;
    }

    public ModifiedInventory addHorizontalBorder(int row) {
        for(int i = 0; i < inventory.getSize(); i++) {
            if(i>=row*9 && i <= row*9+8) {
                inventory.setItem(i, new ModifiedItem(Material.STAINED_GLASS_PANE).clearItem().getItemStack());
            }
        }
        return this;
    }



    /*
    Folgende Funktionen fügen in angegebener Reihe eine vertikale Border hinzu. Reihen verfügbar: 0-8
     */
    public ModifiedInventory addVerticalBorder(Material material, int row) {
        for(int i = 0; i < inventory.getSize()/9; i++) {
            inventory.setItem(i*9+row, new ModifiedItem(material).clearItem().getItemStack());
        }
        return this;
    }

    public ModifiedInventory addVerticalBorder(int row) {
        for(int i = 0; i < inventory.getSize()/9; i++) {
            inventory.setItem(i*9+row, new ModifiedItem(Material.STAINED_GLASS_PANE).clearItem().getItemStack());
        }
        return this;
    }

    //Folgende Funktionen füllen alle Leerstellen in einem Inventar auf...

    public ModifiedInventory fillup(Material m) {
        for(int i = 0; i < inventory.getSize(); i++) {
            if(inventory.getItem(i).getType()==Material.AIR) {
                inventory.setItem(i, new ModifiedItem(m).clearItem().getItemStack());
            }
        }
        return this;
    }


    public ModifiedInventory fillup() {
        fillup(Material.STAINED_GLASS_PANE);
        return this;
    }





    public Inventory getInventory() {
        return inventory;
    }

    public void passInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
