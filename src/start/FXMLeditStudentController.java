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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLeditStudentController implements Initializable {

    @FXML
    private Button removeStudent;
    @FXML
    private Button addNewStudent;
    @FXML
    private Button Logout;
    @FXML
    private Button prevBtn;
    @FXML
    private TableView<ModelEditStudent> tables;
    @FXML
    private TableColumn<ModelEditStudent, String> col_nr_indeksu;
    @FXML
    private TableColumn<ModelEditStudent, String> col_imie;
    @FXML
    private TableColumn<ModelEditStudent, String> col_nazwisko;
    @FXML
    private TextField searchField; 
    

 public static ObservableList<ModelEditStudent> oblists=FXCollections.observableArrayList();
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
    private void redirectToAddNewStudent(ActionEvent event)throws IOException{
        Stage dialogStage = (Stage)addNewStudent.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLaddStudent.fxml"));
                
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
                Parent root = FXMLLoader.load(getClass().getResource("FXMLdziekanat.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
    @FXML
    private void removeStudent(ActionEvent event)throws IOException, SQLException{
        tables.getItems().removeAll(tables.getSelectionModel().getSelectedItem());
        
       try{
           PreparedStatement st;
           Connection myConn=ConnectionManager.getConnection();
           String query = "DELETE FROM student WHERE nr_indeksu="+col_nr_indeksu+"";
           st = myConn.prepareStatement(query);
           st.setString(1, col_nr_indeksu.getText());
           st.executeUpdate();
          
           
    }
       catch(SQLException e1){
            System.err.println(e1);
             
        }
    
}
    
    @FXML
    private void searchStudent(ActionEvent event){
        //TODO
    }
}
