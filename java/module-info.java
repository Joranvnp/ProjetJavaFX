module com.example.projetjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.common;
    requires java.sql;


    opens com.example.projetjavafx to javafx.fxml;
    exports com.example.projetjavafx;
}