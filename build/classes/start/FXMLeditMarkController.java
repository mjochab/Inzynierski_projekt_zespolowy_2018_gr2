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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static start.GradesController.oblist;

/**
 * FXML Controller class
 *
 * @author Dorota
 */
public class FXMLeditMarkController implements Initializable {

    @FXML
    private Button prevBtn;
    @FXML
    private Button Logout;
    @FXML
    private Button addMark;
            @FXML
    private TableView<ModelEditMark> tablee;
          @FXML
    private TableColumn<ModelEditMark, String> col_nr_indeksu;
                      @FXML
    private TableColumn<ModelEditMark, String> col_nazwa;
            @FXML
    private TableColumn<ModelEditMark, String> col_ocena;

    /**
     * Initializes the controller class.
     */
            public static ObservableList<ModelEditMark> obliste=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                try {
            PreparedStatement st;
            Connection myConn=ConnectionManager.getConnection();
             st = myConn.prepareStatement("SELECT * FROM oceny");
            
            ResultSet rs= st.executeQuery();
            
            
            
            while (rs.next())   {
                obliste.add(new ModelEditMark(rs.getString("nr_indeksu"), rs.getString("nazwa"),
                        rs.getString("ocena")));
                
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
                col_nr_indeksu.setCellValueFactory(new PropertyValueFactory<ModelEditMark, String>("nr_indeksu"));
                col_nazwa.setCellValueFactory(new PropertyValueFactory<ModelEditMark, String>("nazwa"));
                col_ocena.setCellValueFactory(new PropertyValueFactory<ModelEditMark, String>("ocena"));
                
                tablee.setItems(null);
                tablee.setItems(obliste);
    }    

    @FXML
    private void prevWindow(ActionEvent event) throws IOException {
         Stage dialogStage = (Stage)prevBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLwykladowca.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        
         Stage dialogStage = (Stage)prevBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
        
    }


    @FXML
    private void redirectToAddNewMark(ActionEvent event) throws IOException {
         Stage dialogStage = (Stage)prevBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLaddMark.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
}
