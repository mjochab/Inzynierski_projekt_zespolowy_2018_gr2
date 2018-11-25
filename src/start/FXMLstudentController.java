package start;

import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLstudentController implements Initializable {

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnGrade;
    @FXML
    private Button btnSubject;
    @FXML
    private Button btnScholarship;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) btnLogout.getScene().getWindow();
        dialogStage.close(); // zamknięcie okna po wylogowaniu

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); // powrót do okna głównego

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void redirectToGrades(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) btnGrade.getScene().getWindow();
        dialogStage.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Grades.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    
     @FXML
    private void redirectToSubject(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) btnSubject.getScene().getWindow();
        dialogStage.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SubjectSelect.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    
       @FXML
    private void redirectToScholarship(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) btnScholarship.getScene().getWindow();
        dialogStage.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Scholarship.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
