package com.accidentanalysis.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.City;
import com.accidentanalysis.Models.User;

public class UserDbAccess {
	
public User CheckUser(User user){
		
		User user1 = null;
		
		QueryResult QR = null;
		List<City> cities = new ArrayList<City>();
		try{
			
			String userName  = user.getUsername();
		     QR = DBConnect.ExecuteQuery("select * from USERS where lower(name) = lower('"+ user.getUsername()+"') and password = '"+ user.getPassword()+"'");
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { //System.out.println (rset.getString (1));
		      	//sb += rset.getString(1) + " , ";
		      	System.out.println(rset.getString(1));
		      	System.out.println(rset.getString(2));
		      	user1 = new User();
		      	user1.setUsername(rset.getString(1));
		      	user1.setPassword(rset.getString(2));
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
		
		return user1;
	}

}
