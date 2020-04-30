package edu.upc.eetac.dsa.orm.model;

import java.util.List;

public class Item {

    private String ID;
    private String name;
    private String type;
    private int rarity;
    private int description;
    List<Material> listMaterials;
    private int offense;
    private int defense;
    //Empty Constructor
    public Item() {
    }
    public Item(String ID, String name, String type, int rarity, int description, List<Material> listMaterials, int offense, int defense) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.description = description;
        this.listMaterials = listMaterials;
        this.offense = offense;
        this.defense = defense;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public List<Material> getListMaterials() {
        return listMaterials;
    }

    public void setListMaterials(List<Material> listMaterials) {
        this.listMaterials = listMaterials;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
