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
		
		try{
			
			QR = DBConnect.ExecuteQuery("select * from PEOPLE where lower(name) = lower('"+ user.getUsername()+"') and password = '"+ user.getPassword()+"'");
		    ResultSet rset = QR.resultSet;
		    while (rset.next())
		    { 
		      	//System.out.println(rset.getString(2));
		      	//System.out.println(rset.getString(3));
		      	user1 = new User();
		      	user1.setId(rset.getInt(1));
		      	user1.setUsername(rset.getString(2));
		      	user1.setPassword(rset.getString(3));
		      	user1.setGender(rset.getString(4));
		      	user1.setType(rset.getString(5));
		      	user1.setStreet(rset.getString(6));
		      	user1.setCity(rset.getString(7));
		      	user1.setState(rset.getString(8));
		      	user1.setZip(rset.getInt(9));
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
