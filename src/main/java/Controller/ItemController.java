package Controller;

import DataAccessObject.ItemFileAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import View.ItemView;
import Model.Item;

import java.io.IOException;

// Controller class for managing items
public class ItemController {

    private final ItemView view;
    private String username;

    public ItemView getView() {
        return view;
    }

    private final ItemFileAccess itemDAO;

    public ItemController(String username) {
        this.username = username;
        this.view = new ItemView();
        this.itemDAO = new ItemFileAccess();

        this.view.getTableView().setItems(itemDAO.getAll());

        this.view.getBtnAdd().setOnAction(e -> onItemAdd());
        this.view.getBtnDelete().setOnAction(this::onItemDelete);
        this.view.getBtnUpdate().setOnAction(e -> onItemUpdate());
        this.view.getBtnSearch().setOnAction(e -> onSearchItem());
        this.view.getBtnBack().setOnAction(e -> onBackButtonPressed());

        setEditListeners();
    }

    private void setEditListeners() {
        this.view.getItemIDColumn().setOnEditCommit(e -> {
            try {
                e.getRowValue().setItemID(Integer.parseInt(e.getNewValue().toString()));
                itemDAO.updateAll();
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Item ID must be a number.");
                view.getTableView().refresh();
            }
        });

        // Other edit listeners...
    }

    private void onItemAdd() {
        try {
            int itemID = Integer.parseInt(view.getTfItemID().getText());
            String name = view.getTfName().getText();
            int cost = Integer.parseInt(view.getTfCost().getText());
            int retailPrice = Integer.parseInt(view.getTfRetailPrice().getText());
            int sectorCode = Integer.parseInt(view.getTfSectorCode().getText());
            int sID = Integer.parseInt(view.getTfSID().getText());
            int quantity = Integer.parseInt(view.getTfNrOfStock().getText());

            Item item = new Item(itemID, name, cost, retailPrice, sectorCode, sID, quantity);

            if (itemDAO.create(item)) {
                showAlert("Success", "Item added successfully.");
                clearInputFields();
                view.getTableView().setItems(itemDAO.getAll());
            } else {
                showAlert("Error", "Failed to add item.");
            }
        } catch (NumberFormatException ex) {
            showAlert("Invalid Input", "Ensure all numeric fields contain valid numbers.");
        }
    }

    private void clearInputFields() {
        view.getTfItemID().clear();
        view.getTfName().clear();
        view.getTfCost().clear();
        view.getTfRetailPrice().clear();
        view.getTfSectorCode().clear();
        view.getTfSID().clear();
        view.getTfNrOfStock().clear();
    }

    private void onItemDelete(ActionEvent event) {
        ObservableList<Item> selectedItems = view.getTableView().getSelectionModel().getSelectedItems();
        if (itemDAO.deleteAll(selectedItems)) {
            showAlert("Success", "Selected items deleted.");
            view.getTableView().setItems(itemDAO.getAll());
        } else {
            showAlert("Error", "Failed to delete selected items.");
        }
    }

    private void onItemUpdate() {
        if (itemDAO.updateAll()) {
            showAlert("Success", "Items updated successfully.");
        } else {
            showAlert("Error", "Failed to update items.");
        }
    }

    private void onSearchItem() {
        String searchQuery = view.getTfSearch().getText().toLowerCase();
        ObservableList<Item> filteredItems = FXCollections.observableArrayList();
        for (Item item : itemDAO.getAll()) {
            if (item.getName().toLowerCase().contains(searchQuery)) {
                filteredItems.add(item);
            }
        }
        view.getTableView().setItems(filteredItems);
    }

    private void onBackButtonPressed() {
        try {
            PageNavigation.showManagerMenuView(username);
        } catch (IOException | ClassNotFoundException ex) {
            showAlert("Error", "Failed to navigate back.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
