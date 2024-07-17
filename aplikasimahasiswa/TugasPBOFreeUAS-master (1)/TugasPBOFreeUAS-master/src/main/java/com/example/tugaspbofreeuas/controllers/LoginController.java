package com.example.tugaspbofreeuas.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/uas_pbo";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static ResultSet rs;
    static Statement stmt;
    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button tombolKembali;
    @FXML
    private BorderPane thisPane;
    private Stage thisStage;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField enterPasswordfield;


    @FXML
    public void LoginButtonOnAction(ActionEvent event){

        try{
            if (emailTextField.getText().isBlank() == false && enterPasswordfield.getText().isBlank() == false){
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                String sql = "SELECT password, account_name, username FROM akun_mahasiswa WHERE username = '"+emailTextField.getText()+"'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                rs.next();
                if(enterPasswordfield.getText().equals(rs.getString("password")))
                {
                    thisStage = (Stage)thisPane.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/nextMenu.fxml"));
                    MenuController menuController = new MenuController(rs.getString("account_name"), rs.getString("username"));
                    fxmlLoader.setController(menuController);
                    thisStage.setScene(new Scene(fxmlLoader.load()));
                }else {
                    loginMessageLabel.setText("Password yang anda masukkan salah...");
                }
                conn.close();
            }
            else{
                loginMessageLabel.setText("Coba masukkan akun yang benar");
            }
        }catch(SQLException e){
            loginMessageLabel.setText("Akun tidak ditemukan...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void kembali(ActionEvent event){

        try{
            thisStage = (Stage)thisPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setController(new DaftarPageController());
            thisStage.setScene(new Scene(loader.load(getClass().getResource("/com/example/tugaspbofreeuas/daftar-page.fxml"))));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void register(ActionEvent event){

        try{
            thisStage = (Stage)thisPane.getScene().getWindow();
            thisStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/example/tugaspbofreeuas/hello-view.fxml"))));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}