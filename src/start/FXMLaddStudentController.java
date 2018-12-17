package start;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLaddStudentController implements Initializable {
    
    @FXML
    private Button Logout;
    @FXML
    private Button prevBtn;
    @FXML
    private Button confirm;
    @FXML
    private TextField pesel;
    @FXML
    private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private TextField indexNumber;
    @FXML
    private TextField degreeCourse;
    @FXML
    private TextField password;
    @FXML
    private TextField street;
    @FXML
    private TextField houseNumber;
    @FXML
    private TextField postCode;
    @FXML
    private TextField city;
    @FXML
    private TextField phoneNumber;
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
     private void handleButtonAction(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage)Logout.getScene().getWindow();
        dialogStage.close();
        
        Stage stage = new Stage(); 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show(); 
    }
     
    @FXML
    private void prevWindow(ActionEvent event)throws IOException{
        Stage dialogStage = (Stage)prevBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditStudent.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
    @FXML
    private void addStudentOnClick(ActionEvent event)throws IOException, SQLException {

        try{
            PreparedStatement st;
            Connection myConn=ConnectionManager.getConnection();
            st = myConn.prepareStatement("INSERT INTO student ( nr_indeksu, imie, nazwisko, haslo, pesel, kierunek_s, ulica, nr_domu, kod_p, miejscowosc, nr_tel VALUES(?,?,?,?,?,?,?,?,?,?,?");
          
                st.setString(1, indexNumber.getText());
                st.setString(2, name.getText());
                st.setString(3, lastName.getText());
                st.setString(4, password.getText());
                st.setString(5, pesel.getText());
                st.setString(6, degreeCourse.getText());
                st.setString(7, street.getText());
                st.setString(8, houseNumber.getText());
                st.setString(9, postCode.getText());
                st.setString(10, city.getText());
                st.setString(11, phoneNumber.getText());
                st.execute();
                st.close();
        }
        catch(Exception e1){
            System.err.println(e1);
             
        }
            
                   
                    
        }
        
    }
            
            
            
