import java.sql.*;
import java.util.Scanner;

public class InputValues {
	// Input values into table 1
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	
	public static void main(String [] args) throws Exception {
		// make string
		String driverInfo = "oracle.jdbc.driver.OracleDriver";
		String query = "INSERT INTO MobileCustomer VALUES (?, ?, ?, ?)";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uname = "system";
		String pwd = "12345";
		
		
		
		
		
		Class.forName(driverInfo);
		
		con = DriverManager.getConnection(url, uname, pwd);
		System.out.println("Connection has been made.");
		
		pst = con.prepareStatement(query);
		System.out.println("Statement has been made.");
		
		// Getting values for MobileCustomer
	    Scanner sc = new Scanner(System.in);
	    System.out.println("How many entries do you want to enter?");
	    int limit = sc.nextInt();
	    
	    for(int i = 0; i < limit; i++) {
		    System.out.println("Enter a customer ID: ");
		    int id = sc.nextInt();
			System.out.println("Enter a customer name: ");
			String name = sc.next();
			System.out.println("Enter a phone brand");
			String brand = sc.next();
			System.out.println("Enter a phone OS");
			String os = sc.next();
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, brand);
			pst.setString(4, os);
			
			rs = pst.executeQuery();
			System.out.println("Query has been executed.");
	    }
		
		
		
		System.out.println("\nValues have been inserted.");
		/*
		 * while(rs.next()) { rs.getInt(1); rs.getString(2); }
		 */
		
		rs.close(); pst.close(); con.close();
	}
}