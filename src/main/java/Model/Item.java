package Model;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 5L;

    private String name;
    private int itemID;
    private int cost;
    private int retailPrice;
    private int sectorCode;
    private int id;

    public Item(String name, int itemID, int cost, int retailPrice, int sectorCode, int id) {
        this.name = name;
        this.itemID = itemID;
        this.cost = cost;
        this.retailPrice = retailPrice;
        this.sectorCode = sectorCode;
        this.id = id;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getItemID() {return itemID;}
    public void setItemID(int itemID) {this.itemID = itemID;}
    public int getCost() {return cost;}
    public void setCost(int cost) {this.cost = cost;}
    public int getRetailPrice() {return retailPrice;}
    public void setRetailPrice(int retailPrice) {this.retailPrice = retailPrice;}
    public int getSectorCode() {return sectorCode;}
    public void setSectorCode(int sectorCode) {this.sectorCode = sectorCode;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
