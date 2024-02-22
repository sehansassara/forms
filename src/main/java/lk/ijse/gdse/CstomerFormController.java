package lk.ijse.gdse;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.DB.Db;
import lk.ijse.gdse.Entity.Customer;

public class CstomerFormController {

    @FXML
    private AnchorPane CustomerForm;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<String, String> colAddress;

    @FXML
    private TableColumn<String, String> colID;

    @FXML
    private TableColumn<String, String> colName;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    public void initialize(){
        getAllCustomers();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Id = txtCustomerID.getText();

        int index=0;
        for (Customer customer:Db.customerArrayList){
            if (customer.getID().equals(Id)){
                Db.customerArrayList.remove(index);
                break;
            }
            index++;
        }
        getAllCustomers();
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String Id = txtCustomerID.getText();
        String Name = txtCustomerName.getText();
        String Address = txtCustomerAddress.getText();

        Customer customer = new Customer(Id, Name, Address);
        Db.customerArrayList.add(customer);

        getAllCustomers();
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String Id = txtCustomerID.getText();
        String Name = txtCustomerName.getText();
        String Address = txtCustomerAddress.getText();

        int index=0;
        for(Customer customer : Db.customerArrayList){
            if (customer.getID().equals(Id)){
                Db.customerArrayList.set(index,new Customer(Id,Name,Address));
                break;
            }
            index++;
        }
        getAllCustomers();
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
    }

    @FXML
    void txtCustomerAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerNameOnAction(ActionEvent event) {

    }

    public void getAllCustomers(){
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        for (Customer customer:Db.customerArrayList){
            customerObservableList.add(new Customer(customer.getID(),customer.getName(),customer.getAddress()));
        }

        tblCustomer.setItems(customerObservableList);
    }

        public void clearTextField(){
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtCustomerAddress.clear();
        }

    public void OnMouseClicked(MouseEvent mouseEvent) {
        int index = tblCustomer.getSelectionModel().getSelectedIndex();

        if (index <= -1){
            return;
        }
        String id = colID.getCellData(index).toString();
        String name = colName.getCellData(index).toString();
        String address = colAddress.getCellData(index).toString();

        txtCustomerID.setText(id);
        txtCustomerName.setText(name);
        txtCustomerAddress.setText(address);
    }
}
