package Model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bill implements Serializable {
    private static final long serialVersionUID = 6L;

    private int billID;
    private transient LocalDate billDate; // Transient to exclude from default serialization
    private transient int[] NrOfItem; // Transient to exclude from default serialization
    private int totalPrice;
    private transient Item[] item; // Transient to exclude from default serialization

    public Bill(int billID, LocalDate billDate, int[] NrOfItem, int totalPrice, Item[] item) {
        this.billID = billID;
        this.billDate = billDate;
        this.NrOfItem = NrOfItem;
        this.totalPrice = totalPrice;
        this.item = item;
    }

    public Bill() {
    	
    }
    
    public int getBillID() { return billID; }
    public void setBillID(int billID) { this.billID = billID; }

    public LocalDate getBillDate() { return billDate; }
    public void setBillDate(LocalDate billDate) { this.billDate = billDate; }

    public int[] getNrOfItem() { return NrOfItem; }
    public void setNrOfItem(int[] NrOfItem) { this.NrOfItem = NrOfItem; }

    public int getTotalPrice() { return totalPrice; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }

    public Item[] getItem() { return item; }
    public void setItem(Item[] item) { this.item = item; }

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        // Default write of non-transient fields
        outputStream.defaultWriteObject();

        // Write LocalDate as a string using a formatter for LocalDate
        outputStream.writeUTF(billDate.format(DateTimeFormatter.ISO_LOCAL_DATE));

        // Write other fields
        outputStream.writeInt(this.billID);
        outputStream.writeInt(this.totalPrice);

        // Serialize the Item array
        if (item != null) {
            outputStream.writeInt(item.length);
            for (Item i : item) {
                outputStream.writeObject(i);
            }
        } else {
            outputStream.writeInt(0); // No items
        }
    }


    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        // Default read of non-transient fields
        inputStream.defaultReadObject();

        // Read and convert LocalDate from String using the correct formatter
        String billDateString = inputStream.readUTF();
        this.billDate = LocalDate.parse(billDateString, DateTimeFormatter.ISO_LOCAL_DATE);

        // Read other fields
        this.billID = inputStream.readInt();
        this.totalPrice = inputStream.readInt();

        // Deserialize the Item array
        int itemCount = inputStream.readInt();
        this.item = new Item[itemCount];
        for (int i = 0; i < itemCount; i++) {
            this.item[i] = (Item) inputStream.readObject();
        }
    }


    @Override
    public String toString() {
        return "Bill ID: " + billID + ", Date: " + billDate + ", Total Price: " + totalPrice;
    }
}