package DataAccessObject;


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
import Model.Bill;
import Model.Item;

public class BillFileAccess {

    public static final String FILE_PATH = "bills.dat";
    private static final File DATA_FILE = new File(FILE_PATH);

    private final ObservableList<Bill> bills = FXCollections.observableArrayList();

    public ObservableList<Bill> getAll() {
        if (bills.isEmpty()) {
            loadBillsFromFile();
        }
        return bills;
    }


    private void loadBillsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            while (true) {
                Bill bill = (Bill) inputStream.readObject();
                bills.add(bill);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException ex) {
            // log to a file
            System.out.println(ex.getMessage());
        }
    }

    public boolean AddBillToFile(Bill bill) {

        // FileOutputStream is an append mode -> true flag
        try (FileOutputStream outputStream = new FileOutputStream(DATA_FILE, true)) {

            ObjectOutputStream writer;

            // uses an ObjectOutputStream to serialize the country object
            // and append it to the file.
            if (DATA_FILE.length() > 0) {
                writer = new HeaderlessObjectOutputStream(outputStream); // optional
            } else {
                writer = new ObjectOutputStream(outputStream);
            }

            writer.writeObject(bill);

            bills.add(bill);

            return true;

        } catch (IOException ex) {
            return false;
        }

    }

}