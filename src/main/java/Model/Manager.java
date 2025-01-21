package Model;


import java.util.Date;

public class Manager extends User {


    private static final long serialVersionUID = 3L;
    private Sector[] sectors;
    public Manager(String username, String password, String name, String surname, Date dateOfBirth, int phoneNr, String email, int salary, String lvlOfAccess, Sector[] sectors) {
        super(username, password, name, surname, dateOfBirth, phoneNr, email, salary, lvlOfAccess);
        this.sectors = sectors;
    }
}