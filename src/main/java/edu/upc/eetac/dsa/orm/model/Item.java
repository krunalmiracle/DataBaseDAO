package edu.upc.eetac.dsa.orm.model;

import java.util.List;

public class Item {

    //Basic values
    private String name;
    private String type;
    private int rarity;
    private int description;
    List<String> listMaterials;
    List<String> listMaterialAmounts;
    private int offense;
    private int defense;

    //Empty Constructor
    public Item() { }

    //Constructor
    public Item(String name, String type, int rarity, int description, int offense, int defense) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.description = description;
        this.offense = offense;
        this.defense = defense;
    }

    //Setters and Getters
    private String ID;
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
    public List<String> getListMaterials() {
        return listMaterials;
    }
    public void setListMaterials(List<String> listMaterials) {
        this.listMaterials = listMaterials;
    }
    public List<String> getListMaterialAmounts() {
        return listMaterialAmounts;
    }

    public void setListMaterialAmounts(List<String> listMaterialAmounts) {
        this.listMaterialAmounts = listMaterialAmounts;
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
