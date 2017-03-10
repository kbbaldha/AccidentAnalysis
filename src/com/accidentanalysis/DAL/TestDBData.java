package com.accidentanalysis.DAL;
import java.sql.*;  

public class TestDBData {

	public String GetData(){
		
		String sb = "";
		 QueryResult QR = null;
		try{
			
			System.out.println("before execute");
		     QR = DBConnect.ExecuteQuery("select name from city");
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { System.out.println (rset.getString (1));
		      	sb += rset.getString(1) + " , ";
		     }
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		finally{
			
			try {
				QR.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return sb;
	}
}
