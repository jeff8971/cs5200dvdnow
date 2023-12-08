package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Database connection class
 */
public class DbUtil {
    private String url="jdbc:mysql://localhost:3306/redbox"; // Your URL, database name is "books"
    private String user="root"; // Your username
    private String psd="Zhaoyigeusa2019"; // Your password
    private String jdbcName ="com.mysql.cj.jdbc.Driver";

    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con= DriverManager.getConnection(url,user,psd);
        return con;
    }

    public void closeCon(Connection con) throws Exception{
        if (con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil=new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("Link Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}