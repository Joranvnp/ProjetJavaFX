module com.example.projetjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.common;


    opens com.example.projetjavafx to javafx.fxml;
    exports com.example.projetjavafx;
}