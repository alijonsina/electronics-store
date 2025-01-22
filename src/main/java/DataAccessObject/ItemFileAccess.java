
package DataAccessObject;

import java.io.*;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Item;

public class ItemFileAccess {

    public static final String FILE_PATH = "items.dat";
    private static final File DATA_FILE = new File(FILE_PATH);

    private final ObservableList<Item> items = FXCollections.observableArrayList();

    public ItemFileAccess() {
        initializeFile();
    }

    private void initializeFile() {
        if (!DATA_FILE.exists()) {
            try {
                DATA_FILE.createNewFile();
            } catch (IOException ex) {
                System.out.println("Failed to initialize data file: " + ex.getMessage());
            }
        }
    }

    public ObservableList<Item> getAll() {
        if (items.isEmpty()) {
            loadItemsFromFile();
        }
        return items;
    }

    private void loadItemsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            while (true) {
                Item item = (Item) inputStream.readObject();
                items.add(item);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error loading items: " + ex.getMessage());
        }
    }

    public boolean create(Item item) {
        try (FileOutputStream fos = new FileOutputStream(DATA_FILE, true)) {
            ObjectOutputStream oos = (DATA_FILE.length() == 0)
                    ? new ObjectOutputStream(fos)
                    : new HeaderlessObjectOutputStream(fos);
            oos.writeObject(item);
            items.add(item);
            return true;
        } catch (IOException ex) {
            System.out.println("Error creating item: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteAll(List<Item> itemsToRemove) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Item item : items) {
                if (!itemsToRemove.contains(item)) {
                    outputStream.writeObject(item);
                }
            }
            items.removeAll(itemsToRemove);
            return true;
        } catch (IOException ex) {
            System.out.println("Error deleting items: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateAll() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Item item : items) {
                outputStream.writeObject(item);
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Error updating items: " + ex.getMessage());
            return false;
        }
    }
}
