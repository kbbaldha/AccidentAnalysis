package com.accidentanalysis.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.City;
import com.accidentanalysis.Models.Trend;

public class APIDBAccess {

	public List<Trend> GetTrendData(){
		
		
		QueryResult QR = null;
		List<Trend> trends = new ArrayList<Trend>();
		try{
			
			
		     QR = DBConnect.ExecuteQuery("select count(*),year_inci from (select Extract(year from TIMESTAMP) as Year_Inci from Incident ) group by year_inci order by year_inci");
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { //System.out.println (rset.getString (1));
		      	//sb += rset.getString(1) + " , ";
		    	trends.add(new Trend(rset.getInt(2),rset.getInt(1)));
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
		
		return trends;
	}
}
