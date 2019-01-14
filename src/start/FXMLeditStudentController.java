package start;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private Button modifyBtn;
    @FXML
    private TableView<ModelEditStudent> tables;
    @FXML
    private TableColumn<ModelEditStudent, String> col_nr_indeksu;
    @FXML
    private TableColumn<ModelEditStudent, String> col_imie;
    @FXML
    private TableColumn<ModelEditStudent, String> col_nazwisko;
    

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
    private void redirectToModifyStudent(ActionEvent event)throws IOException{
        Stage dialogStage = (Stage)modifyBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLmodifyStudent.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
    @FXML
    private void removeStudentOnClick(ActionEvent event) throws IOException, SQLException{
            ModelEditStudent student=(ModelEditStudent)tables.getSelectionModel().getSelectedItem();
           
            String sql="DELETE FROM student WHERE nr_indeksu = ? ";
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Usuwanie studenta");
            alert.setHeaderText(null);
            alert.setContentText("Czy na pewno chcesz usunąc tego studenta z listy?");
            Optional <ButtonType> action = alert.showAndWait();
            
            if(action.get() == ButtonType.OK){
                
            tables.getItems().removeAll(tables.getSelectionModel().getSelectedItem());  
            
            try{
            
                try (Connection myConn = ConnectionManager.getConnection()) {
                 try (PreparedStatement st = myConn.prepareStatement(sql)) {
                    st.setString(1, student.getNr_indeksu());
                    st.executeUpdate();
                }
               
                myConn.close();
                
            }
             
            }catch (SQLException e){
                System.out.println(e);
            }
            }
        
        
        
        
        
    }
    
    
    
}
