package edu.upc.eetac.dsa.orm.model;

public class Enemy {

    //Basic values
    private String ID;
    private String name;
    private int power;
    private int health;

    //Empty Constructor
    public Enemy() { }

    //Constructor
    public Enemy(String ID, String name, int power, int health){
        this.ID=ID;
        this.name=name;
        this.power=power;
        this.health=health;
    }

    //Setters and Getters
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
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }



}
