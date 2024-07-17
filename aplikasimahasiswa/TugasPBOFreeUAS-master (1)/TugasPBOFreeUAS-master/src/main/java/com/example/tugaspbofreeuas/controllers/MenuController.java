package com.example.tugaspbofreeuas.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    public MenuController(String storedValue, String storedEmail){
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
    private Label welcomeText = new Label();
    @FXML
    private ImageView logIconHolder;
    @FXML
    private ImageView editIconHolder;
    @FXML
    private Button tombolkembali;
    @FXML
    private ImageView informationIconHolder;
    @FXML
    private Pane initialPage;
    private Stage thisStage;

    public String getStoredValue(){
        return storedValue;
    }

    public String getStoredEmail(){
        return storedEmail;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            logIconHolder.setImage(new Image(getClass().getResourceAsStream("/com/example/tugaspbofreeuas/download.png")));
            editIconHolder.setImage(new Image(getClass().getResourceAsStream("/com/example/tugaspbofreeuas/edit-icon.png")));
            informationIconHolder.setImage(new Image(getClass().getResourceAsStream("/com/example/tugaspbofreeuas/information-icon.png")));
            welcomeText.setText("Selamat datang, "+storedValue+"...");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void logButtonAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/log-page.fxml"));
            fxmlLoader.setController(new LogController(storedValue,storedEmail));
            thisStage = (Stage)initialPage.getScene().getWindow();
            thisStage.setScene(new Scene(fxmlLoader.load()));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void editButtonAction() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/register.fxml"));
            thisStage = (Stage)initialPage.getScene().getWindow();
            fxmlLoader.setController(new EditController(storedValue,storedEmail));
            thisStage.setScene(new Scene(fxmlLoader.load()));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void toMenu() {
        try{

        }catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    public void informationButtonAction() {
        try{
            thisStage = (Stage)initialPage.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/information-page.fxml"));
            loader.setController(new InfoController(storedValue,storedEmail));
            thisStage.setScene(new Scene(loader.load()));
            conn.close();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    @FXML
    public void kembali(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.createStatement().execute("INSERT INTO log VALUES('"+storedEmail+"','Logout')");
            thisStage = (Stage)initialPage.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tugaspbofreeuas/daftar-page.fxml"));
            loader.setController(new DaftarPageController());
            thisStage.setScene(new Scene(loader.load()));
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


}
