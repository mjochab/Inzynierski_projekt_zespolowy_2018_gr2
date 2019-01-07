package start;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        PreparedStatement st;
        ResultSet rs;
        if (rbStudent.isSelected()) {
            myConn = ConnectionManager.getConnection();
            int a;
            int b;
            st = myConn.prepareStatement("SELECT * FROM student WHERE nr_indeksu = ? and haslo = ?");
            st.setString(1, UserField.getText());

            st.setString(2, PassField.getText());

            rs = st.executeQuery();

            if (rs.next()) {

               
                Stage stage = new Stage();
                  FXMLLoader loader=new FXMLLoader();
                
               loader.setLocation(getClass().getResource("FXMLstudent.fxml"));
             loader.load();
               // Pane root= loader.load(getClass().getResource("/start/FXMLstudent.fxml").openStream());
              
               FXMLstudentController display= loader.getController();
                display.setText(UserField.getText());
                Parent root=loader.getRoot();
                Scene scene = new Scene(root);
              
                stage.setScene(scene);
                stage.show();
                Stage dialogStage = (Stage) buttonLog.getScene().getWindow();
               dialogStage.close(); // zamknięcie okna po wylogowaniu

            } else {

                labelOne.setText("Nieprawidłowe hasło lub identyfikator!");
            }
        } else if (rbWykladowca.isSelected()) {

            myConn = ConnectionManager.getConnection();

            st = myConn.prepareStatement("SELECT * FROM wykladowca WHERE id_wykladowcy = ? and haslo = ?");
            st.setString(1, UserField.getText());

            st.setString(2, PassField.getText());

            rs = st.executeQuery();
            if (rs.next()) {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLwykladowca.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                Stage dialogStage = (Stage) buttonLog.getScene().getWindow();
                dialogStage.close(); // zamknięcie okna po wylogowaniu
            } else {

                labelOne.setText("Nieprawidłowe hasło lub identyfikator!");
            }
        } else if (rbDziekanat.isSelected()) {

            myConn = ConnectionManager.getConnection();

            st = myConn.prepareStatement("SELECT * FROM dziekanat WHERE id_pracownika = ? and haslo = ?");
            st.setString(1, UserField.getText());

            st.setString(2, PassField.getText());

            rs = st.executeQuery();
            if (rs.next()) {

                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLdziekanat.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                Stage dialogStage = (Stage) buttonLog.getScene().getWindow();
                dialogStage.close(); // zamknięcie okna po wylogowaniu
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
