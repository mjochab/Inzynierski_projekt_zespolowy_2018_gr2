package start;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static start.GradesController.oblist;

/**
 * FXML Controller class
 *
 * @author dodz
 */
public class ScholarshipController extends FXMLstudentController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnBackward;
    @FXML
    private Label indeks;
   @FXML
   private Button zlozButton;

    @FXML
        private TableView<ModelScholarship> tableq;
    @FXML
    private TableColumn<ModelScholarship, String> colnr_indeksu;
    @FXML
    private TableColumn<ModelScholarship, String> col_srednia;


    /**
     * Initializes the controller class.
     */
        public static ObservableList<ModelScholarship> oblistq = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle rb) {

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
      public void setIndeks(String indeks1){
        indeks.setText(indeks1);
       try{
                            PreparedStatement st;
            Connection myConn = ConnectionManager.getConnection();
            st = myConn.prepareStatement("SELECT nr_indeksu, avg(ocena) as avoc FROM oceny where nr_indeksu= ?");
             st.setString(1, indeks.getText());

            ResultSet rs = st.executeQuery();
                 while(rs.next()) {
                oblistq.add(new ModelScholarship(rs.getString("nr_indeksu"), rs.getString("avoc")));

            }
        }catch(SQLException ex){
       System.out.println(ex.getMessage());
             
    }
        
                colnr_indeksu.setCellValueFactory(new PropertyValueFactory<ModelScholarship, String>("NrIndeksu"));
        col_srednia.setCellValueFactory(new PropertyValueFactory<ModelScholarship, String>("srednia"));
   

        
        tableq.setItems(oblistq);
            System.out.println(indeks.getText());
  
    }
   @FXML
    private void zlozWniosek(ActionEvent event) throws IOException {
         try{
                            PreparedStatement st;
            Connection myConn = ConnectionManager.getConnection();
            st = myConn.prepareStatement("INSERT INTO wniosek (nr_indeksu, srednia)  SELECT nr_indeksu, avg(ocena) FROM oceny WHERE nr_indeksu=?");
             st.setString(1, indeks.getText());

             st.executeUpdate();

        }catch(SQLException ex){
       System.out.println(ex.getMessage());
             
    }
    }
    



}
