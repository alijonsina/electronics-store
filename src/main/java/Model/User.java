package Model;


import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient StringProperty username;
    private transient StringProperty password;
    private transient StringProperty name;
    private transient StringProperty surname;
    private transient ObjectProperty<LocalDate> dateOfBirth;
    private transient IntegerProperty phoneNr;
    private transient StringProperty email;
    private transient StringProperty salary;
    private transient StringProperty lvlOfAccess;



    // Constructor

    public User(String username, String password, String name, String surname, LocalDate dateOfBirth, 

                int phoneNr, String email, String salary, String lvlOfAccess) {

        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.phoneNr = new SimpleIntegerProperty(phoneNr);
        this.email = new SimpleStringProperty(email);
        this.salary = new SimpleStringProperty(salary);
        this.lvlOfAccess = new SimpleStringProperty(lvlOfAccess);

    }



    // Getters and Setters

    public String getUsername() {return username.get();}
    public void setUsername(String username) {this.username.set(username);}
    public StringProperty usernameProperty() {return username;}
    
    public String getPassword() {return password.get();}
    public void setPassword(String password) {this.password.set(password);}
    public StringProperty passwordProperty() {return password;}
    
    
    public String getName() {return name.get();}
    public void setName(String name) {this.name.set(name);}
    public StringProperty nameProperty() {return name;}



    public String getSurname() {return surname.get();}
    public void setSurname(String surname) {this.surname.set(surname);}
    public StringProperty surnameProperty() {return surname;}



    public LocalDate getDateOfBirth() {return dateOfBirth.get();}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth.set(dateOfBirth);}
    public ObjectProperty<LocalDate> dateOfBirthProperty() {return dateOfBirth;}



    public int getPhoneNr() {return phoneNr.get();}
    public void setPhoneNr(int phoneNr) {this.phoneNr.set(phoneNr);}
    public IntegerProperty phoneNrProperty() {return phoneNr;}



    public String getEmail() {return email.get();}
    public void setEmail(String email) {this.email.set(email);}
    public StringProperty emailProperty() {return email;}



    public String getSalary() {return salary.get();}
    public void setSalary(String salary) {this.salary.set(salary);}
    public StringProperty salaryProperty() {return salary;}



    public String getLvlOfAccess() {return lvlOfAccess.get();}
    public void setLvlOfAccess(String lvlOfAccess) {this.lvlOfAccess.set(lvlOfAccess);}
    public StringProperty lvlOfAccessProperty() {return lvlOfAccess;}

    
}