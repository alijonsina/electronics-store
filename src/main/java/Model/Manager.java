package Model;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.time.LocalDate;

public class Manager extends User {


    private static final long serialVersionUID = 3L;
    public Manager(String username, String password, String name, String surname, LocalDate dateOfBirth, int phoneNr, String email, int salary, String lvlOfAccess) {
        super(username, password, name, surname, dateOfBirth, phoneNr, email, salary, lvlOfAccess);
    }

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject(); // Serialize superclass fields
    }

    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject(); // Deserialize superclass fields
    }

}