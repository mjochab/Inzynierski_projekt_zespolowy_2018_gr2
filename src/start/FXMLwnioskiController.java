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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLwnioskiController implements Initializable {
    
    @FXML
    private Button Logout;
    @FXML
    private Button prevBtn;
    @FXML
        private TableView<ModelWnioski> tablew;
          @FXML
    private TableColumn<ModelWnioski, String> col_id_wniosku;
                      @FXML
    private TableColumn<ModelWnioski, String> col_nr_indeksu;
    

public static ObservableList<ModelWnioski> oblista=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            PreparedStatement st;
            Connection myConn=ConnectionManager.getConnection();
             st = myConn.prepareStatement("SELECT * FROM wniosek");
            
            ResultSet rs= st.executeQuery();
            
            
            
            while (rs.next())   {
                oblista.add(new ModelWnioski(rs.getString("id_wniosku"), rs.getString("nr_indeksu")));
                
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
                col_id_wniosku.setCellValueFactory(new PropertyValueFactory<ModelWnioski, String>("id_wniosku"));
                col_nr_indeksu.setCellValueFactory(new PropertyValueFactory<ModelWnioski, String>("nr_indeksu"));
              
                
                tablew.setItems(null);
                tablew.setItems(oblista);
                
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
                Parent root = FXMLLoader.load(getClass().getResource("FXMLdziekanat.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
}
