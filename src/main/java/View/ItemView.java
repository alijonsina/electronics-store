package View;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import Model.Item;
import javafx.util.converter.IntegerStringConverter;
import javafx.beans.property.SimpleObjectProperty;


public class ItemView  {

    private final BorderPane borderPane = new BorderPane();
    private final Scene scene = new Scene(borderPane);

    // TableView to display list of items
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

    // Buttons for adding, deleting, and updating items
    private final Button btnAdd = new Button("Add");
    private final Button btnDelete = new Button("Delete");
    private final Button btnUpdate = new Button("Update");
    private final Button btnBack = new Button("Back");

    // constructor - when an object is created
    @SuppressWarnings({ "unchecked", "deprecation" })
    public ItemView() {

        // Style the TableView to be editable and allow multiple selection
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3;");

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Initialize columns with headers and properties
        itemIDColumn = new TableColumn<>("ID");
        itemIDColumn.setMinWidth(50);
        itemIDColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getItemID()));
        itemIDColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(70);
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        costColumn = new TableColumn<>("Cost");
        costColumn.setMinWidth(70);
        costColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCost()));
        costColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        retailPriceColumn = new TableColumn<>("Retail Price");
        retailPriceColumn.setMinWidth(70);
        retailPriceColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getRetailPrice()));
        retailPriceColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        sectorCodeColumn = new TableColumn<>("Sector Code");
        sectorCodeColumn.setMinWidth(70);
        sectorCodeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSectorCode()));
        sectorCodeColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        sIDColumn = new TableColumn<>("Sector ID");
        sIDColumn.setMinWidth(50);
        sIDColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSID()));
        sIDColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        nrOfStockColumn = new TableColumn<>("Nr. Of Stock");
        nrOfStockColumn.setMinWidth(50);
        nrOfStockColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getQuantity()));
        nrOfStockColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        // Add columns to the table
        tableView.getColumns().addAll(itemIDColumn, nameColumn, costColumn, retailPriceColumn, sectorCodeColumn, sIDColumn, nrOfStockColumn);

        // Configure input fields
        tfItemID.setPromptText("Enter ID");
        tfName.setPromptText("Enter Name");
        tfCost.setPromptText("Enter Cost");
        tfRetailPrice.setPromptText("Enter Retail Price");
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
        btnBack.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-padding: 5 10;");

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
        buttonBox.getChildren().addAll(btnAdd, btnDelete, btnUpdate, btnBack);

        // layout for search
        HBox searchBox = new HBox(10);
        searchBox.setPadding(new Insets(10));
        searchBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
        searchBox.getChildren().addAll(new Label("Search Item:"), tfSearch, btnSearch);

        // Combine input and button sections
        VBox bottomBox = new VBox(5);
        bottomBox.getChildren().addAll(inputBox, buttonBox, searchBox);

        // Set padding and layout for the main view
        borderPane.setPadding(new Insets(15));
        borderPane.setStyle("-fx-background-color: #ffffff;");
        borderPane.setCenter(tableView);
        borderPane.setBottom(bottomBox);
    }

    public Scene getScene() {
        return scene;
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

    public ButtonBase getBtnBack() {
        return btnBack;
    }
}
