/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiub.consultation.booking.system;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Sirajum Munir Fahim
 */
public class ImgFunc {
        
    
    public ImageIcon resizePic(String picPath,byte[] BLOBpic, int wdth, int hgt ){
        ImageIcon myImg;
        if(picPath!=null){
            myImg = new ImageIcon(picPath);
        }
        else{
            myImg = new ImageIcon(BLOBpic);
        }
        
        Image img = myImg.getImage().getScaledInstance(wdth, hgt, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return  myPicture;
    }
    
    
    
    
    
}