package com.accidentanalysis.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.Correlation;
import com.accidentanalysis.Models.Trend;

public class CorrelationDBAccess {
	
public List<Correlation> GetCorrelationData(){
		
		QueryResult QR = null;
		List<Correlation> correlations = new ArrayList<Correlation>();
		try{

    	    QR = DBConnect.ExecuteQuery("select speed,count(*) from affected,lane where lane_id=lane_id_fk group by speed order by speed");
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { System.out.println("speed "+rset.getInt(1) + "avg accidents "+rset.getInt(2));
		    	Correlation correlation = new Correlation(rset.getInt(1),rset.getInt(2));
		    	correlations.add(correlation);
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
		
		return correlations;
	}

}
