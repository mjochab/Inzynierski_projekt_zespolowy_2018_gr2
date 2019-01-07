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
    private ComboBox ComboBox;

    private ObservableList<String> subjectList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {     
    chooseSubject();
    }

    @FXML
    private void chooseSubject() {
         String sqlSubjectName = "select nazwa from przedmioty";
        
        Connection myConn = null;
        try {
            myConn = ConnectionManager.getConnection();
            PreparedStatement ps = myConn.prepareStatement(sqlSubjectName);
            ResultSet rs = ps.executeQuery(sqlSubjectName);

            while (rs.next()) {
                if(!subjectList.contains(rs.getString("nazwa")))
                subjectList.add(rs.getString("nazwa"));
            }

            rs.close();
            ps.close();
            myConn.close();
      
        } catch (SQLException ex) {
            System.err.println("SQL ERR" + ex);
        }
        
        ComboBox.setItems(subjectList);
        
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
    private void submitSubject(ActionEvent event) {
    }

}
