package com.example.tugaspbofreeuas.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;

public class EditController {
    public EditController(String storedValue,String storedEmail){
        this.storedValue = storedValue;
        this.storedEmail = storedEmail;
    }
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/uas_pbo";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static ResultSet rs;
    static Statement stmt;

    private String storedEmail;
    private String storedValue;
    @FXML
    private TextField namalengkapTextField, tempatlhrField, kelaminField, agamaField, alamatfield, kodeposField;
    @FXML
    private Button tombolSimpan, tombolKembali;
    @FXML
    private AnchorPane thisPane;
    private Stage thisStage;

    @FXML
    public void simpanData(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "INSERT INTO mahasiswa VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,storedEmail);
            statement.setString(2,namalengkapTextField.getText());
            statement.setString(3,tempatlhrField.getText());
            statement.setString(4,kelaminField.getText().toLowerCase());
            statement.setString(5,agamaField.getText());
            statement.setString(6,alamatfield.getText());
            statement.setInt(7,Integer.valueOf(kodeposField.getText()));
            statement.execute();
            conn.createStatement().execute("INSERT INTO log VALUES('"+storedEmail+"','menambahkan data informasi')");
            thisStage = (Stage)thisPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/nextMenu.fxml"));
            loader.setController(new MenuController(storedValue,storedEmail));
            thisStage.setScene(new Scene(loader.load()));
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void kembali(){
        try{
            thisStage = (Stage)thisPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/nextMenu.fxml"));
            loader.setController(new MenuController(storedValue,storedEmail));
            thisStage.setScene(new Scene(loader.load()));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
