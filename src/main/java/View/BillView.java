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

public class BillView extends BorderPane {

	private final TableView<Item> tableView = new TableView<>();
	private final TableView<Item> billView = new TableView<>();


	private final TableColumn<Item, Integer> quantityColumn;
	private final TableColumn<Item, Integer> itemIDColumn;
	private final TableColumn<Item, String> nameColumn;
	private final TableColumn<Item, Integer> retailPriceColumn;
	private final TableColumn<Item, Integer> sectorCodeColumn;
	private final TableColumn<Item, Integer> sIDColumn;
	private final TableColumn<Item, Integer> nrOfStockColumn;
	
	
	private final Button btnSearch = new Button("Search");
	private final TextField tfSearch = new TextField();

	
	private final Button btnAdd = new Button("Add");
	private final Button btnRemove = new Button("Remove");
	private final Button btnClose = new Button("Close Bill");
	private final Button btnShow = new Button("Show Bill");
	
	private final VBox tableBox = new VBox();
	
	// constructor - when an object is created
	@SuppressWarnings({ "unchecked", "deprecation" })
	public BillView() {

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
		//profileItem.setOnAction(e -> showProfileScene());

		MenuItem exitItem = new MenuItem("Exit Program");
		exitItem.setStyle("-fx-text-fill: #2196f3; -fx-font-size: 14px;");
		exitItem.setOnAction(e -> System.exit(0));

		menu.getItems().addAll(homeItem, profileItem, exitItem);
		menuBar.getMenus().add(menu);

		// Adding MenuBar to the top of the layout
		this.setTop(menuBar);
		
		
		tableView.setEditable(false);
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableView.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3;");
		
		billView.setEditable(true);
		billView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		billView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		billView.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3;");
		
		
		
		itemIDColumn = new TableColumn<>("ID");
		itemIDColumn.setMinWidth(30);
		itemIDColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));
		itemIDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(70);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
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
		
		quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(30);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		
		tableView.getColumns().addAll(itemIDColumn, nameColumn, retailPriceColumn, sectorCodeColumn, sIDColumn, nrOfStockColumn);
		billView.getColumns().addAll(quantityColumn, itemIDColumn, nameColumn, retailPriceColumn, nrOfStockColumn);
		
		btnAdd.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 5 10;");
		btnRemove.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
		btnClose.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-padding: 5 10;");
		btnShow.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-padding: 5 10;");
	    
	    
	    tableBox.getChildren().addAll(tableView, billView); // Add both tables
	    tableBox.setSpacing(10);
	    tableBox.setPadding(new Insets(10));
	    tableBox.setStyle("-fx-background-color: #ffffff;");

	    HBox buttonBox = new HBox(10);
		buttonBox.setPadding(new Insets(10));
		buttonBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
		buttonBox.getChildren().addAll(btnAdd, btnRemove, btnClose, btnShow);
		
		HBox searchBox = new HBox(10);
		searchBox.setPadding(new Insets(10));
		searchBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
		searchBox.getChildren().addAll(new Label("Search Item:"), tfSearch, btnSearch);
		
		VBox bottomBox = new VBox(5);
		bottomBox.getChildren().addAll(buttonBox, searchBox);
		
		
		this.setPadding(new Insets(15));
		this.setStyle("-fx-background-color: #ffffff;");
		this.setBottom(bottomBox);
	    this.setCenter(tableBox);
 
	}
	

	public TableColumn<Item, Integer> getQuantityColumn() {
		return itemIDColumn;
	}
	
	
	public TableColumn<Item, Integer> getItemIDColumn() {
		return itemIDColumn;
	}
	
	public TableColumn<Item, String> getNameColumn() {
		return nameColumn;
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
	
	public TableView<Item> getBillView() {
		return billView;
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

	public Button getbtnRemove() {
		return btnRemove;
	}

	public Button getBtnClose() {
		return btnClose;
	}
	
	public Button getBtnShow() {
		return btnShow;
	}

	// Method to show Home Scene (TableView with all countries)
	private void showHomeScene() {
		this.setCenter(tableBox);
	}

	// Method to show Profile Scene (Just a "Hello" label)
	//private void showProfileScene() {
	//	this.setCenter(profileScene.getRoot());
	//}
}
