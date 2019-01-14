package start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class FXMLdziekanatController implements Initializable {

    @FXML
    private Button EditStudent;
    @FXML
    private Button Logout;
    @FXML 
    private Button Wnioski;
@FXML
    private Button EditWykladowca;

  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage)Logout.getScene().getWindow();
        dialogStage.close(); // zamknięcie okna po wylogowaniu
        
        Stage stage = new Stage(); 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); // powrót do okna głównego
        
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show(); 
    }
    
    @FXML
    private void redirectToEditStudent(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage)EditStudent.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditStudent.fxml"));
        
        Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
    @FXML
    private void redirectToWnioski(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) Wnioski.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass() .getResource("FXMLwnioski.fxml"));
                
        Scene scene = new Scene(root);
                
                stage.setScene(scene);
                stage.show();
    }
       @FXML
    private void redirectToEditWykladowca(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage)EditWykladowca.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditWykladowca.fxml"));
        
        Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }

}
        
   

