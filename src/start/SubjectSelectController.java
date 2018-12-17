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
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SubjectSelectController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnBackward;
    @FXML
    private Button btnSubmit;
    @FXML
    private ComboBox<ModelSubject> ComboBox;

     private ObservableList<ModelSubject> oblist = FXCollections.observableArrayList();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      try {
            PreparedStatement st;
            Connection myConn = ConnectionManager.getConnection();
            st = myConn.prepareStatement("SELECT * FROM przedmioty where nazwa = ?");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                oblist.add(new ModelSubject(rs.getString("nazwa")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        

        ComboBox.setItems(oblist);
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

    @FXML
    private void submitGrade(ActionEvent event) {
    }

    @FXML
    private void chooseSubject(ActionEvent event) {
        ComboBox.setItems(oblist);
    }

}
