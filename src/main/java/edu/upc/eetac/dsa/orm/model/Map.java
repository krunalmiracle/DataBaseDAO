package edu.upc.eetac.dsa.orm.model;

public class Map {

    //Basic values
    private String ID;
    private int sizeX;
    private int sizeY;
    private String designGrid;

    //Empty Constructor
    public Map() {}

    //Constructor
    public Map(String ID, int sizeX, int sizeY, String designGrid) {
        this.ID = ID;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.designGrid = designGrid;
    }

    //Setters and Getters
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    public String getDesignGrid() {
        return designGrid;
    }
    public void setDesignGrid(String designGrid) {
        this.designGrid = designGrid;
    }



}
