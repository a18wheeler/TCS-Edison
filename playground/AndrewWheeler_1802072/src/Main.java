import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	
	public static void main(String [] args) throws Exception {
		String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
	    
	    // queries
	    String query = "";
	    String [] queries = new String [3];
	    queries[0] = "SELECT mobConAreaCode, COUNT(*)" + 
	    		"FROM MobileConnection" + 
	    		"GROUP BY mobConAreaCode;"; 
	    queries[1] = "SELECT mobBillStatus, COUNT(*)" + 
	    		"FROM MobileBill" + 
	    		"WHERE mobBillStatus='Bad'" + 
	    		"GROUP BY mobBillStatus;";
	    queries[2] = "SELECT EXTRACT(month FROM mobBillDate) Month, SUM(mobBillAmount) Sum" + 
	    		"FROM MobileBill" + 
	    		"WHERE mobBillStatus = 'Good'" + 
	    		"GROUP BY EXTRACT(month FROM mobBillDate)" + 
	    		"ORDER BY EXTRACT(month FROM mobBillDate) DESC;";
	    
	    System.out.println("Please select the query you wish to run:\n"
	    		+ "1. Total Connections Per Area\n"
	    		+ "2. Total Outstanding Bills\n"
	    		+ "3. Total Revenue Generated Month Wise");
	    
	    // Choosing the query
	    Scanner sc = new Scanner(System.in);
	    int choice = sc.nextInt();
	    
	    switch(choice) {
	    	case 1:
	    		method1();
	    		break;
	    	case 2:
	    		method2();
	    		break;
	    	case 3:
	    		method3();
	    		break;
	    }
	    
	    
	    Class.forName(driverInfo);
	    
	    con = DriverManager.getConnection(url, uname, pwd);
	    pst = con.prepareStatement(query);
	    rs = pst.executeQuery();
	    
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
	
	
	static void method1() throws Exception { 
		String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
		String query = "SELECT mobConAreaCode, COUNT(*)" + 
	    		"FROM MobileConnection" + 
	    		"GROUP BY mobConAreaCode";
		
		Class.forName(driverInfo);
	    
	    con = DriverManager.getConnection(url, uname, pwd);
	    pst = con.prepareStatement(query);
	    rs = pst.executeQuery();
	    
	    System.out.println("Executed the update");
	    while(rs.next()){
	        System.out.printf("%-3d  -----  ", rs.getInt(1));   //Column name or index
	        System.out.printf("%-7s  -----  ", rs.getString(2));
	        System.out.printf("%-15s -----", rs.getString(3));
	        System.out.printf("%-7s%n", rs.getString(4));
	    }
	}
	
	static void method2() throws Exception {
		String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
	    String query = "SELECT mobBillStatus, COUNT(*)" + 
	    		"FROM MobileBill" + 
	    		"WHERE mobBillStatus='Bad'" + 
	    		"GROUP BY mobBillStatus;";
	    
	    Class.forName(driverInfo);
	    
	    con = DriverManager.getConnection(url, uname, pwd);
	    pst = con.prepareStatement(query);
	    rs = pst.executeQuery();
	    
	    System.out.println("Executed the update");
	    while(rs.next()){
	        System.out.print(rs.getInt(1) + " ");   //Column name or index
	        System.out.print(rs.getInt(2) + " ");
	        System.out.print(rs.getString(3) + " ");
	        System.out.print(rs.getString(4) + " ");
	        System.out.println(rs.getInt(5) + " ");
	    }
	}
	
	static void method3() throws Exception {
		String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
	    String query = "SELECT EXTRACT(month FROM mobBillDate) Month, SUM(mobBillAmount) Sum" + 
	    		"FROM MobileBill" + 
	    		"WHERE mobBillStatus = 'Good'" + 
	    		"GROUP BY EXTRACT(month FROM mobBillDate)" + 
	    		"ORDER BY EXTRACT(month FROM mobBillDate) DESC;";
	    
	    Class.forName(driverInfo);
	    
	    con = DriverManager.getConnection(url, uname, pwd);
	    pst = con.prepareStatement(query);
	    rs = pst.executeQuery();
	    
	    System.out.println("Executed the update");
	    while(rs.next()){
	    	System.out.print(rs.getInt(1) + " ");   //Column name or index
	        System.out.print(rs.getInt(2) + " ");
	        System.out.print(rs.getInt(3) + " ");
	        System.out.print(rs.getDate(4) + " ");
	        System.out.println(rs.getInt(5) + " ");
	        System.out.print(rs.getString(6) + " ");   //Column name or index
	    }
	}
	

}
