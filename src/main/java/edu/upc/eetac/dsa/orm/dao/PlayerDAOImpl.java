package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.FactorySession;
import edu.upc.eetac.dsa.orm.Session;
import edu.upc.eetac.dsa.orm.model.Employee;
import edu.upc.eetac.dsa.orm.model.Player;

public class PlayerDAOImpl {
    public Player getPlayer(String id){
        Session session = null;
        Player player = null;
        try {
            session = FactorySession.openSession();
            player = (Player)session.get(Player.class, id);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return player;
    }
    public void deletePlayer(String id){
        Player player = this.getPlayer(id);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Player.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }


    }
}
