package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.model.Material;

import java.util.List;

public interface IMaterialDAO {
    int addMaterial(String ID, String name, String description, int quantity);
    Material getMaterial();
    void updateMaterial(String materialID);
    void deleteMaterial(String materialID);
    List<Material> getAllMaterials();
}
