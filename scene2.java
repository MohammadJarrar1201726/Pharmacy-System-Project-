import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class scene2 implements Initializable {
    ObservableList<Manufacturer> mymanufactures = FXCollections.observableArrayList(Data.dataManufacturer);
    ObservableList<Medicine> mymedicines = FXCollections.observableArrayList(Data.dataMedicine);
    Integer index;


    @FXML
    private Button back1;

    @FXML
    void getmycust(MouseEvent event) {

    }

    @FXML
    private TextField medname;

    @FXML
    private TableView<Medicine> medicinestable;

    @FXML
    private TableColumn<Medicine, String> medicinesnames;

    @FXML
    private TableView<Manufacturer> mantable;

    @FXML
    private TableColumn<Manufacturer, String> manufacturenames;

    @FXML
    private TextField manufacturername;

    @FXML
    private Button placeorder;

    @FXML
    private TextField quantity;
    @FXML
    private TableColumn<Medicine, String> Expire_Date1;
    @FXML
    void bck(ActionEvent event) {

    }

    @FXML
    public void kkk(MouseEvent event) {


    }


    @FXML
    public void placeOrder() {

    }

    private boolean isNumeric(String input) {
        return Pattern.matches("\\d+", input);
    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void show(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manufacturenames.setCellValueFactory(new PropertyValueFactory<Manufacturer, String>("mname"));
        medicinesnames.setCellValueFactory(new PropertyValueFactory<Medicine, String>("mType"));
        Expire_Date1.setCellValueFactory(new PropertyValueFactory<Medicine, String>("expiryDate"));
        medicinestable.setItems(mymedicines);
        mantable.setItems(mymanufactures);

    }






    public void placeorder(ActionEvent actionEvent) {
        String quantityText = quantity.getText();
        Manufacturer selectedItem = mantable.getSelectionModel().getSelectedItem();
        Medicine selectedItem1 = medicinestable.getSelectionModel().getSelectedItem();
        if (!isNumeric(quantityText  )|| Integer.parseInt(quantityText) < 0 || selectedItem == null ||selectedItem1 == null) {
            showErrorMessage("Invalid Quantity", "Invalid Input");
        } else {
            int quantity = Integer.parseInt(quantityText);
            Data.updateMedicineQuantity(selectedItem1.getMid(),selectedItem1.getCid(),selectedItem1.getQuantity()+quantity);
            show("Added successfully", "Order has been placed");
        }
    }


    @FXML

    public void searchman(KeyEvent keyEvent) {
        ObservableList<Manufacturer> newlistman = null;
        ArrayList<Manufacturer> dataman = new ArrayList<>();
        dataman.clear();
        String inputCname = "";

        try {
            inputCname = manufacturername.getText();
            for (Manufacturer man : Data.dataManufacturer) {
                if (man.getMname().toLowerCase().contains(inputCname.toLowerCase())) {
                    dataman.add(man);
                }
            }
            newlistman = FXCollections.observableArrayList(dataman);
            if (newlistman != null)
                mantable.setItems(newlistman);


            if (inputCname == "")
                mantable.setItems(newlistman);

        } catch (NumberFormatException e) {
            mantable.setItems(newlistman);
//                System.out.println("Invalid input");
        }


    }
    @FXML

    public void searchmed(KeyEvent keyEvent) {
        ObservableList<Medicine> newlistmed = null;
        ArrayList<Medicine> datamed = new ArrayList<>();
        datamed.clear();
        String inputCname = "";
//        Medicine n = new Medicine();
//        String mname = n.getMname();

        try {
            inputCname = medname.getText();
            for (Medicine med : Data.dataMedicine) {
                if (med.getMType().toLowerCase().contains(inputCname.toLowerCase())) {
                    datamed.add(med);
                }
            }
            newlistmed = FXCollections.observableArrayList(datamed);
            if (newlistmed != null)
                medicinestable.setItems(newlistmed);


            if (inputCname == "")
                medicinestable.setItems(newlistmed);

        } catch (NumberFormatException e) {
            medicinestable.setItems(newlistmed);
//                System.out.println("Invalid input");
        }


    }
    public void callall(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Scene scene = new Scene(root);


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
//        root.prefWidth(screenBounds.getWidth());
//        root.prefHeight(screenBounds.getHeight());

        Data.stage.setScene(scene);
        Data.stage.setTitle("my pharmacy");
//        primaryStage.setFullScreen(true);

        Data.stage.show();

    }
    public void callman(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("csutomer.fxml")));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
        Scene scene = new Scene(root);
        Data.stage.setScene(scene);
        Data.stage.show();

    }

}
