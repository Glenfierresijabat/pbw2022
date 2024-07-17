package com.example.tugaspbofreeuas.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class RegisterController{

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/uas_pbo";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static ResultSet rs;
    @FXML
    private Text warningText;
    @FXML
    private TextField namaTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Pane registrationPage;
    @FXML
    private Button tombolKembali;
    @FXML
    private Button next;
    private Stage thisStage;

    @FXML
    public void next(){
        try{
            if (emailTextField.getText().isBlank() == true || passwordTextField.getText().isBlank() == true){
                warningText.setText("Maukkan email / password !!!");
            }else{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                String sql = "INSERT INTO akun_mahasiswa (account_name,username,password) VALUES(?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,namaTextField.getText());
                preparedStatement.setString(2,emailTextField.getText());
                preparedStatement.setString(3,passwordTextField.getText());
                preparedStatement.execute();
                thisStage = (Stage)registrationPage.getScene().getWindow();
                thisStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/example/tugaspbofreeuas/login.fxml"))));
                conn.close();
            }
        }catch(SQLIntegrityConstraintViolationException e){
            warningText.setText("Email tersebut sudah dipakai user lain...");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void kembali(){
        try{
            thisStage = (Stage)registrationPage.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/daftar-page.fxml"));
            loader.setController(new DaftarPageController());
            thisStage.setScene(new Scene(loader.load()));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
