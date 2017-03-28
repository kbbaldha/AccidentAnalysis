package com.accidentanalysis.DAL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.*;

public class TestDBData {

	public List<City> GetData(){
		
		
		QueryResult QR = null;
		List<City> cities = new ArrayList<City>();
		try{
			
			
		     QR = DBConnect.ExecuteQuery("select Phone from phone_number");
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { //System.out.println (rset.getString (1));
		      	//sb += rset.getString(1) + " , ";
		      	cities.add(new City(rset.getString(1)));
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
		
		return cities;
	}
}
