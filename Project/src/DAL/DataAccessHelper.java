package DAL;

import MeThodShow.MyMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessHelper {

    protected Connection cnn;
    //netstat -a -P TCP
    String Hostname = "LAPTOP-A0RR97TI";
    String port = "1433";
    String DBName = "QuanLySinhVien_Offcial";
    String User = "sa";
    String Password = "1234";
    String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://" + Hostname + ":" + port + ";database=" + DBName;

    MyMethod temp = new MyMethod();

    public void getConnect() {
        try {
            Class.forName(Driver);
            cnn = DriverManager.getConnection(URL, User, Password);
        } catch (ClassNotFoundException | SQLException ex) {
            temp.showMessegaWa("Error in Connect : " + ex.toString());
        }
    }

    public void getClose() {
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
