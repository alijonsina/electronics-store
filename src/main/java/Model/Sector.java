package Model;

import java.io.Serializable;

public class Sector implements Serializable {
    private static final long serialVersionUID = 6L;

    private String sectorName;
    private int sectorCode;
    private Cashier[] cashiers;
    private Item[] sectorItems;
    private int[] nrOfItems;

    public Sector(String sectorName, int sectorCode, Cashier[] cashiers, Item[] sectorItems, int[] nrOfItems) {
        this.sectorName = sectorName;
        this.sectorCode = sectorCode;
        this.cashiers = cashiers;
        this.sectorItems = sectorItems;
        this.nrOfItems = nrOfItems;
    }

    public String getSectorName() {return sectorName;}
    public void setSectorName(String sectorName) {this.sectorName = sectorName;}
    public int getSectorCode() {return sectorCode;}
    public void setSectorCode(int sectorCode) {this.sectorCode = sectorCode;}
    public Cashier[] getCashiers() {return cashiers;}
    public void setCashiers(Cashier[] cashiers) {this.cashiers = cashiers;}
    public Item[] getSectorItems() {return sectorItems;}
    public void setSectorItems(Item[] sectorItems) {this.sectorItems = sectorItems;}
    public int[] getNrOfItems() {return nrOfItems;}
    public void setNrOfItems(int[] nrOfItems) {this.nrOfItems = nrOfItems;}
}