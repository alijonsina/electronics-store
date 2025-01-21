package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import Model.Item;
import javafx.util.converter.IntegerStringConverter;


public class ItemView extends BorderPane {
	// TableView to display list of countries
	private final TableView<Item> tableView = new TableView<>();

	// Columns for the item
	private final TableColumn<Item, Integer> itemIDColumn;
	private final TableColumn<Item, String> nameColumn;
	private final TableColumn<Item, Integer> costColumn;
	private final TableColumn<Item, Integer> retailPriceColumn;
	private final TableColumn<Item, Integer> sectorCodeColumn;
	private final TableColumn<Item, Integer> sIDColumn;
	private final TableColumn<Item, Integer> nrOfStockColumn;


	// Input fields for user to add item data
	private final TextField tfItemID = new TextField();
	private final TextField tfName = new TextField();
	private final TextField tfCost = new TextField();
	private final TextField tfRetailPrice = new TextField();
	private final TextField tfSectorCode = new TextField();
	private final TextField tfSID = new TextField();
	private final TextField tfNrOfStock = new TextField();
	private final TextField tfSearch = new TextField();
	private final Button btnSearch = new Button("Search");

	// *****New ProfileView
	private final Scene profileScene = new Scene(new VBox(new Label("Hello!")), 300, 200);

	// Buttons for adding, deleting, and updating countries
	private final Button btnAdd = new Button("Add");
	private final Button btnDelete = new Button("Delete");
	private final Button btnUpdate = new Button("Update");

