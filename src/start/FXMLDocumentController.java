package start;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    Connection myConn = null;

    private Label label;
    @FXML
    private Pane logPane;
    @FXML
    private AnchorPane image;
    @FXML
    private TextField UserField;
    @FXML
    private PasswordField PassField;
    @FXML
    private RadioButton rbStudent;
    @FXML
    private ToggleGroup oneRB;
    @FXML
    private RadioButton rbWykladowca;
    @FXML
    private RadioButton rbDziekanat;
    @FXML
    private Button buttonLog;
    @FXML
    private Label labelOne;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {

        Statement st;
        ResultSet rs;
        if (rbStudent.isSelected()) {
            myConn = ConnectionManager.getConnection();

            st = myConn.createStatement();
            String searchQuery;
            rs = st.executeQuery("SELECT * FROM student WHERE nr_indeksu" + " = '" + UserField.getText() + "' or haslo = '" + PassField.getText() + "'");
            if (rs.next()) {

                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLstudent.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                Stage dialogStage = (Stage) buttonLog.getScene().getWindow();
                dialogStage.close();
            } else {

                labelOne.setText("Nieprawidłowe hasło lub identyfikator!");
            }
        } else if (rbWykladowca.isSelected()) {

            myConn = ConnectionManager.getConnection();

            st = myConn.createStatement();
            String searchQuery;
            rs = st.executeQuery("SELECT * FROM wykladowca WHERE id_wykladowca" + " = '" + UserField.getText() + "' and haslo = '" + PassField.getText() + "'");
            if (rs.next()) {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLwykladowca.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                Stage dialogStage = (Stage) buttonLog.getScene().getWindow();
                dialogStage.close();
            } else {

                labelOne.setText("Nieprawidłowe hasło lub identyfikator!");
            }
        } else if (rbDziekanat.isSelected()) {

            myConn = ConnectionManager.getConnection();

            st = myConn.createStatement();
            String searchQuery;
            rs = st.executeQuery("SELECT * FROM dziekanat WHERE id_pracownika" + " = '" + UserField.getText() + "' and haslo = '" + PassField.getText() + "'");
            if (rs.next()) {

                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLdziekanat.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                Stage dialogStage = (Stage) buttonLog.getScene().getWindow();
                dialogStage.close();
            } else {

                labelOne.setText("Nieprawidłowe hasło lub identyfikator!");
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
