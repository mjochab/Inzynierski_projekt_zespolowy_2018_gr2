package start;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dodz
 */
public class GradesController extends FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnBackward;
    @FXML
    private TableView<ModelGrades> table;
    @FXML
    private TableColumn<ModelGrades, String> col_ocena;
    @FXML
    private TableColumn<ModelGrades, String> col_id_wykladowcy;
    @FXML
    private TableColumn<ModelGrades, String> col_id_przedmiotu;

    public static ObservableList<ModelGrades> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            PreparedStatement st;
            Connection myConn = ConnectionManager.getConnection();
            st = myConn.prepareStatement("SELECT * FROM oceny");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                oblist.add(new ModelGrades(rs.getString("ocena"), rs.getString("id_wykladowcy"),
                        rs.getString("nazwa")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        col_ocena.setCellValueFactory(new PropertyValueFactory<ModelGrades, String>("ocena"));
        col_id_wykladowcy.setCellValueFactory(new PropertyValueFactory<ModelGrades, String>("Wykladowca"));
        col_id_przedmiotu.setCellValueFactory(new PropertyValueFactory<ModelGrades, String>("Przedmiot"));

        table.setItems(null);
        table.setItems(oblist);

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
    private void printToPdf(ActionEvent event) throws IOException {
        try {
            String file_name="C:\\Oceny.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            
            Connection myConn=ConnectionManager.getConnection();
            PreparedStatement ps=null;
            ResultSet rset=null;
            
            String query="select * from oceny";
            ps=myConn.prepareStatement(query);
            rset=ps.executeQuery();
            
            Paragraph para = new Paragraph(" ");
            
            Paragraph title = new Paragraph("TABELA OCEN STUDENTA");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(para);
            document.add(para);
            
            //table1
            PdfPTable tbl = new PdfPTable(3);
            tbl.addCell("Ocena");
            tbl.addCell("Wykladowca");
            tbl.addCell("Przedmiot");
            document.add(tbl);
            
            document.add(para);

            
            //table2
            PdfPTable tbl2 = new PdfPTable(3);
            while(rset.next()) {
                Paragraph p1 = new Paragraph(rset.getString("ocena"));
                Paragraph p2 = new Paragraph(rset.getString("nazwisko_w"));
                Paragraph p3 = new Paragraph(rset.getString("nazwa"));
                tbl2.addCell(p1);
                tbl2.addCell(p2);
                tbl2.addCell(p3);
            }
            document.add(tbl2);
            document.close();
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }

}
