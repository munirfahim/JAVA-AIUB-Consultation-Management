
package aiub.consultation.booking.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sirajum Munir Fahim
 */
public class CourseQuery {
    public boolean insertCourse(Courses cor)
    {   
        boolean courseiscreated = true;
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        try {
            ps= con.prepareStatement("INSERT INTO `courses`(`Course Name`, `StdID`) VALUES (?,?)");
            ps.setString(1, cor.getCname());
            ps.setString(2, cor.getStdid());
            
            if(ps.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null, "Course Created");
                }else{
                JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                courseiscreated=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return courseiscreated;
    }
    
    public boolean removeCourse(Courses cor)
    {   
        boolean courseiscreated = false;
        Connection con= ConnectionDB.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps= con.prepareStatement("DELETE FROM `courses` WHERE `StdID` = ? AND `Course Name` = ?");
            ps.setString(1, cor.getStdid());
            ps.setString(2, cor.getCname());
            
            //rs = ps.executeQuery();
            if(ps.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null, "Course is Removed");
                }else{
                JOptionPane.showMessageDialog(null, "Error! Something went wrong");
                courseiscreated=true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
        return courseiscreated;
    }
}
