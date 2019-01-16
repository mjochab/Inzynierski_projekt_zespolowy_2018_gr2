/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

    private ObservableList<String> subjectList = FXCollections.observableArrayList();

    private ObservableList<String> studentList = FXCollections.observableArrayList();
    @FXML
    private ComboBox btnChooseSubject;
    @FXML
    private ComboBox btnChooseStudent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dodajPrzedmiot();
        chooseStudent();
    }

    @FXML
    private void prevWindow(ActionEvent event) throws IOException {
        Stage dialogStage = (Stage) prevBtn.getScene().getWindow();
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
        Stage dialogStage = (Stage) prevBtn.getScene().getWindow();
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
        String sql = "INSERT INTO oceny ( ocena) VALUES (?)";
        String sql1 = "INSERT INTO przed_ocen ( ocena) VALUES (?)";

        if (validateFields()) {
            try {

                try (Connection myConn = ConnectionManager.getConnection()) {
                    PreparedStatement st = myConn.prepareStatement(sql);

                    st.setString(1, this.newMark.getText());

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

    }

    private boolean validateFields() {
        if (newMark.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Uwaga");
            alert.setHeaderText(null);
            alert.setContentText("Proszę wypełnić wszystkie pola");
            alert.showAndWait();

            return false;
        }
        return true;
    }

    @FXML
    private void dodajPrzedmiot() {
        String sqlSubjectName = "SELECT * FROM `przedmioty_studenci` inner join przedmioty on przedmioty_studenci.id_przedmiotu=przedmioty.id_przedmiotu inner join student on przedmioty_studenci.id_studenta=student.id_studenta ";

        Connection myConn = null;
        try {
            myConn = ConnectionManager.getConnection();
            PreparedStatement ps = myConn.prepareStatement(sqlSubjectName);
            ResultSet rs = ps.executeQuery(sqlSubjectName);

            while (rs.next()) {
                if (!subjectList.contains(rs.getString("nazwa"))) {
                    subjectList.add(rs.getString("nazwa"));
                }
            }

            rs.close();
            ps.close();
            myConn.close();

        } catch (SQLException ex) {
            System.err.println("SQL ERR" + ex);
        }

        btnChooseSubject.setItems(subjectList);
    }

    @FXML
    private void chooseStudent() {

        btnChooseSubject.setOnAction(e -> {
            System.out.println("user selected: " + btnChooseSubject.getValue());

            String sqlStudentName = "SELECT * FROM `przedmioty_studenci` inner join przedmioty on przedmioty_studenci.id_przedmiotu=przedmioty.id_przedmiotu inner join student on przedmioty_studenci.id_studenta=student.id_studenta";

            Connection myConn = null;
            try {
                myConn = ConnectionManager.getConnection();
                PreparedStatement ps = myConn.prepareStatement(sqlStudentName);
               // ps.setString(1, (String)btnChooseSubject.getSelectionModel().getSelectedItem());
                ResultSet rs = ps.executeQuery(sqlStudentName);

                while (rs.next()) {

                    if (!studentList.contains(rs.getString("nr_indeksu"))) {

                        studentList.add(rs.getString("nr_indeksu"));
                    }

                }

                rs.close();
                ps.close();
                myConn.close();

            } catch (SQLException ex) {
                System.err.println("SQL ERR" + ex);

            }
        });
        btnChooseStudent.setItems(studentList);
    }

}
