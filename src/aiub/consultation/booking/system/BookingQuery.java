/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiub.consultation.booking.system;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sirajum Munir Fahim
 */
public class BookingQuery {
    
    public void addBooking(Bookings book)
    {   
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        try {
            
            
            ps= con.prepareStatement("INSERT INTO `bookings`(`Topic`, `Description`, `Date & Time`, `Stid`, `Tid`, `Course Name`) VALUES (?,?,?,?,?,?)");
            ps.setString(1, book.getTopic());
            ps.setString(2, book.getDescription());
            ps.setString(3, book.getDate());
            ps.setString(4, book.getStid());
            ps.setString(5, book.getTid());
            ps.setString(6, book.getCourseName());
            
            if(ps.executeUpdate()!=0){
                if(RemoveOldBookings()){
            JOptionPane.showMessageDialog(null, "Error! Enter Future Dates");
            }
                else
                JOptionPane.showMessageDialog(null, "Booking Created");
                }else{
                JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void RescheduleBooking(String b,String date)
    {   
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        try {
            ps= con.prepareStatement("UPDATE `bookings` SET `Date & Time` = ? WHERE `Date & Time`= ?");
            //ps.setString(1, book.getTopic());
            //ps.setString(2, book.getDescription());
            ps.setString(1, b);
            ps.setString(2, date);
            //ps.setString(4, book.getStid());
            //ps.setString(5, book.getTid());
            //ps.setString(6, book.getCourseName());
            
            if(ps.executeUpdate()!=0){if(RemoveOldBookings()){
            JOptionPane.showMessageDialog(null, "Booking Removed As you entered old date");
            }
                else
                JOptionPane.showMessageDialog(null, "Booking Updated");
                }else{
                JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public void RemoveBooking(String date, String sid)
    {   
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        try {
            ps= con.prepareStatement("DELETE FROM `bookings` WHERE `Date & Time`= ? AND `Stid`= ?");
            //ps.setString(1, book.getTopic());
            //ps.setString(2, book.getDescription());
            ps.setString(1, date);
            ps.setString(2, sid);
            //ps.setString(4, book.getStid());
            //ps.setString(5, book.getTid());
            //ps.setString(6, book.getCourseName());
            
            if(ps.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null, "Booking Updated");
                }else{
                JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public void removeCourse(Bookings book)
    {   
        
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps= con.prepareStatement("DELETE FROM `courses` WHERE `StdID` = ? AND `Course Name` = ?");
            
            ps.setString(1, book.getTopic());
            ps.setString(2, book.getDescription());
            ps.setString(3, book.getDate());
            ps.setString(4, book.getStid());
            ps.setString(5, book.getTid());
            ps.setString(6, book.getCourseName());
            
            if(ps.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null, "Course is Removed");
                }else{
                JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
        
        
    }
    
    public ArrayList<Bookings> BookingList(String stid){
        
        ArrayList<Bookings> blist = new ArrayList<Bookings>();
        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        RemoveOldBookings();
        
        try {
            ps=con.prepareStatement("SELECT `Topic`, `Description`, `Date & Time`, `stid`, `Tid`, `Course Name` FROM `bookings` WHERE `stid` = ? ORDER BY `Date & Time`");
            //rs = st.executeQuery("SELECT `Topic`, `Description`, `Date & Time`, `stid`, `Tid`, `Course Name` FROM `bookings` WHERE stid= "+stid);
            ps.setString(1,stid );
            rs=ps.executeQuery();
      
            
            
            Bookings b;
            
            while(rs.next()){
                b= new Bookings(null, 
                        rs.getString("Topic"), 
                        rs.getString("Description"), 
                        rs.getString("Date & Time"), 
                        rs.getString("Stid"), 
                        rs.getString("Tid"), 
                        rs.getString("Course Name"));
                blist.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blist;
    }
    
    public ArrayList<Bookings> TeacherBookingList(String tid){
        
        ArrayList<Bookings> blist = new ArrayList<Bookings>();
        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT `Topic`, `Description`, `Date & Time`, `stid`, `Tid`, `Course Name` FROM `bookings` WHERE `Tid` = ? ORDER BY `Date & Time`");
            //rs = st.executeQuery("SELECT `Topic`, `Description`, `Date & Time`, `stid`, `Tid`, `Course Name` FROM `bookings` WHERE stid= "+stid);
            ps.setString(1,tid );
            rs=ps.executeQuery();
      
            
            
            Bookings b;
            
            while(rs.next()){
                b= new Bookings(null, 
                        rs.getString("Topic"), 
                        rs.getString("Description"), 
                        rs.getString("Date & Time"), 
                        rs.getString("Stid"), 
                        rs.getString("Tid"), 
                        rs.getString("Course Name"));
                blist.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blist;
    }
    
    
    public boolean RemoveOldBookings()
    {   
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        try {
            ps= con.prepareStatement("DELETE FROM `bookings` WHERE date(`Date & Time`) < CURDATE()");
            
            
            if(ps.executeUpdate()!=0){
                //JOptionPane.showMessageDialog(null, "Booking Updated");
                return true;
                }else{
               // JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return false;
        
        
    }
}
