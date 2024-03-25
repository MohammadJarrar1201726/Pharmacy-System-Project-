public class chart {
    double total;
    String sdate;

    public chart(String sdate, int total) {
        this.sdate=sdate;
        this.total=total;
    }
    public String getSdate() {
        return sdate;
    }

    public double getTotal() {
        return total;
    }

}
