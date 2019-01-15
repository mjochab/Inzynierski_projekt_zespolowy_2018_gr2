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


public class FXMLeditWykladowcaController implements Initializable {

    @FXML
    private Button removeWykladowca;
    @FXML
    private Button addNewWykladowca;
    @FXML
    private Button Logout;
    @FXML
    private Button prevBtn;
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
                col_id_wykladowcy.setCellValueFactory(new PropertyValueFactory<ModelEditWykladowca, String>("Id_Wykladowcy"));
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
    private void redirectToAddNewWykladowca(ActionEvent event)throws IOException{
        Stage dialogStage = (Stage)addNewWykladowca.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLaddWykladowca.fxml"));
                
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
    private void redirectToModifyWykladowca(ActionEvent event)throws IOException{
        try{
            ModelEditWykladowca wykladowca1=(ModelEditWykladowca)tables.getSelectionModel().getSelectedItem();
            
        Stage dialogStage = (Stage)modifyBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                          FXMLLoader loader=new FXMLLoader();
                
               loader.setLocation(getClass().getResource("FXMLmodifyWykladowca.fxml"));
             loader.load();
               // Pane root= loader.load(getClass().getResource("/start/FXMLstudent.fxml").openStream());
              
               FXMLmodifyWykladowcaController display= loader.getController();
                display.showTable(wykladowca1.getId_Wykladowcy());
                
                Parent root=loader.getRoot();
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();}catch(NullPointerException ex){
                             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Uwaga");
                alert.setHeaderText(null);
                alert.setContentText("Proszę zaznaczyć wykładowcę!");
                alert.showAndWait();
                        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditWykladowca.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
                }
    }
    @FXML
    private void removeWykladowcaOnClick(ActionEvent event) throws IOException, SQLException{
            ModelEditWykladowca wykladowca=(ModelEditWykladowca)tables.getSelectionModel().getSelectedItem();
           
            String sql="DELETE FROM wykladowca WHERE id_wykladowcy = ? ";
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Usuwanie wykladowcy");
            alert.setHeaderText(null);
            alert.setContentText("Czy na pewno chcesz usunąc tego wykładowcę z listy?");
            Optional <ButtonType> action = alert.showAndWait();
            
            if(action.get() == ButtonType.OK){
                
            tables.getItems().removeAll(tables.getSelectionModel().getSelectedItem());  
            
            try{
            
                try (Connection myConn = ConnectionManager.getConnection()) {
                 try (PreparedStatement st = myConn.prepareStatement(sql)) {
                    st.setString(1, wykladowca.getId_Wykladowcy());
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
