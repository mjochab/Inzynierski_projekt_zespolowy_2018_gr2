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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLaddWykladowcaController implements Initializable {
    
    @FXML
    private Button Logout;
    @FXML
    private Button prevBtn;
    @FXML
    private Button confirm;
    @FXML
    private Button clearbtn;
    @FXML
    private TextField pesel;
    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField haslo;
    
    
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
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditWykladowca.fxml"));
                
                Scene scene;
        scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
    @FXML
    private void addWykladowcaOnClick(ActionEvent event)throws IOException, SQLException {
        
        String sql = "INSERT INTO wykladowca (imie, nazwisko, haslo, pesel) VALUES (?,?,?,?)";
        
        if(validateFields()){
        
        try{
            
            try (Connection myConn = ConnectionManager.getConnection()) {
                PreparedStatement st = myConn.prepareStatement(sql);
                
                st.setString(1, this.imie.getText());
                st.setString(2, this.nazwisko.getText());
                st.setString(3, this.haslo.getText());
                st.setString(4, this.pesel.getText());
     
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Dodanie wykładowcy");
                alert.setHeaderText(null);
                alert.setContentText("Udało się poprawnie dodać wykładowcę");
                alert.showAndWait();
                
                st.execute();
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
    private void clearFields(ActionEvent event){
          this.imie.setText(null);
        this.nazwisko.setText(null);
        this.haslo.setText(null);
        this.pesel.setText(null);
    }
    
    private boolean validateFields(){
        if(haslo.getText().isEmpty() | 
                nazwisko.getText().isEmpty() |
                pesel.getText().isEmpty() |
                imie.getText().isEmpty()){
            
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
            
            
            
