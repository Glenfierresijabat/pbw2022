package com.example.tugaspbofreeuas.controllers;

import com.example.tugaspbofreeuas.models.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LogController implements Initializable {
    LogController(String storedValue, String storedEmail){
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
    @FXML
    private TableView<Mahasiswa> tblHistori;

    private String storedValue,storedEmail;
    @FXML
    private TableColumn<Mahasiswa,String> clmLog;
    private Stage thisStage;
    private ObservableList<Mahasiswa> mahasiswas = FXCollections.observableArrayList();
    @FXML
    private Pane logPane;

    private Button kembali;
    @FXML
    public void kembali(){
        try{
            thisStage = (Stage)logPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/nextMenu.fxml"));
            loader.setController(new MenuController(storedValue,storedEmail));
            thisStage.setScene(new Scene(loader.load()));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT message FROM log WHERE username='"+storedEmail+"'");
            while(rs.next()){
                System.out.println(rs.getString("message"));
                mahasiswas.add(new Mahasiswa(storedEmail,rs.getString("message")));
            }
            clmLog.setCellValueFactory(new PropertyValueFactory<Mahasiswa,String>("message"));
            mahasiswas.get(0);
            tblHistori.setItems(mahasiswas);
            conn.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
