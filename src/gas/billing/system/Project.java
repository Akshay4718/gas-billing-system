
package gas.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
    String atype,meter;
    
    Project(String atype,String meter){
        this.atype=atype;
        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/back3.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        mb.setBackground(new Color(240,219,211));
        setJMenuBar(mb);
        
        JMenu master=new JMenu("Master");
        master.setForeground(Color.BLUE); 
        
        
        JMenuItem newcustomer=new JMenuItem("New customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('A');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetails=new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('B');
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        
        JMenuItem depositdetails=new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('C');
        depositdetails.addActionListener(this);
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        master.add(depositdetails);
        
        JMenuItem calculatebill=new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4=icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('D');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        master.add(calculatebill);

        JMenu info=new JMenu("Information");
        info.setForeground(Color.BLUE); 
        
//        
        JMenuItem updateinformation=new JMenuItem("Update information");
        updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinformation.setBackground(Color.WHITE);
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5));
        updateinformation.setMnemonic('E');
        updateinformation.addActionListener(this);
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        info.add(updateinformation);
        
        JMenuItem viewinformation=new JMenuItem("View information");
        viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinformation.setBackground(Color.WHITE);
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6=icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(image6));
        viewinformation.setMnemonic('F');
        viewinformation.addActionListener(this);
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        info.add(viewinformation);
        
        JMenu user=new JMenu("User");
        user.setForeground(Color.BLUE); 
        
        
        JMenuItem paybill=new JMenuItem("Pay bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7=icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('G');
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        user.add(paybill);
        
        JMenuItem billdetails=new JMenuItem("Bill details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8=icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('H');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        JMenu report=new JMenu("Report");
        report.setForeground(Color.BLUE); 
        
        
        JMenuItem generatebill=new JMenuItem("Generate bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9=icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('I');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        report.add(generatebill);
        
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLUE); 
        
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('J');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        JMenuItem Calculator=new JMenuItem("Calculator");
        Calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        Calculator.setBackground(Color.WHITE);
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11=icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Calculator.setIcon(new ImageIcon(image11));
        Calculator.setMnemonic('K');
        Calculator.addActionListener(this);
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        utility.add(Calculator);
        
        JMenu mexit=new JMenu("Exit");
        mexit.setForeground(Color.BLUE); 
        
        
        JMenuItem exit=new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12=icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('L');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        mexit.add(exit);
        
        if(atype.equals("Admin")){
            mb.add(master);
        }
        else{
             mb.add(info);
             mb.add(user);
             mb.add(report);
        }
        mb.add(utility);
        mb.add(mexit);
        
        setLayout(new FlowLayout());
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("New customer")){
            new Newcustomer();
        }
        else if(msg.equals("Customer Details")){
            new customerdetails();
        }
        else if(msg.equals("Deposit Details")){
            new depositdetails();
        }
        else if(msg.equals("Calculate Bill")){
            new calculatebill();
        }
        else if(msg.equals("View information")){
            new viewinformation(meter);
        }
        else if(msg.equals("Update information")){
            new updateinformation(meter);
        }else if(msg.equals("Bill details")){
             new billdetails(meter);
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
             try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay bill")){
            new paybill(meter);
        }
        else if(msg.equals("Generate bill")){
            new generatebill(meter);
        }
    }
    public static void main(String[] args) {
        new Project("","");
    }
}
