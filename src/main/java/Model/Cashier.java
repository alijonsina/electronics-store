package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.time.LocalDate;

public class Cashier extends User{

    private static final long serialVersionUID = 4L;
    private transient IntegerProperty nrOfBill;
    private transient StringProperty sectorCode;

    public Cashier(String username, String password, String name, String surname, LocalDate dateOfBirth, int phoneNr, String email, int salary, String lvlOfAccess, int nrOfBill, String sectorCode) {
        super(username, password, name, surname, dateOfBirth, phoneNr, email, salary, lvlOfAccess);
        this.nrOfBill = new SimpleIntegerProperty(nrOfBill);
        this.sectorCode = new SimpleStringProperty(sectorCode);
    }

    public int getNrOfBill() {return nrOfBill.get();}
    public void setNrOfBill(int nrOfBill) {this.nrOfBill.set(nrOfBill);}
    public String getSectorCode() {return sectorCode.get();}
    public void setSectorCode(String sectorCode) {this.sectorCode.set(sectorCode);}

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject(); // Serialize superclass fields
        outputStream.writeInt(this.nrOfBill.get());
        outputStream.writeUTF(this.sectorCode.getValueSafe());
    }

    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject(); // Deserialize superclass fields
        this.sectorCode = new SimpleStringProperty(inputStream.readUTF());
        this.nrOfBill = new SimpleIntegerProperty(inputStream.readInt());
    }
}