package View;
import javafx.scene.control.*;
import javafx.util.Callback;

import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import Model.Item;
import javafx.util.converter.IntegerStringConverter;

public class BillView {

    private final BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane);


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
    private final Button btnBack = new Button("Back");

    private final VBox tableBox = new VBox();

    // constructor - when an object is created
    @SuppressWarnings({ "unchecked", "deprecation" })
    public BillView() {

        tableView.setEditable(false);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3;");

        billView.setEditable(true);
        billView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        billView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        billView.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3;");



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
                    setText(String.valueOf(item));
                }
            }
        });


        nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(70);
        nameColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName()));
        nameColumn.setCellFactory(column -> new TableCell<Item, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
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


        quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(30);
        quantityColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getQuantity()));
        quantityColumn.setCellFactory(column -> new TableCell<Item, Integer>() {
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


        tableView.getColumns().addAll(itemIDColumn, nameColumn, retailPriceColumn, sectorCodeColumn, sIDColumn, nrOfStockColumn);
        billView.getColumns().addAll(quantityColumn, itemIDColumn, nameColumn, retailPriceColumn, nrOfStockColumn);

        btnAdd.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 5 10;");
        btnRemove.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
        btnClose.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-padding: 5 10;");
        btnShow.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-padding: 5 10;");
        btnBack.setStyle("-fx-background-color: gray; -fx-text-fill: black; -fx-padding: 5 10;");

        tableBox.getChildren().addAll(tableView, billView); // Add both tables
        tableBox.setSpacing(10);
        tableBox.setPadding(new Insets(10));
        tableBox.setStyle("-fx-background-color: #ffffff;");

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
        buttonBox.getChildren().addAll(btnAdd, btnRemove, btnClose, btnShow, btnBack);

        HBox searchBox = new HBox(10);
        searchBox.setPadding(new Insets(10));
        searchBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #dcdcdc;");
        searchBox.getChildren().addAll(new Label("Search Item:"), tfSearch, btnSearch);

        VBox bottomBox = new VBox(5);
        bottomBox.getChildren().addAll(buttonBox, searchBox);



        borderPane.setPadding(new Insets(15));
        borderPane.setStyle("-fx-background-color: #ffffff;");
        borderPane.setBottom(bottomBox);
        borderPane.setCenter(tableBox);

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

    public Scene getScene() {
        return scene;
    }

    public ButtonBase getBtnBack() {
        return btnBack;
    }
}