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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dodz
 */
public class GradesController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnBackward;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void backToStudent(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) btnBackward.getScene().getWindow();
        dialogStage.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLstudent.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