	// constructor - when an object is created
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ItemView() {

		// *****MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.setStyle("-fx-background-color: #2196f3;");

		Menu menu = new Menu("Menu");
		menu.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

		MenuItem homeItem = new MenuItem("Table");
		homeItem.setStyle("-fx-text-fill: #2196f3; -fx-font-size: 14px;");
		homeItem.setOnAction(e -> showHomeScene());

		MenuItem profileItem = new MenuItem("Simple Test Profile");
		profileItem.setStyle("-fx-text-fill: #2196f3; -fx-font-size: 14px;");
		profileItem.setOnAction(e -> showProfileScene());

		MenuItem exitItem = new MenuItem("Exit Program");
		exitItem.setStyle("-fx-text-fill: #2196f3; -fx-font-size: 14px;");
		exitItem.setOnAction(e -> System.exit(0));

		menu.getItems().addAll(homeItem, profileItem, exitItem);
		menuBar.getMenus().add(menu);

		// Adding MenuBar to the top of the layout
		this.setTop(menuBar);

		// Style the TableView to be editable and allow multiple selection
		tableView.setEditable(true);
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableView.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3;");

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Initialize columns with headers and properties
		// to bind to item model fields
		itemIDColumn = new TableColumn<>("ID");
		itemIDColumn.setMinWidth(50);

		// **setCellValueFactory is used to specify which property
		// **of the item model should be displayed in this column.

		// new PropertyValueFactory<>("item") tells the TableView that
		// this column should display data from the item property of the item
		// object.
		itemIDColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));
		// how the data will be displayed and edited in the column.
		itemIDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(70);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		costColumn = new TableColumn<>("Cost");
		costColumn.setMinWidth(70);
		costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
		costColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		retailPriceColumn = new TableColumn<>("Retail Price");
		retailPriceColumn.setMinWidth(70);
		retailPriceColumn.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));
		retailPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		sectorCodeColumn = new TableColumn<>("Sector Code");
		sectorCodeColumn.setMinWidth(70);
		sectorCodeColumn.setCellValueFactory(new PropertyValueFactory<>("sectorCode"));
		sectorCodeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		sIDColumn = new TableColumn<>("Sector ID");
		sIDColumn.setMinWidth(50);
		sIDColumn.setCellValueFactory(new PropertyValueFactory<>("sID"));
		sIDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		nrOfStockColumn = new TableColumn<>("Nr. Of Stock");
		nrOfStockColumn.setMinWidth(50);
		nrOfStockColumn.setCellValueFactory(new PropertyValueFactory<>("nrOfStock"));
		nrOfStockColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		// Add columns to the table
		tableView.getColumns().addAll(itemIDColumn, nameColumn, costColumn, retailPriceColumn, sectorCodeColumn, sIDColumn, nrOfStockColumn);

		
		// Configure input fields
		tfItemID.setPromptText("Enter ID");
		tfName.setPromptText("Enter Name");
		tfCost.setPromptText("Enter Cost");
		tfRetailPrice.setPromptText("Enter Retaial Price");
		tfSectorCode.setPromptText("Enter Sector Code");
		tfSID.setPromptText("Enter Sector ID");
		tfNrOfStock.setPromptText("Enter Stock");
		tfItemID.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");
		tfName.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");
		tfCost.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");
		tfRetailPrice.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");
		tfSectorCode.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");
		tfSID.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");
		tfNrOfStock.setStyle("-fx-padding: 5; -fx-border-color: #c3c3c3;");

		// Style buttons
		btnAdd.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 5 10;");
		btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
		btnUpdate.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-padding: 5 10;");

		// Layout for inputs
		HBox inputBox = new HBox(10);
		inputBox.setPadding(new Insets(10));
		inputBox.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #dcdcdc;");
		inputBox.getChildren().addAll(new Label("ID:"), tfItemID, new Label("Name:"), tfName,
									new Label("Cost:"), tfCost, new Label("Retail Price:"), 
									tfRetailPrice, new Label("Sector Code:"), tfSectorCode, 
									new Label("Sector ID:"), tfSID, new Label("Nr. Of Stock:"), tfNrOfStock);

		// Layout for buttons
		HBox buttonBox = new HBox(10);
		buttonBox.setPadding(new Insets(10));
		buttonBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
		buttonBox.getChildren().addAll(btnAdd, btnDelete, btnUpdate);

		// layout for search
		HBox searchBox = new HBox(10);
		searchBox.setPadding(new Insets(10));
		searchBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
		searchBox.getChildren().addAll(new Label("Search Item:"), tfSearch, btnSearch);

		// Combine input and button sections
		VBox bottomBox = new VBox(5);
		bottomBox.getChildren().addAll(inputBox, buttonBox, searchBox);

		// Set padding and layout for the main view
		this.setPadding(new Insets(15));
		this.setStyle("-fx-background-color: #ffffff;");
		this.setCenter(tableView);
		this.setBottom(bottomBox);
	}


	public TableColumn<Item, Integer> getItemIDColumn() {
		return itemIDColumn;
	}
	
	public TableColumn<Item, String> getNameColumn() {
		return nameColumn;
	}

	public TableColumn<Item, Integer> getCostColumn() {
		return costColumn;
	}

	public TableColumn<Item, Integer> getRetailPriceColumn() {
		return retailPriceColumn;
	}

	public TableColumn<Item, Integer> getSectorCodeColumn() {
		return sectorCodeColumn;
	}
	
	public TableColumn<Item, Integer> getSIDColumn() {
		return sIDColumn;
	}
	
	public TableColumn<Item, Integer> getNrOfStockColumn() {
		return nrOfStockColumn;
	}

	public TableView<Item> getTableView() {
		return tableView;
	}

	public TextField getTfItemID() {
		return tfItemID;
	}

	public TextField getTfName() {
		return tfName;
	}

	public TextField getTfCost() {
		return tfCost;
	}

	public TextField getTfRetailPrice() {
		return tfRetailPrice;
	}

	public TextField getTfSectorCode() {
		return tfSectorCode;
	}

	public TextField getTfSID() {
		return tfSID;
	}

	public TextField getTfNrOfStock() {
		return tfNrOfStock;
	}

	public Button getBtnAdd() {
		return btnAdd;
	}

	public TextField getTfSearch() {
		return tfSearch;
	}

	public Button getBtnSearch() {
		return btnSearch;
	}

	public Button getBtnDelete() {
		return btnDelete;
	}

	public Button getBtnUpdate() {
		return btnUpdate;
	}

	// Method to show Home Scene (TableView with all countries)
	private void showHomeScene() {
		this.setCenter(tableView);
	}

	// Method to show Profile Scene (Just a "Hello" label)
	private void showProfileScene() {
		this.setCenter(profileScene.getRoot());
	}

}