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
import javafx.scene.control.Label;
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
public class FXMLmodifyWykladowcaController implements Initializable {

    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField haslo;
    @FXML
    private TextField pesel;
    @FXML
    private TextField nrid;
    @FXML
    private Button confirm;
    @FXML
    private Button prevBtn;
    @FXML
    private Button Logout;
    @FXML
    private Button clearbtn;
    @FXML
    private Button selectBtn;
    @FXML
    private Button modifyBtn;
    @FXML
    private TableView<ModelEditWykladowca> tables;
    @FXML
    private TableColumn<ModelEditWykladowca, String> col_id_wykladowcy;
    @FXML
    private TableColumn<ModelEditWykladowca, String> col_imie;
    @FXML
    private TableColumn<ModelEditWykladowca, String> col_nazwisko;
    

 public ObservableList<ModelEditWykladowca> oblistt=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            PreparedStatement st;
            Connection myConn=ConnectionManager.getConnection();
             st = myConn.prepareStatement("SELECT * FROM wykladowca");
            
            ResultSet rs= st.executeQuery();
            
            
            
            while (rs.next())   {
                oblistt.add(new ModelEditWykladowca(rs.getString("id_wykladowcy"), rs.getString("imie"),
                        rs.getString("nazwisko")));
                
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
                col_id_wykladowcy.setCellValueFactory(new PropertyValueFactory<ModelEditWykladowca, String>("id_Wykladowcy"));
                col_imie.setCellValueFactory(new PropertyValueFactory<ModelEditWykladowca, String>("imie"));
                col_nazwisko.setCellValueFactory(new PropertyValueFactory<ModelEditWykladowca, String>("nazwisko"));
                
                tables.setItems(null);
                tables.setItems(oblistt);
                
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
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditWykladowca.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
     @FXML
      private void selectTeacherOnClick(ActionEvent event) throws SQLException {
            ModelEditWykladowca wykladowca=(ModelEditWykladowca)tables.getSelectionModel().getSelectedItem();
            String query = "SELECT * FROM wykladowca WHERE id_wykladowcy=?";
            
             try (Connection myConn = ConnectionManager.getConnection()) {
                PreparedStatement st = myConn.prepareStatement(query);
                st.setString(1, wykladowca.getId_Wykladowcy());
                ResultSet rs = st.executeQuery();
                
                while(rs.next()){
                    pesel.setText(rs.getString("pesel"));
                    imie.setText(rs.getString("imie"));
                    nazwisko.setText(rs.getString("nazwisko"));
                    haslo.setText(rs.getString("haslo"));                 
                    
                   
                    st.close();
                    rs.close();    
                }
             }
      }
    
    
    @FXML
    public void modifyWykladowcaOnClick(ActionEvent event)throws IOException, SQLException {
  
        String sql = "UPDATE wykladowca SET imie=?, nazwisko=?, haslo=?, pesel=? WHERE id_wykladowcy=?";
        
        if(validateFields()){
        
        try{
            
            try (Connection myConn = ConnectionManager.getConnection()) {
                PreparedStatement st = myConn.prepareStatement(sql);
                
                st.setString(1, this.imie.getText());
                st.setString(2, this.nazwisko.getText());
                st.setString(3, this.haslo.getText());
                st.setString(4, this.pesel.getText());
                st.setString(5, nrid.getText());
                        st.executeUpdate();
              
   tables.getItems().removeAll(tables.getItems());  
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edycja wykladowcy");
                alert.setHeaderText(null);
                alert.setContentText("Wykładowca został edytowany");
                alert.showAndWait();
                  
             
             

               
                                          
            }
             
            } catch (SQLException e){
                e.printStackTrace();
            }
         
        this.imie.setText(null);
        this.nazwisko.setText(null);
        this.haslo.setText(null);
        this.pesel.setText(null);
 
        
        } 
      
    }
    
    @FXML
    private void clearFields(){
          this.imie.setText(null);
        this.nazwisko.setText(null);
        this.haslo.setText(null);
        this.pesel.setText(null);
    }
    
    private boolean validateFields(){
        if(imie.getText().isEmpty() | nazwisko.getText().isEmpty() |
                haslo.getText().isEmpty() | pesel.getText().isEmpty()){
            
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

