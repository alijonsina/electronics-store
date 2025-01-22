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
	private static final long serialVersionUID = 1;

	private transient IntegerProperty itemID;
	private transient StringProperty name;
	private transient IntegerProperty cost;
	private transient IntegerProperty retailPrice;
	private transient IntegerProperty sectorCode;
	private transient IntegerProperty sID;
	private transient IntegerProperty nrOfStock;
	private transient IntegerProperty quantity;

	public Item(int itemID, String name, int cost, int retailPrice,  int sectorCode, int sID, int nrOfStock) {
		this.itemID = new SimpleIntegerProperty(itemID);
		this.name = new SimpleStringProperty(name);
		this.cost = new SimpleIntegerProperty(cost);
		this.retailPrice = new SimpleIntegerProperty(retailPrice);
		this.sectorCode = new SimpleIntegerProperty(sectorCode);	
		this.sID = new SimpleIntegerProperty(sID);
		this.nrOfStock = new SimpleIntegerProperty(nrOfStock);
	}
	
	public Item() {
	}

	public int getItemID() {return this.itemID.get();}

	public void setItemID(int itemID) {this.itemID.set(itemID);}

	public String getName() {return this.name.get();}

	public void setName(String name) {this.name.set(name);}


	public int getCost() {return this.cost.get();}

	public void setCost(int cost) {this.cost.set(cost);}
	
	public int getRetailPrice() {return this.retailPrice.get();}

	public void setRetailPrice(int retailPrice) {this.retailPrice.set(retailPrice);}
	
	public int getSectorCode() {return this.sectorCode.get();}

	public void setSectorCode(int sectorCode) {this.sectorCode.set(sectorCode);}
	
	public int getSID() {return this.sID.get();}

	public void setSID(int sID) {this.sID.set(sID);}
	
	public int getNrOfStock() {return this.nrOfStock.get();}

	public void setNrOfStock(int nrOfStock) {this.nrOfStock.set(nrOfStock);}

	public int getQuantity() {return this.quantity.get();}
	
	public void setQuantity(int quantity) {this.quantity.set(quantity);}
	
	@Override
	public String toString() {return this.name.get();}

	@Serial
	private void writeObject(ObjectOutputStream outputStream) throws IOException {
		// defaultWriteObject() writes the non-transient fields
		outputStream.defaultWriteObject();
		outputStream.writeInt(this.itemID.getValue());
		outputStream.writeUTF(this.name.getValueSafe());
		outputStream.writeInt(this.cost.getValue());
		outputStream.writeInt(this.retailPrice.getValue());
		outputStream.writeInt(this.sectorCode.getValue());
		outputStream.writeInt(this.sID.getValue());
		outputStream.writeInt(this.nrOfStock.getValue());
		outputStream.writeInt(this.quantity.getValue());
	}

	@Serial
	// deserializing the object’s state from a stream.
	private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
		// they have to be in the same order as in writeObject
	    this.itemID = new SimpleIntegerProperty(inputStream.readInt());
	    this.name = new SimpleStringProperty(inputStream.readUTF());
	    this.cost = new SimpleIntegerProperty(inputStream.readInt());
	    this.retailPrice = new SimpleIntegerProperty(inputStream.readInt());
	    this.sectorCode = new SimpleIntegerProperty(inputStream.readInt());
	    this.sID = new SimpleIntegerProperty(inputStream.readInt());
	    this.nrOfStock = new SimpleIntegerProperty(inputStream.readInt());
	    this.quantity = new SimpleIntegerProperty(inputStream.readInt());
	}

}
