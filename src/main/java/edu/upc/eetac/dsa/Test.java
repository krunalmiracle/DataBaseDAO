package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.orm.model.Item;
import edu.upc.eetac.dsa.orm.model.Material;

import java.util.LinkedList;
import java.util.List;

public class Test {
        private String name;
        private double aDouble;
        private int anInt;
        private boolean aBoolean;
        private List<Material> listName;

        public Test(){
            this.name = "22";
            this.aDouble = 22.00345;
            this.aBoolean = true;
            this.anInt = 3;
            listName = new LinkedList<Material>();
            listName.add(new Material("001","wood","Madera",1));
            listName.add(new Material("002","iron","Hierro",5));
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Material> getListName() {
            return listName;
        }

        public void setListName(List<Material> listName) {
            this.listName = listName;
        }
        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }

        public boolean isaBoolean() {
            return aBoolean;
        }

        public void setaBoolean(boolean aBoolean) {
            this.aBoolean = aBoolean;
        }
        public double getaDouble() {
            return aDouble;
        }

        public void setaDouble(double aDouble) {
            this.aDouble = aDouble;
        }
}
