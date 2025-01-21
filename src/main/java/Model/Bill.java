package Model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {
    private static final long serialVersionUID = 6L;

    private int billID;
    private Date billDate;
    private int[] NrOfItem;
    private int totalPrice;
    private Item[] item;

    public Bill(int billID, Date billDate, int[] NrOfItem, int totalPrice, Item[] item) {
        this.billID = billID;
        this.billDate = billDate;
        this.NrOfItem = NrOfItem;
        this.totalPrice = totalPrice;
        this.item = item;
    }

    public int getBillID() {return billID;}
    public void setBillID(int billID) {this.billID = billID;}
    public Date getBillDate() {return billDate;}
    public void setBillDate(Date billDate) {this.billDate = billDate;}
    public int[] getNrOfItem() {return NrOfItem;}
    public void setNrOfItem(int[] NrOfItem) {this.NrOfItem = NrOfItem;}
    public int getTotalPrice() {return totalPrice;}
    public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}
    public Item[] getItem() {return item;}
    public void setItem(Item[] item) {this.item = item;}
}
