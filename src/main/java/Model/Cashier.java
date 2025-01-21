package Model;

import java.util.Date;

public class Cashier extends User{

    private static final long serialVersionUID = 4L;
    private int nrOfBill;
    private String sectorCode;
    private Bill[] bill;

    public Cashier(String username, String password, String name, String surname, Date dateOfBirth, int phoneNr, String email, int salary, String lvlOfAccess, int nrOfBill, String sectorCode, Bill[] bill) {
        super(username, password, name, surname, dateOfBirth, phoneNr, email, salary, lvlOfAccess);
        this.nrOfBill = nrOfBill;
        this.sectorCode = sectorCode;
        this.bill = bill;
    }

    public int getNrOfBill() {return nrOfBill;}
    public void setNrOfBill(int nrOfBill) {this.nrOfBill = nrOfBill;}
    public String getSectorCode() {return sectorCode;}
    public void setSectorCode(String sectorCode) {this.sectorCode = sectorCode;}
    public Bill[] getBill() {return bill;}
    public void setBill(Bill[] bill) {this.bill = bill;}
}