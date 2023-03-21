package ustbatchno3.Railway_Reservation;
import java.sql.*;
import java.util.*;
public class Railway_Reservation {

		private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/jenson";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "pass@word1";

		public static void main(String args[]) throws Exception
		{
		  String name,mobileno,loc,dest;
		  Scanner in=new Scanner(System.in);
		  System.out.println("Welcome to KSRTC reservation page");
		  System.out.println("Enter your name ");
		  name=in.nextLine();
		  System.out.println("Enter your mobile number ");
		  mobileno=in.nextLine();
		  System.out.println("Enter your location ");
		  loc=in.nextLine();
		  System.out.println("Enter your destination ");
		  dest=in.nextLine();
		  
		  Connection dbConnection = null;
	      Statement preparedStatement = null;
	      ResultSet rs = null;

	      try {
	          Class.forName(DB_DRIVER);
	          dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	          preparedStatement =dbConnection.createStatement();
	          rs = preparedStatement.executeQuery("SELECT * FROM ksrtcbook");

	          // Check if the variable matches any of the values in the table
	          boolean matchFound = false;

	          while (rs.next()) {
	              String location = rs.getString("location");
	              String destination = rs.getString("destination");
	              int id=rs.getInt("id");

	              if (loc.equals(location) &&dest.equals(destination)) {
	                  System.out.println(id+" Bus booked");
	                  matchFound = true;
	              }
	          }

	          if (!matchFound) {
	              System.out.println("No match found for variable ");
	          }

	      } catch (SQLException e) {
	          e.printStackTrace();
	      
		} finally {
	          // Close the resources
	          try {
	              if (rs != null) rs.close();
	              if (preparedStatement != null) preparedStatement.close();
	              if (dbConnection != null) dbConnection.close();
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
	  }

	}

