package com.example.tugaspbofreeuas.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
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

public class InfoController implements Initializable {
    public InfoController(String storedValue,String storedEmail){
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
    private Stage thisStage;
    @FXML
    private AnchorPane thisPane;

    @FXML
    private Button kembali;

    @FXML
    private Text namalengkap= new Text(), tempatLhr = new Text(), jenisKelamin = new Text(), agama = new Text(), alamat = new Text(), kodePos = new Text();

    @FXML
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM mahasiswa WHERE username = '"+storedEmail+"'";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            namalengkap.setText(namalengkap.getText()+" "+ rs.getString("nama_lengkap"));
            tempatLhr.setText(tempatLhr.getText()+" "+ rs.getString("tempat_lahir"));
            jenisKelamin.setText(jenisKelamin.getText()+" "+ rs.getString("jenis_kelamin"));
            agama.setText(agama.getText()+" "+ rs.getString("agama"));
            alamat.setText(alamat.getText()+" "+ rs.getString("alamat"));
            kodePos.setText(kodePos.getText()+" "+(rs.getInt("kode_Pos")));
            conn.close();
        }catch(SQLException e){
            namalengkap.setText(namalengkap.getText()+" -");
            tempatLhr.setText(tempatLhr.getText()+" -");
            jenisKelamin.setText(jenisKelamin.getText()+" -");
            agama.setText(agama.getText()+" -");
            alamat.setText(alamat.getText()+" -");
            kodePos.setText(kodePos.getText()+" -");
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
