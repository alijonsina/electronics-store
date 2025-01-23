package DataAccessObject;

import Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileAccess {

    private static final String FILE_NAME = "UserData.dat";

    // Method to create a new user file with an empty user list
    public void createNewUserFile() {
        File file = new File(FILE_NAME);
        try {
            if (file.exists() && !file.delete()) {
                System.out.println("Unable to delete corrupted file.");
                return;
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(new ArrayList<User>()); // Initialize with an empty user list
                System.out.println("New user file created.");
            }
        } catch (IOException e) {
            System.err.println("Error while creating new user file: " + e.getMessage());
        }
    }

    // Method to add a user
    public void addUser(User user) throws IOException, ClassNotFoundException {

        List<User> users = readUsers();
        if (users == null) {
            users = new ArrayList<>();
            users.add(user);
            writeUsers(users);
        } else {
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername())) {
                    System.out.println("User already exists: " + user.getUsername());
                    return;
                }
            }
            users.add(user);
            System.out.println(users.size());
            writeUsers(users);
            System.out.println("User added: " + user.getUsername());

        }
    }
    // Method to change a user's password
    public String changePassword(String username, String newPassword) {
        try {
            List<User> users = readUsers();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    user.setPassword(newPassword);
                    writeUsers(users);
                    return "Password changed successfully.";
                }
            }
            return "User not found.";
        } catch (IOException | ClassNotFoundException e) {
            return "Error while changing password: " + e.getMessage();
        }
    }

    // Method to delete a user
    public void deleteUser(String username) {
        try {
            List<User> users = readUsers();
            boolean removed = users.removeIf(user -> user.getUsername().equals(username));
            if (removed) {
                writeUsers(users);
                System.out.println("User deleted: " + username);
            } else {
                System.out.println("User not found: " + username);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while deleting user: " + e.getMessage());
        }
    }

    // Method to modify a user's properties
    public void modifyUser(User user) {
        try {
            List<User> users = readUsers();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(user.getUsername())) {
                    users.set(i, user);
                    writeUsers(users);
                    System.out.println("User modified: " + user.getUsername());
                    return;
                }
            }
            System.out.println("User not found: " + user.getUsername());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while modifying user: " + e.getMessage());
        }
    }

    // Method to verify login credentials
    public String confirmLogIn(String userType, String username, String password) {
        try {
            List<User> users = readUsers();
            System.out.println("reading users");
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).getLvlOfAccess() + " " + users.get(i).getUsername() + " " + users.get(i).getPassword());
                System.out.println(username + password + userType);
                if (users.get(i).getUsername().equals(username) && users.get(i).getLvlOfAccess().equals(userType)) {
                    System.out.println("user and usertype comparison works");
                    if (users.get(i).getPassword().equals(password)) {
                        return "Login Authorized";
                    } else {
                        return "Incorrect Password";
                    }
                }
            }
            return "User does not exist";
        } catch (IOException | ClassNotFoundException e) {
            return "Error during login: " + e.getMessage();
        }
    }

    // Method to retrieve user information
    public User viewUserInfo(String username) {
        try {
            List<User> users = readUsers();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            System.out.println("User not found: " + username);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while viewing user info: " + e.getMessage());
        }
        return null;
    }

    // Helper method to read users from the binary file
    private List<User> readUsers() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);


        if (!file.exists() || file.length() == 0) {
            createNewUserFile();
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        } catch (InvalidClassException | EOFException e) {
            System.out.println("File is corrupted or incompatible. Recreating file...");
            return new ArrayList<>();
        }
    }

    // Helper method to write users to the binary file
    private void writeUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }
}