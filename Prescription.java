/*
 * CREATE TABLE `prescription` (
   `did` int NOT NULL,
   `cusid` int NOT NULL,
   `mid` int NOT NULL,
   `per_text` varchar(64) DEFAULT NULL,
   `per_date` date DEFAULT NULL,
   `quantity` int DEFAULT NULL,
   PRIMARY KEY (`did`,`cusid`,`mid`),
 */
public class Prescription {
    int did;
    int cusid;
    int mid;
    String per_text;
    String per_date;
    int quantity ;
    public Prescription(int did, int cusid, int mid, String per_text, String per_date, int quantity) {
        super();
        this.did = did;
        this.cusid = cusid;
        this.mid = mid;
        this.per_text = per_text;
        this.per_date = per_date;
        this.quantity = quantity;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public int getCusid() {
        return cusid;
    }
    public void setCusid(int cusid) {
        this.cusid = cusid;
    }
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getPer_text() {
        return per_text;
    }
    public void setPer_text(String per_text) {
        this.per_text = per_text;
    }
    public String getPer_date() {
        return per_date;
    }
    public void setPer_date(String per_date) {
        this.per_date = per_date;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Prescription [did=" + did + ", cusid=" + cusid + ", mid=" + mid + ", per_text=" + per_text
                + ", per_date=" + per_date + ", quantity=" + quantity + "]";
    }

}
