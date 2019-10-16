import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateTables {
	public static Connection con = null;
    public static PreparedStatement pst = null;
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
	    String driverInfo = "oracle.jdbc.driver.OracleDriver" ;  
	    String uname = "system";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";   //DB->properties->connection URL
	    String pwd = "12345";
	    String [] query = new String[3];
	    query[0] = "CREATE TABLE MobileCustomer ("
	    		+ "mobCusID INT PRIMARY KEY NOT NULL,"
	    		+ "mobCusName VARCHAR(20) NOT NULL,"
	    		+ "mobCusphoneBrand VARCHAR(20) NOT NULL,"
	    		+ "mobCusPhoneOS VARCHAR(20) NOT NULL"
	    		+ ")";
	    query[1] = "CREATE TABLE MobileConnection ("
	    		+ "mobConID INT PRIMARY KEY NOT NULL,"
	    		+ "mobCusID INT NOT NULL,"
	    		+ "mobConPlan VARCHAR(20) NOT NULL,"
	    		+ "mobConDataPlan VARCHAR(20) NOT NULL,"
	    		+ "mobConAreaCode INT NOT NULL,"
	    		+ "FOREIGN KEY (mobCusID) REFERENCES MobileCustomer(mobCusID)"
	    		+ ")";
	    query[2] = "CREATE TABLE MobileBill ("
	    		+ "mobBillID INT PRIMARY KEY NOT NULL,"
	    		+ "mobConID INT NOT NULL,"
	    		+ "mobCusID INT NOT NULL,"
	    		+ "mobBillDate DATE NOT NULL,"
	    		+ "mobBillAmount NUMBER NOT NULL,"
	    		+ "mobBillStatus VARCHAR(20),"
	    		+ "FOREIGN KEY (mobConID) REFERENCES MobileConnection(mobConID),"
	    		+ "FOREIGN KEY (mobCusID) REFERENCES MobileCustomer(mobCusID)"
	    		+ ")";
	    
	    Class.forName(driverInfo);
	    con = DriverManager.getConnection(url, uname, pwd);
	    
	    // Creating the tables
	    for(int i = 0; i < 3; i++) {
	    	pst = con.prepareStatement(query[i]);
	    	pst.executeUpdate();
	    	System.out.println("Created table " + (i+1));
	    }
	    System.out.println("\nCreated all tables.");

	    
	    
	    // Closing 
	    pst.close();
	    con.close();
	}
	
	public void addValues() {
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
			
			
	    }
	}

}
