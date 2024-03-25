/* insid INT,
    instype VARCHAR(32),
    company VARCHAR(32),
    coverageSdate DATE,
    coverageEdate DATE,
    PRIMARY KEY (insid)*/


public class Insurance {
    private int insid;
    private String instype;
    private String company;
    private String coverageSdate;
    private String coverageEdate ;
    public Insurance(int insid, String instype, String company,String coverageSdate, String coverageEdate) {
        super();
        this.insid = insid;
        this.instype = instype;
        this.company = company;
        this.coverageSdate = coverageSdate;
        this.coverageEdate = coverageEdate;
    }

    public Insurance() {

    }

    public int getInsid() {
        return insid;
    }
    public void setInsid(int insid) {
        this.insid = insid;
    }
    public String getInstype() {
        return instype;
    }
    public void setInstype(String instype) {
        this.instype = instype;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCoverageSdate() {
        return coverageSdate;
    }
    public void setCoverageSdate(String coverageSdate) {
        this.coverageSdate = coverageSdate;
    }
    public String getCoverageEdate() {
        return coverageEdate;
    }
    public void setCoverageEdate(String coverageEdate) {
        this.coverageEdate = coverageEdate;
    }
    @Override
    public String toString() {
        return "Insurance [insid=" + insid + ", instype=" + instype + ", company=" + company + ", coverageSdate="
                + coverageSdate + ", coverageEdate=" + coverageEdate + "]";
    }


}

