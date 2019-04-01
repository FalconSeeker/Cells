package me.falconseeker.cells.utils.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilders {
   
   private ItemStack is;

   public ItemBuilders(Material m){
     this(m, 1);
   }

   public ItemBuilders(ItemStack is){
     this.is=is;
   }

   public ItemBuilders(Material m, int amount){
     is= new ItemStack(m, amount);
   }

   /**
    * Set the displayname of the item.
    * @param name The name to change it to.
    */
   public ItemBuilders setName(String name){
     ItemMeta im = is.getItemMeta();
     im.setDisplayName(name);
     is.setItemMeta(im);
     return this;
   }
   /**
    * 
    * Set the skull owner for the item. Works on skulls only.
    * 
    * @param owner The name of the skull's owner.
    */
   public ItemBuilders setSkullOwner(String owner){
     try{
       SkullMeta im = (SkullMeta)is.getItemMeta();
       im.setOwner(owner);
       is.setItemMeta(im);
     }catch(ClassCastException expected){}
     return this;
   }
   /**
    * Re-sets the lore.
    * @param lore The lore to set it to.
    */
   public ItemBuilders setLore(String... lore){
     ItemMeta im = is.getItemMeta();
     im.setLore(Arrays.asList(lore));
     is.setItemMeta(im);
     return this;
   }
   /**
    * Re-sets the lore.
    * @param lore The lore to set it to.
    */
   public ItemBuilders setLore(List<String> lore) {
     ItemMeta im = is.getItemMeta();
     im.setLore(lore);
     is.setItemMeta(im);
     return this;
   }
   /**
    * Remove a lore line.
    * @param lore The lore to remove.
    */
   public ItemBuilders removeLoreLine(String line){
     ItemMeta im = is.getItemMeta();
     List<String> lore = new ArrayList<>(im.getLore());
     if(!lore.contains(line))return this;
     lore.remove(line);
     im.setLore(lore);
     is.setItemMeta(im);
     return this;
   }
   /**
    * Remove a lore line.
    * @param index The index of the lore line to remove.
    */
   public ItemBuilders removeLoreLine(int index){
     ItemMeta im = is.getItemMeta();
     List<String> lore = new ArrayList<>(im.getLore());
     if(index<0||index>lore.size())return this;
     lore.remove(index);
     im.setLore(lore);
     is.setItemMeta(im);
     return this;
   }
   /**
    * Add a lore line.
    * @param line The lore line to add.
    */
   public ItemBuilders addLoreLine(String line){
     ItemMeta im = is.getItemMeta();
     List<String> lore = new ArrayList<>();
     if(im.hasLore())lore = new ArrayList<>(im.getLore());
     lore.add(line);
     im.setLore(lore);
     is.setItemMeta(im);
     return this;
   }
   /**
    * Add a lore line.
    * @param line The lore line to add.
    * @param pos The index of where to put it.
    */
   public ItemBuilders addLoreLine(String line, int pos){
     ItemMeta im = is.getItemMeta();
     List<String> lore = new ArrayList<>(im.getLore());
     lore.set(pos, line);
     im.setLore(lore);
     is.setItemMeta(im);
     return this;
   }
   /**
    * Sets the dye color of a wool item. Works only on wool.
    * @see ItemBuilder@setDyeColor(DyeColor)
    * @param color The DyeColor to set the wool item to.
    */
   public ItemBuilders setWoolColor(DyeColor color){
    if(!is.getType().equals(Material.WOOL))return this;
    this.is.setDurability(color.getWoolData());
    return this;
   }
   /**
    * Change the durability of the item.
    * @param dur The durability to set it to.
    */
   public ItemBuilders setDurability(short dur){
     is.setDurability(dur);
     return this;
   }
   /**
    * Retrieves the itemstack from the ItemBuilder.
    * @return The itemstack created/modified by the ItemBuilder instance.
    */
   public ItemStack buildItem(){
     return is;
   }
}
