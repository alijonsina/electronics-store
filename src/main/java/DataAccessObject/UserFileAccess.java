package DataAccessObject;

import java.io.*;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileAccess {

    private static final String FILE_NAME = "UserData.dat";

    // Method to create a new user file
    public void createNewUserFile() throws IOException, ClassNotFoundException {
        File file = new File("users.ser");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ois.readObject(); // Test deserialization
            } catch (InvalidClassException e) {
                System.out.println("Serialized file incompatible. Recreating...");
                file.delete(); // Delete the incompatible file
            }
        }
        if (!file.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(new ArrayList<User>()); // Create an empty user list
            }
        }
    }

    // Method to add a user
    public void addUser(User user) throws IOException, ClassNotFoundException {
        List<User> users = readUsers();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                System.out.println("User already exists.");  // display a message in model layer
                return;
            }
        }
        users.add(user);
        writeUsers(users);
        System.out.println("User added: " + user);  // user added successfully in model
    }

    // Method to change a user's password
    public void changePassword(String username, String newPassword) throws IOException, ClassNotFoundException {
        List<User> users = readUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                writeUsers(users);
                System.out.println("Password updated for user: " + username);
                return;
            }
        }
        System.out.println("User not found: " + username);
    }

    // Method to delete a user
    public void deleteUser(String username) throws IOException, ClassNotFoundException {
        List<User> users = readUsers();
        boolean removed = users.removeIf(user -> user.getUsername().equals(username));
        if (removed) {
            writeUsers(users);
            System.out.println("User deleted: " + username);
        } else {
            System.out.println("User not found: " + username);
        }
    }

    // Method to modify a user's properties
    public void modifyUser(User user) throws IOException, ClassNotFoundException {
        List<User> users = readUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                writeUsers(users);
                return;
            }
        }
    }


    // Helper method to read users from the binary file
    public List<User> readUsers() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        }
    }

    // Helper method to write users to the binary file
    public void writeUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }

    public String confirmLogIn(String userType, String username, String password) throws IOException, ClassNotFoundException {
        List<User> users = readUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getLvlOfAccess().equals(userType)) {
                if (users.get(i).getPassword().equals(password)) {
                    return "Login Authorized";
                } else {
                    return "Incorrect Password";
                }
            }
        }
        return "User does not exist";
    }

    public User viewUserInfo(String username) throws IOException, ClassNotFoundException {
        List<User> users = readUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }
}