/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiub.consultation.booking.system;

/**
 *
 * @author Sirajum Munir Fahim
 */
public class Courses {
    private String cid;
    private String cname;
    private String stdid;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    

    public Courses(String cid, String cname, String stdid) {
        this.cid = cid;
        this.cname = cname;
        this.stdid = stdid;
    }

    public Courses() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }
    
   
}
