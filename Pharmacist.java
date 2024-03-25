public class Pharmacist {
    private int phid;
    private String phname;
    private int age;
    private String gender;
    private String contact_info;
    public Pharmacist(int phid, String phname, int age, String gender, String contact_info) {
        super();
        this.phid = phid;
        this.phname = phname;
        this.age = age;
        this.gender = gender;
        this.contact_info = contact_info;
    }

    public Pharmacist() {

    }

    public int getPhid() {
        return phid;
    }
    public void setPhid(int phid) {
        this.phid = phid;
    }
    public String getPhname() {
        return phname;
    }
    public void setPhname(String phname) {
        this.phname = phname;
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
    public String getContact_info() {
        return contact_info;
    }
    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }
    @Override
    public String toString() {
        return "Pharmacist [phid=" + phid + ", phname=" + phname + ", age=" + age + ", gender=" + gender
                + ", contact_info=" + contact_info + "]";
    }



}
