package com.accidentanalysis.DAL;


import java.sql.*;  

public class DBConnect {
    public static final String URL = "jdbc:oracle:thin:hr/hr@oracle1.cise.ufl.edu:1521:orcl"; //"jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "kbbaldha";
    public static final String PASS = "Avisha$123";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
      try {
    	  
    	  Class.forName("oracle.jdbc.driver.OracleDriver");  
    	  // Load the Oracle JDBC driver
    	    //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

    	    // Connect to the database
    	    // You must put a database name after the @ sign in the connection URL.
    	    // You can use either the fully specified SQL*net syntax or a short cut
    	    // syntax as <host>:<port>:<sid>.  The example uses the short cut syntax.
    	    Connection conn =
    	      DriverManager.getConnection (URL,USER,PASS);
    	    
    	    return conn;
          
      } catch (Exception ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
    
    public static QueryResult ExecuteQuery(String query){
    	
    	Connection con = DBConnect.getConnection();
    	QueryResult QR = new QueryResult();
    	QR.connection = con;
    	ResultSet rset = null;	
    	
		try{
			 // Create a Statement
		    Statement stmt = con.createStatement();

		    System.out.println("before");
		    rset = stmt.executeQuery(query);
		    System.out.println("after");
		    //con.close();
		    QR.resultSet = rset; 
		   
		}
		catch(Exception e){
			System.out.println(e.toString());
			try{
				//con.close();
				}
				catch(Exception ex){
					System.out.println(ex.toString());
				}
		}
		finally{
			
		}
		return QR;
	 
    }
    
    /**
     * Test Connection
     */
    public static void main(String[] args) {
       // Connection connection = DBConnect.getConnection();
    }
}