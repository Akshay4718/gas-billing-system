
package gas.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class customerdetails extends JFrame implements ActionListener {
    Choice meternumber,cmonth; 
    JTable table;
    JButton search,print;
    customerdetails(){
        super("Customer Details");
        
        setSize(1200,650);
        setLocation(200,150);
        
        table=new JTable();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
         JScrollPane sp=new JScrollPane(table);
         add(sp);
        
         
         print=new JButton("Print");
         
         print.setBackground(Color.DARK_GRAY);
         print.setForeground(Color.WHITE);
         print.addActionListener(this);
         add(print,"South");
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
       
      
    }
    public static void main(String[] args) {
        new customerdetails();
    }
}
