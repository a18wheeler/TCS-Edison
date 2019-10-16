import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MakeClass {
	public static Connection con = null;
    public static Statement st = null;
    public static ResultSet rs = null;
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		
		
	    String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	     //RightClick on proj - > bulid path -> external lib -> configure -> add jar
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
	    String query = "create table lizard5 (scales INT, color VARCHAR(20) )";
	    //String query = "drop table lizard4"; 
	    Class.forName(driverInfo);
	    
	    con = DriverManager.getConnection(url, uname, pwd);
	    st = con.createStatement();
	    st.executeUpdate(query);
	    System.out.println("Made another lizard table.");
	    //System.out.println("Dropped the damn lizard.");
//	    while(rs.next()){
//	        System.out.printf("%-3d  -----  ", rs.getInt(1));   //Column name or index
//	        System.out.printf("%-7s  -----  ", rs.getString(2));
//	        System.out.printf("%-15s%n", rs.getString(3));
//	    }
	    //rs.close();
	    st.close();
	    con.close();
	}

}
