package gas.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class meterinfo extends JFrame implements ActionListener{
    JTextField tfname,tfaddress,tfcity,tfstate,tfemail,tfphone; 
    JButton next,cancel;
    JLabel lblmeter;
    Choice meterlocation,metertype,phasecode,billtype;
    String meternumber;
    meterinfo(String meternumber){
        this.meternumber=meternumber;
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(240,219,211));
        add(p);   
        
         JLabel heading=new JLabel("Meter Information");
         heading.setBounds(180, 10, 200, 25);
         heading.setFont(new Font("Tahoma",Font.PLAIN,24));
         p.add(heading);
         
         JLabel lblname=new JLabel("Meter number");
         lblname.setBounds(100, 80, 100, 20);
         p.add(lblname);
        
         JLabel lblmeternumber=new JLabel(meternumber);
         lblmeternumber.setBounds(240, 80, 100, 20);
         p.add(lblmeternumber);
         
         JLabel lblmeterno=new JLabel("Meter Loaction");
         lblmeterno.setBounds(100, 120, 100, 20);
         p.add(lblmeterno);
        
         meterlocation=new Choice();
         meterlocation.add("Outside");
         meterlocation.add("Inside");
         meterlocation.setBounds(240,120,200,20);
         p.add(meterlocation);
         
        
         JLabel lbladdress=new JLabel("Meter type");
         lbladdress.setBounds(100, 160, 100, 20);
         p.add(lbladdress);
         
         metertype=new Choice();
         metertype.add("LPG meter");
         metertype.setBounds(240,160,200,20);
         p.add(metertype);
        
         
         JLabel lblcity=new JLabel("Phase code");
         lblcity.setBounds(100, 200, 100, 20);
         p.add(lblcity);
        
         phasecode=new Choice();
         phasecode.add("01");
         phasecode.add("02");
         phasecode.add("03");
         phasecode.add("04");
         phasecode.add("05");
         phasecode.add("06");
         phasecode.add("07");
         phasecode.add("08");
         phasecode.add("09");
         phasecode.setBounds(240,200,200,20);
         p.add(phasecode);
         
         JLabel lblstate=new JLabel("Bill type");
         lblstate.setBounds(100, 240, 100, 20);
         p.add(lblstate);
        
         billtype=new Choice();
         billtype.add("Household");
         billtype.add("Commercial");
         billtype.setBounds(240,240,200,20);
         p.add(billtype);
         
         JLabel lblemail=new JLabel("Days");
         lblemail.setBounds(100, 280, 100, 20);
         p.add(lblemail);
        
         JLabel lblemails=new JLabel("30 Days");
         lblemails.setBounds(240, 280, 100, 20);
         p.add(lblemails);
         
         JLabel lblphonenumber=new JLabel("Note");
         lblphonenumber.setBounds(100, 320, 100, 20);
         p.add(lblphonenumber);
        
         JLabel lblphonenumbers=new JLabel("By default Bill is calculated for 30 days only");
         lblphonenumbers.setBounds(240, 320, 500, 20);
         p.add(lblphonenumbers);
         
         next=new JButton("Submit");
         next.setBounds(220,390,100,25);
         next.setBackground(Color.darkGray);
         next.setForeground(Color.WHITE);
         next.addActionListener(this);
         p.add(next);
         
         
         
         
         setLayout(new BorderLayout());
         add(p,"Center");
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
         Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         add(image,"West");
         
         getContentPane().setBackground(Color.WHITE);
         
         
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String meter=meternumber;
            String location=meterlocation.getSelectedItem();
            String type=metertype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String typebill=billtype.getSelectedItem();
            String days="30";
            
            String query="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
            try{
                conn c=new conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
                setVisible(false);
                
                //new frame

                 
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }   
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new meterinfo("");
    }
}
