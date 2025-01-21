package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Item;

public class ItemDAO {

	public static final String FILE_PATH = "items.dat";
	private static final File DATA_FILE = new File(FILE_PATH);

	// is observable-> UI components can bind to this list to update automatically
	// when the list changes.
	private final ObservableList<Item> items = FXCollections.observableArrayList();

	public ObservableList<Item> getAll() {
		if (items.isEmpty()) {
			loadCountriesFromFile();
		}
		return items;
	}

	// reads the serialized item objects from the file
	// and adds them to the items list.
	private void loadCountriesFromFile() {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
			while (true) {
				Item item = (Item) inputStream.readObject();
				items.add(item);
			}
		} catch (EOFException ignored) {
		} catch (IOException | ClassNotFoundException ex) {
			// log to a file
			System.out.println(ex.getMessage());
		}
	}

	// creates a new item by writing it to the file
	public boolean create(Item item) {

		// FileOutputStream is an append mode -> true flag
		try (FileOutputStream outputStream = new FileOutputStream(DATA_FILE, true)) {

			ObjectOutputStream writer;

			// uses an ObjectOutputStream to serialize the country object
			// and append it to the file.
			if (DATA_FILE.length() > 0) { // optional
				writer = new HeaderlessObjectOutputStream(outputStream); // optional
			} else {
				writer = new ObjectOutputStream(outputStream);
			}

			// new country is added at the end of the file
			writer.writeObject(item);

			items.add(item);

			return true;

		} catch (IOException ex) {
			return false;
		}
	}

	// It re-writes all countries to the file except the one being deleted
	// and then removes the country from the countries list.
	public boolean delete(Item item) {

		// FileOutputStream is not an append mode
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
			for (Item c : items) {
				if (!c.equals(item)) {
					outputStream.writeObject(c);
				}
			}
			items.remove(item);

			return true;

		} catch (IOException ex) {
			return false;
		}
	}

	// writing all items back to the file except
	// for those in the itemsToRemove list.
	public boolean deleteAll(List<Item> countriesToRemove) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
			for (Item c : items) {
				if (!countriesToRemove.contains(c)) {
					outputStream.writeObject(c);
				}
			}
			items.removeAll(countriesToRemove);
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	// writing all items from the countries list back to the file.
	public boolean updateAll() {

		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
			for (Item c : items) {
				outputStream.writeObject(c);
			}
			return true;
		} catch (IOException ex) {
			return false;
		}
	}
}
