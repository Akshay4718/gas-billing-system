package gas.billing.system; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
        JButton login,cancel,signup;
        JTextField inun,inpw;
        Choice loginas;
       Login(){
           super("Login page");
           getContentPane().setBackground(Color.BLACK);
           setLayout(null);
           
           JLabel un=new JLabel("Username");
           un.setBounds(300, 30, 100, 20);
           un.setForeground(Color.WHITE);
           add(un);
           
           inun=new JTextField();
           inun.setBounds(400, 30, 150, 20);
           add(inun);
           
           JLabel pw=new JLabel("Password");
           pw.setBounds(300, 70, 100, 20);
           pw.setForeground(Color.WHITE);
           add(pw);
           
           inpw=new JTextField();
           inpw.setBounds(400, 70, 150, 20);
           add(inpw);
           
           JLabel lias=new JLabel("Login as");
           lias.setBounds(300, 110, 100, 20);
           lias.setForeground(Color.WHITE);
           add(lias);
           
           loginas=new Choice();
           loginas.add("Admin");
           loginas.add("Customer");
           loginas.setBounds(400, 110, 150, 20);
           add(loginas);
           
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
           Image i2=i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
            login=new JButton("Login",new ImageIcon(i2));
           login.setBounds(330,170,100,20);
           login.addActionListener(this);
           add(login);
           
           ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
           Image i4=i3.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
            cancel=new JButton("Cancel",new ImageIcon(i4));
           cancel.setBounds(450,170,100,20);
           cancel.addActionListener(this);
           add(cancel);
           
           ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
           Image i6=i5.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
            signup=new JButton("SignUp",new ImageIcon(i6));
           signup.setBounds(390,210,100,20);
           signup.addActionListener(this);
           add(signup);
           
           ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
           Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
           ImageIcon i9=new ImageIcon(i8);
           JLabel image=new JLabel(i9);
           image.setBounds(30, 30, 250, 250);
           add(image);
           
           setSize(640,350);
           setLocation(400,200);
           setVisible(true);
       }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String susername=inun.getText();
            String spassword=inpw.getText();
            String user=loginas.getSelectedItem();
            try{
                conn c=new conn();  
                String query="select * from login where username='"+susername+"' and password='"+spassword+"'and user='"+user+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    String meter=rs.getString("meter_no");
                    setVisible(false);
                    new Project(user,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null, "inavlid login!!");
                    inun.setText("");
                    inpw.setText("");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new signup();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
