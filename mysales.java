import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class mysales implements Initializable {


    @FXML
    private Button back1;
    @FXML
    private TextField CustomerTXT;

    @FXML
    private TableColumn<Customer, String> Cutomer_col;
    @FXML
    public  DatePicker date;
    public static DatePicker datePicker;
    @FXML
    private TextField DoctorTXT;
    @FXML
    private TableView<?> Bill_tb;

    @FXML
    private Label addr;

    @FXML
    private Label addr1;

    @FXML
    private Label cusname;

    @FXML
    private Label docname;

    @FXML
    private Label inscomp;

    @FXML
    private TableColumn<?, ?> mn_col;

    @FXML
    private TableColumn<?, ?> p_col;

    @FXML
    private Label pay;

    @FXML
    private Label pay1;

    @FXML
    private Label pharmname;

    @FXML
    private Label phname;

    @FXML
    private Label phname1;

    @FXML
    private Label phne;

    @FXML
    private Label phne1;

    @FXML
    private TableColumn<?, ?> q_col;

    @FXML
    void Datelbl(MouseEvent event) {

    }

    @FXML
    void rctno(MouseEvent event) {

    }


    @FXML
    private TableColumn<Doctor, String> Doctors_col;

    @FXML
    private TableColumn<Medicine, String> Expire_Date_col;

    @FXML
    private ComboBox<String> InsuranceCOMBO;

    @FXML
    private TableColumn<Medicine, String> Med_col;

    @FXML
    private TextField MedicineTXT;

    @FXML
    private Button NEW;

    @FXML
    private ComboBox<String> PaymentCOMBO;

    @FXML
    private ComboBox<String> PharmasistCOMBO;

    @FXML
    private TextField QuantityTXT;

    public static ArrayList<Cart> allCart  = new ArrayList<>();
    @FXML
    private TableView<Customer> table_Customer;
    public static TableView<Customer> customerTableView;
    public static TableView<Doctor> docTableView;


    @FXML
    private TableView<Doctor> table_Doctor;

    @FXML
    private TableView<Medicine> table_Med;

    @FXML
    private TableView<Cart> Cart;
    @FXML
    private TableColumn<Cart, String> Name_col;
    @FXML
    private TableColumn<Cart, Float> Price_col;
    @FXML
    private TableColumn<Customer, Integer> ID_col;
    @FXML
    private TableColumn<Cart, Integer> Quantiity_col;

    private ObservableList<Doctor> listDoctor;
    private ObservableList<Medicine> listMedicine;
    private ObservableList<Customer> listcustomer;
    private ObservableList<Cart> listCart;

    private ObservableList<String> listIn;

    private ObservableList<String> listName;
    private ObservableList<String> listpay;
    public static ComboBox<String> insuranceComboBox;
    public static ComboBox<String> pharmComboBox;
    public static ComboBox<String> payComboBox;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Cutomer_col.setCellValueFactory(new PropertyValueFactory<Customer,String>("cname"));
        Doctors_col.setCellValueFactory(new PropertyValueFactory<Doctor,String>("dname"));
        Med_col.setCellValueFactory(new PropertyValueFactory<Medicine,String>("mType"));
        Expire_Date_col.setCellValueFactory(new PropertyValueFactory<Medicine,String>("expiryDate"));
        ID_col.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("cid"));

        Name_col.setCellValueFactory(new PropertyValueFactory<Cart,String>("Name"));
        Price_col.setCellValueFactory(new PropertyValueFactory<Cart,Float>("price"));
        Quantiity_col.setCellValueFactory(new PropertyValueFactory<Cart,Integer>("quantity"));

        listcustomer = FXCollections.observableArrayList(Data.dataCustomer);
        listMedicine = FXCollections.observableArrayList(Data.dataMedicine);
        listDoctor = FXCollections.observableArrayList(Data.dataDoctor);


        listIn=FXCollections.observableArrayList(Data.getIn());
        listpay=FXCollections.observableArrayList(Data.getpay());
        listName=FXCollections.observableArrayList(Data.getn());

        datePicker = date;
        customerTableView = table_Customer;
        docTableView=table_Doctor;
        insuranceComboBox = InsuranceCOMBO;
        pharmComboBox = PharmasistCOMBO;
        payComboBox = PaymentCOMBO;



        InsuranceCOMBO.setItems(listIn);
        PaymentCOMBO.setItems(listpay);
        PharmasistCOMBO.setItems(listName);

        table_Customer.setItems(listcustomer);
        table_Doctor.setItems(listDoctor);
        table_Med.setItems(listMedicine);


    }
    public static LocalDate getDatePickerValue() {
        if (datePicker != null) {
            return datePicker.getValue();
        }
        return null;
    }
    public static String getSelectedCustomerName() {
        Customer selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            return selectedCustomer.getCname();
        }
        return null;
    }
    public static String getSelectedDoctorName() {
        Doctor selectedDoctor = docTableView.getSelectionModel().getSelectedItem();
        if (selectedDoctor != null) {
            return selectedDoctor.getDname();
        }
        return null;
    }
    public static String getSelectedInsuranceCompany() {
        return insuranceComboBox.getValue();
    }
    public static String getSelectedpayment() {
        return payComboBox.getValue();
    }
    public static String getSelectedpharm() {
        return pharmComboBox.getValue();
    }




    @FXML
    public void searchCustomerName(KeyEvent keyEvent) {
        ObservableList<Customer> newlistCustomer = null;
        ArrayList<Customer> dataCustomer = new ArrayList<>();
        dataCustomer.clear();
        String inputCname = "";

        try {
            inputCname = CustomerTXT.getText();
            for (Customer customer : Data.dataCustomer) {
                if (customer.getCname().toLowerCase().contains(inputCname.toLowerCase())) {
                    dataCustomer.add(customer);
                }
            }
            newlistCustomer = FXCollections.observableArrayList(dataCustomer);
            if (newlistCustomer != null)
                table_Customer.setItems(newlistCustomer);


            if (inputCname == "")
                table_Customer.setItems(newlistCustomer);

        } catch (NumberFormatException e) {
            table_Customer.setItems(newlistCustomer);
        }


    }

    public void searchdoc(KeyEvent keyEvent) {
        ObservableList<Doctor> newlistmed = null;
        ArrayList<Doctor> datamed = new ArrayList<>();
        datamed.clear();
        String inputCname = "";

        try {
            inputCname = DoctorTXT.getText();
            for (Doctor med : Data.dataDoctor) {
                if (med.getDname().toLowerCase().contains(inputCname.toLowerCase())) {
                    datamed.add(med);
                }
            }
            newlistmed = FXCollections.observableArrayList(datamed);
            if (newlistmed != null)
                table_Doctor.setItems(newlistmed);


            if (inputCname == "")
                table_Doctor.setItems(newlistmed);

        } catch (NumberFormatException e) {
            table_Doctor.setItems(newlistmed);

        }
    }
    public void searchmed(KeyEvent keyEvent) {
        ObservableList<Medicine> newlistmed = null;
        ArrayList<Medicine> datamed = new ArrayList<>();
        datamed.clear();
        String inputCname = "";

        try {
            inputCname = MedicineTXT.getText();
            for (Medicine med : Data.dataMedicine) {
                if (med.getMType().toLowerCase().contains(inputCname.toLowerCase())) {
                    datamed.add(med);
                }
            }
            newlistmed = FXCollections.observableArrayList(datamed);
            if (newlistmed != null)
                table_Med.setItems(newlistmed);


            if (inputCname == "")
                table_Med.setItems(newlistmed);

        } catch (NumberFormatException e) {
            table_Med.setItems(newlistmed);

        }
    }
    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void addCart(javafx.event.ActionEvent actionEvent){
        int Q=0;
        boolean g =false;
        Medicine selectedItem = table_Med.getSelectionModel().getSelectedItem();

        try {
            Q = Integer.parseInt(QuantityTXT.getText());

            if (Q<0  ){
                throw new NumberFormatException();
            }

            if (selectedItem != null) {
                boolean check= true;

                for(int i =0 ;i<allCart.size();i++) {
                    if (allCart.get(i).id == selectedItem.mid) {
                        if (selectedItem.getQuantity()-allCart.get(i).quantity < Q ){
                            g =true;
                            showErrorMessage("Invalid Quantity", "There no enough Quantity");
                            check = false;
                            break;
                        }
                        allCart.get(i).setQuantity(allCart.get(i).quantity + Q);
                        Cart.refresh();
                        check = false;
                    }
                }

                if (check==true)
                    allCart.add(new Cart(selectedItem.mType, selectedItem.price, Q, selectedItem.mid,selectedItem.cid,selectedItem.quantity));

                listCart=FXCollections.observableArrayList(allCart);
                Cart.setItems(listCart);
            }else {
                throw new NumberFormatException();
            }


        } catch (NumberFormatException e) {
            Data.Error();
            showErrorMessage("Invalid Input", "Please enter a valid quantity.");
            if (g){
                System.out.println("There no enough Quantity");
            }else
                System.out.println("Invalid input");
        }
    }

    @FXML
    public void Delete(javafx.event.ActionEvent actionEvent){
        Cart selectedItem = Cart.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            allCart.remove(selectedItem);

        }
        listCart=FXCollections.observableArrayList(allCart);
        Cart.setItems(listCart);
    }


    public void callall(javafx.event.ActionEvent actionEvent) throws IOException {
        allCart.clear();
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
        allCart.clear();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("csutomer.fxml")));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
        Scene scene = new Scene(root);
        Data.stage.setScene(scene);
        Data.stage.show();

    }


    public void Buy(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {;
        int Ih = 0;
        int p=0;

        Doctor selectedDoctor= table_Doctor.getSelectionModel().getSelectedItem();
        Customer selectedCustomer = table_Customer.getSelectionModel().getSelectedItem();
        String comapny = InsuranceCOMBO.getSelectionModel().getSelectedItem();
        String pharmacist = PaymentCOMBO.getSelectionModel().getSelectedItem();
        String pay = PaymentCOMBO.getSelectionModel().getSelectedItem();
        System.out.println(PharmasistCOMBO.getValue());
        if (selectedDoctor == null || selectedCustomer == null || CustomerTXT == null || PharmasistCOMBO.getValue()== null || PaymentCOMBO.getValue() == null || date.getValue() == null) {
            showErrorMessage("Missing Fields", "Please fill in all the required fields.");
            return;
        }
        for (int i=0;i<Data.dataPharmacist.size();i++){
            if(pharmacist.equals(Data.dataPharmacist.get(i).getPhname())){
                p=i;
                break;
            }
        }
        for (int i=0;i<Data.dataInsurance.size();i++){
            if(comapny.equals(Data.dataInsurance.get(i).getInstype())){
                //Ih=Data.dataInsurance.get(i);
                Ih=i;
                break;
            }
        }
        boolean shouldContinue = false;
        Data.insertData(new Invoice(1,1,pay,Data.dataPharmacist.get(p).getPhid(), selectedCustomer.getCid()));
        for(int i=0; i<allCart.size();i++){
            if(allCart.get(i).oldq-allCart.get(i).quantity >0) {
                Data.updateMedicineQuantity(allCart.get(i).id, allCart.get(i).cid, allCart.get(i).oldq - allCart.get(i).quantity);
                shouldContinue = true;
            }

        }
        if (!shouldContinue) {
            // Show a message or perform any necessary actions
            showErrorMessage("Invalid Input", "not enough quantity.");
            return; // Stop further execution
        }

        int j=Data.getindex(Data.dataPharmacist.get(p).getPhid(), allCart.get(0).cid);
        Data.getdata();
        for(int i =0;i<allCart.size();i++){
            Data.insertData(new Invoice_med(Data.countin,allCart
                    .get(i).id,allCart.get(i).cid,allCart.get(i).quantity,String.valueOf(date.getValue())));

        }
        Data.getdata();




// call new fxml
//allcart
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("recite.fxml")));
        Scene scene = new Scene(root);


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());


        Data.stage.setScene(scene);
        Data.stage.setTitle("my pharmacy");

        Data.stage.show();




    }






//    void bck(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
//        Scene scene = new Scene(root);
//
//
//        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
//
//        System.out.println(screenBounds.getWidth());
//        System.out.println(screenBounds.getHeight());
//
//
//        Data.stage.setScene(scene);
//        Data.stage.setTitle("my pharmacy");
//
//        Data.stage.show();
//    }

}
