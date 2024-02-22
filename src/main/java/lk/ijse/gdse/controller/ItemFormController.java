package lk.ijse.gdse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.DB.Db;
import lk.ijse.gdse.Entity.Item;

public class ItemFormController {

    public TableView tblItem;
    public TableColumn colId;
    public TableColumn colname;
    public TableColumn colUnitPrice;
    @FXML
    private AnchorPane ItemForm;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtUnitPrice;

    public void initialize(){
        getAllItems();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtItemId.getText();

        int index=0;
        for (Item item:Db.itemArrayList){
            if (item.getId().equals(id)){
                Db.itemArrayList.remove(index);
                break;
            }
            index++;
        }
        getAllItems();
        txtItemId.setText("");
        txtItemName.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String name = txtItemName.getText();
        double price = Double.parseDouble(txtUnitPrice.getText());

        for (Item item:Db.itemArrayList) {
            if (item.getId().equals(id)) {
                new Alert(Alert.AlertType.ERROR,"Incorrect input").showAndWait();
                break;
            }
        }
        Item it = new Item(id,name,price);
        Db.itemArrayList.add(it);

        System.out.println(Db.itemArrayList);

        getAllItems();
        txtItemId.setText("");
        txtItemName.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String name = txtItemName.getText();
        double price = Double.parseDouble(txtUnitPrice.getText());

        int index=0;
        for(Item item:Db.itemArrayList){
            if (item.getId().equals(id)){
                Db.itemArrayList.set(index,new Item(id,name,price));
                break;
            }
            index++;
        }
        getAllItems();
        txtItemId.setText("");
        txtItemName.setText("");
        txtUnitPrice.setText("");
    }

    public void getAllItems(){
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        for(Item item:Db.itemArrayList){
            itemObservableList.add(new Item(item.getId(), item.getName(), item.getUnitPrice()));
        }
        tblItem.setItems(itemObservableList);
    }

    public void clearTextField(){
        txtItemId.clear();
        txtItemName.clear();
        txtUnitPrice.clear();
    }

    public void OnMouseClicked(MouseEvent mouseEvent) {
        int index = tblItem.getSelectionModel().getSelectedIndex();

        if (index <= -1){
            return;
        }
        String id = colId.getCellData(index).toString();
        String name = colname.getCellData(index).toString();
        double unitPrice = Double.parseDouble(colUnitPrice.getCellData(index).toString());

        System.out.println(id);

        txtItemId.setText(id);
        txtItemName.setText(name);
        txtUnitPrice.setText(String.valueOf(unitPrice));
    }

}
