package ormtests;
import edu.upc.eetac.dsa.orm.*;
import edu.upc.eetac.dsa.orm.dao.IItemDAO;
import edu.upc.eetac.dsa.orm.dao.ItemDAOImpl;
import edu.upc.eetac.dsa.orm.model.Item;
import edu.upc.eetac.dsa.orm.model.Material;
import org.apache.log4j.Logger;
//Junit 4.13
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class ItemDAOImplTest {
    // THE QUICK REMINDER: Remember to name the test class public smh
    //Log4j Logger initialization
    private static final Logger logger = Logger.getLogger(IItemDAO.class);
    IItemDAO ItemDAOImpl = new ItemDAOImpl();
    Item item = null;
    String itemID;
    @Before
    public void setUp() {
        item = null;
        itemID = "AAAABBBBCCCCDDDE";
    }
    //Tests
    //Metodo Test para crear un nuevo brote
    @Test
    public void addItemTest(){
        String ID = ItemDAOImpl.addItem("001","Bow","Ranged","Extinct","Long lost Bow",2,0);
        Assert.assertNotNull(ID);
    }
    @Test
    public void getItemTest(){

        String ID = ItemDAOImpl.addItem("001","Bow","Ranged","Extinct","Long lost Bow",2,0);
        item = ItemDAOImpl.getItem(ID);
        Assert.assertNotNull(item);
    }
    @Test
    public void getInItemMaterialTest(){
        String itemID = "AAAABBBBCCCCDDDE";
        List<Material> mats = ItemDAOImpl.getListMaterialsByItemID(itemID);
        Assert.assertNotNull(mats);
    }
    @Test
    public void setFromItemMaterialTest(){
        String itemID = "AAAABBBBCCCCDDDE";
        item = ItemDAOImpl.getItem(itemID);
        List<Material> mats = ItemDAOImpl.getListMaterialsByItemID(itemID);
        int size = mats.size();
        item.setListMaterials(mats);
        ItemDAOImpl.addItemMaterials(item);
        mats = ItemDAOImpl.getListMaterialsByItemID(itemID);
        Assert.assertEquals(size*2,mats.size());
    }
    @After
    public void tearDown() {
    }
}
