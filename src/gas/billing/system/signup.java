package gas.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class signup extends JFrame implements ActionListener {
    JButton create,back;
    Choice accounttype;
    JTextField meter,name,password,username;
    signup(){
//        setSize(700,400);
//        setLocation(450,150);
        setBounds(450,150,700,400);//instead of above 2 lines it takes parameters as location , size
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        JPanel panel=new JPanel();
        panel.setBounds(30,30,650,300);//location,size
        panel.setBorder(new TitledBorder(new LineBorder(Color.RED,3),"Create Account"));//color ,shade
        panel.setLayout(null);
        add(panel);
        
        JLabel heading=new JLabel("Create account as");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.darkGray);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        
         accounttype=new Choice();
        accounttype.add("Admin");
        accounttype.add("Customer");
        accounttype.setBounds(260,50,150,20);
        panel.add(accounttype);
        
        
        JLabel lblmeter=new JLabel("Meter number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setForeground(Color.darkGray);
        lblmeter.setFont(new Font("Tahoma",Font.BOLD,14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);
        
        
        
         meter=new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        panel.add(meter);
        
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.darkGray);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblusername);
        
        username=new JTextField();
        username.setBounds(260,130,150,20);
        panel.add(username);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.darkGray);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblname);
        
        name=new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener(){
            @Override
            public void  focusGained(FocusEvent fe){}
            @Override
            public void focusLost(FocusEvent fe) {
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from login where meter_no='"+meter.getText()+"'");
                    while(rs.next()){
                        name.setText(rs.getString("name"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setForeground(Color.darkGray);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblpassword);
        
        password=new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);
        
        accounttype.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user=accounttype.getSelectedItem();
                if(user.equals("Customer")){
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }
                else{
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
         create=new JButton("Create");
        create.setBounds(100,260,150,25);
        create.addActionListener(this);
        panel.add(create);
        
         back=new JButton("Back");
        back.setBounds(260,260,150,25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);
        panel.add(heading);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String atype=accounttype.getSelectedItem();
            String susername=username.getText();
            String sname=name.getText();
            String spassword=password.getText();
            String smeter=meter.getText();
            try{
                conn c=new conn();
                
                String query=null;
                if(atype.equals("Admin")){
                      query="insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";
                }else{
                     query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully!!!");
                setVisible(false);
                new Login();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new signup();
    }
}
