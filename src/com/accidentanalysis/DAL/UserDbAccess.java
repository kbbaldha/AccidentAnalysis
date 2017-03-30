package com.accidentanalysis.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;

import com.accidentanalysis.Models.City;
import com.accidentanalysis.Models.User;

public class UserDbAccess {
	
public User CheckUser(User user){
		
		User user1 = null;
		QueryResult QR = null;
		
		try{
			
			QR = DBConnect.ExecuteQuery("select * from PEOPLE where lower(user_name) = lower('"+ user.getUsername()+"') and password = '"+ user.getPassword()+"'");
		    ResultSet rset = QR.resultSet;
		    while (rset.next())
		    { 
		      	//System.out.println(rset.getString(2));
		      	//System.out.println(rset.getString(3));
		    	//User_id, password, gender, type, street, city, state, zip, first_name, last_name, user_name
		      	user1 = new User();
		      	user1.setId(rset.getInt(1));
		      	user1.setPassword(rset.getString(2));  	
		      	
		      	user1.setGender(rset.getString(3));
		      	user1.setType(rset.getString(4));
		      	user1.setStreet(rset.getString(5));
		      	user1.setCity(rset.getString(6));
		      	user1.setState(rset.getString(7));
		      	user1.setZip(rset.getString(8));
		      	user1.setFirstname(rset.getString(9));
		      	user1.setLastname(rset.getString(10));
		      	user1.setUsername(rset.getString(11));
		      	
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


public StringBuffer RegisterUser(User user){
	
	User user1 = null;
	Connection connection = DBConnect.getConnection();
		
	String insertTableSQL = "INSERT INTO PEOPLE"
			+ "(USER_NAME,Password,Gender,Type,Street,City,State,Zip,First_name,Last_Name) VALUES"
			+ "(?,?,?,?,?,?,?,?,?,?)";
	
	
	StringBuffer stringBuffer = new StringBuffer();
	
	try{
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
		System.out.println(user.getUsername());
		preparedStatement.setString(1,user.getUsername());
		if(user.getUsername().isEmpty()){
			stringBuffer.append("Missing Username ");
		}
		else{
			preparedStatement.setString(1,user.getUsername());
			}
		if(stringBuffer.length()>0){
			stringBuffer.append(",");
		}
		if(user.getPassword().isEmpty()){
			stringBuffer.append("Missing Password ");
		}
		else
		{
			preparedStatement.setString(2,user.getPassword());
		}
		preparedStatement.setString(3,user.getGender());
		preparedStatement.setString(4,user.getType());
		preparedStatement.setString(5,user.getStreet());
		preparedStatement.setString(6,user.getCity());
		preparedStatement.setString(7,user.getState());
		//System.out.println("zip code "+user.getZip());
		preparedStatement.setInt(8,user.getZip());
		if(user.getFirstname().isEmpty()){
			stringBuffer.append("Missing First Name");
		}
		else
		{
			preparedStatement.setString(9,user.getFirstname());
		}
		if(user.getLastname().isEmpty()){
			stringBuffer.append("Missing Last Name");
		}
		else
		{
			preparedStatement.setString(10,user.getLastname());
		}
		
		preparedStatement.executeUpdate();
		
		connection.close();
		user1 = CheckUser(user);
		if(user1==null)
		{
			System.out.println("reg failed");
			return stringBuffer.append("Registration failed");
		}
	  
	}
	catch(Exception e){
		
		System.out.println(e.toString());
		stringBuffer.append("Registration failed");
	}
	finally{
		try {
			if(!connection.isClosed()){
			connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return stringBuffer;
		}
	}
}

}
