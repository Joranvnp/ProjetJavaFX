package com.example.projetjavafx;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import java.sql.*;
public class HelloController {
    @FXML
    private TextField monID;
    @FXML
    private PasswordField monMdp;

    @FXML
    protected void onHelloButtonClick() throws NoSuchAlgorithmException, NoSuchProviderException, IOException {
        String URL = "jdbc:mysql://172.19.0.9:3306/ProjetCle";

        String LOGIN = "phpmyadmin";
        String PASSWORD = "0550002D";
        try {

            Connection connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            Statement stmt = connexion.createStatement();
            String req = "SELECT login, password, droit FROM users";
            ResultSet res1 = stmt.executeQuery(req);
            res1.next();

            int droit = res1.getInt("droit");
            String login = res1.getString("login");
            String mdp = res1.getString("password");

            Hasher hasher = Hashing.sha256().newHasher();
            hasher.putString("test", Charsets.UTF_8);
            HashCode sha256 = hasher.hash();

            System.out.println(mdp);

            Hasher hasherMdp = Hashing.sha256().newHasher();
            hasherMdp.putString(monMdp.getText(), Charsets.UTF_8);
            HashCode monMdpHash = hasherMdp.hash();

            if (login.equals(login) && monMdpHash.equals(sha256)) {
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
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
