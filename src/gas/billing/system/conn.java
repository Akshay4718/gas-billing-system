
package gas.billing.system;
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    conn(){
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/gbs","root","Akshay@12");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
