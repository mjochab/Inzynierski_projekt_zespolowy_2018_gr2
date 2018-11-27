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

public class FXMLwykladowcaController implements Initializable {

    private Button Logout;
    @FXML
    private Button btnLogout;
    @FXML
    private Button editMark;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void redirectToEditMark(ActionEvent event) throws IOException {

        Stage dialogStage = (Stage) btnLogout.getScene().getWindow();
        dialogStage.close(); // zamknięcie okna po wylogowaniu

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLeditMark.fxml")); // powrót do okna głównego

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
