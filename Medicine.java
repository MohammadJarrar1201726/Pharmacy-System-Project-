/*
 * CREATE TABLE Medicine (
    mid INT AUTO_INCREMENT,
    mType VARCHAR(32),
    dosage VARCHAR(32),
    expiryDate DATE,
    price real,
    quantity int,
    cid INT,
 */
public class Medicine {

    int mid;
    String mType;
    String dosage;
    String expiryDate;
    float price;
    int quantity ;
    int cid ; //Manufacturer id
    public Medicine(int mid, String mType, String dosage, String expiryDate, float price, int quantity, int cid) {
        super();
        this.mid = mid;
        this.mType = mType;
        this.dosage = dosage;
        this.expiryDate = expiryDate;
        this.price = price;
        this.quantity = quantity;
        this.cid = cid;
    }
    public Medicine(int mid, String type, String date){
        this.mid=mid;
        this.mType=type;
        this.expiryDate=date;


    }

    public Medicine(String mType) {
        this.mType=mType;
    }
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getMType() {
        return mType;
    }
    public void setMType(String mType) {
        this.mType = mType;
    }
    public String getDosage() {
        return dosage;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    @Override
    public String toString() {
        return "Medicine [mid=" + mid + ", mType=" + mType + ", dosage=" + dosage + ", expiryDate=" + expiryDate
                + ", price=" + price + ", quantity=" + quantity + ", cid=" + cid + "]";
    }



}

