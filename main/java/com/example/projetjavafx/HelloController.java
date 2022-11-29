package com.example.projetjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class HelloController {
    @FXML
    private TextField monID;
    @FXML
    private PasswordField monMdp;

    @FXML
    protected void onHelloButtonClick() throws NoSuchAlgorithmException, NoSuchProviderException, IOException {
        String id, mdp,mdpVerif;
        id = monID.getText();
        mdp = monMdp.getText();
        mdpVerif = "";
        mdp = hashage.hasher(mdp);
        String[] strs = mdp.split(";");

        for (int i = 0; i < strs.length; i++) {
            mdp = strs[0];
            mdpVerif = strs[1];
        }

        if (id.equals("admin") && monMdp.getText().equals("admin") && mdp.equals(mdpVerif)) {
            Stage newWindow = new Stage();
            FXMLLoader fxmlLoader = new
                    FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            newWindow.setScene(scene);
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText("Connexion");
            alert.setContentText("identifiant erroné");
            alert.showAndWait();
        }

    }
}