public class sales {
    int totalAmount;
    String mType;


    public sales(String mType,int totalAmount) {
        this.mType=mType;
        this.totalAmount=totalAmount;

    }

    public String getMType() {
        return mType;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}

