import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;

public class scene implements Initializable {

    @FXML
    private TableView<Customer> Customertable;

//    @FXML
//    private TableColumn<Customer, Integer> ageColumn = new TableColumn<>("age");
//    ageColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    @FXML
    private LineChart<String, Number> graph;

    @FXML
    private TextField EMP_t;
    @FXML
    private TextField SUPP_t;
    @FXML
    private TextField Customers_t;
    @FXML
    private TableColumn<Medicine, String> mType;
    @FXML
    private TableView<Medicine> Date;
    @FXML
    private TableView<sales> invoicemed;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private TableColumn<Invoice_med, Integer> invid;
    @FXML
    private TableColumn<sales, Integer> quantity;
    @FXML
    private TableColumn<sales, String> medid;
    @FXML
    private TableColumn<Medicine,String>Exp;
    @FXML
    private TableColumn<Medicine,String>type;
    @FXML
    private TableColumn<Medicine,Integer>mid;
    @FXML
    private TableColumn<Customer, Integer> cid;
    @FXML
    private TableColumn<Customer, String> name;
    @FXML
    private TableColumn<Customer, Integer> age;
    @FXML
    private TableColumn<Customer, String> gender;
    @FXML
    private TableColumn<Customer, Integer> insid;
    @FXML
    private TableColumn<Customer, Long> phone;




//    cid.setCellValueFactory(new PropertyValueFactory<>("name"));











    @FXML
    void dash(ActionEvent event) {

    }
    private void populateLineChart(LineChart<String, Number> lineChart, CategoryAxis xAxis, NumberAxis yAxis, ArrayList<chart> chartData) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (chart data : chartData) {
            series.getData().add(new XYChart.Data<>(data.getSdate(), data.getTotal()));
        }

        lineChart.getData().add(series);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cid.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("cid"));
        name.setCellValueFactory(new PropertyValueFactory<Customer,String>("cname"));
        age.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("age"));
        gender.setCellValueFactory(new PropertyValueFactory<Customer,String>("gender"));
        phone.setCellValueFactory(new PropertyValueFactory<Customer,Long>("phone"));
        insid.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("insid"));

//        Customertable.getColumns().addAll(cid,name, age, gender, phone,insid);

        EMP_t.setText(String.valueOf(Data.pharm_count));
        SUPP_t.setText(String.valueOf(Data.m_count));
        Customers_t.setText(String.valueOf(Data.Cust_count));
//        type.setCellValueFactory(new PropertyValueFactory<Medicine,String>("mType"));
        mid.setCellValueFactory(new PropertyValueFactory<Medicine,Integer>("mid"));
        mType.setCellValueFactory(new PropertyValueFactory<Medicine,String>("mType"));
        Exp.setCellValueFactory(new PropertyValueFactory<Medicine,String>("expiryDate"));


        medid.setCellValueFactory(new PropertyValueFactory<sales,String>("mType"));
//        invid.setCellValueFactory(new PropertyValueFactory<Invoice_med,Integer>("invid"));
        quantity.setCellValueFactory(new PropertyValueFactory<sales,Integer>("totalAmount"));



        ObservableList<Customer>people = FXCollections.observableArrayList(Data.dataCustomer);
        ObservableList<Medicine>expiry= FXCollections.observableArrayList(Data.datadates);
        ObservableList<sales> sale= FXCollections.observableArrayList(Data.medicineResults);

        XYChart.Series<chart, chart> series = new XYChart.Series<>();
        ObservableList<chart> show= FXCollections.observableArrayList(Data.chart);
//        expiry.add(new Medicine(1,"Tablet","293-433-2"));
//        System.out.println(expiry+"*********************************************************************************");

        invoicemed.setItems(sale);
        Customertable.setItems(people);
        Date.setItems(expiry);

//        series.getData().add(new XYChart.Data<>(show.get(0), show.get(1)));
        populateLineChart(graph, xAxis, yAxis, Data.chart);


//        graph.getData().add(show.get(0),show.get(1));


    }

//    public ObservableList<Customer> getcust() {
//
//        ObservableList<Customer>people = FXCollections.observableArrayList();
////        Collection<Customer> customerData = getcustomerdata();
//        people.add(new Customer(1,"rami",15,"Male", 568223884,1));
//
//
//        return people;
//
//    }


    public void callRecord(javafx.event.ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Data.getdata();
        //controller.getdata();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("csutomer.fxml")));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
        Scene scene = new Scene(root);
        Data.stage.setScene(scene);
        Data.stage.show();

    }
    public void callorder(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("order.fxml")));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
        Scene scene = new Scene(root);
        Data.stage.setScene(scene);
        Data.stage.show();

    }   public void callnew(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sell.fxml")));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
        Scene scene = new Scene(root);
        Data.stage.setScene(scene);
        Data.stage.show();

    }
    public void exit(javafx.event.ActionEvent actionEvent) throws IOException {

        Data.stage.close();

    }



}



