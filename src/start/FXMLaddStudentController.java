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


public class FXMLaddStudentController implements Initializable {
    
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
        
        String sql = "INSERT INTO student (haslo, imie, nazwisko, pesel, kierunek_s, ulica, "
                + "nr_domu, kod_p, miejscowosc, nr_tel, nr_indeksu) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
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
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Dodanie studenta");
                alert.setHeaderText(null);
                alert.setContentText("Udało się poprawnie dodać studenta");
                alert.showAndWait();
                
                st.execute();
            }
             
            } catch (SQLException e){
                e.printStackTrace();
            }
        this.password.setText(" ");
        this.name.setText(" ");
        this.lastName.setText(" ");
        this.pesel.setText(" ");
        this.degreeCourse.setText(" ");
        this.street.setText(" ");
        this.houseNumber.setText(" ");
        this.postCode.setText(" ");
        this.city.setText(" ");
        this.phoneNumber.setText(" ");
        this.indexNumber.setText(" ");
        
        } 
    }
    
    @FXML
    private void clearFields(ActionEvent event){
        this.password.setText(" ");
        this.name.setText(" ");
        this.lastName.setText(" ");
        this.pesel.setText(" ");
        this.degreeCourse.setText(" ");
        this.street.setText(" ");
        this.houseNumber.setText(" ");
        this.postCode.setText(" ");
        this.city.setText(" ");
        this.phoneNumber.setText(" ");
        this.indexNumber.setText(" ");
    }
    
    private boolean validateFields(){
        if(password.getText().isEmpty() | name.getText().isEmpty() |
                lastName.getText().isEmpty() | pesel.getText().isEmpty() |
                degreeCourse.getText().isEmpty() | street.getText().isEmpty() |
                houseNumber.getText().isEmpty() | postCode.getText().isEmpty() |
                city.getText().isEmpty() | phoneNumber.getText().isEmpty() |
                indexNumber.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Uwaga");
                alert.setHeaderText(null);
                alert.setContentText("Proszę wypełnić wszystkie pola");
                alert.showAndWait();
                
                return false;
        }
        return true;
    }
        
    }
            
            
            
