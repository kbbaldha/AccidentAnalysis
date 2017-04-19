package com.accidentanalysis.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;

import com.accidentanalysis.Models.City;
import com.accidentanalysis.Models.Civilian;
import com.accidentanalysis.Models.TransportOfficial;
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
		      	user1.setLogin(rset.getDate(12));
		      	System.out.println("log in");
		      	DBConnect.ExecuteQuery("insert into loginhistory (user_id,logintime) values (" +user1.getId() + ",current_timestamp)");
				  
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

public TransportOfficial checkTransportOfficial(User user){
	
	TransportOfficial user1 = null;
	QueryResult QR = null;
	
	
	try{
		
		QR = DBConnect.ExecuteQuery("select * from TRANSPORT_OFFICIAL where USER_ID_FK = "+ user.getId()+" and ROLE_ID_FK = "+ user.getRole());
	    ResultSet rset = QR.resultSet;
	    while (rset.next())
	    {		     
	      	user1 = new TransportOfficial();
	      	user1.setUseridfk(rset.getInt(1));
	      	user1.setRoleid(rset.getInt(2));  	
	      	
	      	
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

public Civilian CheckCivilian(User user){
	
	Civilian user1 = null;
	QueryResult QR = null;
	
	try{
		
		QR = DBConnect.ExecuteQuery("select * from Civilian where USER_ID_FK = "+ user.getId()+" and OCCUPATION = '"+ user.getJob()+"'");
	    ResultSet rset = QR.resultSet;
	    while (rset.next())
	    {		     
	      	user1 = new Civilian();
	      	user1.setUseridfk(rset.getInt(1));
	      	user1.setJobdesc(rset.getString(2));  	
	     
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
		user.setId(user1.getId());
		String message=null;
		Object user2;
		if(user.getType().equalsIgnoreCase("Transport official")){
			int roleId = user.getRole();
			message = RegisterTransportOfficial(user,roleId);
			user2= (TransportOfficial) checkTransportOfficial(user);
		}
		else
		{
			message = RegisterCivilian(user);
			user2 = (Civilian)CheckCivilian(user);
		}
		if(message != null){
			stringBuffer.append(message);
		}
		if(user1==null||user2==null)
		{
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

public String RegisterTransportOfficial(User user,int roleId){
	
	Connection connection = DBConnect.getConnection();
		
	String insertTableSQL = "insert into TRANSPORT_OFFICIAL (USER_ID_FK,ROLE_ID_FK) values"+
	"(?,?)";
	
	
	StringBuffer stringBuffer = new StringBuffer();
	
	try{
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1,user.getId());
		if(roleId == 0){
			stringBuffer.append("Missing Role of Transport official");
		}
		else
		{
		preparedStatement.setInt(2,roleId);
		}
		
		preparedStatement.executeUpdate();
		
		connection.close();	
		return stringBuffer.toString();
	  
	}
	catch(Exception e){
		
		System.out.println(e.toString());
		stringBuffer.append("Inserting transport Official failed");
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
		
	}
	return stringBuffer.toString();
}
public String RegisterCivilian(User user){
	
	Connection connection = DBConnect.getConnection();
		
	String insertTableSQL = "insert into civilian (USER_ID_FK,OCCUPATION) values"+
	"(?,?)";
	
	
	StringBuffer stringBuffer = new StringBuffer();
	
	try{
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1,user.getId());
		if(user.getJob().isEmpty()){
			stringBuffer.append("Missing job description of user");
		}
		else{
		preparedStatement.setString(2,user.getJob());
		}	
		preparedStatement.executeUpdate();
		
		connection.close();	
		return stringBuffer.toString();
	  
	}
	catch(Exception e){
		
		System.out.println(e.toString());
		stringBuffer.append("User/Civilian registration failed");
		
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
		finally {
			return stringBuffer.toString();
		}
	}
	
	
}

}
