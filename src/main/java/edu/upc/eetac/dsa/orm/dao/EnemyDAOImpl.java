package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.FactorySession;
import edu.upc.eetac.dsa.orm.Session;
import edu.upc.eetac.dsa.orm.model.Enemy;

import java.util.List;

public class EnemyDAOImpl implements IEnemyDAO{

    public int addEnemy(String enemyID, String name, int power, int health) {
        Session session = null;
        int employeeID = 0;
        try {
            session = FactorySession.openSession();
            Enemy enemy = new Enemy(enemyID, name, power, health);
            session.save(enemy);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return employeeID;
    }


    public Enemy getEnemy(String enemyID) {
        Session session = null;
        Enemy enemy = null;
        try {
            session = FactorySession.openSession();
            enemy = (Enemy)session.get(Enemy.class, enemyID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return enemy;
    }


    public void updateEnemy(String enemyID, String name, int power, int health) {
        Enemy employee = this.getEnemy(enemyID);
        employee.setName(name);
        employee.setPower(power);
        employee.setHealth(health);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(Enemy.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }


    public void deleteEnemy(String enemyID) {
        Enemy enemy = this.getEnemy(enemyID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Enemy.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }


    public List<Enemy> getEnemies() {
        Session session = null;
        List<Enemy> enemyList=null;
        try {
            session = FactorySession.openSession();
            enemyList = session.findAll(Enemy.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return enemyList;
    }

}
