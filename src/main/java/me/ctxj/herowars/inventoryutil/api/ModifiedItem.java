package me.ctxj.herowars.inventoryutil.api;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Array;
import java.util.ArrayList;

public class ModifiedItem {

    private final ItemStack itemStack;

    public ModifiedItem(Material material) {
        itemStack = new ItemStack(material, 1);
    }

    public ModifiedItem(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
    }

    /*
    Im Folgenden finden sich einige Funktionen, die das Erstellen von Items erleichtern.
     */

    public ModifiedItem setDisplayName(String name) {
        ItemMeta im = itemStack.getItemMeta();
        im.setDisplayName(name);
        itemStack.setItemMeta(im);
        return this;
    }
    public ModifiedItem clearDisplayName() {
        ItemMeta im = itemStack.getItemMeta();
        im.setDisplayName(" ");
        itemStack.setItemMeta(im);
        return this;
    }
    public ModifiedItem setLore(ArrayList<String> lore) {
        ItemMeta im = itemStack.getItemMeta();
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return this;
    }

    public ModifiedItem setLore(String line1) {
        ItemMeta im = itemStack.getItemMeta();
        ArrayList<String> al = new ArrayList<>();
        al.add(line1);
        im.setLore(al);
        itemStack.setItemMeta(im);
        return this;
    }

    public ModifiedItem setLore(String line1, String line2) {
        ItemMeta im = itemStack.getItemMeta();
        ArrayList<String> al = new ArrayList<>();
        al.add(line1);
        al.add(line2);

        im.setLore(al);
        itemStack.setItemMeta(im);
        return this;
    }

    public ModifiedItem setLore(String line1, String line2, String line3) {
        ItemMeta im = itemStack.getItemMeta();
        ArrayList<String> al = new ArrayList<>();
        al.add(line1);
        al.add(line2);
        al.add(line3);
        im.setLore(al);
        itemStack.setItemMeta(im);
        return this;
    }

    public ModifiedItem removeLore(String query) {
        ItemMeta im = itemStack.getItemMeta();
        ArrayList<String> al = (ArrayList<String>) im.getLore();
        al.removeIf(s -> s.equals(query));
        im.setLore(al);
        itemStack.setItemMeta(im);
        return this;
    }
    public ModifiedItem removeLore() {
        ItemMeta im = itemStack.getItemMeta();
        ArrayList<String> al = new ArrayList<>();
        im.setLore(al);
        itemStack.setItemMeta(im);
        return this;
    }



    public ModifiedItem addEnchantment(Enchantment enchantment, int i, boolean b) {
        ItemMeta im = itemStack.getItemMeta();
        im.addEnchant(enchantment, i, b);
        itemStack.setItemMeta(im);
        return this;
    }

    public ModifiedItem removeEnchantment(Enchantment enchantment) {
        ItemMeta im = itemStack.getItemMeta();
        im.removeEnchant(enchantment);
        itemStack.setItemMeta(im);
        return this;
    }



    public ModifiedItem clearItem() {
        this.clearDisplayName();
        this.removeLore();
        return this;
    }




    public ItemStack getItemStack() {
        return itemStack;
    }
}
