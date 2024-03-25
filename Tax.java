
/*
 `tid` int NOT NULL,
   `taxType` varchar(32) DEFAULT NULL,
   `taxDescription` varchar(64) DEFAULT NULL,
   PRIMARY KEY (`tid`)
 */
public class Tax {

    @Override
    public String toString() {
        return "Tax [tid=" + tid + ", taxType=" + taxType + ", taxDescription=" + taxDescription + "]";
    }
    int tid ;
    String taxType;
    String taxDescription;
    public Tax(int tid, String taxType, String taxDescription) {
        super();
        this.tid = tid;
        this.taxType = taxType;
        this.taxDescription = taxDescription;
    }
    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }
    public String getTaxType() {
        return taxType;
    }
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
    public String getTaxDescription() {
        return taxDescription;
    }
    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }


}
