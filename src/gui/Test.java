
package gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;




public class Test {
    
    public static String demGio(String gioden,String giodi)
{
	String dateStart=gioden;
	String dateStop=giodi;
	SimpleDateFormat format = new SimpleDateFormat("HH:mm");

	Date d1 = null;
	Date d2 = null;

	try {
	d1 = format.parse(dateStart);
	d2 = format.parse(dateStop);

	long diff = d2.getTime() - d1.getTime();
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
//	long diffDays = diff / (24 * 60 * 60 * 1000);

	return diffHours+"\n"+diffMinutes+"";

	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"lỗi đếm giờ: "+e.toString());
	return null;
	}
}
    
    public static void main(String[] args) {
         
        
          String ngayLap=java.time.LocalDate.now().toString();
//        
       SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");  
     
      System.out.println(ngayLap);   
      //alo
      
        
    }
}
