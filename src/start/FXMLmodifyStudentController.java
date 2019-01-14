/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author szcze
 */
public class FXMLmodifyStudentController implements Initializable {

    @FXML
    private TextField pesel;
    @FXML
    private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private TextField degreeCourse;
    @FXML
    private TextField password;
    @FXML
    private TextField indexNumber;
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
    @FXML
    private Button confirm;
    @FXML
    private Button prevBtn;
    @FXML
    private Button Logout;
    @FXML
    private Button clearbtn;
     @FXML
    private TableView<ModelEditStudent> tables;
    @FXML
    private TableColumn<ModelEditStudent, String> col_nr_indeksu;
    @FXML
    private TableColumn<ModelEditStudent, String> col_imie;
    @FXML
    private TableColumn<ModelEditStudent, String> col_nazwisko;
    

 public static ObservableList<ModelEditStudent> oblists=FXCollections.observableArrayList();
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            PreparedStatement st;
            Connection myConn=ConnectionManager.getConnection();
             st = myConn.prepareStatement("SELECT * FROM student");
            
            ResultSet rs= st.executeQuery();
            
            
            
            while (rs.next())   {
                oblists.add(new ModelEditStudent(rs.getString("nr_indeksu"), rs.getString("imie"),
                        rs.getString("nazwisko")));
                
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
                col_nr_indeksu.setCellValueFactory(new PropertyValueFactory<ModelEditStudent, String>("nr_indeksu"));
                col_imie.setCellValueFactory(new PropertyValueFactory<ModelEditStudent, String>("imie"));
                col_nazwisko.setCellValueFactory(new PropertyValueFactory<ModelEditStudent, String>("nazwisko"));
                
                tables.setItems(null);
                tables.setItems(oblists);
                
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
    
     public void initialize(URL url, ResultSet rs) throws SQLException {
            ModelEditStudent student=(ModelEditStudent)tables.getSelectionModel().getSelectedItem();
            String query = "SELECT * FROM student WHERE nr_indeksu=?";
            
             try (Connection myConn = ConnectionManager.getConnection()) {
                PreparedStatement st = myConn.prepareStatement(query);
                st.setString(1, student.getNr_indeksu());
                rs = st.executeQuery();
                
                while(rs.next()){
                    pesel.setText(rs.getString("pesel"));
                    name.setText(rs.getString("imie"));
                    lastName.setText(rs.getString("nazwisko"));
                    degreeCourse.setText(rs.getString("kierunek_s"));
                    password.setText(rs.getString("haslo"));
                    indexNumber.setText(rs.getString("nr_indeksu"));
                    street.setText(rs.getString("ulica"));
                    houseNumber.setText(rs.getString("nr_domu"));
                    postCode.setText(rs.getString("kod_p"));
                    city.setText(rs.getString("miasto"));
                    phoneNumber.setText(rs.getString("nr_tel"));
                    
                   
                    st.close();
                    rs.close();    
        }
                     
                    
    } catch (SQLException e){
                System.out.println(e);
            }
    
    }
      @FXML
    private void modifyStudentOnClick(ActionEvent event)throws IOException, SQLException {
        
        String sql = "UPDATE student SET haslo=?, imie=?, nazwisko=?, pesel=?, kierunek_s=?,"
                + "ulica=?, nr_domu=?, kod_p=?, miejscowosc=?, nr_tel=?, nr_indeksu=? WHERE nr_indeksu= '" + indexNumber.getText()+"' ";
        
        if(validateFields()){
        
        try{
            
            try (Connection myConn = ConnectionManager.getConnection()) {
                PreparedStatement st = myConn.prepareStatement(sql);
                
                st.setString(1, this.password.getText());
                st.setString(2, this.name.getText());
                st.setString(3, this.lastName.getText());
                st.setString(4, this.pesel.getText());
                st.setString(5, this.degreeCourse.getText());
                st.setString(6, this.street.getText());
                st.setString(7, this.houseNumber.getText());
                st.setString(8, this.postCode.getText());
                st.setString(9, this.city.getText());
                st.setString(10, this.phoneNumber.getText());
                st.setString(11, this.indexNumber.getText());
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edycja studenta");
                alert.setHeaderText(null);
                alert.setContentText("Student został edytowany");
                alert.showAndWait();
                
                st.execute();
            }
             
            } catch (SQLException e){
                e.printStackTrace();
            }
        this.password.setText(null);
        this.name.setText(null);
        this.lastName.setText(null);
        this.pesel.setText(null);
        this.degreeCourse.setText(null);
        this.street.setText(null);
        this.houseNumber.setText(null);
        this.postCode.setText(null);
        this.city.setText(null);
        this.phoneNumber.setText(null);
        this.indexNumber.setText(null);
        
        } 
    }
    
    @FXML
    private void clearFields(ActionEvent event){
        this.password.setText(null);
        this.name.setText(null);
        this.lastName.setText(null);
        this.pesel.setText(null);
        this.degreeCourse.setText(null);
        this.street.setText(null);
        this.houseNumber.setText(null);
        this.postCode.setText(null);
        this.city.setText(null);
        this.phoneNumber.setText(null);
        this.indexNumber.setText(null);
    }
    
    private boolean validateFields(){
        if(password.getText().isEmpty() | name.getText().isEmpty() |
                lastName.getText().isEmpty() | pesel.getText().isEmpty() |
                degreeCourse.getText().isEmpty() | street.getText().isEmpty() |
                houseNumber.getText().isEmpty() | postCode.getText().isEmpty() |
                city.getText().isEmpty() | phoneNumber.getText().isEmpty() |
                indexNumber.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Uwaga");
                alert.setHeaderText(null);
                alert.setContentText("Proszę wypełnić wszystkie pola");
                alert.showAndWait();
                
                return false;
        }
        return true;
    }
    }

