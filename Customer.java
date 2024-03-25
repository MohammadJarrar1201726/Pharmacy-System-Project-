/*
    `cid` INT,
    `cname` VARCHAR(32),
    `age` INT,
    `gender` VARCHAR(32),
    `phone` LONG,
    `insid` INT,
 */
public class Customer {
    private int cid;
    private String cname ;
    private int age;
    private String gender;
    private long phone;
    private int insid;
    public Customer(int cid , String cname , int age , String gender , long phone , int insid) {
        this.cid = cid;
        this.cname = cname;
        this.gender = gender;
        this.phone = phone;
        this.insid = insid;
        this.age=age;
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Customer [cid=" + cid + ", cname=" + cname + ", age=" + age + ", gender=" + gender + ", phone=" + phone
                + ", insid=" + insid + "]";
    }
    public int getInsid() {
        return insid;
    }
    public void setInsid(int insid) {
        this.insid = insid;
    }


}

