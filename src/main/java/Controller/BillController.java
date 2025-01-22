package Controller;

import dao.ItemDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import View.BillView;
import Model.Bill;
import Model.Item;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import Controller.ItemController;
import dao.ItemDAO;
import dao.BillDAO;

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
	private final BillDAO billDAO;
	

	
	public BillController() {
		

		this.view = new BillView();
		itemDAO = new ItemDAO();
		billDAO = new BillDAO();


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
       Alert alert = new Alert(Alert.AlertType.WARNING);
       
        if (ItemBill.isEmpty()) {
     	   alert.setTitle("No Selection");
           alert.setHeaderText(null);
           alert.setContentText("Please select an item to add to the bill.");
           alert.showAndWait();
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
    	Alert alert = new Alert(Alert.AlertType.WARNING);
        
        if (ItemBill.isEmpty()) {
        	   alert.setTitle("No Selection");
               alert.setHeaderText(null);
               alert.setContentText("Please select an item to remove from the bill the bill.");
               alert.showAndWait();
            return;
        }
        ItemBill.removeAll(selectedItems);
        view.getBillView().refresh();
    }

    private void onCloseBill() {
    	Alert alert = new Alert(Alert.AlertType.WARNING);
        
        //Bill consrtuctor to be added
        //Bill bill = new Bill();
        int total = 0;
        
        if (ItemBill.isEmpty()) {
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item to add to the bill.");
            alert.showAndWait();
            return;
        }

        // Initialize bill details and total
        StringBuilder billDetails = new StringBuilder("Bill Details:\n");
        billDetails.append("+----------+----------------------+------------+--------+\n");
        billDetails.append("| Quantity | Title                | Unit Price | Total  |\n");
        billDetails.append("+----------+----------------------+------------+--------+\n");
        
        
        
        for(Item item : ItemBill)
        {
        	//Item T_Item = new Item();
        	//T_Item = item;
        	
            int totalItemPrice = item.getRetailPrice() * item.getQuantity();
            total += totalItemPrice;
        	
            item.setNrOfStock(item.getNrOfStock() - item.getQuantity()); // Update stock

            billDetails.append(String.format("| %-8d | %-20s | %-10.2f | %-6.2f |\n",
            		item.getQuantity(), item.getName(), (double) item.getRetailPrice(), (double) totalItemPrice));

        	//total = (T_Item.getRetailPrice()*T_Item.getQuantity())+total;
        	//T_Item.setNrOfStock(T_Item.getNrOfStock()-T_Item.getQuantity());
        } 
        //bill method to be implemented
        //total = bill.setTotal();
        
        billDetails.append("+----------+----------------------+------------+--------+\n");
        billDetails.append(String.format("\nTotal Amount: %.2f\n", (double) total));

        alert.setTitle("Close Bill");
        alert.setHeaderText("Total Amount: " + total);
        alert.setContentText("Do you want to finalize the bill?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
        //    ItemBill.clear();
        //    view.getBillView().refresh();
        	return;
        }
        
        // Generate bill metadata
        Bill bill = new Bill();
        bill.setBillID(generateRandomID());
        bill.setBillDate(LocalDate.now());
        bill.setTotalPrice(total);

        billDetails.append("\nBill ID: ").append(bill.getBillID()).append("\n");
        billDetails.append("Date: ").append(bill.getBillDate()).append("\n");

        
        // Display the bill in a new window
        showBillInNewWindow(billDetails.toString());
        
        billDAO.AddBillToFile(bill);
        
        // Clear the bill and refresh view
        ItemBill.clear();
        view.getBillView().refresh();
        
        
    }
        //bill.setBillID(bill.generateID);
        //bill.setBillDate(bill.generateDate);
        //bill.setTotalPrice(total);
        //billDAO.AddBillToFile(bill);
        //bill.setUsername(wget);
        
        private int generateRandomID() {
            return (int) (Math.random() * 100000);
        }

        private void showBillInNewWindow(String billDetails) {
            Stage stage = new Stage();
            stage.setTitle("Bill Details");

            TextArea textArea = new TextArea(billDetails);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            VBox vbox = new VBox(textArea);
            Scene scene = new Scene(vbox, 500, 400);

            stage.setScene(scene);
            stage.show();
        }
        

    private void onShowBill() {
        
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	if (ItemBill.isEmpty()) {
          
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item to remove from the bill.");
            alert.showAndWait();
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


        alert.setTitle("Bill Details");
        alert.setHeaderText(null);
        alert.setContentText(billDetails.toString());
        alert.showAndWait();
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

