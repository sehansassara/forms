package lk.ijse.gdse;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HomeFormController {

    public AnchorPane Homeform;
    public AnchorPane ControllArea;
    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnLogout;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CstomerForm.fxml"));
        ControllArea.getChildren().clear();
        ControllArea.getChildren().add(root);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ItemForm.fxml"));
        ControllArea.getChildren().clear();
        ControllArea.getChildren().add(root);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage) Homeform.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

}
