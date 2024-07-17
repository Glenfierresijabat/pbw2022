
module com.example.tugaspbofreeuas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    opens com.example.tugaspbofreeuas.models;
    opens com.example.tugaspbofreeuas to javafx.fxml;
    exports com.example.tugaspbofreeuas;
    exports com.example.tugaspbofreeuas.controllers;
    opens com.example.tugaspbofreeuas.controllers to javafx.fxml;

}