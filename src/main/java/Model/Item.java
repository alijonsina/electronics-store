package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item implements Serializable {

    @Serial
    private static final long serialVersionUID = 5L;

    private transient IntegerProperty itemID;
    private transient StringProperty name;
    private transient IntegerProperty cost;
    private transient IntegerProperty retailPrice;
    private transient IntegerProperty sectorCode;
    private transient IntegerProperty sID;
    private transient IntegerProperty quantity;

    // Updated constructor to include quantity
    public Item(int itemID, String name, int cost, int retailPrice, int sectorCode, int sID, int quantity) {
        this.itemID = new SimpleIntegerProperty(itemID);
        this.name = new SimpleStringProperty(name);
        this.cost = new SimpleIntegerProperty(cost);
        this.retailPrice = new SimpleIntegerProperty(retailPrice);
        this.sectorCode = new SimpleIntegerProperty(sectorCode);
        this.sID = new SimpleIntegerProperty(sID);
        this.quantity = new SimpleIntegerProperty(quantity);
    }


    // Getter and Setter for itemID
    public int getItemID() {
        return itemID.get();
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    // Getter and Setter for name
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    // Getter and Setter for cost
    public int getCost() {
        return cost.get();
    }

    public void setCost(int cost) {
        this.cost.set(cost);
    }

    // Getter and Setter for retailPrice
    public int getRetailPrice() {
        return retailPrice.get();
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice.set(retailPrice);
    }

    // Getter and Setter for sectorCode
    public int getSectorCode() {
        return sectorCode.get();
    }

    public void setSectorCode(int sectorCode) {
        this.sectorCode.set(sectorCode);
    }

    // Getter and Setter for sID
    public int getSID() {
        return sID.get();
    }

    public void setSID(int sID) {
        this.sID.set(sID);
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public IntegerProperty getItemIDProperty() {
        return itemID;
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public IntegerProperty getCostProperty() {
        return cost;
    }

    public IntegerProperty getRetailPriceProperty() {
        return retailPrice;
    }

    public IntegerProperty getSectorCodeProperty() {
        return sectorCode;
    }

    public IntegerProperty getSIDProperty() {
        return sID;
    }

    public IntegerProperty getQuantityProperty() {
        return quantity;
    }

    @Override
    public String toString() {
        return this.name.get();
    }

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(this.itemID.getValue());
        outputStream.writeUTF(this.name.getValueSafe());
        outputStream.writeInt(this.cost.getValue());
        outputStream.writeInt(this.retailPrice.getValue());
        outputStream.writeInt(this.sectorCode.getValue());
        outputStream.writeInt(this.sID.getValue());
        outputStream.writeInt(this.quantity.getValue());  // No more NPE
    }

    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        this.itemID = new SimpleIntegerProperty(inputStream.readInt());
        this.name = new SimpleStringProperty(inputStream.readUTF());
        this.cost = new SimpleIntegerProperty(inputStream.readInt());
        this.retailPrice = new SimpleIntegerProperty(inputStream.readInt());
        this.sectorCode = new SimpleIntegerProperty(inputStream.readInt());
        this.sID = new SimpleIntegerProperty(inputStream.readInt());
        this.quantity = new SimpleIntegerProperty(inputStream.readInt());  // Make sure quantity is properly initialized
    }
}
