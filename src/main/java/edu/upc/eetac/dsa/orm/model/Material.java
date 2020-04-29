package edu.upc.eetac.dsa.orm.model;

import java.util.List;

public class Material {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String ID;
    private String name;
    private String description;
    //Empty Constructor
    public Material() {
    }
}
