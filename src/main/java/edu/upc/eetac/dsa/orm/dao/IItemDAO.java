package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.model.Item;
import edu.upc.eetac.dsa.orm.model.Material;

import java.util.List;

public interface IItemDAO {

    String addItem(String parentID, String name, String type, String rarity, String description, int offense, int defense);
    String addItemMaterials(Item item);
    Item getItem(String itemID);
    void updateItem(String parentID,String name,String type,String rarity, String description,int offense, int defense);
    void deleteItem(String itemID);
    List<Item> getListItems();//getsItems with Zero Material as this are standard items
    List <Material> getListMaterialsByItemID(String itemId);
}
