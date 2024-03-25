
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class controller implements Initializable {

    @FXML
    private TableView<Customer> table_customer;
    @FXML
    private TableColumn<Customer, Integer> age;

    @FXML
    private TableColumn<Customer, Integer> col_cid;

    @FXML
    private TableColumn<Customer, String> cname;

    @FXML
    private TableColumn<Customer, String> gender;

    @FXML
    private TableColumn<Customer, Integer> inside;

    @FXML
    private TableColumn<Customer, Long> phone;
    @FXML
    private TextField tage;
    @FXML
    private TextField search;

    @FXML
    private ComboBox<String> tgender;
    @FXML
    private ComboBox<String> col;
    @FXML
    private TextField tinsid;

    @FXML
    private TextField tname;

    @FXML
    private TextField tphone;

    @FXML
    private TableColumn<Doctor, Integer> DId;

    @FXML
    private TableColumn<Doctor, String> DName;

    @FXML
    private TableColumn<Doctor, String> Dspecialty;
    @FXML
    private ComboBox<String> DDoctor;
    @FXML
    private TextField TDName;

    @FXML
    private TextField TDSpecialty;
    @FXML
    private TextField Dsearch;

    private ObservableList<Doctor> listcDoctor;
    private ObservableList<String> ColDoctor;

    @FXML
    private TableView<Doctor> table_Doctor;

    @FXML
    private ComboBox<String> Insurancecol;

    @FXML
    private TextField Insurancesearch;

    @FXML
    private TextField TIcompany;

    @FXML
    private TextField TIinstype;

    @FXML
    private TableColumn<Insurance, String> col_company;

    @FXML
    private TableColumn<Insurance, String> col_coverageEdate;

    @FXML
    private TableColumn<Insurance, String> col_coverageSdate;
    @FXML
    private DatePicker TIcoverageEdate;

    @FXML
    private DatePicker TIcoverageSdate;

    @FXML
    private TableColumn<Insurance, Integer> col_insid;

    @FXML
    private TableColumn<Insurance, String> col_instype;

    @FXML
    private TableView<Insurance> table_Insurance;
    private ObservableList<Insurance> listInsurance;
    private ObservableList<String> colInsurance;
    @FXML
    private ComboBox<String> Invoicecol;

    @FXML
    private TableColumn<Invoice, Integer> cidIN;

    @FXML
    private TableColumn<Invoice, String> paymentMethIN;


    @FXML
    private TableColumn<Invoice, Integer> pharidIN;

    @FXML
    private TableColumn<Invoice, Float> priceIN;

    @FXML
    private TextField searchInvoice;

    @FXML
    private TableView<Invoice> table_Invoice;



    @FXML
    private TextField txt_Cid;

    @FXML
    private TextField txt_PaymentMeth;



    @FXML
    private TextField txt_Pharid;



    @FXML
    private TableColumn<Invoice, Integer> vidIN;
    private ObservableList<Invoice> listInvoice;
    private ObservableList<String> valueInvoice;

    @FXML
    private TextField AddressTXT;

    @FXML
    private TextField MNameTXT;

    @FXML
    private TextField MidTXT;

    @FXML
    private TextField PhoneTXT;

    @FXML
    private TableColumn<Manufacturer , String> addresstab;

    @FXML
    private ComboBox<String> colManufacturer;

    @FXML
    private TableColumn<Manufacturer , Integer> midtab;

    @FXML
    private TableColumn<Manufacturer , String> mnametab;

    @FXML
    private TableColumn<Manufacturer , Long> phonetab;

    @FXML
    private TextField searchManufacturer;

    @FXML
    private TableView<Manufacturer > table_Manufacturer;

    private ObservableList<Manufacturer > listManufacturer ;
    private ObservableList<String> valueManufacturer ;

    @FXML
    private ComboBox<String> COLPrescription;

    @FXML
    private TextField CusidX;

    @FXML
    private TextField MidX;

    @FXML
    private DatePicker Per_dateX;

    @FXML
    private TextField Per_textX;

    @FXML
    private TextField QuantityX;
    @FXML
    private TextField  DidX;

    @FXML
    private TextField searchPrescription;

    @FXML
    private TableColumn<Prescription, Integer> tabcusid;

    @FXML
    private TableColumn<Prescription, Integer> tabdid;

    @FXML
    private TableView<Prescription> table_Prescription;

    @FXML
    private TableColumn<Prescription, Integer> tabmid;

    @FXML
    private TableColumn<Prescription, String> tabper_date;

    @FXML
    private TableColumn<Prescription, String> tabper_text;

    @FXML
    private TableColumn<Prescription, Integer> tabquantity;

    private ObservableList<Prescription> listPrescription;
    private ObservableList<String> valuePrescription;

    @FXML
    private TableColumn<Medicine, Integer> cidmed;

    @FXML
    private ComboBox<String> combMedicine;

    @FXML
    private TableColumn<Medicine, String> dosagemed;

    @FXML
    private TableColumn<Medicine, String> expiryDatemed;

    @FXML
    private TableColumn<Medicine, String> mTypemed;

    @FXML
    private TableColumn<Medicine, Integer> midmed;

    @FXML
    private TableColumn<Medicine, Float> pricemed;

    @FXML
    private TableColumn<Medicine, Integer> quantitymed;

    @FXML
    private TextField searchMedicine;

    @FXML
    private TableView<Medicine> table_Medicine;

    @FXML
    private TextField txtcid;

    @FXML
    private TextField txtdosage;

    @FXML
    private DatePicker txtexpiryDate;

    @FXML
    private TextField txtmType;

    @FXML
    private TextField txtprice;

    @FXML
    private TextField txtquantity;


    private ObservableList<Medicine> listMedicine;
    private ObservableList<String> valueMedicine;


    @FXML
    private Button add211;

    @FXML
    private TableColumn<Pharmacist, Integer> ageph;

    @FXML
    private ComboBox<String> combPharmacsist;

    @FXML
    private TableColumn<Pharmacist, String> contact_infoph;

    @FXML
    private TableColumn<Pharmacist, String> genderph;

    @FXML
    private TableColumn<Pharmacist, Integer> phidph;

    @FXML
    private TableColumn<Pharmacist, String> phnameph;

    @FXML
    private TextField searchPharmacist;

    @FXML
    private TableView<Pharmacist> table_Pharmacist;

    @FXML
    private TextField txtPharamacistName;

    @FXML
    private TextField txtPharmacistAge;

    @FXML
    private TextField txtPharmacistContact_info;

    @FXML

    private ComboBox<String> txtPharmacistGender;



    private ObservableList<Pharmacist> listPharmacist;
    private ObservableList<String> valuePharmacist;




    private ObservableList<Customer> listcustomer;
    private ObservableList<String> lists;
    private ObservableList<String> listgender;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_customer.setEditable(true);
        col_cid.setCellValueFactory(new PropertyValueFactory<Customer, Integer> ("cid"));
        cname.setCellValueFactory(new PropertyValueFactory<Customer, String> ("cname"));
        cname.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());
        cname.setOnEditCommit(
                (TableColumn.CellEditEvent<Customer, String> t) -> {
                    ((Customer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCname(t.getNewValue());
                    Data.updateCustomerName(t.getRowValue().getCid(),t.getNewValue());
                });
        age.setCellValueFactory(new PropertyValueFactory<Customer, Integer> ("age"));
        age.setCellFactory(TextFieldTableCell.<Customer, Integer>forTableColumn(new IntegerStringConverter()));
        age.setOnEditCommit((TableColumn.CellEditEvent<Customer, Integer> t) -> {
            try {
                Integer newValue = t.getNewValue();
                if (newValue < 0 || newValue >150) {
                    throw new NumberFormatException();
                }
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAge(newValue);
                Data.updateCustomerAge(t.getRowValue().getCid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid age input");
                table_customer.setItems(listcustomer);
            }
        });

        gender.setCellValueFactory(new PropertyValueFactory<Customer, String> ("gender"));
        gender.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());
        gender.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            try {
                String newValue = t.getNewValue();
                if (!Objects.equals(newValue, "Male") && !Objects.equals(newValue, "male")&& !Objects.equals(newValue, "Female")
                        && !Objects.equals(newValue, "female")) {
                    throw new NumberFormatException();
                }
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGender(newValue);
                Data.updateCustomerGender(t.getRowValue().getCid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid Gender input");
                table_customer.setItems(listcustomer);
            }
        });
        inside.setCellValueFactory(new PropertyValueFactory<Customer, Integer> ("insid"));
        inside.setCellFactory(TextFieldTableCell.<Customer, Integer>forTableColumn(new IntegerStringConverter()));
        inside.setOnEditCommit((TableColumn.CellEditEvent<Customer, Integer> t) -> {
            try {
                Integer newValue = t.getNewValue();
                if (newValue < 0) {
                    throw new NumberFormatException();
                }
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInsid(newValue);
                Data.updateCustomerInsid(t.getRowValue().getCid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid Insid input");
                table_customer.setItems(listcustomer);
            }
        });
        phone.setCellValueFactory(new PropertyValueFactory<Customer, Long>  ("phone"));
        phone.setCellFactory(TextFieldTableCell.<Customer, Long>forTableColumn(new LongStringConverter()));
        phone.setOnEditCommit((TableColumn.CellEditEvent<Customer, Long> t) -> {
            try {
                Long newValue = t.getNewValue();
                if (newValue < 0) {
                    throw new NumberFormatException();
                }
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhone(newValue);
                Data.updateCustomerPhone(t.getRowValue().getCid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid phone input");
                table_customer.setItems(listcustomer);
            }
        });
        listcustomer = FXCollections.observableArrayList(Data.dataCustomer);
        listgender= FXCollections.observableArrayList("Male","Female");
        lists=FXCollections.observableArrayList("Cid","CName","Age","Gender","Phone","Insid");
        col.setItems(lists);
        col.setValue("Cid");
        tgender.setItems(listgender);
        tgender.setValue("Male");
        table_customer.setItems(listcustomer);



//********************************* Doctor Table set //*************************************************************

        table_Doctor.setEditable(true);
        DId.setCellValueFactory(new PropertyValueFactory<Doctor, Integer> ("did"));
        DName.setCellValueFactory(new PropertyValueFactory<Doctor, String> ("dname"));
        DName.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
        DName.setOnEditCommit(
                (TableColumn.CellEditEvent<Doctor, String> t) -> {
                    ((Doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setDname(t.getNewValue());
                    Data.updateDoctorName(t.getRowValue().getDid(),t.getNewValue());
                });
        Dspecialty.setCellValueFactory(new PropertyValueFactory<Doctor, String> ("specialty"));
        Dspecialty.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
        Dspecialty.setOnEditCommit(
                (TableColumn.CellEditEvent<Doctor, String> t) -> {
                    ((Doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSpecialty(t.getNewValue());
                    Data.updateDoctorSpecialty(t.getRowValue().getDid(),t.getNewValue());
                });


        listcDoctor = FXCollections.observableArrayList(Data.dataDoctor);
        ColDoctor=FXCollections.observableArrayList("did","dname","specialty");
        DDoctor.setItems(ColDoctor);
        DDoctor.setValue("did");
        table_Doctor.setItems(listcDoctor);





        //********************************* Insurance Table set //*************************************************************
        table_Insurance.setEditable(true);
        col_insid.setCellValueFactory(new PropertyValueFactory<Insurance, Integer> ("insid"));
        col_company.setCellValueFactory(new PropertyValueFactory<Insurance, String> ("company"));
        col_company.setCellFactory(TextFieldTableCell.<Insurance>forTableColumn());
        col_company.setOnEditCommit(
                (TableColumn.CellEditEvent<Insurance, String> t) -> {
                    ((Insurance) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCompany(t.getNewValue());
                    Data.updateInsuranceCompany(t.getRowValue().getInsid(),t.getNewValue());
                });
        col_instype.setCellValueFactory(new PropertyValueFactory<Insurance, String> ("instype"));
        col_instype.setCellFactory(TextFieldTableCell.<Insurance>forTableColumn());
        col_instype.setOnEditCommit(
                (TableColumn.CellEditEvent<Insurance, String> t) -> {
                    ((Insurance) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setInstype(t.getNewValue());
                    Data.updateInsuranceType(t.getRowValue().getInsid(),t.getNewValue());
                });
        col_coverageEdate.setCellValueFactory(new PropertyValueFactory<Insurance, String> ("coverageEdate"));
        col_coverageEdate.setCellFactory(TextFieldTableCell.<Insurance>forTableColumn());
        col_coverageEdate.setOnEditCommit(
                (TableColumn.CellEditEvent<Insurance, String> t) -> {
                    ((Insurance) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCoverageEdate(t.getNewValue());
                    Data.updateInsuranceCoverageEdate(t.getRowValue().getInsid(),t.getNewValue());
                });
        col_coverageSdate.setCellValueFactory(new PropertyValueFactory<Insurance, String> ("coverageSdate"));
        col_coverageSdate.setCellFactory(TextFieldTableCell.<Insurance>forTableColumn());
        col_coverageSdate.setOnEditCommit(
                (TableColumn.CellEditEvent<Insurance, String> t) -> {
                    ((Insurance) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCoverageSdate(t.getNewValue());
                    Data.updateInsuranceCoverageSdate(t.getRowValue().getInsid(),t.getNewValue());
                });

        listInsurance= FXCollections.observableArrayList(Data.dataInsurance);
        colInsurance=FXCollections.observableArrayList("insid","company","instype","coverageEdate","coverageSdate");
        Insurancecol.setItems(colInsurance);
        Insurancecol.setValue("insid");
        table_Insurance.setItems(listInsurance);







        //********************************* Invoice Table set //*************************************************************


        table_Invoice.setEditable(true);
        vidIN.setCellValueFactory(new PropertyValueFactory<Invoice, Integer> ("vid"));
        paymentMethIN.setCellValueFactory(new PropertyValueFactory<Invoice, String> ("paymentMeth"));
        paymentMethIN.setCellFactory(TextFieldTableCell.<Invoice>forTableColumn());
        paymentMethIN.setOnEditCommit(
                (TableColumn.CellEditEvent<Invoice, String> t) -> {
                    ((Invoice) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPaymentMeth(t.getNewValue());
                    Data.updateInvoicePaymentMeth(t.getRowValue().getCid(),t.getNewValue());
                });

        priceIN.setCellValueFactory(new PropertyValueFactory<Invoice,Float> ("price"));
        priceIN.setCellFactory(TextFieldTableCell.<Invoice, Float>forTableColumn(new FloatStringConverter()));

        pharidIN.setCellValueFactory(new PropertyValueFactory<Invoice,Integer> ("pharid"));
        pharidIN.setCellFactory(TextFieldTableCell.<Invoice, Integer>forTableColumn(new IntegerStringConverter()));
        pharidIN.setOnEditCommit((TableColumn.CellEditEvent<Invoice,Integer> t) -> {
            try {
                Integer newValue = t.getNewValue();
                if (newValue < 0 ) {
                    throw new NumberFormatException();
                }
                ((Invoice) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPharid(newValue);
                Data.updateInvoicePharid(t.getRowValue().getCid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid pharid input");
                table_Invoice.setItems(listInvoice);
            }
        });

        cidIN.setCellValueFactory(new PropertyValueFactory<Invoice,Integer> ("cid"));
        cidIN.setCellFactory(TextFieldTableCell.<Invoice, Integer>forTableColumn(new IntegerStringConverter()));

        listInvoice= FXCollections.observableArrayList(Data.dataInvoice);
        valueInvoice=FXCollections.observableArrayList("vid","price","paymentMeth","pharid","cid");
        Invoicecol.setItems(valueInvoice);
        Invoicecol.setValue("vid");
        table_Invoice.setItems(listInvoice);





        //********************************* Manufacturer Table set //*************************************************************


        table_Manufacturer.setEditable(true);
        midtab.setCellValueFactory(new PropertyValueFactory<Manufacturer, Integer> ("mid"));
        addresstab.setCellValueFactory(new PropertyValueFactory<Manufacturer, String> ("address"));
        addresstab.setCellFactory(TextFieldTableCell.<Manufacturer>forTableColumn());
        addresstab.setOnEditCommit(
                (TableColumn.CellEditEvent<Manufacturer, String> t) -> {
                    ((Manufacturer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAddress(t.getNewValue());
                    Data.updateManufacturerAddress(t.getRowValue().getMid(),t.getNewValue());
                });
        mnametab.setCellValueFactory(new PropertyValueFactory<Manufacturer, String> ("mname"));
        mnametab.setCellFactory(TextFieldTableCell.<Manufacturer>forTableColumn());
        mnametab.setOnEditCommit(
                (TableColumn.CellEditEvent<Manufacturer, String> t) -> {
                    ((Manufacturer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setMname(t.getNewValue());
                    Data.updateManufacturerName(t.getRowValue().getMid(),t.getNewValue());
                });
        phonetab.setCellValueFactory(new PropertyValueFactory<Manufacturer,Long> ("phone"));
        phonetab.setCellFactory(TextFieldTableCell.<Manufacturer, Long>forTableColumn(new LongStringConverter()));
        phonetab.setOnEditCommit((TableColumn.CellEditEvent<Manufacturer,Long> t) -> {
            try {
                Long newValue = t.getNewValue();
                if (newValue < 0 ) {
                    throw new NumberFormatException();
                }
                ((Manufacturer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhone(newValue);
                Data.updateManufacturerPhone(t.getRowValue().getMid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid phone input");
                table_Manufacturer.setItems(listManufacturer);
            }
        });


        listManufacturer= FXCollections.observableArrayList(Data.dataManufacturer);
        valueManufacturer=FXCollections.observableArrayList("mid","address","mname","phone");
        colManufacturer.setItems(valueManufacturer);
        colManufacturer.setValue("mid");
        table_Manufacturer.setItems(listManufacturer);


//****************************************  Prescription  Table set **************************************************/
        table_Prescription.setEditable(true);
        tabdid.setCellValueFactory(new PropertyValueFactory<Prescription, Integer> ("did"));
        tabcusid.setCellValueFactory(new PropertyValueFactory<Prescription, Integer> ("cusid"));
        tabmid.setCellValueFactory(new PropertyValueFactory<Prescription, Integer> ("mid"));
        tabper_text.setCellValueFactory(new PropertyValueFactory<Prescription, String> ("per_text"));
        tabper_text.setCellFactory(TextFieldTableCell.<Prescription>forTableColumn());
        tabper_text.setOnEditCommit(
                (TableColumn.CellEditEvent<Prescription, String> t) -> {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPer_text(t.getNewValue());
                    Data.updatePrescriptionText(t.getRowValue().getDid(),t.getRowValue().getCusid(),t.getRowValue().getMid(),t.getNewValue());
                });
        tabquantity.setCellValueFactory(new PropertyValueFactory<Prescription, Integer> ("quantity"));
        tabquantity.setCellFactory(TextFieldTableCell.<Prescription, Integer>forTableColumn(new IntegerStringConverter()));
        tabquantity.setOnEditCommit((TableColumn.CellEditEvent<Prescription, Integer> t) -> {
            try {
                Integer newValue = t.getNewValue();
                if (newValue < 0) {
                    throw new NumberFormatException();
                }
                ((Prescription) t.getTableView().getItems().get(t.getTablePosition().getRow())).setQuantity(newValue);
                Data.updatePrescriptionQuantity(t.getRowValue().getDid(),t.getRowValue().getCusid(),t.getRowValue().getMid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid age input");
                table_Prescription.setItems(listPrescription);
            }

        });
        tabper_date.setCellValueFactory(new PropertyValueFactory<Prescription, String> ("per_date"));
        tabper_date.setCellFactory(TextFieldTableCell.<Prescription>forTableColumn());
        tabper_date.setOnEditCommit(
                (TableColumn.CellEditEvent<Prescription, String> t) -> {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPer_date(t.getNewValue());
                    Data.updatePrescriptionDate(t.getRowValue().getDid(),t.getRowValue().getCusid(),t.getRowValue().getMid(),t.getNewValue());
                });
        listPrescription= FXCollections.observableArrayList(Data.dataPrescription);
        valuePrescription=FXCollections.observableArrayList("did","cusid","mid","per_text","per_date","quantity");
        COLPrescription.setItems(valuePrescription);
        COLPrescription.setValue("did");
        table_Prescription.setItems(listPrescription);
        //********************************* Medicine Table set //*************************************************************
        /*
        int mid;String mType;String dosage;String expiryDate;float price;int quantity ;int cid ; //Manufacturer id
         */
        table_Medicine.setEditable(true);
        midmed.setCellValueFactory(new PropertyValueFactory<Medicine, Integer> ("mid"));
        cidmed.setCellValueFactory(new PropertyValueFactory<Medicine , Integer>("cid"));
        mTypemed.setCellValueFactory(new PropertyValueFactory<Medicine , String> ("mType"));
        mTypemed.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());

        mTypemed.setOnEditCommit(
                (TableColumn.CellEditEvent<Medicine, String> t) -> {
                    ((Medicine) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setMType(t.getNewValue());
                    Data.updateMedicineType(t.getRowValue().getMid() , t.getRowValue().getCid(), t.getNewValue());
                });
        dosagemed.setCellValueFactory(new PropertyValueFactory<Medicine, String> ("dosage"));
        dosagemed.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        dosagemed.setOnEditCommit(
                (TableColumn.CellEditEvent<Medicine, String> t) -> {
                    ((Medicine) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setDosage(t.getNewValue());
                    Data.updateMedicineDosage(t.getRowValue().getMid() , t.getRowValue().getCid(), t.getNewValue());
                });
        expiryDatemed.setCellValueFactory(new PropertyValueFactory<Medicine, String> ("expiryDate"));
        expiryDatemed.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        expiryDatemed.setOnEditCommit(
                (TableColumn.CellEditEvent<Medicine, String> t) -> {
                    ((Medicine) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setExpiryDate(t.getNewValue());
                    Data.updateMedicineExpiryDate(t.getRowValue().getMid() , t.getRowValue().getCid(), t.getNewValue());
                });
        pricemed.setCellValueFactory(new PropertyValueFactory<Medicine,Float> ("price"));
        pricemed.setCellFactory(TextFieldTableCell.<Medicine, Float>forTableColumn(new FloatStringConverter()));
        pricemed.setOnEditCommit(
                (TableColumn.CellEditEvent<Medicine,Float> t) -> {
                    try {
                        Float newValue = t.getNewValue();
                        if (newValue < 0 ) {
                            throw new NumberFormatException();
                        }
                        ((Medicine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(newValue);
                        Data.updateMedicinePrice(t.getRowValue().getMid() , t.getRowValue().getCid() , t.getNewValue());
                    } catch (NumberFormatException e) {
                        Data.Error();
                        System.out.println("Invalid Price input");
                        table_Medicine.setItems(listMedicine);

                    }


                });
        quantitymed.setCellValueFactory(new PropertyValueFactory<Medicine,Integer> ("quantity"));
        quantitymed.setCellFactory(TextFieldTableCell.<Medicine, Integer>forTableColumn(new IntegerStringConverter()));
        quantitymed.setOnEditCommit((TableColumn.CellEditEvent<Medicine,Integer> t) -> {
            try {
                Integer newValue = t.getNewValue();
                if (newValue < 0 ) {
                    throw new NumberFormatException();
                }
                ((Medicine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setQuantity(newValue);
                Data.updateMedicineQuantity( t.getRowValue().getMid(),t.getRowValue().getCid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid quantity input");
                table_Medicine.setItems(listMedicine);
            }
        });



        listMedicine= FXCollections.observableArrayList(Data.dataMedicine);
        valueMedicine=FXCollections.observableArrayList("mid","mType" , "price","dosage","expiryDate" , "quantity" , "cid");
        combMedicine.setItems(valueMedicine);
        combMedicine.setValue("mid");
        table_Medicine.setItems(listMedicine);


        //********************************* Pharmacist Table set //*************************************************************

        /*private int phid;private String phname; private int age; private String gender; private String contact_info;
         */
        table_Pharmacist.setEditable(true);
        phidph.setCellValueFactory(new PropertyValueFactory<Pharmacist, Integer> ("phid"));
        phnameph.setCellValueFactory(new PropertyValueFactory<Pharmacist , String> ("phname"));
        phnameph.setCellFactory(TextFieldTableCell.<Pharmacist>forTableColumn());
        phnameph.setOnEditCommit(
                (TableColumn.CellEditEvent<Pharmacist, String> t) -> {
                    ((Pharmacist) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhname(t.getNewValue());
                    Data.updatePharmacistName(t.getRowValue().getPhid() , t.getNewValue());
                });
        ageph.setCellValueFactory(new PropertyValueFactory<Pharmacist,Integer> ("age"));
        ageph.setCellFactory(TextFieldTableCell.<Pharmacist, Integer>forTableColumn(new IntegerStringConverter()));
        ageph.setOnEditCommit((TableColumn.CellEditEvent<Pharmacist,Integer> t) -> {
            try {
                Integer newValue = t.getNewValue();
                if (newValue < 0  || newValue > 150) {
                    throw new NumberFormatException();
                }
                ((Pharmacist) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAge(newValue);
                Data.updatePharmacistAge( t.getRowValue().getPhid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid age input");
                table_Pharmacist.setItems(listPharmacist);
            }
        });
        genderph.setCellValueFactory(new PropertyValueFactory<Pharmacist, String> ("gender"));
        genderph.setCellFactory(TextFieldTableCell.<Pharmacist>forTableColumn());
        genderph.setOnEditCommit((TableColumn.CellEditEvent<Pharmacist, String> t) -> {
            try {
                String newValue = t.getNewValue();
                if (!Objects.equals(newValue, "Male") && !Objects.equals(newValue, "male")&& !Objects.equals(newValue, "Female")
                        && !Objects.equals(newValue, "female")) {
                    throw new NumberFormatException();
                }
                ((Pharmacist) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGender(newValue);
                Data.updatePharmacistGender(t.getRowValue().getPhid(), newValue);
            } catch (NumberFormatException e) {
                Data.Error();
                System.out.println("Invalid Gender input");
                table_Pharmacist.setItems(listPharmacist);
            }
        });
        contact_infoph.setCellValueFactory(new PropertyValueFactory<Pharmacist, String> ("contact_info"));
        contact_infoph.setCellFactory(TextFieldTableCell.<Pharmacist>forTableColumn());
        contact_infoph.setOnEditCommit(
                (TableColumn.CellEditEvent<Pharmacist, String> t) -> {
                    ((Pharmacist) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setContact_info(t.getNewValue());
                    Data.updatePharmacistContact_info(t.getRowValue().getPhid(), t.getNewValue());
                });

        ObservableList<String> listPharmacistGender;

        /*private int phid;private String phname; private int age; private String gender; private String contact_info;*/
        listPharmacist= FXCollections.observableArrayList(Data.dataPharmacist);
        listPharmacistGender= FXCollections.observableArrayList("Male","Female");
        valuePharmacist=FXCollections.observableArrayList("phid","phname" , "age","gender","contact_info" );
        combPharmacsist.setItems(valuePharmacist);
        combPharmacsist.setValue("phid");
        txtPharmacistGender.setItems(listPharmacistGender);
        table_Pharmacist.setItems(listPharmacist);





    }
    //********************************* Function Customer //*************************************************************
    @FXML
    void ADDCustomer(javafx.event.ActionEvent actionEvent) {
        int age=0;
        int inside=0;
        long phone=0;
        String nam = tname.getText();
        String gen= tgender.getSelectionModel().getSelectedItem().toString();
        try {
            age = Integer.parseInt(tage.getText());
            if (age < 0 || age > 150  ) {
                throw new NumberFormatException();
            }
            inside = Integer.parseInt(tinsid.getText());
            if (inside < 0 ) {
                throw new NumberFormatException();
            }
            phone = Long.parseLong(tphone.getText());
            if (phone < 0 ) {
                throw new NumberFormatException();
            }
            // System.out.println(nam + " " + gen + " " + age +  " "+ inside + " "+ phone);


            Data.insertData(new Customer(1,nam ,age , gen , phone , inside ));
            listcustomer.clear();
            listcustomer = FXCollections.observableArrayList(Data.dataCustomer);
            table_customer.setItems(listcustomer);
        } catch (NumberFormatException e) {
            Data.Error();
            if (age < 0 || age > 150  ) {
                System.out.println("age is wrong");
            }else if(inside<0){
                System.out.println("inside is wrong");
            }else
                System.out.println("Invalid input");
        }

    }
    public void getdata(){
        listcustomer = FXCollections.observableArrayList(Data.dataCustomer);
        table_customer.setItems(listcustomer);
        listcDoctor = FXCollections.observableArrayList(Data.dataDoctor);
        table_Doctor.setItems(listcDoctor);
        listInsurance = FXCollections.observableArrayList(Data.dataInsurance);
        table_Insurance.setItems(listInsurance);
        listInvoice = FXCollections.observableArrayList(Data.dataInvoice);
        table_Invoice.setItems(listInvoice);
        listManufacturer = FXCollections.observableArrayList(Data.dataManufacturer);
        table_Manufacturer.setItems(listManufacturer);
        listPrescription = FXCollections.observableArrayList(Data.dataPrescription);
        table_Prescription.setItems(listPrescription);
    }
    @FXML
    public void DeleteCustomer(javafx.event.ActionEvent actionEvent){
        Customer selectedItem = table_customer.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listcustomer.remove(selectedItem);
            Data.deleteRow(selectedItem );

        }
        getdata();
    }


    public void searchgo(KeyEvent keyEvent) {
        ObservableList<Customer> newlistcustomer=null;
        ArrayList<Customer> dataCustomer =new ArrayList<>();
        dataCustomer.clear();
        if((col.getSelectionModel().getSelectedItem().toString()).equals("Cid")){
            int inputCid=0;
            try {
                inputCid = Integer.parseInt(search.getText());
                for (Customer customer : Data.dataCustomer) {
                    if (String.valueOf(customer.getCid()).contains(String.valueOf(inputCid))) {
                        dataCustomer.add(customer);
                    }
                }
                newlistcustomer = FXCollections.observableArrayList(dataCustomer);
                if(newlistcustomer != null)
                    table_customer.setItems(newlistcustomer);

            } catch (NumberFormatException e) {
                table_customer.setItems(listcustomer);
                System.out.println("Invalid input");
            }
        }else if((col.getSelectionModel().getSelectedItem().toString()).equals("CName")){
            String inputCname="";
            try {
                inputCname = search.getText();
                for (Customer customer : Data.dataCustomer) {
                    if (customer.getCname().toLowerCase().contains(inputCname.toLowerCase())) {
                        dataCustomer.add(customer);
                    }
                }
                newlistcustomer = FXCollections.observableArrayList(dataCustomer);
                if(newlistcustomer != null)
                    table_customer.setItems(newlistcustomer);
                if(inputCname=="")
                    table_customer.setItems(listcustomer);

            } catch (NumberFormatException e) {
                table_customer.setItems(listcustomer);
                System.out.println("Invalid input");
            }

        }else if((col.getSelectionModel().getSelectedItem().toString()).equals("Gender")){
            String inputGender="";
            try {
                inputGender = search.getText();
                for (Customer customer : Data.dataCustomer) {
                    if (customer.getGender().toLowerCase().equals(inputGender.toLowerCase())) {
                        dataCustomer.add(customer);
                    }
                }
                newlistcustomer = FXCollections.observableArrayList(dataCustomer);
                if(newlistcustomer != null)
                    table_customer.setItems(newlistcustomer);
                if(inputGender=="")
                    table_customer.setItems(listcustomer);

            } catch (NumberFormatException e) {
                table_customer.setItems(listcustomer);
                System.out.println("Invalid input");
            }

        }else if((col.getSelectionModel().getSelectedItem().toString()).equals("Age")){
            int inputAge=0;
            try {
                inputAge = Integer.parseInt(search.getText());
                for (Customer customer : Data.dataCustomer) {
                    if (String.valueOf(customer.getAge()).contains(String.valueOf(inputAge))) {
                        dataCustomer.add(customer);
                    }
                }
                newlistcustomer = FXCollections.observableArrayList(dataCustomer);
                if(newlistcustomer != null)
                    table_customer.setItems(newlistcustomer);

            } catch (NumberFormatException e) {
                table_customer.setItems(listcustomer);
                System.out.println("Invalid input");
            }
        }else if((col.getSelectionModel().getSelectedItem().toString()).equals("Insid")){
            int inputInsid=0;
            try {
                inputInsid = Integer.parseInt(search.getText());
                for (Customer customer : Data.dataCustomer) {
                    if (String.valueOf(customer.getInsid()).contains(String.valueOf(inputInsid))) {
                        dataCustomer.add(customer);
                    }
                }
                newlistcustomer = FXCollections.observableArrayList(dataCustomer);
                if(newlistcustomer != null)
                    table_customer.setItems(newlistcustomer);

            } catch (NumberFormatException e) {
                table_customer.setItems(listcustomer);
                System.out.println("Invalid input");
            }
        }else if((col.getSelectionModel().getSelectedItem().toString()).equals("Phone")){
            int inputPhone=0;
            try {
                inputPhone = Integer.parseInt(search.getText());
                for (Customer customer : Data.dataCustomer) {
                    if (String.valueOf(customer.getPhone()).contains(String.valueOf(inputPhone))) {
                        dataCustomer.add(customer);
                    }
                }
                newlistcustomer = FXCollections.observableArrayList(dataCustomer);
                if(newlistcustomer != null)
                    table_customer.setItems(newlistcustomer);

            } catch (NumberFormatException e) {
                table_customer.setItems(listcustomer);
                System.out.println("Invalid input");
            }
        }


    }

    //********************************* Function Doctor //*************************************************************
    @FXML
    void ADDDoctor(javafx.event.ActionEvent actionEvent) {
        String nam = TDName.getText();
        String sp = TDSpecialty.getText();

        Data.insertData(new Doctor(1,nam ,sp ));
        listcDoctor.clear();
        listcDoctor = FXCollections.observableArrayList(Data.dataDoctor);
        table_Doctor.setItems(listcDoctor);

    }
    @FXML
    public void DeleteDoctor(javafx.event.ActionEvent actionEvent){
        Doctor selectedItem = table_Doctor.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listcDoctor.remove(selectedItem);
            Data.deleteRow(selectedItem );

        }
        getdata();
    }


    public void searchDoctor(KeyEvent keyEvent) {
        ObservableList<Doctor> newlistDoctor=null;
        ArrayList<Doctor> dataDoctor =new ArrayList<>();
        dataDoctor.clear();
        if((DDoctor.getSelectionModel().getSelectedItem().toString()).equals("did")){
            int inputdid=0;
            try {
                inputdid = Integer.parseInt(Dsearch.getText());
                for (Doctor doctor : Data.dataDoctor) {
                    if (String.valueOf(doctor.getDid()).contains(String.valueOf(inputdid))) {
                        dataDoctor.add(doctor);
                    }
                }
                newlistDoctor = FXCollections.observableArrayList(dataDoctor);
                if(newlistDoctor != null)
                    table_Doctor.setItems(newlistDoctor);

            } catch (NumberFormatException e) {
                table_Doctor.setItems(listcDoctor);
                System.out.println("Invalid input");
            }
        }else if((DDoctor.getSelectionModel().getSelectedItem()).equals("dname")){
            String inputDname="";
            try {
                inputDname = Dsearch.getText();
                for (Doctor doctor : Data.dataDoctor) {
                    if (doctor.getDname().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataDoctor.add(doctor);
                    }
                }
                newlistDoctor = FXCollections.observableArrayList(dataDoctor);
                if(newlistDoctor != null)
                    table_Doctor.setItems(newlistDoctor);
                if(inputDname=="")
                    table_Doctor.setItems(listcDoctor);

            } catch (NumberFormatException e) {
                table_Doctor.setItems(listcDoctor);
                System.out.println("Invalid input");
            }

        }else if((DDoctor.getSelectionModel().getSelectedItem()).equals("specialty")){
            String inputDname="";
            try {
                inputDname = Dsearch.getText();
                for (Doctor doctor : Data.dataDoctor) {
                    if (doctor.getSpecialty().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataDoctor.add(doctor);
                    }
                }
                newlistDoctor = FXCollections.observableArrayList(dataDoctor);
                if(newlistDoctor != null)
                    table_Doctor.setItems(newlistDoctor);
                if(inputDname=="")
                    table_Doctor.setItems(listcDoctor);

            } catch (NumberFormatException e) {
                table_Doctor.setItems(listcDoctor);
                System.out.println("Invalid input");
            }

        }

    }




    //********************************* Function Insurance//*************************************************************
    @FXML
    void ADDInsurance(javafx.event.ActionEvent actionEvent) {
        String company = TIcompany.getText();
        String type = TIinstype.getText();
        String s = String.valueOf(TIcoverageSdate.getValue());
        String se = String.valueOf(TIcoverageEdate.getValue());

        Data.insertData(new Insurance(1,type,company,s,se ));
        listInsurance.clear();
        listInsurance = FXCollections.observableArrayList(Data.dataInsurance);
        table_Insurance.setItems(listInsurance);

    }
    @FXML
    public void DeleteInsurance(javafx.event.ActionEvent actionEvent){
        Insurance selectedItem = table_Insurance.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listInsurance.remove(selectedItem);
            Data.deleteRow(selectedItem );

        }
        getdata();
    }


    public void searchInsurance(KeyEvent keyEvent) {
        ObservableList<Insurance> newlistInsurance=null;
        ArrayList<Insurance> dataInsurance =new ArrayList<>();
        dataInsurance.clear();
        if((Insurancecol.getSelectionModel().getSelectedItem().toString()).equals("insid")){
            int inputinsid=0;
            try {
                inputinsid = Integer.parseInt(Insurancesearch.getText());
                for (Insurance insurance : Data.dataInsurance) {
                    if (String.valueOf(insurance.getInsid()).contains(String.valueOf(inputinsid))) {
                        dataInsurance.add(insurance);
                    }
                }
                newlistInsurance = FXCollections.observableArrayList(dataInsurance);
                if(newlistInsurance!= null)
                    table_Insurance.setItems(newlistInsurance);

            } catch (NumberFormatException e) {
                table_Insurance.setItems(listInsurance);
                System.out.println("Invalid input");
            }
        }else if((Insurancecol.getSelectionModel().getSelectedItem()).equals("instype")){
            String inputDname="";
            try {
                inputDname = Insurancesearch.getText();
                for (Insurance insurance : Data.dataInsurance) {
                    if (insurance.getInstype().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataInsurance.add(insurance );
                    }
                }
                newlistInsurance = FXCollections.observableArrayList(dataInsurance);
                if(newlistInsurance != null)
                    table_Insurance.setItems(newlistInsurance);
                if(inputDname=="")
                    table_Insurance.setItems(listInsurance);

            } catch (NumberFormatException e) {
                table_Insurance.setItems(listInsurance);
                System.out.println("Invalid input");
            }

        }else if((Insurancecol.getSelectionModel().getSelectedItem()).equals("company")){
            String inputDname="";
            try {
                inputDname = Insurancesearch.getText();
                for (Insurance insurance : Data.dataInsurance) {
                    if (insurance.getCompany().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataInsurance.add(insurance );
                    }
                }
                newlistInsurance = FXCollections.observableArrayList(dataInsurance);
                if(newlistInsurance != null)
                    table_Insurance.setItems(newlistInsurance);
                if(inputDname=="")
                    table_Insurance.setItems(listInsurance);

            } catch (NumberFormatException e) {
                table_Insurance.setItems(listInsurance);
                System.out.println("Invalid input");
            }

        }else if((Insurancecol.getSelectionModel().getSelectedItem()).equals("coverageSdate")){
            String inputDname="";
            try {
                inputDname = Insurancesearch.getText();
                for (Insurance insurance : Data.dataInsurance) {
                    if (insurance.getCoverageSdate().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataInsurance.add(insurance );
                    }
                }
                newlistInsurance = FXCollections.observableArrayList(dataInsurance);
                if(newlistInsurance != null)
                    table_Insurance.setItems(newlistInsurance);
                if(inputDname=="")
                    table_Insurance.setItems(listInsurance);

            } catch (NumberFormatException e) {
                table_Insurance.setItems(listInsurance);
                System.out.println("Invalid input");
            }

        }else if((Insurancecol.getSelectionModel().getSelectedItem()).equals("coverageEdate")){
            String inputDname="";
            try {
                inputDname = Insurancesearch.getText();
                for (Insurance insurance : Data.dataInsurance) {
                    if (insurance.getCoverageEdate().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataInsurance.add(insurance );
                    }
                }
                newlistInsurance = FXCollections.observableArrayList(dataInsurance);
                if(newlistInsurance != null)
                    table_Insurance.setItems(newlistInsurance);
                if(inputDname=="")
                    table_Insurance.setItems(listInsurance);

            } catch (NumberFormatException e) {
                table_Insurance.setItems(listInsurance);
                System.out.println("Invalid input");
            }

        }

    }
    //********************************* Function Invoice  //*************************************************************
    @FXML
    void ADDInvoice(javafx.event.ActionEvent actionEvent) {
        String paymentMeth;
        int pharid; // pharmacist id
        int cid ; // Customer id
        paymentMeth = txt_PaymentMeth.getText();
        try {
            pharid = Integer.parseInt(txt_Pharid.getText());
            if (pharid < 0   ) {
                throw new NumberFormatException();
            }
            cid = Integer.parseInt(txt_Cid.getText());
            if (cid < 0 ) {
                throw new NumberFormatException();
            }

            Data.insertData(new Invoice(1,1,paymentMeth,pharid,cid));
            listInvoice.clear();
            listInvoice = FXCollections.observableArrayList(Data.dataInvoice);
            table_Invoice.setItems(listInvoice);
        } catch (NumberFormatException e) {
            Data.Error();
            System.out.println("Invalid input");
        }

    }
    @FXML
    public void DeleteInvoice(javafx.event.ActionEvent actionEvent){
        Invoice selectedItem = table_Invoice.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listInvoice.remove(selectedItem);
            Data.deleteRow(selectedItem );

        }
        getdata();
    }


    public void searchInvoice(KeyEvent keyEvent) {
        //  "vid","price","paymentMeth","pharid","cid "
        ObservableList<Invoice> newlistInvoice=null;
        ArrayList<Invoice> dataInvoice =new ArrayList<>();
        dataInvoice.clear();
        if((Invoicecol.getSelectionModel().getSelectedItem().toString()).equals("vid")){
            int inputCid=0;
            try {
                inputCid = Integer.parseInt(searchInvoice.getText());
                for (Invoice invoice : Data.dataInvoice) {
                    if (String.valueOf(invoice.getVid()).contains(String.valueOf(inputCid))) {
                        dataInvoice.add(invoice);
                    }
                }
                newlistInvoice = FXCollections.observableArrayList(dataInvoice);
                if(newlistInvoice != null)
                    table_Invoice.setItems(newlistInvoice);

            } catch (NumberFormatException e) {
                table_Invoice.setItems(listInvoice);
                System.out.println("Invalid input");
            }
        }else if((Invoicecol.getSelectionModel().getSelectedItem().toString()).equals("price")){
            try {
                for (Invoice invoice : Data.dataInvoice) {
                    if (String.valueOf(invoice.getPrice()).contains(searchInvoice.getText())) {
                        dataInvoice.add(invoice);
                    }
                }
                newlistInvoice = FXCollections.observableArrayList(dataInvoice);
                if(newlistInvoice != null)
                    table_Invoice.setItems(newlistInvoice);

            } catch (NumberFormatException e) {
                table_Invoice.setItems(listInvoice);
                System.out.println("Invalid input");
            }
        }
        else if((Invoicecol.getSelectionModel().getSelectedItem().toString()).equals("cid")){
            int inputCid=0;
            try {
                inputCid = Integer.parseInt(searchInvoice.getText());
                for (Invoice invoice : Data.dataInvoice) {
                    if (String.valueOf(invoice.getCid()).contains(String.valueOf(inputCid))) {
                        dataInvoice.add(invoice);
                    }
                }
                newlistInvoice = FXCollections.observableArrayList(dataInvoice);
                if(newlistInvoice != null)
                    table_Invoice.setItems(newlistInvoice);

            } catch (NumberFormatException e) {
                table_Invoice.setItems(listInvoice);
                System.out.println("Invalid input");
            }
        }else if((Invoicecol.getSelectionModel().getSelectedItem().toString()).equals("pharid")){
            int inputCid=0;
            try {
                inputCid = Integer.parseInt(searchInvoice.getText());
                for (Invoice invoice : Data.dataInvoice) {
                    if (String.valueOf(invoice.getPharid()).contains(String.valueOf(inputCid))) {
                        dataInvoice.add(invoice);
                    }
                }
                newlistInvoice = FXCollections.observableArrayList(dataInvoice);
                if(newlistInvoice != null)
                    table_Invoice.setItems(newlistInvoice);

            } catch (NumberFormatException e) {
                table_Invoice.setItems(listInvoice);
                System.out.println("Invalid input");
            }
        } else if((Invoicecol.getSelectionModel().getSelectedItem().toString()).equals("paymentMeth")){
            String inputCname="";
            try {
                inputCname = searchInvoice.getText();
                for (Invoice invoice : Data.dataInvoice) {
                    if (invoice.getPaymentMeth().toLowerCase().contains(inputCname.toLowerCase())) {
                        dataInvoice.add(invoice);
                    }
                }
                newlistInvoice = FXCollections.observableArrayList(dataInvoice);
                if(newlistInvoice!= null)
                    table_Invoice.setItems(newlistInvoice);
                if(inputCname=="")
                    table_Invoice.setItems(listInvoice);

            } catch (NumberFormatException e) {
                table_Invoice.setItems(listInvoice);
                System.out.println("Invalid input");
            }

        }

    }




    //********************************* Function Manufacturer //*************************************************************
    @FXML
    void ADDManufacturer(javafx.event.ActionEvent actionEvent) {
        long phone=0;
        String nam = MNameTXT.getText();
        String addr = AddressTXT.getText();
        try {

            phone = Long.parseLong(PhoneTXT.getText());
            if (phone < 0 ) {
                throw new NumberFormatException();
            }


            Data.insertData(new Manufacturer(1,addr,nam, phone  ));
            listManufacturer.clear();
            listManufacturer = FXCollections.observableArrayList(Data.dataManufacturer);
            table_Manufacturer.setItems(listManufacturer);
        } catch (NumberFormatException e) {
            Data.Error();
            System.out.println("Invalid input");
        }

    }
    @FXML
    public void DeleteManufacturer(javafx.event.ActionEvent actionEvent){
        Manufacturer selectedItem = table_Manufacturer.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listManufacturer.remove(selectedItem);
            Data.deleteRow(selectedItem );

        }
        getdata();
    }
    public void searchManufacturer(KeyEvent keyEvent) {
        //"mid","address","mname","phone"
        ObservableList<Manufacturer> newlistManufacturer=null;
        ArrayList<Manufacturer> dataManufacturer =new ArrayList<>();
        dataManufacturer.clear();
        if((colManufacturer.getSelectionModel().getSelectedItem().toString()).equals("mid")){
            int inputCid=0;
            try {
                inputCid = Integer.parseInt(searchManufacturer.getText());
                for (Manufacturer manufacturer : Data.dataManufacturer) {
                    if (String.valueOf(manufacturer .getMid()).contains(String.valueOf(inputCid))) {
                        dataManufacturer.add(manufacturer );
                    }
                }
                newlistManufacturer = FXCollections.observableArrayList(dataManufacturer);
                if(newlistManufacturer != null)
                    table_Manufacturer.setItems(newlistManufacturer);

            } catch (NumberFormatException e) {
                table_Manufacturer.setItems(listManufacturer);
                System.out.println("Invalid input");
            }
        }else if ((colManufacturer.getSelectionModel().getSelectedItem().toString()).equals("phone")){
            int inputCid=0;
            try {
                inputCid = Integer.parseInt(searchManufacturer.getText());
                for (Manufacturer manufacturer : Data.dataManufacturer) {
                    if (String.valueOf(manufacturer .getPhone()).contains(String.valueOf(inputCid))) {
                        dataManufacturer.add(manufacturer );
                    }
                }
                newlistManufacturer = FXCollections.observableArrayList(dataManufacturer);
                if(newlistManufacturer != null)
                    table_Manufacturer.setItems(newlistManufacturer);

            } catch (NumberFormatException e) {
                table_Manufacturer.setItems(listManufacturer);
                System.out.println("Invalid input");
            }
        }else if((colManufacturer.getSelectionModel().getSelectedItem().toString()).equals("address")){
            String inputCname="";
            try {
                inputCname = searchManufacturer.getText();
                for (Manufacturer manufacturer : Data.dataManufacturer) {
                    if (manufacturer.getAddress().toLowerCase().contains(inputCname.toLowerCase())) {
                        dataManufacturer.add(manufacturer);
                    }
                }
                newlistManufacturer= FXCollections.observableArrayList(dataManufacturer);
                if(newlistManufacturer != null)
                    table_Manufacturer.setItems(newlistManufacturer);
                if(inputCname=="")
                    table_Manufacturer.setItems(listManufacturer);

            } catch (NumberFormatException e) {
                table_Manufacturer.setItems(listManufacturer);
                System.out.println("Invalid input");
            }

        }else if((colManufacturer.getSelectionModel().getSelectedItem().toString()).equals("mname")){
            String inputCname="";
            try {
                inputCname = searchManufacturer.getText();
                for (Manufacturer manufacturer : Data.dataManufacturer) {
                    if (manufacturer.getMname().toLowerCase().contains(inputCname.toLowerCase())) {
                        dataManufacturer.add(manufacturer);
                    }
                }
                newlistManufacturer= FXCollections.observableArrayList(dataManufacturer);
                if(newlistManufacturer != null)
                    table_Manufacturer.setItems(newlistManufacturer);
                if(inputCname=="")
                    table_Manufacturer.setItems(listManufacturer);

            } catch (NumberFormatException e) {
                table_Manufacturer.setItems(listManufacturer);
                System.out.println("Invalid input");
            }

        }


    }


    //********************************* Function Prescription //*************************************************************
    @FXML
    void ADDPrescription(javafx.event.ActionEvent actionEvent) {
        int did=0;
        int cu=0;
        int mid=0;
        int q=0;
        String text = Per_textX.getText();
        String s = String.valueOf(Per_dateX.getValue());

        try {
            did = Integer.parseInt(DidX.getText());
            if (did < 0   ) {
                throw new NumberFormatException();
            }
            cu = Integer.parseInt(CusidX.getText());
            if (cu< 0 ) {
                throw new NumberFormatException();
            }
            mid =Integer.parseInt(MidX.getText());
            if (mid< 0 ) {
                throw new NumberFormatException();
            }
            q = Integer.parseInt(QuantityX.getText());
            if (q< 0 ) {
                throw new NumberFormatException();
            }


            Data.insertData(new Prescription(did,cu ,mid , text , s , q ));
            listPrescription.clear();
            listPrescription = FXCollections.observableArrayList(Data.dataPrescription);
            table_Prescription.setItems(listPrescription);
        } catch (NumberFormatException e) {
            Data.Error();
            System.out.println("Invalid input");
        }

    }
    @FXML
    public void DeletePrescription(javafx.event.ActionEvent actionEvent){
        Prescription selectedItem = table_Prescription.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listPrescription.remove(selectedItem);
            Data.deleteRow(selectedItem );

        }
        getdata();
    }
    public void searchPrescription(KeyEvent keyEvent) {
        ObservableList<Prescription> newlistPrescription = null;
        ArrayList<Prescription> dataPrescription = new ArrayList<>();
        dataPrescription.clear();
        if ((COLPrescription.getSelectionModel().getSelectedItem().toString()).equals("did")) {
            int inputinsid = 0;
            try {
                inputinsid = Integer.parseInt(searchPrescription.getText());
                for (Prescription prescription : Data.dataPrescription) {
                    if (String.valueOf(prescription.getDid()).contains(String.valueOf(inputinsid))) {
                        dataPrescription.add(prescription);
                    }
                }
                newlistPrescription = FXCollections.observableArrayList(dataPrescription);
                if (newlistPrescription != null)
                    table_Prescription.setItems(newlistPrescription);

            } catch (NumberFormatException e) {
                table_Prescription.setItems(listPrescription);
                System.out.println("Invalid input");
            }
        } else if ((COLPrescription.getSelectionModel().getSelectedItem().toString()).equals("cusid")) {
            int inputinsid = 0;
            try {
                inputinsid = Integer.parseInt(searchPrescription.getText());
                for (Prescription prescription : Data.dataPrescription) {
                    if (String.valueOf(prescription.getCusid()).contains(String.valueOf(inputinsid))) {
                        dataPrescription.add(prescription);
                    }
                }
                newlistPrescription = FXCollections.observableArrayList(dataPrescription);
                if (newlistPrescription != null)
                    table_Prescription.setItems(newlistPrescription);

            } catch (NumberFormatException e) {
                table_Prescription.setItems(listPrescription);
                System.out.println("Invalid input");
            }
        } else if ((COLPrescription.getSelectionModel().getSelectedItem().toString()).equals("mid")) {
            int inputinsid = 0;
            try {
                inputinsid = Integer.parseInt(searchPrescription.getText());
                for (Prescription prescription : Data.dataPrescription) {
                    if (String.valueOf(prescription.getMid()).contains(String.valueOf(inputinsid))) {
                        dataPrescription.add(prescription);
                    }
                }
                newlistPrescription = FXCollections.observableArrayList(dataPrescription);
                if (newlistPrescription != null)
                    table_Prescription.setItems(newlistPrescription);

            } catch (NumberFormatException e) {
                table_Prescription.setItems(listPrescription);
                System.out.println("Invalid input");
            }
        } else if ((COLPrescription.getSelectionModel().getSelectedItem().toString()).equals("quantity")) {
            int inputinsid = 0;
            try {
                inputinsid = Integer.parseInt(searchPrescription.getText());
                for (Prescription prescription : Data.dataPrescription) {
                    if (String.valueOf(prescription.getQuantity()).contains(String.valueOf(inputinsid))) {
                        dataPrescription.add(prescription);
                    }
                }
                newlistPrescription = FXCollections.observableArrayList(dataPrescription);
                if (newlistPrescription != null)
                    table_Prescription.setItems(newlistPrescription);

            } catch (NumberFormatException e) {
                table_Prescription.setItems(listPrescription);
                System.out.println("Invalid input");
            }
        } else if ((COLPrescription.getSelectionModel().getSelectedItem()).equals("per_text")) {
            String inputDname = "";
            try {
                inputDname = searchPrescription.getText();
                for (Prescription prescription : Data.dataPrescription) {
                    if (prescription.getPer_text().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataPrescription.add(prescription);
                    }
                }
                newlistPrescription = FXCollections.observableArrayList(dataPrescription);
                if (newlistPrescription != null)
                    table_Prescription.setItems(newlistPrescription);
                if (inputDname == "")
                    table_Prescription.setItems(listPrescription);

            } catch (NumberFormatException e) {
                table_Prescription.setItems(listPrescription);
                System.out.println("Invalid input");
            }

        } else if ((COLPrescription.getSelectionModel().getSelectedItem()).equals("per_date")) {
            String inputDname = "";
            try {
                inputDname = searchPrescription.getText();
                for (Prescription prescription : Data.dataPrescription) {
                    if (prescription.getPer_date().toLowerCase().contains(inputDname.toLowerCase())) {
                        dataPrescription.add(prescription);
                    }
                }
                newlistPrescription = FXCollections.observableArrayList(dataPrescription);
                if (newlistPrescription != null)
                    table_Prescription.setItems(newlistPrescription);
                if (inputDname == "")
                    table_Prescription.setItems(listPrescription);

            } catch (NumberFormatException e) {
                table_Prescription.setItems(listPrescription);
                System.out.println("Invalid input");
            }

        }
    }

    //********************************* Function Medicine //*************************************************************
    @FXML
    void ADDMedicine(javafx.event.ActionEvent actionEvent) {
        String mType = txtmType.getText();
        String dosage = txtdosage.getText();
        int quantity = 0;
        float price = 0;
        int cid  = 0;
        String expiryDate = String.valueOf(txtexpiryDate.getValue());
        try {
            quantity= Integer.parseInt(txtquantity.getText());
            if (quantity < 0   ) {
                throw new NumberFormatException();
            }
            boolean exitsCid = false;
            cid = Integer.parseInt(txtcid.getText());
            for(int i = 0 ; i < Data.dataPharmacist.size() ; i++){
                if(Data.dataManufacturer.get(i).getMid() == cid){
                    exitsCid  = true;
                    break;
                }
            }
            if(cid < 0 || !exitsCid){
                throw new NumberFormatException();
            }

            price = Float.parseFloat(txtprice.getText());
            if (price < 0 ) {
                throw new NumberFormatException();
            }


            /*int mid, String mType, String dosage, String expiryDate, float price, int quantity, int cid*/
            Data.insertData(new Medicine(1,mType,dosage , expiryDate,price,quantity , cid ));
            listMedicine.clear();
            listMedicine = FXCollections.observableArrayList(Data.dataMedicine);
            table_Medicine.setItems(listMedicine);
        } catch (NumberFormatException e) {
            Data.Error();
            if (quantity < 0   ) {
                System.out.println("quantity is wrong");
            }else if(cid <  0){
                System.out.println("Cid is wrong");
            }
            else
                System.out.println("Invalid input");
        }
        txtprice.clear();
        txtquantity.clear();
        txtdosage.clear();
        txtmType.clear();
        txtcid.clear();


    }

    @FXML
    public void DeleteMedicine(javafx.event.ActionEvent actionEvent) {
        Medicine selectedItem = table_Medicine.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listMedicine.remove(selectedItem);
            Data.deleteRow(selectedItem);

        }
        listMedicine = FXCollections.observableArrayList(Data.dataMedicine);
        table_Medicine.setItems(listMedicine);

    }

    public void searchMed(KeyEvent keyEvent) {
        ObservableList<Medicine> newlistMedicine=null;
        ArrayList<Medicine> dataMedicine =new ArrayList<>();
        dataMedicine.clear();
        if((combMedicine.getSelectionModel().getSelectedItem().toString()).equals("mid")){
            int inputmid = 0;
            try {

                inputmid = Integer.parseInt(searchMedicine.getText());
                for (Medicine medicine : Data.dataMedicine) {
                    if (String.valueOf(medicine.getMid()).contains(String.valueOf(inputmid))) {
                        dataMedicine.add(medicine);
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if(newlistMedicine!= null)
                    table_Medicine.setItems(newlistMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }

        }
        else if((combMedicine.getSelectionModel().getSelectedItem().toString()).equals("cid")){
            int inputcid = 0;
            try {

                inputcid = Integer.parseInt(searchMedicine.getText());
                for (Medicine medicine : Data.dataMedicine) {
                    if (String.valueOf(medicine.getMid()).contains(String.valueOf(inputcid))) {
                        dataMedicine.add(medicine);
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if(newlistMedicine!= null)
                    table_Medicine.setItems(newlistMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }

        }
        else if((combMedicine.getSelectionModel().getSelectedItem()).equals("mType")) {
            String inputmType = "";
            try {

                inputmType = searchMedicine.getText();
                for (Medicine medicine : Data.dataMedicine) {
                    if (medicine.getMType().toLowerCase().contains(inputmType.toLowerCase())) {
                        dataMedicine.add(medicine);
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if (newlistMedicine != null)
                    table_Medicine.setItems(newlistMedicine);
                if (inputmType == "")
                    table_Medicine.setItems(listMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }
        }
        else if((combMedicine.getSelectionModel().getSelectedItem()).equals("dosage")){
            String inputDosage="";
            try {

                inputDosage = searchMedicine.getText();
                for (Medicine medicine : Data.dataMedicine) {
                    if (medicine.getDosage().toLowerCase().contains(inputDosage.toLowerCase())) {
                        dataMedicine.add(medicine);
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if(newlistMedicine != null)
                    table_Medicine.setItems(newlistMedicine);
                if(inputDosage=="")
                    table_Medicine.setItems(listMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }
        }else if((combMedicine.getSelectionModel().getSelectedItem()).equals("quantity")){
            int inputquantity = 0;
            try {

                inputquantity = Integer.parseInt(searchMedicine.getText());
                for (Medicine medicine : Data.dataMedicine) {
                    if (String.valueOf(medicine.getMid()).contains(String.valueOf(inputquantity))) {
                        dataMedicine.add(medicine);
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if(newlistMedicine!= null)
                    table_Medicine.setItems(newlistMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }

        }else if((combMedicine.getSelectionModel().getSelectedItem()).equals("expiryDate")){
            String inputExpiryDate="";
            try {
                inputExpiryDate = searchMedicine.getText();
                for (Medicine medicine : Data.dataMedicine) {
                    if (medicine.getExpiryDate().toLowerCase().contains(inputExpiryDate.toLowerCase())) {
                        dataMedicine.add(medicine );
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if(newlistMedicine != null)
                    table_Medicine.setItems(newlistMedicine);
                if(inputExpiryDate=="")
                    table_Medicine.setItems(listMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }

        }
        else  if((combMedicine.getSelectionModel().getSelectedItem().toString()).equals("price")) {
            float inputprice = 0;
            try {

                inputprice = Integer.parseInt(searchMedicine.getText());
                for (Medicine medicine : Data.dataMedicine) {
                    if (String.valueOf(medicine.getMid()).contains(String.valueOf(inputprice))) {
                        dataMedicine.add(medicine);
                    }
                }
                newlistMedicine = FXCollections.observableArrayList(dataMedicine);
                if (newlistMedicine != null)
                    table_Medicine.setItems(newlistMedicine);

            } catch (NumberFormatException e) {
                table_Medicine.setItems(listMedicine);
                System.out.println("Invalid input");
            }
        }




    }





    //********************************* Function Pharmacist //*************************************************************
    @FXML
    void ADDPharmacist(javafx.event.ActionEvent actionEvent) {
        String name = txtPharamacistName.getText();


        String contact_info = txtPharmacistContact_info.getText();

        int age = 0;

        String gender= txtPharmacistGender.getSelectionModel().getSelectedItem().toString();
        try {
            age = Integer.parseInt(txtPharmacistAge.getText());
            if (age < 0 || age > 150) {
                throw new NumberFormatException();
            }

            /*int phid, String phname, int age, String gender, String contact_info*/


            Data.insertData(new Pharmacist(1, name, age, gender, contact_info ));
            listPharmacist.clear();
            listPharmacist = FXCollections.observableArrayList(Data.dataPharmacist);
            table_Pharmacist.setItems(listPharmacist);
        } catch (NumberFormatException e) {
            Data.Error();
            if (age < 0 || age > 150) {
                System.out.println("age is wrong");
            }

        }

        txtPharamacistName.clear();
        txtPharmacistAge.clear();
        txtPharmacistContact_info.clear();
    }
    @FXML
    public void DeletePharmacist(javafx.event.ActionEvent actionEvent) {
        Pharmacist selectedItem = table_Pharmacist.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listPharmacist.remove(selectedItem);
            Data.deleteRow(selectedItem);

        }
        listPharmacist = FXCollections.observableArrayList(Data.dataPharmacist);
        table_Pharmacist.setItems(listPharmacist);

    }
    public void searchPharm(KeyEvent keyEvent) {
        /*int phid, String phname, int age, String gender, String contact_info*/
        ObservableList<Pharmacist> newlistPharmacist=null;
        ArrayList<Pharmacist> dataPharmacist =new ArrayList<>();
        dataPharmacist.clear();
        if((combPharmacsist.getSelectionModel().getSelectedItem().toString()).equals("phid")){
            int inputPhid=0;
            try {
                inputPhid = Integer.parseInt(searchPharmacist.getText());
                for (Pharmacist pharmacist : Data.dataPharmacist) {
                    if (String.valueOf(pharmacist.getPhid()).contains(String.valueOf(inputPhid))) {
                        dataPharmacist.add(pharmacist);
                    }
                }
                newlistPharmacist = FXCollections.observableArrayList(dataPharmacist);
                if(newlistPharmacist != null)
                    table_Pharmacist.setItems(newlistPharmacist);

            } catch (NumberFormatException e) {
                table_Pharmacist.setItems(listPharmacist);
                System.out.println("Invalid input");
            }
        }else if((combPharmacsist.getSelectionModel().getSelectedItem().toString()).equals("phname")){
            String inputPhname="";
            try {
                inputPhname = searchPharmacist.getText();
                for (Pharmacist pharmacist : Data.dataPharmacist) {
                    if (pharmacist.getPhname().toLowerCase().contains(inputPhname.toLowerCase())) {
                        dataPharmacist.add(pharmacist);
                    }
                }
                newlistPharmacist = FXCollections.observableArrayList(dataPharmacist);
                if(newlistPharmacist != null)
                    table_Pharmacist.setItems(newlistPharmacist);
                if(inputPhname=="")
                    table_Pharmacist.setItems(listPharmacist);

            } catch (NumberFormatException e) {
                table_Pharmacist.setItems(listPharmacist);
                System.out.println("Invalid input");
            }

        }else if((combPharmacsist.getSelectionModel().getSelectedItem().toString()).equals("age")){
            int inputAge=0;
            try {
                inputAge = Integer.parseInt(searchPharmacist.getText());
                for (Pharmacist pharmacist : Data.dataPharmacist) {
                    if (String.valueOf(pharmacist.getAge()).contains(String.valueOf(inputAge))) {
                        dataPharmacist.add(pharmacist);
                    }
                }
                newlistPharmacist = FXCollections.observableArrayList(dataPharmacist);
                if(newlistPharmacist != null)
                    table_Pharmacist.setItems(newlistPharmacist);

            } catch (NumberFormatException e) {
                table_Pharmacist.setItems(listPharmacist);
                System.out.println("Invalid input");
            }
        }
        else if((combPharmacsist.getSelectionModel().getSelectedItem().toString()).equals("gender")){
            String inputGender="";
            try {
                inputGender = searchPharmacist.getText();
                for (Pharmacist pharmacist : Data.dataPharmacist) {
                    if (pharmacist.getGender().toLowerCase().equals(inputGender.toLowerCase())) {
                        dataPharmacist.add(pharmacist);
                    }
                }
                newlistPharmacist = FXCollections.observableArrayList(dataPharmacist);
                if(newlistPharmacist != null)
                    table_Pharmacist.setItems(newlistPharmacist);
                if(inputGender=="")
                    table_Pharmacist.setItems(listPharmacist);

            } catch (NumberFormatException e) {
                table_Pharmacist.setItems(listPharmacist);
                System.out.println("Invalid input");
            }

        }else if((combPharmacsist.getSelectionModel().getSelectedItem().toString()).equals("contact_info")) {
            String inputContact_info = "";
            try {
                inputContact_info = searchPharmacist.getText();
                for (Pharmacist pharmacist : Data.dataPharmacist) {
                    if (pharmacist.getContact_info().toLowerCase().contains(inputContact_info.toLowerCase())) {
                        dataPharmacist.add(pharmacist);
                    }
                }
                newlistPharmacist = FXCollections.observableArrayList(dataPharmacist);
                if (newlistPharmacist != null)
                    table_Pharmacist.setItems(newlistPharmacist);
                if (inputContact_info == "")
                    table_Pharmacist.setItems(listPharmacist);

            } catch (NumberFormatException e) {
                table_Pharmacist.setItems(listPharmacist);
                System.out.println("Invalid input");
            }
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
}