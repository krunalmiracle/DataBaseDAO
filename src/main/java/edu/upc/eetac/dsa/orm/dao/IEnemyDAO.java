package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.model.Enemy;

import java.util.List;

public interface IEnemyDAO {
    int addEnemy(String enemyID, String name, int power, int health);
    Enemy getEnemy(String enemyID);
    void updateEnemy(String enemyID, String name, int power, int health);
    void deleteEnemy(String enemyID);
    List<Enemy> getEnemies();
}

