package Model;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 4L;

    private String name;
    private int itemID;
    private int cost;
    private int retailPrice;
    private int sectorCode;
    private int sid;
    private int nrOfStock;

    public Item(String name, int itemID, int cost, int retailPrice, int sectorCode, int sid) {
        this.name = name;
        this.itemID = itemID;
        this.cost = cost;
        this.retailPrice = retailPrice;
        this.sectorCode = sectorCode;
        this.sid = sid;
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
    public int getSId() {return sid;}
    public void setSId(int sid) {this.sid = sid;}
    public int getNrOfStock() {return nrOfStock;}
    public void setNrOfStock(int nrOfStock) {this.nrOfStock = nrOfStock;}
}
