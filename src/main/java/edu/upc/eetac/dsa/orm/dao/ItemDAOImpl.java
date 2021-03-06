package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.FactorySession;
import edu.upc.eetac.dsa.orm.Session;
import edu.upc.eetac.dsa.orm.model.Item;
import edu.upc.eetac.dsa.orm.model.Material;
import org.apache.log4j.Logger;

import java.util.List;

public class ItemDAOImpl implements IItemDAO{
    static final Logger logger = Logger.getLogger(ItemDAOImpl.class);
    @Override
    public String addItem(String parentID, String name, String type, String rarity, String description, int offense, int defense) {
        Item item = new Item(parentID,name,type,rarity,description,null,offense,defense);
        Session session = null; String ID = "";
        try {
            session = FactorySession.openSession();
            ID = session.save(item);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return ID;
    }
    public String addItemMaterials(Item item) {
        Session session = null; String ID = "";
        try {
            session = FactorySession.openSession();
             session.saveList(item);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return ID;
    }
    @Override
    public Item getItem(String itemID) {
        Session session = null;
        Item item = null;
        try {
            session = FactorySession.openSession();
            item = (Item) session.get(Item.class, itemID);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return item;
    }

    @Override
    public void updateItem(String parentID, String name, String type, String rarity, String description, int offense, int defense) {
        Session session = null;
        Item item = null;
        item = new Item(parentID,name,type,rarity,description,null,offense,defense);
        try {
            session = FactorySession.openSession();
            //TODO MAKE UPDATE FUNCTION ALIVE
            //session.update(item);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteItem(String itemID) {
        Session session = null;
        Item item = null;
        try {
            session = FactorySession.openSession();
            //TODO MAKE DELETE FUNCTION ALIVE
            //session.update(item);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<Item> getListItems() {
        Session session = null;
        List<Item> listMaterials = null;
        Item item = null;
        try {
            session = FactorySession.openSession();
            listMaterials =(List) session.findAll(Item.class);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return listMaterials;
    }

    @Override
    public List<Material> getListMaterialsByItemID(String itemID) {
        Session session = null;
        List<Material> listMaterials = null;
        Item item = null;
        try {
            session = FactorySession.openSession();
            listMaterials =(List) session.getList(Material.class, itemID);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return listMaterials;
    }
}
