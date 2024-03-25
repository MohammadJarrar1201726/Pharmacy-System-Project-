import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class Data extends Application{
    public static String dbURL;

    private static String dbUsername = "root";
    private static String dbPassword = "root1234";
    private static String URL = "127.0.0.1";
    private static String port = "3306";
    private static String dbName = "Pharmacy";
    private static Connection con;

    public static ArrayList<Pharmacist> dataPharmacist ;


    public static ArrayList<Insurance> dataInsurance;

    public static int countin=0;
    public static ArrayList<Doctor> dataDoctor;


    public static ArrayList<Manufacturer> dataManufacturer;


    public static ArrayList<Customer> dataCustomer;


    public static ArrayList<Tax> dataTax;


    public static ArrayList<Medicine> dataMedicine;


    public static ArrayList<Prescription> dataPrescription;


    public static ArrayList<Invoice> dataInvoice;


    public static ArrayList<Invoice_med> dataInvoice_med;

    public static int pharm_count;
    public static int m_count;

    public static int Cust_count;

    public static ArrayList<Medicine> datadates;
    public static ArrayList<Medicine> datadates1;

    public static ArrayList<Invoice_med> datasales;


    public static ArrayList<sales> medicineResults = new ArrayList<>();
    public static ArrayList<chart> chart = new ArrayList<>();


    public static ArrayList<Manufacturer> dataManufacturer1;

    public static void main(String[] args )  {


        launch(args);


    }

    public static Stage stage;
    public void start(Stage primaryStage ) throws IOException {
        stage= primaryStage;
        try {
            dataCustomer = new ArrayList<>();
            dataPharmacist = new ArrayList<>();
            dataManufacturer = new ArrayList<>();
            dataMedicine = new ArrayList<>();
            dataTax = new ArrayList<>();
            dataInvoice = new ArrayList<>();
            dataInsurance = new ArrayList<>();
            dataDoctor= new ArrayList<>();
            dataPrescription = new ArrayList<>();
            dataInvoice_med = new ArrayList<>();
            dataMedicine = new ArrayList<>();
            /*********************************************************************/
            datadates = new ArrayList<>();
            datadates1 = new ArrayList<>();
            datasales = new ArrayList<Invoice_med>();
            medicineResults = new ArrayList<>();
            chart = new ArrayList<>();
            /******************************************************************/
            dataManufacturer = new ArrayList<>();
            dataManufacturer1 = new ArrayList<>();

            getDataCustomer();
            getDataPharmacist();
            getDataManufacturer();

            getDataTax();
            getDataInvoice();
            getDataInsurance();
            getDataDoctor();
            getDataPrescription();
            getDataInvoice_med();
            getDataMedicine();
            /********************************/
            getDates();
//            getsales();
            getq();
            graphing();
            /********************************/
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }


        /**********************************************************************************************/
        /********************************/

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Scene scene = new Scene(root);


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        System.out.println(screenBounds.getWidth());
        System.out.println(screenBounds.getHeight());
//        root.prefWidth(screenBounds.getWidth());
//        root.prefHeight(screenBounds.getHeight());

        primaryStage.setScene(scene);
        primaryStage.setTitle("my pharmacy");
//        primaryStage.setFullScreen(true);

        primaryStage.show();
        /********************************************/






        // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("csutomer.fxml")));
        // Scene scene = new Scene(root);
        // primaryStage.setScene(scene);
        // primaryStage.setTitle("Customer");
        // primaryStage.setFullScreen(true);
        // primaryStage.show();



































        /*************************************************************************************************/

        System.out.println("Customer Data");
        for(int i =0 ; i<dataCustomer.size() ; i++) {
            System.out.println(dataCustomer.get(i));
        }
        System.out.println();

        System.out.println("Insurance Data");
        for(int i =0 ; i<dataInsurance.size() ; i++) {
            System.out.println(dataInsurance.get(i));
        }
        System.out.println();

        System.out.println("Doctor data");
        for(int i = 0 ; i<dataDoctor.size() ; i++) {
            System.out.println(dataDoctor.get(i));
        }
        System.out.println();

        System.out.println("Invoice_med data");
        for(int i = 0 ; i<dataInvoice_med.size() ; i++) {
            System.out.println(dataInvoice_med.get(i));
        }
        System.out.println();

        System.out.println("Invoice data");
        for(int i = 0 ; i < dataInvoice.size() ; i++) {
            System.out.println(dataInvoice.get(i));
        }
        System.out.println();

        System.out.println("Manufacturer  data");
        for(int i =0 ; i<dataManufacturer.size() ; i++) {
            System.out.println(dataManufacturer.get(i));
        }
        System.out.println();



        System.out.println("Pharmacist data");
        for(int i =0; i<dataPharmacist.size() ; i++) {
            System.out.println(dataPharmacist.get(i));
        }
        System.out.println();

        System.out.println("Prescription data");
        for(int i =0; i<dataPrescription.size() ; i++) {
            System.out.println(dataPrescription.get(i));
        }
        System.out.println();

        System.out.println("Tax data");
        for(int i = 0;i<dataTax.size() ;i++) {
            System.out.println(dataTax.get(i));
        }
        System.out.println("Medicine data");
        for(int i =0 ; i<dataMedicine.size() ; i++) {
            System.out.println(dataMedicine.get(i));
        }
        System.out.println();

    }

    public static void Error() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Error Message");
        Label errorLabel = new Label("An error has occurred!");
        errorLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
        StackPane root = new StackPane();
        root.getChildren().add(errorLabel);
        root.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 300, 200);
        StackPane.setAlignment(errorLabel, Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(dbURL , p);

    }

    private static void getDataCustomer() throws SQLException , ClassNotFoundException{
        String SQL ;
        connectDB();
        /*********************************************************************/

        Cust_count=0;
        /*********************************************************************/
        System.out.println("Connection established");
        SQL = "select cid , cname , age ,  gender , phone ,insid from Customer;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while(rs.next()) {
            System.out.print(rs.getInt(3) +",");
            dataCustomer.add(new Customer(rs.getInt(1) , rs.getString(2) , rs.getInt(3) , rs.getString(4) , rs.getLong(5) , rs.getInt(6)));
            Cust_count++;

        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Connection closed");

    }


    private static void getDataDoctor() throws SQLException , ClassNotFoundException{
        String SQL ;
        connectDB();

        System.out.println("Connection established");
        SQL = "select did , dname , specialty from Doctor;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {
            dataDoctor.add(new Doctor(rs.getInt(1) , rs.getString(2) , rs.getString(3)));

        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Connection closed");

    }
    private static void getDataManufacturer() throws SQLException , ClassNotFoundException{
        String SQL;
        connectDB();
        /*********************************************************************/
        m_count=0;
        /*********************************************************************/
        System.out.println("Connection established");
        SQL = "select mid , address ,mname , phone from Manufacturer;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {
            dataManufacturer.add(new Manufacturer(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getLong(4)));
            m_count++;
        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Connection closed");
    }

    private static void getDataPharmacist() throws SQLException , ClassNotFoundException{
        String SQL;
        connectDB();
        pharm_count=0;

        System.out.println("Connection established");
        SQL = "select phid , phname , age , gender , contact_info from Pharmacist;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {
            dataPharmacist.add(new Pharmacist(
                    Integer.parseInt(rs.getString(1)) , rs.getString(2) , Integer.parseInt(rs.getString(3)), rs.getString(4) , rs.getString(5) ));
            pharm_count++;

        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Connection closed" + dataPharmacist.size() );

    }

    public void getDates() throws SQLException , ClassNotFoundException{

        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select mid,mtype,expirydate from Medicine order by 3 asc;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {
            datadates.add(new Medicine(rs.getInt(1),rs.getString(2),rs.getString(3)));
            datadates1.add(new Medicine(rs.getString(2)));
        }


//        System.out.println("*********************************************************************************");
//        System.out.println(datadates);
//        System.out.println("*********************************************************************************");

        rs.close();
        stmt.close();
        con.close();
    }

    public void getq() throws SQLException , ClassNotFoundException{

        String SQL;
        connectDB();
        System.out.println("Connection established");
        String SQL2="SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));";
        Statement stmt2 = con.createStatement();
        ResultSet rs2 = stmt2.executeQuery(SQL2);

        SQL = "  SELECT M.mid, m.mtype AS medicine_name, SUM(im.quantity) AS total_price\n" +
                "FROM Medicine M, Invoice I, Invoice_med im\n" +
                "WHERE M.mid = Im.mid AND im.invid = i.vid\n" +
                "GROUP BY M.mid, m.mtype\n" +
                "order by 3 desc " +
                "LIMIT 0, 1000" +
                ";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while(rs.next()) {

//            String mType = rs.getString("mType");
//            double totalAmount = rs.getDouble("totalAmount");
            medicineResults.add(new sales(rs.getString(2),rs.getInt(3)));

        }
        rs.close();
        stmt.close();
        con.close();
    }
    public void graphing() throws SQLException , ClassNotFoundException{

        String SQL;
        connectDB();
        System.out.println("Connection established");
        String SQL2="SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));";
        Statement stmt2 = con.createStatement();
        ResultSet rs2 = stmt2.executeQuery(SQL2);

        SQL = "select im.sdate,SUM(M.Price * im.quantity) AS sales from medicine M , invoice_med im , invoice i group by im.sdate order by im.sdate;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while(rs.next()) {


            chart.add(new chart(rs.getString(1),rs.getInt(2)));

        }

        rs.close();
        stmt.close();
        con.close();
    }


    private static void getDataInsurance() throws SQLException , ClassNotFoundException{
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Insurance;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {

            dataInsurance.add(new Insurance(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5)));
        }
        rs.close();
        stmt.close();
        con.close();
    }
    private void getDataTax() throws SQLException , ClassNotFoundException{
		/*
		 * int tid ;
	String taxType;
	String taxDescription;
		 */
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Tax;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {

            dataTax.add(new Tax(rs.getInt(1) , rs.getString(2) , rs.getString(3) ));
        }
        rs.close();
        stmt.close();
        con.close();
    }
    private static void getDataMedicine() throws SQLException , ClassNotFoundException{
		/*
		 *
	int mid;
	String mType;
	String dosage;
	String expiryDate;
	float price;
	int quantity ;
	int cid ; //Manufacturer id
		 */
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Medicine;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {



            dataMedicine.add(new Medicine(rs.getInt(1) , rs.getString(2) , rs.getString(3)  , rs.getString(4) , Float.parseFloat(rs.getString(5) )  , rs.getInt(6) , rs.getInt(7)  ));
        }
        rs.close();
        stmt.close();
        con.close();
    }
    private static void getDataPrescription() throws SQLException , ClassNotFoundException{
		/*
		 int did;
	int cusid;
	int mid;
	String per_text;
	String per_date;
	int quantity ;
		 */
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Prescription;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {

            dataPrescription.add(new Prescription(rs.getInt(1) , rs.getInt(2) , rs.getInt(3) , rs.getString(4) , rs.getString(5) , rs.getInt(6) ));
        }
        rs.close();
        stmt.close();
        con.close();
    }
    public static int getindex(int ph,int cid) throws SQLException , ClassNotFoundException{
		/*
		int vid ;
	float price;
	String paymentMeth;
	double percentage;
	int pharid; // pharmacist id
	int tid; // tax id
	int cid ; // Customer id
		 */
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = " SELECT I.*, SUM(M.price * IM.quantity) AS InvoicePrice\n" +
                "FROM Invoice I\n" +
                "JOIN Invoice_med IM ON I.vid = IM.invid\n" +
                "JOIN Medicine M ON M.mid = IM.mid AND M.cid = IM.cid\n" +
                "GROUP BY I.vid\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT I.*, 0 AS InvoicePrice\n" +
                "FROM Invoice I\n" +
                "WHERE I.vid NOT IN (\n" +
                "    SELECT IM.invid\n" +
                "    FROM Invoice_med IM\n" +
                ")\n" +
                "GROUP BY I.vid;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        int check=0;
        while(rs.next()) {

            if(rs.getInt(3) == ph &&rs.getInt(4) == cid )
                return rs.getInt(1);
            check++;
        }

        rs.close();
        stmt.close();
        con.close();
        return 0;
    }
    private static void getDataInvoice() throws SQLException , ClassNotFoundException{
		/*
		int vid ;
	float price;
	String paymentMeth;
	double percentage;
	int pharid; // pharmacist id
	int tid; // tax id
	int cid ; // Customer id
		 */
        countin=0;
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = " SELECT I.*, SUM(M.price * IM.quantity) AS InvoicePrice\n" +
                "FROM Invoice I\n" +
                "JOIN Invoice_med IM ON I.vid = IM.invid\n" +
                "JOIN Medicine M ON M.mid = IM.mid AND M.cid = IM.cid\n" +
                "GROUP BY I.vid\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT I.*, 0 AS InvoicePrice\n" +
                "FROM Invoice I\n" +
                "WHERE I.vid NOT IN (\n" +
                "    SELECT IM.invid\n" +
                "    FROM Invoice_med IM\n" +
                ")\n" +
                "GROUP BY I.vid;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
//int vid,  float price, String paymentMeth, int pharid, int cid
        while(rs.next()) {
            countin++;
            dataInvoice.add(new Invoice(rs.getInt(1) ,rs.getFloat(5) ,  rs.getString(2) , rs.getInt(3) , rs.getInt(4) ));
        }
        rs.close();
        stmt.close();
        con.close();
    }
    private static void getDataInvoice_med() throws SQLException , ClassNotFoundException{
		/*
		invid` int NOT NULL,
   `mid` int NOT NULL,
   `cid` int NOT NULL,
   `quantity` int DEFAULT NULL,
		 */
        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Invoice_med;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while(rs.next()) {

            dataInvoice_med.add(new Invoice_med(rs.getInt(1) , rs.getInt(2) , rs.getInt(3) , rs.getInt(4),rs.getString(5) ));
        }
        rs.close();
        stmt.close();
        con.close();
    }



    public static void ExecuteStatement(String SQL) throws SQLException , DateTimeParseException , IllegalArgumentException{
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();

        }
        catch(SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed");
        }
        catch(DateTimeParseException e) {

        }
        catch(IllegalArgumentException e) {

        }
    }


    public static  void insertData(Insurance ins) {
        try {
            System.out.println("insert into Insurance( instype , company , coverageSdate , coverageEdate) values("+ ins.getInstype() +ins.getCompany() +ins.getCoverageSdate() +ins.getCoverageEdate() +");");
            connectDB();
            ExecuteStatement("insert into Insurance( instype , company , coverageSdate , coverageEdate) values('"
                    + ins.getInstype() + "','"
                    +ins.getCompany() + "','"
                    +ins.getCoverageSdate() + "','"
                    +ins.getCoverageEdate()  +"');");
            con.close();
            System.out.println("Connection Closed");
            dataInsurance.clear();
            getDataInsurance();
        }
        catch(SQLException e) {
            Error();
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            Error();
            e.printStackTrace();
        }
    }

    public static  void insertData(Pharmacist ph) {

        try {
            System.out.println("Insert into Pharmacist(phid , phname , age, gender , contact_info) values(" +ph.getPhid() + ph.getPhname() + ph.getAge() + ph.getGender() + ph.getContact_info() + ");");

            connectDB();
            ExecuteStatement("Insert into Pharmacist(phid , phname , age, gender , contact_info) values(" +ph.getPhid() +",'"
                    + ph.getPhname() + "',"
                    + ph.getAge() + ",'" +
                    ph.getGender() + "','"
                    + ph.getContact_info() + "');");
            con.close();
            System.out.println("Connection closed");
            dataPharmacist.clear();
            getDataPharmacist();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static  void insertData(Doctor d) {

        try {
            System.out.println("Insert into Doctor( dname  , specialty) values('"
                    +d.getDname()+ "','"
                    +d.getSpecialty() + "');");

            connectDB();
            ExecuteStatement("Insert into Doctor(dname  , specialty) values('"
                    + d.getDname() + "','"
                    +d.getSpecialty() + "');");
            con.close();
            System.out.println("Connection closed");
            dataDoctor.clear();
            getDataDoctor();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static  void insertData(Manufacturer m) {
        try {
            System.out.println("insert into Manufacturer( address , mname , phone) values("+ m.address +m.mname +m.phone +");");
            connectDB();
            ExecuteStatement("insert into Manufacturer( address , mname , phone) values('"
                    + m.address + "','"
                    +m.mname + "',"  +
                    +m.phone +");");
            con.close();
            System.out.println("Connection Closed");
            dataManufacturer.clear();
            getDataManufacturer();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static  void insertData(Medicine m) {

		/*
		   `mid` int NOT NULL AUTO_INCREMENT,
		   `mname` varchar(32) DEFAULT NULL,
		   `mType` varchar(32) DEFAULT NULL,
		   `dosage` varchar(32) DEFAULT NULL,
		   `expiryDate` date DEFAULT NULL,
		   `price` double DEFAULT NULL,
		   `quantity` int DEFAULT NULL,
		   `cid` int NOT NULL,
		   PRIMARY KEY (`mid`,`cid`),
		   KEY `cid` (`cid`),
 */
        try {
            System.out.println("insert into Medicine(mid , mType , dosage , expiryDate , price , quantity , cid ) values("
                    +m.mid + ",'"
                    + m.mType + "','"
                    + m.dosage + "','"
                    + m.expiryDate + "',"
                    + m.price + ","
                    + m.quantity + ","
                    + m.cid +");");
            connectDB();
            ExecuteStatement("insert into Medicine(mid , mType , dosage , expiryDate , price , quantity , cid ) values("
                    +m.mid + ",'"
                    + m.mType + "','"
                    + m.dosage + "','"
                    + m.expiryDate + "',"
                    + m.price + ","
                    + m.quantity + ","
                    + m.cid +");");
            con.close();
            System.out.println("Connection Closed");
            dataMedicine.clear();
            getDataMedicine();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static  void insertData(Prescription p) {

		/*
		 `did` int NOT NULL,
   `cusid` int NOT NULL,
   `mid` int NOT NULL,
   `per_text` varchar(64) DEFAULT NULL,
   `per_date` date DEFAULT NULL,
   `quantity` int DEFAULT NULL,
   */
        try {
            System.out.println("insert into Prescription(did , cusid , mid , per_text , per_date , quantity) values("
                    +p.did+ ","
                    +p.cusid+ ","
                    +p.mid+ ",'"
                    +p.per_text+ "','"
                    +p.per_date+ "',"
                    +p.quantity +");");
            connectDB();
            ExecuteStatement("insert into Prescription(did , cusid , mid , per_text , per_date , quantity) values("
                    +p.did+ ","
                    +p.cusid+ ","
                    +p.mid+ ",'"
                    +p.per_text+ "','"
                    +p.per_date+ "',"
                    +p.quantity +");");
            con.close();
            System.out.println("Connection Closed");
            dataPrescription.clear();
            getDataPrescription();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static  void insertData(Invoice i) {

			/*
			 `vid` int NOT NULL AUTO_INCREMENT,
	   `currency` varchar(32) DEFAULT NULL,
	   `price` double DEFAULT NULL,
	   `paymentMeth` varchar(32) DEFAULT NULL,
	   `percentage` double DEFAULT NULL,
	   `pharid` int DEFAULT NULL,
	   `cid` int DEFAULT NULL,
	   `tid` int DEFAULT NULL,
	   PRIMARY KEY (`vid`),
	   KEY `pharid` (`pharid`),
	   KEY `cid` (`cid`),
	   KEY `tid` (`tid`)
			 */
        try {
            System.out.println("insert into Invoice(paymentMeth , pharid , cid ) values('"
                    +i.paymentMeth + "',"
                    +i.pharid + ","+i.cid
                    +");");
            connectDB();
            ExecuteStatement("insert into Invoice( paymentMeth ,pharid , cid) values('"
                    +i.paymentMeth + "',"
                    +i.pharid + ","
                    +i.cid
                    +");");
            con.close();
            System.out.println("Connection Closed");
            dataInvoice.clear();
            getDataInvoice();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static  void insertData(Invoice_med im) {

		/*
		invid` int NOT NULL,
   `mid` int NOT NULL,
   `cid` int NOT NULL,
   `quantity` int DEFAULT NULL,
		 */
        try {
            System.out.println("insert into Invoice_med(invid, mid, cid ,  quantity) values("
                    +im.invid + ","
                    +im.mid + ","
                    +im.cid + ","
                    +im.quantity +");");
            connectDB();
            ExecuteStatement("insert into Invoice_med(invid, mid ,cid , quantity,sdate) values("
                    +im.invid + ","
                    +im.mid + ","
                    +im.cid + ","
                    +im.quantity+ ","
                    +im.sdate+");");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertData(Customer c) {

		/*
		    `cid` INT,
		    `cname` VARCHAR(32),
		    `age` INT,
		    `gender` VARCHAR(32),
		    `phone` INT,
		    `insid` INT,
		 */
        try {
            System.out.println("Insert into Customer(  cname, age , gender , phone , insid) values('"
                    +c.getCname()+ "',"
                    +c.getAge() + ",'"
                    +c.getGender() + "',"
                    +c.getPhone() + ","
                    +c.getInsid() + ");");

            connectDB();
            ExecuteStatement("Insert into Customer( cname, age , gender , phone , insid) values('"
                    +c.getCname()+ "',"
                    +c.getAge() + ",'"
                    +c.getGender() + "',"
                    +c.getPhone() + ","
                    +c.getInsid() + ");");
            con.close();
            System.out.println("Connection closed");
            dataCustomer.clear();
            getDataCustomer();

        }
        catch(SQLException e) {

            System.out.println("Error customer no added ");
        }
        catch(ClassNotFoundException e) {

            System.out.println("Error customer no added ");
        }
    }


    public static  void getdata() throws SQLException, ClassNotFoundException {
        dataCustomer.clear();
        getDataCustomer();
        dataPrescription.clear();
        getDataPrescription();
        dataManufacturer.clear();
        getDataManufacturer();
        dataInvoice.clear();
        getDataInvoice();
        dataDoctor.clear();
        getDataDoctor();
        dataInsurance.clear();
        getDataInsurance();
        dataMedicine.clear();
        getDataMedicine();
        dataInvoice_med.clear();
        getDataInvoice_med();
        dataPharmacist.clear();
        getDataPharmacist();
    }



    //Delete Rows
    public static void deleteRow(Customer row) {
        try {
            connectDB();
            System.out.println("delete from Customer where cid = "+row.getCid() + ";");
            ExecuteStatement("delete from Customer where cid = "+row.getCid() + ";");
            con.close();
            System.out.println("Connection closed");
            getdata();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRow(Pharmacist row) {
        try {
            System.out.println("delete from Pharmacist where phid = "+row.getPhid() +";");
            connectDB();
            ExecuteStatement("delete from Pharmacist where phid = "+row.getPhid() +";");
            con.close();
            System.out.println("Connection closed");
            getdata();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRow(Insurance row) {
        try {
            System.out.println("delete from Insurance where insid = "+row.getInsid() +";");
            connectDB();
            ExecuteStatement("delete from Insurance where insid = "+row.getInsid() +";");
            con.close();
            System.out.println("Connection closed");
            getdata();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRow(Doctor row) {
        try {
            System.out.println("delete from Doctor where did = "+row.getDid() +";");
            connectDB();
            ExecuteStatement("delete from Doctor where did = "+row.getDid() +";");
            con.close();
            System.out.println("Connection closed");
            getdata();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRow(Manufacturer row) {
        try {
            System.out.println("delete from Manufacturer where mid = " +row.mid + ";");
            connectDB();
            ExecuteStatement("delete from Manufacturer where mid =" +row.mid + ";");
            con.close();
            System.out.println("Connection closed");
            getdata();


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void deleteRow(Medicine row) {
        try {
            System.out.println("delete from Medicine where mid = " +row.mid +" and cid = " +row.cid +  ";");
            connectDB();
            ExecuteStatement("delete from Medicine where mid = " +row.mid +" and cid = " +row.cid +  ";");
            con.close();
            System.out.println("Connection closed");
            getdata();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRow(Invoice row) {
        try {
            System.out.println("delete from Invoice where vid = " +row.vid + ";");
            connectDB();
            ExecuteStatement("delete from Invoice where vid =" +row.vid+ ";");
            con.close();
            System.out.println("Connection closed");
            getdata();


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRow(Prescription row) {
        try {
            System.out.println("delete from Prescription where mid = " +row.mid+ " and cusid = " +row.cusid + " and did =  " + row.did + ";");
            connectDB();
            ExecuteStatement("delete from Prescription where mid = " +row.mid+ " and cusid = " +row.cusid + " and did =  " + row.did + ";");
            con.close();
            System.out.println("Connection closed");
            getdata();


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRow(Invoice_med row) {
        try {
            System.out.println("delete from Invoice_med where invid = " +row.invid + " and mid = " + row.mid + " and cid = "  + row.cid + ";");
            connectDB();
            ExecuteStatement("delete from Invoice_med where invid = " +row.invid + " and mid = " + row.mid + " and cid = "  + row.cid + ";");
            con.close();
            System.out.println("Connection closed");
            getdata();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }






    //Updates:

    //1:update Pharmacist Attributes:

    public static void updatePharmacistName(int phid, String phname) {
        try {
            System.out.println("update Pharmacist set phname = '" + phname + "' where phid = " +phid);
            connectDB();

            ExecuteStatement("update Pharmacist set phname = '" +phname + "' where phid = " +phid + ";");
            con.close();
            System.out.println("Connection closed");

        }


        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void updatePharmacistAge(int phid, int age) {
        try {
            System.out.println("update Pharmacist set age = "+age+  " where phid = " +phid);
            connectDB();
            ExecuteStatement("update Pharmacist set age = "+age + " where phid = "+phid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updatePharmacistGender(int phid, String gender) {

        try {
            System.out.println("update Pharmacist set gender = '"+gender + "' where phid = " +phid + ";");
            connectDB();
            ExecuteStatement("update Pharmacist set  gender = '"+gender +"' where phid = "+phid + ";");
            con.close();
            System.out.println("Connection Closed");
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e ) {
            e.printStackTrace();
        }

    }
    public static void updatePharmacistContact_info(int phid, String contact_info) {

        try {
            System.out.println("update Pharmacist set contact_info = " +contact_info + "where phid = " +phid +";");
            connectDB();
            ExecuteStatement("update Pharmacist set contact_info = '"+contact_info + "' where phid = "+phid +";");
            con.close();
            System.out.println("Connection closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    //2:update Insurance Attributes:
    public static void updateInsuranceType(int insid, String instype) {
        try {
            System.out.println("update Insurance set instype =  '"+instype + "' where insid = " +insid +";");
            connectDB();
            ExecuteStatement("update Insurance set instype =  '"+instype + "' where insid = " +insid +";");
            con.close();
            System.out.println("Connection closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateInsuranceCompany(int insid, String company) {
        try {
            System.out.println("update Insurance set company = '"+company + "' where insid = "+insid +";");
            connectDB();
            ExecuteStatement("update Insurance set company = '"+company + "' where insid = "+insid +";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateInsuranceCoverageSdate(int insid, String coverageSdate) {
        try {
            LocalDate date = LocalDate.parse(coverageSdate.toString(), DateTimeFormatter.ISO_DATE);
            System.out.println("update Insurance set coverageSdate = '" +date + "' where insid = "+insid +";");
            connectDB();
            ExecuteStatement("update Insurance set coverageSdate = '" +date.toString() + "'  where insid = "+insid +";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e);
        }
        catch (DateTimeParseException e) {

            System.out.println("Exception: " + e);
        }

    }
    public static void updateInsuranceCoverageEdate(int insid, String coverageEdate) {
        try {
            LocalDate date = LocalDate.parse(coverageEdate.toString(), DateTimeFormatter.ISO_DATE);
            System.out.println("update Insurance set coverageEdate = '" +coverageEdate + "' where insid = "+insid +";");
            connectDB();
            ExecuteStatement("update Insurance set coverageEdate = '" +date + "' where insid = "+insid +";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //3:update Doctor Attributes:
    public static void updateDoctorName(int did, String dname) {
        try {
            System.out.println("update Doctor set dname = '"+dname +"' where did = "+did);
            connectDB();
            ExecuteStatement("update Doctor set dname = '"+dname +  "' where did = "+did + ";");
            con.close();
            System.out.println("Connection established");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateDoctorSpecialty(int did, String specialty) {
        try {
            System.out.println("update Doctor set specialty = '"+specialty +"' where did = "+did + ";");
            connectDB();
            ExecuteStatement("update Doctor set specialty = '"+specialty +"' where did = "+did + ";");
            con.close();
            System.out.println("Connection established");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //4:Update Manufacturer Attributes:
    public static void updateManufacturerAddress(int mid, String address) {
        try {
            connectDB();
            System.out.println("update Manufacturer set address = '"+address + "' where mid = " +mid + ";");
            ExecuteStatement("update Manufacturer set address = '"+address + "' where mid = " +mid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateManufacturerName(int mid, String mname) {
        try {
            connectDB();
            System.out.println("update Manufacturer set mname = '"+mname + "' where mid = "+mid +";");
            ExecuteStatement("update Manufacturer set mname = '"+mname + "' where mid = "+mid +";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateManufacturerPhone(int mid, long phone) {
        try {
            connectDB();
            System.out.println("update Manufacturer set phone = "+phone + " where mid = "+mid +";");
            ExecuteStatement("update Manufacturer set phone = "+phone + " where mid = "+mid +";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //5:Update Customer Attributes:
    public static void updateCustomerName(int cid, String cname) {
        try {
            connectDB();
            System.out.println("update Customer set cname = '"+cname +"' where cid = " +cid + ";");
            ExecuteStatement("update Customer set cname = '"+cname +"' where cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateCustomerAge(int cid , int age) {
        try {
            connectDB();
            System.out.println("update Customer set age = " +age +" where cid = " +cid + ";");
            ExecuteStatement("update Customer set age = " +age +" where cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateCustomerGender(int cid , String gender) {
        try {
            connectDB();
            System.out.println("update Customer set gender = '" +gender + "' where cid = " +cid + ";");
            ExecuteStatement("update Customer set gender = '" +gender + "' where cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  static void updateCustomerPhone(int cid , long phone ) {
        try {
            connectDB();
            System.out.println("update Customer set phone = " +phone +" where cid = " +cid + ";");
            ExecuteStatement("update Customer set phone = " +phone +" where cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  static void updateCustomerInsid(int cid , int insid) {
        try {
            connectDB();
            System.out.println("update Customer set insid = " +insid +" where cid = " +cid + ";");
            ExecuteStatement("update Customer set insid = " +insid +" where cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    //7: Update Medicine Attributes

    public static void updateMedicineType(int mid, int cid, String mType) {
        try {
            connectDB();
            System.out.println("update Medicine set mType = '" +mType + "' where mid = " +mid + " and cid = " +cid + ";");
            ExecuteStatement("update Medicine set mType = '" +mType + "' where mid = " +mid + " and cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateMedicineDosage(int mid, int cid, String dosage) {
        try {
            connectDB();
            System.out.println("update Medicine set dosage = '" +dosage + "' where mid = " +mid + " and cid = " +cid + ";");
            ExecuteStatement("update Medicine set dosage = '" +dosage + "' where mid = " +mid + " and cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateMedicineExpiryDate(int mid, int cid, String expiryDate) {
        try {
            connectDB();
            System.out.println("update Medicine set expiryDate = '" +expiryDate + "' where mid = " +mid + " and cid = " +cid + ";");
            ExecuteStatement("update Medicine set expiryDate = '" +expiryDate + "' where mid = " +mid + " and cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateMedicinePrice(int mid, int cid, float price) {
        try {
            connectDB();
            System.out.println("update Medicine set price = " +price + " where mid = " +mid + " and cid = " +cid + ";");
            ExecuteStatement("update Medicine set price = " +price + " where mid = " +mid + " and cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateMedicineQuantity(int mid, int cid, int quantity) {
        try {
            connectDB();
            System.out.println("update Medicine set quantity = " +quantity + " where mid = " +mid + " and cid = " +cid + ";");
            ExecuteStatement("update Medicine set quantity = " +quantity + " where mid = " +mid + " and cid = " +cid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //8:Prescription Update Attributes:

    public static void updatePrescriptionText(int did, int cusid, int mid, String per_text) {
        try {
            connectDB();
            System.out.println("update Prescription set per_text = '" +per_text +"' where did = " +did + " and cusid = " + cusid + " and mid = " +mid + ";");
            ExecuteStatement("update Prescription set per_text = '" +per_text +"' where did = " +did + " and cusid = " + cusid + " and mid = " +mid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updatePrescriptionDate(int did, int cusid, int mid, String per_date) {
        try {
            connectDB();
            System.out.println("update Prescription set per_date = '" +per_date +"' where did = " +did + " and cusid = " + cusid + " and mid = " +mid + ";");
            ExecuteStatement("update Prescription set per_date = '" +per_date +"' where did = " +did + " and cusid = " + cusid + " and mid = " +mid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updatePrescriptionQuantity(int did, int cusid, int mid, int quantity) {
        try {
            connectDB();
            System.out.println("update Prescription set quantity = " +quantity +" where did = " +did + " and cusid = " + cusid + " and mid = " +mid + ";");
            ExecuteStatement("update Prescription set quantity = " +quantity +" where did = " +did + " and cusid = " + cusid + " and mid = " +mid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //9: Update Invoice Attributes :


    public static void updateInvoicePaymentMeth(int vid, String paymentMeth) {
        try {
            connectDB();
            System.out.println("update Invoice set paymentMeth = '" +paymentMeth+ "' where vid = "+ vid + ";");
            ExecuteStatement("update Invoice set paymentMeth = '" +paymentMeth+ "' where vid = "+ vid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateInvoicePharid(int vid, int pharid) {
        try {
            connectDB();
            System.out.println("update Invoice set pharid = " +pharid + " where vid = "+ vid + ";");
            ExecuteStatement("update Invoice set pharid = " +pharid + " where vid = "+ vid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateInvoiceTid(int vid, int tid) {
        try {
            connectDB();
            System.out.println("update Invoice set tid = " +tid  + " where vid = "+ vid + ";");
            ExecuteStatement("update Invoice set tid = " +tid  + " where vid = "+ vid + ";");
            con.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //10 : Update Attributes of Invoice_med:

    public void updateInvoice_medQuantity(int invid , int mid , int cid , int quantity) {
        try {
            connectDB();
            System.out.println("update Invoice_med set quantity = " +quantity + " where mid = " +mid + " and cid = "+cid  +" and invid = " + invid + ";");
            ExecuteStatement("update Invoice_med set quantity = " +quantity + " where mid = " +mid + " and cid = "+cid  +" and invid = " + invid + ";");
            con.close();
            System.out.println("Connection Closed");

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Customer> getCustomer(){
        return dataCustomer;
    }


    /*******************************/
    public static ArrayList<String> getn(){
        ArrayList<String> list= new ArrayList<String>();
        for (Pharmacist invoice : dataPharmacist){
            if(!list.contains(invoice.getPhname())){
                list.add(invoice.getPhname());
            }
        }
        return list;
    }
    /****************************/
    public static ArrayList<String> getIn() {
        ArrayList<String> list = new ArrayList<String>();
        for (Insurance invoice : dataInsurance) {
            if (!list.contains(invoice.getCompany())) {
                list.add(invoice.getCompany());
            }
        }
        return list;
    }

    public static ArrayList<String> getpay(){
        ArrayList<String> list= new ArrayList<String>();
        for (Invoice invoice : dataInvoice){
            if(!list.contains(invoice.getPaymentMeth())){
                list.add(invoice.getPaymentMeth());
            }
        }
        return list;
    }
}
