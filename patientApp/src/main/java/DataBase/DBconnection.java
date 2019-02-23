package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Class with the characteristics needed for a database connection.
*/
public class DBconnection {

	private String URL,USER,PASS;
	private Connection conn;
	private Statement stmt;
	
	/**
	* Constructor. Starts a database connection.
	*/
	public DBconnection() throws SQLException
	{
		try {
                    Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex) {
           System.out.println("Error: unable to load driver class!");
           System.exit(1);
        }
                
		URL = "jdbc:mysql://localhost:3306/PATIENT_LIB" ;
		USER = "root" ; 
		PASS = "etheodorako921230";
		conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
		stmt = conn.createStatement();
		
	}
	/**
	* Getter.
	* @return Statement
	*/
	public Statement get_statement()
	{
		return stmt;
	}
	/**
	* Getter.
	* @return Connection
	*/
	public Connection get_connection()
	{
		return conn;
	}
	/**
	* closes the database connection
	*/
	public void close()
	{
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("Could not close the current connection.");
			e.printStackTrace();
		}
	}
}
