/*CREATE TABLE `invoice` (
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
   KEY `tid` (`tid`),*/

public class Invoice {
    int vid ;
    float price;
    String paymentMeth;
    int pharid; // pharmacist id
    int cid ; // Customer id
    public Invoice(int vid,  float price, String paymentMeth, int pharid, int cid) {
        super();
        this.vid = vid;

        this.price = price;
        this.paymentMeth = paymentMeth;

        this.pharid = pharid;

        this.cid = cid;
    }
    public int getVid() {
        return vid;
    }
    public void setVid(int vid) {
        this.vid = vid;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getPaymentMeth() {
        return paymentMeth;
    }
    public void setPaymentMeth(String paymentMeth) {
        this.paymentMeth = paymentMeth;
    }

    public int getPharid() {
        return pharid;
    }
    public void setPharid(int pharid) {
        this.pharid = pharid;
    }

    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    @Override
    public String toString() {
        return "Invoice [vid=" + vid  + ", price=" + price + ", paymentMeth=" + paymentMeth
                +  ", pharid=" + pharid +  ", cid=" + cid + "]";
    }



}
