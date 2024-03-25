/*mid int auto_increment,
    address varchar(32),
    mname varchar(32),
    phone long,*/
public class Manufacturer {
    int mid;
    String address;
    String mname;
    long phone;
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public Manufacturer(int mid, String address, String mname,long phone) {
        super();
        this.mid = mid;
        this.address = address;
        this.mname = mname;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Manufacturer [mid=" + mid + ", address=" + address + ", mname=" + mname + ", phone=" + phone + "]";
    }

}
