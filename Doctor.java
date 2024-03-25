/*did int auto_increment,
        dname varchar(32),
        specialty varchar(32));*/
public class Doctor {
    @Override
    public String toString() {
        return "Doctor [did=" + did + ", dname=" + dname + ", specialty=" + specialty + "]";
    }
    private int did;
    private String dname;
    private String specialty;
    public Doctor(int did, String dname, String specialty) {
        super();
        this.did = did;
        this.dname = dname;
        this.specialty = specialty;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
