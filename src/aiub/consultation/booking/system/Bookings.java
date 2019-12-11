/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiub.consultation.booking.system;

import java.util.Date;

/**
 *
 * @author Sirajum Munir Fahim
 */
public class Bookings{
    private String bid;
    private String Topic;
    private String Description;
    private String date;
    private String Stid;
    private String tid;
    private String CourseName;

    public Bookings() {
    }

    public Bookings(String bid,String Topic, String Description, String date, String Stid, String tid, String CourseName) {
        this.Topic = Topic;
        this.Description = Description;
        this.date = date;
        this.Stid = Stid;
        this.tid = tid;
        this.CourseName = CourseName;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

    public String getStid() {
        return Stid;
    }

    public void setStid(String Stid) {
        this.Stid = Stid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
    
    
    
    
}
