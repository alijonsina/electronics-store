package Model;

import java.time.LocalDate;

public class Manager extends User {

    private static final long serialVersionUID = 3L;
    private Sector[] sectors;

    public Manager(String username, String password, String name, String surname, LocalDate dateOfBirth, 
                   int phoneNr, String email, String salary, String lvlOfAccess, Sector[] sectors) {
        super(username, password, name, surname, dateOfBirth, phoneNr, email, salary, lvlOfAccess);
        this.sectors = sectors;
    }
}
