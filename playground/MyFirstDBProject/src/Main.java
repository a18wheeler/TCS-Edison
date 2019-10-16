import java.sql.*;
import java.util.Scanner;

public class Main {
	// Insert values into lizard2
	
	// Six steps
	/* 1. Register driver
	 * 2. Make a connection
	 * 3. Create a statement
	 * 4. Execute the query
	 * 5. Iterate through result set
	 * 6. Close
	 */
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	
	public static void main(String [] args) throws Exception {
		// make string
		String driverInfo = "oracle.jdbc.driver.OracleDriver";
		String query = "INSERT INTO lizard2 VALUES (?, ?)";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uname = "system";
		String pwd = "12345";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		System.out.print("Enter a string: ");
		String str = sc.next();
		
		
		
		Class.forName(driverInfo);
		
		con = DriverManager.getConnection(url, uname, pwd);
		System.out.println("Connection has been made.");
		
		pst = con.prepareStatement(query);
		System.out.println("Statement has been made.");
		
		pst.setInt(1, num);
		pst.setString(2, str);
		
		rs = pst.executeQuery();
		System.out.println("Query has been executed.");
		
		System.out.println("\nValues have been inserted.");
		/*
		 * while(rs.next()) { rs.getInt(1); rs.getString(2); }
		 */
		
		rs.close(); pst.close(); con.close();
	}
}