package ormtests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import edu.upc.eetac.dsa.orm.*;
public class PlayerDAOImplTest{
    PlayerDAOImpl playerdao= new PlayerDAOImpl();
    Player player = null;
    @Before
    public void setUp() {
        player = null;
    }
    @Test
    public void addPlayerTest(){
        Assert.assertEquals(0,playerdao.addPlayer("Marc", "pass", 5, 4, 2, 23, 2));
    }
    @Test
    public void getPlayerTest(){
       String id= playerdao.addPlayer("Yo", "pass", 5, 4, 2, 23, 2);
       Assert.assertNotNull(playerdao.getPlayer(id));
    }
    @Test
    public void getPlayersTest(){
        Assert.assertNotNull(playerdao.getPlayers());
    }
    @After
    public void tearDown() {
    }

}