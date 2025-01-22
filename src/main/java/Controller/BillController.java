package Controller;

import dao.ItemDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import View.BillView;
import Model.Item;
import Controller.ItemController;
import dao.ItemDAO;

//the controller class that interacts with the model (data) and the view (UI).
//it manages the user actions and updates the view or model accordingly.
public class BillController {

	
	private final ObservableList<Item> ItemBill = FXCollections.observableArrayList(); 
	// the UI
	private final BillView view;

	// called in the main to show the UI view
	public BillView getView() {
		return view;
	}

	
	private final ItemDAO itemDAO;

	
	public BillController() {
		

		this.view = new BillView();
		itemDAO = new ItemDAO();


		this.view.getTableView().setItems(itemDAO.getAll());
		this.view.getTableView().setItems(ItemBill);
		

			
        view.getBtnAdd().setOnAction(e -> onAddToBill());
        view.getbtnRemove().setOnAction(e -> onRemoveFromBill());
        view.getBtnClose().setOnAction(e -> onCloseBill());
        view.getBtnShow().setOnAction(e -> onShowBill());
		
		setEditListeners();
		setSearchListener();	
		}
	
	private void setEditListeners() {

		// For each editable column the listener updates
		// the respective attribute in the item object
		this.view.getItemIDColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setItemID(e.getNewValue());
		});
		this.view.getNameColumn().setOnEditCommit(e -> {
			itemDAO.getAll().get(e.getTablePosition().getRow()).setName(e.getNewValue());
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
		//this.view.getBtnUpdate().setOnAction(e -> {
			//if (this.itemDAO.updateAll()) {
				//System.out.println("content updated");
			//} else {
			//	System.out.println("update failed");
			//}
		//});
	}	
		
    private void onAddToBill() {
       ObservableList<Item> selectedItems = view.getTableView().getSelectionModel().getSelectedItems();
       Alert showAlert = new Alert(Alert.AlertType.WARNING);
       
        if (ItemBill.isEmpty()) {
            showAlert.setContentText("No Selection \n Please select an item to remove from the bill.");
            return;
        }
        for (Item item : selectedItems) {
            if (!ItemBill.contains(item)) {
            	ItemBill.add(item);
            }
        }
        view.getBillView().refresh();
    }

    private void onRemoveFromBill() {
        ObservableList<Item> selectedItems = view.getBillView().getSelectionModel().getSelectedItems();
        Alert showAlert = new Alert(Alert.AlertType.WARNING) ;
        
        if (ItemBill.isEmpty()) {
        	showAlert.setContentText("No Selection \n Please select an item to remove from the bill.");
            return;
        }
        ItemBill.removeAll(selectedItems);
        view.getBillView().refresh();
    }

    private void onCloseBill() {
        Alert showAlert = new Alert(Alert.AlertType.WARNING);
        
        //Bill consrtuctor to be added
        //Bill bill = new Bill();
        int total = 0;
        
        if (ItemBill.isEmpty()) {
        	showAlert.setContentText("No Selection \n Please select an item to remove from the bill.");
            return;
        }

        for(Item item : ItemBill)
        {
        	Item T_Item = new Item();
        	T_Item = item;
        	
        	total = (T_Item.getRetailPrice()*T_Item.getQuantity())+total;
        } 
        //bill method to be implemented
        //total = bill.setTotal();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close Bill");
        alert.setHeaderText("Total Amount: " + total);
        alert.setContentText("Do you want to finalize the bill?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            ItemBill.clear();
            view.getBillView().refresh();
        }
    }

    private void onShowBill() {
        
    	Alert showAlert = new Alert(Alert.AlertType.WARNING);
    	if (ItemBill.isEmpty()) {
    		showAlert.setContentText("No Selection \n Please select an item to remove from the bill.");
            return;
        }

        StringBuilder billDetails = new StringBuilder("Bill Details:\n");
        for (Item item : ItemBill) {
            billDetails.append(item.getName())
                .append(" - Quantity: ")
                .append(item.getQuantity())
                .append(" - Price: ")
                .append(item.getRetailPrice())
                .append("\n");
        }

        //showAlert("Bill Details", billDetails.toString(), Alert.AlertType.INFORMATION);
    }

    
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

