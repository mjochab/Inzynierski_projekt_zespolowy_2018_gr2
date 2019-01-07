/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dorota
 */
public class FXMLaddMarkController implements Initializable {

    @FXML
    private Button prevBtn;
    @FXML
    private Button Logout;
    @FXML
    private Button addBtn;
    @FXML
    private TextField newMark;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void prevWindow(ActionEvent event) throws IOException {
          Stage dialogStage = (Stage)prevBtn.getScene() .getWindow();
        dialogStage.close();
        
        Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLeditMark.fxml"));
                
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
   private void addToMark(ActionEvent event) throws IOException, SQLException {
        String sql = "INSERT INTO oceny ( ocena, nr_indeksu, nazwa, imie_w, "
                + "nazwisko_w, id_wykladowcy, id_oceny) VALUES (?,?,?,?,?,?,?)";
        if (validateFields()) {
            try {

                try (Connection myConn = ConnectionManager.getConnection()) {
                    PreparedStatement st = myConn.prepareStatement(sql);

                    st.setString(1, this.newMark.getText());
                    st.setString(2, this.index.getText());
                    st.setString(3, this.subject.getText());
                    st.setString(4, this.name.getText());
                    st.setString(5, this.surname.getText());
                    st.setString(6, this.id_w.getText());
                    st.setString(7, this.id.getText());

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Dodanie oceny");
                    alert.setHeaderText(null);
                    alert.setContentText("Udało się poprawnie dodać ocenę");
                    alert.showAndWait();

                    st.execute();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearFields(ActionEvent event) {
        this.newMark.setText(" ");
        this.index.setText(" ");
        this.subject.setText(" ");
        this.name.setText(" ");
        this.surname.setText(" ");
        this.id_w.setText(" ");

    }

    private boolean validateFields() {
        if (newMark.getText().isEmpty() | index.getText().isEmpty()
                | subject.getText().isEmpty() | name.getText().isEmpty()
                | surname.getText().isEmpty() | id_w.getText().isEmpty()) {

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



