
package aiub.consultation.booking.system;


public class Student {
    private String stdid;
    private String password;
    private String address;
    private String emailid;
    private String contactno;
    private String firstname;
    private String lastname;
    
    private Bookings b[];
    private Courses c[];
    
    public Student(String stdid, String password, String address, String emailid, String contactno,String firstname,String lastname){
    this.stdid=stdid;
    this.password= password;
    this.address=address;
    this.emailid=emailid;
    this.contactno=contactno;
    this.b=new Bookings[100];
    this.c=new Courses[50];
    this.firstname=firstname;
    this.lastname=lastname;
} 
    public Student(){}
    
   
    public String getstdid(){
        return stdid;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Bookings[] getB() {
        return b;
    }

    public void setB(Bookings[] b) {
        this.b = b;
    }

    public Courses[] getC() {
        return c;
    }

    public void setC(Courses[] c) {
        this.c = c;
    }
    
    
}
