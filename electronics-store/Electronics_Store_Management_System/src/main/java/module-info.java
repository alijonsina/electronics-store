module com.example.electronics_store_management_system {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.electronics_store_management_system to javafx.fxml;
    exports com.example.electronics_store_management_system;
}