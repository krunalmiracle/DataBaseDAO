package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.model.Item;
import edu.upc.eetac.dsa.orm.model.Material;
import edu.upc.eetac.dsa.orm.model.Player;

import java.util.List;

public interface IPlayerDAO {
    String addPlayer(String username, String password, int gamesPlayed, int kills, int deaths, int experience, int wins);
    Player getPlayer(String id);
    void deletePlayer(String id);
    void updatePlayer(String ID, String username, String password, int gamesPlayed, int kills, int deaths, int experience, int wins, List<Item> listItems, List<Material> listMaterial);
    List<Player> getPlayers();
}
