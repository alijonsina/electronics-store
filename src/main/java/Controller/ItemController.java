package Controller;

import dao.ItemDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import View.ItemView;
import Model.Item;

//the controller class that interacts with the model (data) and the view (UI).
//it manages the user actions and updates the view or model accordingly.
public class ItemController {

	// the UI
	private final ItemView view;

	// called in the main to show the UI view
	public ItemView getView() {
		return view;
	}

	// the data access layer
	private final ItemDAO itemDAO;

	// constructor
	public ItemController() {
		// initializes objects
		this.view = new ItemView();
		itemDAO = new ItemDAO();

		// Load data into the table view from -itemDAO.getAll()
		this.view.getTableView().setItems(itemDAO.getAll());

		// Set an action for the Add button
		// The onItemAdd method is executed when the “Add” button is clicked.
		this.view.getBtnAdd().setOnAction(e -> onItemAdd());

		// Set an action for the Delete button
		this.view.getBtnDelete().setOnAction(event -> onItemDelete(event));

		// responsible for setting up listeners
		// for editing the data directly in the table view.
		setEditListeners();
		setSearchListener();
	}

	// The TableView columns are editable, and each column has a listener
	// that updates the corresponding field in the item object when a cell edit
	// is committed.
	private void setEditListeners() {

		// For each editable column the listener updates
		// the respective attribute in the item object
		this.view.getItemIDColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setItemID(e.getNewValue());
		});
		this.view.getNameColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setName(e.getNewValue());
		});
		this.view.getCostColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setCost(e.getNewValue());
		});
		this.view.getRetailPriceColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setRetailPrice(e.getNewValue());
		});
		this.view.getSectorCodeColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setSectorCode(e.getNewValue());
		});
		this.view.getSIDColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setSID(e.getNewValue());
		});
		this.view.getNrOfStockColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setNrOfStock(e.getNewValue());
		});


		// The “Update” button triggers an update to the data using the updateAll()
		// method in the DAO. If the update is successful, a message is printed to the
		// console.
		this.view.getBtnUpdate().setOnAction(e -> {
			if (this.itemDAO.updateAll()) {
				System.out.println("content updated");
			} else {
				System.out.println("update failed");
			}
		});
	}

	// when delete button is clicked
	private void onItemDelete(ActionEvent event) {

		ObservableList<Item> selectedItems = this.view.getTableView().getSelectionModel().getSelectedItems();
		Alert alert;

		if (itemDAO.deleteAll(selectedItems)) {
			alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Deleted successfully");
			System.out.println("Deleted successfully");
		} else {
			alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Deletion failed");
		}

		alert.setTitle("Delete result");
		alert.show();
	}

	// when add button is clicked
	private void onItemAdd() {

		

		int itemID = Integer.parseInt(this.view.getTfItemID().getText());
		String name = this.view.getTfName().getText();
		int cost = Integer.parseInt(this.view.getTfCost().getText());
		int retailPrice = Integer.parseInt(this.view.getTfRetailPrice().getText());
		int sectorCode = Integer.parseInt(this.view.getTfSectorCode().getText());
		int sID = Integer.parseInt(this.view.getTfSID().getText());
		int nrOfStock = Integer.parseInt(this.view.getTfNrOfStock().getText());
		
		Item item = new Item(itemID, name, cost, retailPrice, sectorCode, sID, nrOfStock);

		// The create() method in the DAO is called to
		// save the new Item object in the data source.

		if (itemDAO.create(item)) {
			System.out.println("Saved successfully");

			// If the item is successfully added, the input fields are cleared.

			this.view.getTfItemID().clear();
			this.view.getTfName().clear();
			this.view.getTfCost().clear();
			this.view.getTfRetailPrice().clear();
			this.view.getTfSectorCode().clear();
			this.view.getTfSID().clear();
			this.view.getTfNrOfStock().clear();
			
		} else {
			System.out.println("Item creation failed");
		}
	}

	// logic for search button

	private void setSearchListener() {
		this.view.getBtnSearch().setOnAction(e -> onSearchItem()); // Now using the getter
	}

	private void onSearchItem() {

		// Get search text and convert it to lowercase
		String searchQuery = this.view.getTfSearch().getText().toLowerCase();

		ObservableList<Item> filteredItems = FXCollections.observableArrayList();

		for (Item item : itemDAO.getAll()) {
			if (item.getName().toLowerCase().contains(searchQuery)) {
				filteredItems.add(item);
			}
		}

		this.view.getTableView().setItems(filteredItems);
	}

}
