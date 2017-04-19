package com.accidentanalysis.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.CorelationData;
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


public CorelationData GetCorrelation(){
	
CorelationData corelationData = null;
	QueryResult QR = null;
	try{

	    QR = DBConnect.ExecuteQuery("select case when CorrTest > 0 and CorrTest < 0.3 Then 'There is a small positive correlation present. As the value is between 0 and 0.3, there is practically no correlation between speed limit and number of accident'"+
        " when CorrTest >=0.3 and CorrTest < 0.6 Then 'There is a positive correlation between speed limit and number of accidents. And number of accidents do depend on speed limit.'"+
        " when CorrTest >=0.6 and Corrtest<=1 Then 'There is a strong positive correlation between speed limit and number of accidents. As speed limit increases, the number of accidents increase greatly'"+ 
        " when CorrTest <0 and CorrTest >0.3 Then 'There is a small negative correlation between speed and number of accidents'"+
        " else 'There is a strongn negative correlation between speed and number of accidents. As the speed limit increases, the number of accidents decrease.'"+
       " end as NewC,round(CorrTest,2)"+
" from ( select corr( speed,count) as CorrTest "+
" from ( select speed,count(*) as count"+
" from affected,lane " +
" where lane_id=lane_id_fk"+
" group by speed"+
" order by speed ))");
	    ResultSet rset = QR.resultSet;
	   
	    while (rset.next())
	    { System.out.println("speed "+rset.getString(1) + "Corelation value "+rset.getFloat(2));
	    corelationData = new CorelationData(rset.getString(1),rset.getFloat(2));
	    	
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
	
	return corelationData;
}

}
