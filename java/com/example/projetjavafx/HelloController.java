package com.example.tpjavafx;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelloController extends HelloApplication{
    @FXML
    private TextField monID;
    @FXML
    private PasswordField monMdp;

    @FXML
    private TextField numCle;

    @FXML
    private TextField coulCle;

    @FXML
    private TextField ouvertureCle;

    public String URL = "jdbc:mysql://172.19.0.27:3306/tpcle";

    public String LOGIN = "phpmyadmin";

    public String PASSWORD = "0550002D";

    @FXML
    private ComboBox<Cle> liste ;

    protected ObservableList<Cle> listCle;

    public List<Cle> laliste = new ArrayList<>();

     public  static void main(String[] args){
//
         launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        liste = new ComboBox<>();
        liste.setPromptText("Sélectionnez une clé");
        liste.setItems(listCle);
        listCle = FXCollections.observableArrayList(getTteCle());
        try {
            Label colorLabel = new Label("Couleur :");
            coulCle = new TextField();
            Label descriptionLabel = new Label("Description :");
            ouvertureCle = new TextField();
            Label numberLabel = new Label("Numéro :");
            numCle = new TextField();
            Button addButton = new Button("Ajouter");
            Button updateButton = new Button("Modifier");
            Button deleteButton = new Button("Supprimer");


            liste.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    coulCle.setText(newValue.getCouleur());
                    ouvertureCle.setText(newValue.getOuverture());
                    numCle.setText(String.valueOf(newValue.getNumero()));
                }
            });

//            addButton.setOnAction(e -> addKey());
//            updateButton.setOnAction(e -> updateKey());
//            deleteButton.setOnAction(e -> deleteKey());

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.add(liste, 0, 0, 3, 1);
            gridPane.addRow(1, colorLabel, coulCle);
            gridPane.addRow(2, descriptionLabel, ouvertureCle);
            gridPane.addRow(3, numberLabel, numCle);
            gridPane.addRow(4, addButton, updateButton, deleteButton);

            Scene scene = new Scene(gridPane, 400, 200);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestion des clés");
            listCle.addAll(getTteCle());
            primaryStage.show();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private List<Cle> getTteCle() throws SQLException {


            Connection connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            try {
                Statement stmt = connexion.createStatement();
                String req = "SELECT * FROM cle";
                ResultSet res1 = stmt.executeQuery(req);
                while (res1.next()) {
                    int numCle = res1.getInt("numero");

                    String couleurCle = res1.getString("couleur");
                    String ouvertureCle = res1.getString("ouverture");
                    Cle cle1 = new Cle(numCle, couleurCle, ouvertureCle);
                    laliste.add(cle1);


                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return laliste;
        }

    @FXML
    protected void onHelloButtonClick() throws NoSuchAlgorithmException, NoSuchProviderException, IOException {




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

    public void onSearchButtonClick(ActionEvent actionEvent) {

    }

    public void onModifButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    protected void onAddButtonClick()throws NoSuchAlgorithmException, NoSuchProviderException, IOException  {
        try {
            Cle cle = new Cle(Integer.parseInt(numCle.getText()),coulCle.getText(),ouvertureCle.getText());
            Connection connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            Statement stmt = connexion.createStatement();
            String req = "INSERT INTO cle (numero, couleur, ouverture) VALUES (" + cle.getNumero() + ", '" + cle.getCouleur() + "', '" + cle.getOuverture() + "')";
            stmt.executeUpdate(req);


        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void onSuppButtonClick(ActionEvent actionEvent) {
    }
}
