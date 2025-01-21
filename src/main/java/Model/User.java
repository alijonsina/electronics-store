package Model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String username;
    private String password;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private int phoneNr;
    private String email;
    private int salary;
    private String lvlOfAccess;
    private static final long serialVersionUID = 1L;


    public User(String username, String password, String name, String surname, Date dateOfBirth, int phoneNr, String email, int salary, String lvlOfAccess) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNr = phoneNr;
        this.email = email;
        this.salary = salary;
        this.lvlOfAccess = lvlOfAccess;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public Date getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public int getPhoneNr() {return phoneNr;}
    public void setPhoneNr(int phoneNr) {this.phoneNr = phoneNr;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}
    public String getLvlOfAccess() {return lvlOfAccess;}
    public void setLvlOfAccess(String lvlOfAccess) {this.lvlOfAccess = lvlOfAccess;}

}