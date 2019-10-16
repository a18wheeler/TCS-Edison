import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertValues {
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
	static Statement st = null;
	static ResultSet rs = null;
	
	public static void main(String [] args) throws Exception {
		// make string
		String driverInfo = "oracle.jdbc.driver.OracleDriver";
		String query = "INSERT INTO lizard2 VALUES (200, 'green')";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uname = "system";
		String pwd = "12345";
		
		Class.forName(driverInfo);
		
		con = DriverManager.getConnection(url, uname, pwd);
		System.out.println("Connection has been made.");
		
		st = con.createStatement();
		System.out.println("Statement has been made.");
		
		rs = st.executeQuery(query);
		System.out.println("Query has been executed.");
		
		System.out.println("\nValues have been inserted.");
//		while(rs.next()) {
//			
//		}
	}
}