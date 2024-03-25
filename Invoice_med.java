/*
 CREATE TABLE `invoice_med` (
   `invid` int NOT NULL,
   `mid` int NOT NULL,
   `cid` int NOT NULL,
   `quantity` int DEFAULT NULL,
 */
public class Invoice_med {
    int invid ; // Invoice id
    int mid ; // Medicine id
    int cid ;
    int quantity;
    String sdate;
    public Invoice_med(int invid, int mid, int cid, int quantity, String sdate) {
        super();
        this.invid = invid;
        this.mid = mid;
        this.cid = cid;
        this.quantity = quantity;
        this.sdate=sdate;
    }
    public int getInvid() {
        return invid;
    }
    public void setInvid(int invid) {
        this.invid = invid;
    }
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Invoice_med [invid=" + invid + ", mid=" + mid + ", cid=" + cid + ", quantity=" + quantity + "]";
    }

}
