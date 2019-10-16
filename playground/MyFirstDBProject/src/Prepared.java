import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prepared {
	public static Connection con = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		
		
	    String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	     //RightClick on proj - > bulid path -> external lib -> configure -> add jar
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
	    String query = "select * from passenger"; 
	    Class.forName(driverInfo);
	    
	    con = DriverManager.getConnection(url, uname, pwd);
	    pst = con.prepareStatement(query);
	    rs = pst.executeQuery();
	    //int i = pst.executeUpdate();
	    System.out.println("Executed the update");
	    while(rs.next()){
	        System.out.printf("%-3d  -----  ", rs.getInt(1));   //Column name or index
	        System.out.printf("%-7s  -----  ", rs.getString(2));
	        System.out.printf("%-15s%n", rs.getString(3));
	    }
//	    rs.close();
	    pst.close();
	    con.close();
	}

}
