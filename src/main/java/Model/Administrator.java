package Model;

import java.time.LocalDate;

public class Administrator extends User {

    private static final long serialVersionUID = 1L;

    public Administrator(String username, String password, String name, String surname, LocalDate dateOfBirth,
                         int phoneNr, String email, String salary, String lvlOfAccess) {
        super(username, password, name, surname, dateOfBirth, phoneNr, email, salary, lvlOfAccess);
    }
}
