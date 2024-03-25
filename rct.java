import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class rct implements Initializable {

    @FXML
    private TableView<Cart> Bill_tb;

    @FXML
    private Label addr;

    @FXML
    private Label cusname;

    @FXML
    private Label docname;

    @FXML
    private Label dt;

    @FXML
    private Label inscomp;

    @FXML
    private TableColumn<Cart, String> mn_col;

    @FXML
    private TableColumn<Cart, Float> p_col;

    @FXML
    private Label pay;

    @FXML
    private Label pharmname;

    @FXML
    private Label phname;

    @FXML
    private Label phne;

    @FXML
    private TableColumn<Cart, Integer> q_col;

    @FXML
    private Label rct;

    @FXML
    private Label ttl;

    private ObservableList<String> listIn;
    private ObservableList<String> listName;
    private ObservableList<String> listpay;

    private ObservableList<Customer> listcustomer;
    private ObservableList<Medicine> listMedicine;
    private ObservableList<Doctor> listDoctor;

    float totalprice = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mn_col.setCellValueFactory(new PropertyValueFactory<Cart, String>("Name"));
        p_col.setCellValueFactory(new PropertyValueFactory<Cart, Float>("price"));
        q_col.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("quantity"));

        listcustomer = FXCollections.observableArrayList(Data.dataCustomer);
        listMedicine = FXCollections.observableArrayList(Data.dataMedicine);
        listDoctor = FXCollections.observableArrayList(Data.dataDoctor);

        listIn = FXCollections.observableArrayList(Data.getIn());
        listpay = FXCollections.observableArrayList(Data.getpay());
        listName = FXCollections.observableArrayList(Data.getn());

        LocalDate date = mysales.getDatePickerValue();
        dt.setText(date != null ? date.toString() : "");

        String customerName = mysales.getSelectedCustomerName();
        cusname.setText(customerName != null ? customerName : "");

        String dName = mysales.getSelectedDoctorName();
        docname.setText(dName != null ? dName : "");

        String insuranceCompany = mysales.getSelectedInsuranceCompany();
        inscomp.setText(insuranceCompany != null ? insuranceCompany : "");

        String paym = mysales.getSelectedpayment();
        pay.setText(paym != null ? paym : "");

        String pharmn = mysales.getSelectedpharm();
        pharmname.setText(pharmn != null ? pharmn : "");

        populateBillTableView();
        ttl.setText(String.valueOf(totalprice));
    }

    public void populateBillTableView() {
        ArrayList<Cart> cartItems = mysales.allCart;
        ObservableList<Cart> billItems = FXCollections.observableArrayList();

        for (Cart cartItem : cartItems) {
            Cart billItem = new Cart(cartItem.getName(), cartItem.getPrice(), cartItem.getQuantity());
            billItems.add(billItem);
            totalprice += billItem.getQuantity() * billItem.getPrice();
        }

        Bill_tb.setItems(billItems);
    }
    public void callall(javafx.event.ActionEvent actionEvent) throws IOException {
        mysales.allCart.clear();
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




}

