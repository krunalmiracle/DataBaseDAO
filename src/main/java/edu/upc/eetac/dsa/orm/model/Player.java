package edu.upc.eetac.dsa.orm.model;

import java.util.List;

public class Player {
    private String ID;
    private String username;
    private String password;
    private int gamesPlayed;
    private int kills;
    private int deaths;
    private int experience;
    private int wins;
    List<String> listItems;
    List<String> listMaterials;
    //Empty Constructor
    public Player(){}
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public List<String> getListItems() {
        return listItems;
    }

    public void setListItems(List<String> listItems) {
        this.listItems = listItems;
    }

    public List<String> getListMaterials() {
        return listMaterials;
    }

    public void setListMaterials(List<String> listMaterials) {
        this.listMaterials = listMaterials;
    }



}
