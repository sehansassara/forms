package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
public class LoginFormController {

    public AnchorPane LoginForm;
    @FXML
    private JFXButton btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String name = txtUserName.getText();
        String pw = txtPassword.getText();

        if (true) {//name.equals("Admin") && pw.equals("1234")
            Parent root = FXMLLoader.load(getClass().getResource("/view/HomeForm.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) LoginForm.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }else{
            new Alert(Alert.AlertType.ERROR,"Incorrect input").showAndWait();
        }
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

}