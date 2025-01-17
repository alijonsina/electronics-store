package Model;

import java.io.Serializable;

public class Supplier implements Serializable {

    private static final long serialVersionUID = 7L;

    public String name;
    public int sID;
    public Item[] typesOfItems;

    public Supplier(String name, int sID, Item[] typesOfItems) {
        this.name = name;
        this.sID = sID;
        this.typesOfItems = typesOfItems;
    }
}