package com.accidentanalysis.DAL;


import java.sql.*;  

public class DBConnect {
    public static final String URL = "jdbc:oracle:thin:hr/hr@oracle1.cise.ufl.edu:1521:orcl"; //"jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "nhugar";
    public static final String PASS = "8uhb*UHB";
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
		    System.out.println(query);
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
    
    public static QueryResult ExecuteSP(String spName){
    	
    	Connection con = DBConnect.getConnection();
    	QueryResult QR = new QueryResult();
    	
    	CallableStatement callableStatement = null;
    	

		String getDBUSERByUserIdSql = "{call " + spName + "(?)}";
    	
		try{
			 // Create a Statement
			//callableStatement.setInt(1, 10);
		//	callableStatement.registerOutParameter(2, java.sql.Types.);

			// execute getDBUSERByUserId store procedure
			callableStatement.executeUpdate();

			String userName = callableStatement.getString(2);
			String createdBy = callableStatement.getString(3);
			Date createdDate = callableStatement.getDate(4);

			System.out.println("UserName : " + userName);
			System.out.println("CreatedBy : " + createdBy);
			System.out.println("CreatedDate : " + createdDate);
		   
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