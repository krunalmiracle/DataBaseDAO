package edu.upc.eetac.dsa.orm.model;

import java.util.List;

public class Item {

    private String ID;
    private String parentID="";
    private String name;
    private String type;
    private String rarity;
    private String description;
    List<Material> listMaterials;
    private int offense;
    private int defense;
    //Empty Constructor
    public Item() {
    }
    public Item(String parentID, String name, String type, String rarity, String description, List<Material> listMaterials, int offense, int defense) {
        this.parentID = parentID;
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

    public String getParentID() { return parentID;}

    public void setParentID(String parentID) {this.parentID = parentID;}

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

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
