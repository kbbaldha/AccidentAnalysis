package com.accidentanalysis.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.Car;
import com.accidentanalysis.Models.Correlation;

public class DashboardDBAccess {

public List<Car> getCarsInvolvedInAccident(){
		
		QueryResult QR = null;
		List<Car> cars = new ArrayList<Car>();
		try{

    	    QR = DBConnect.ExecuteQuery("select count(*),make,model from vehicle,involves where vehicle_id_fk=vehicle_id group by make,model order by count(*) desc");
		    ResultSet rset = QR.resultSet;
		   int count = 0;
		    while (rset.next())
		    { System.out.println("count "+rset.getInt(1) + "make "+rset.getString(2)+ "model " + rset.getString(3));
		    	Car car = new Car(rset.getInt(1),rset.getString(2),rset.getString(3));
		    	cars.add(car);
		    	count++;
		    	if(count > 5)
		    	{
		    		break;
		    	}
		     }
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		finally{
			
			try {
				if(QR.connection !=null && !(QR.connection.isClosed()))
				QR.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cars;
	}

public int getInvestigationPeriod() {
	QueryResult QR = null;
	int investigationPeriod = -1;
	try{

	    QR = DBConnect.ExecuteQuery("select round(avg((CAR_SPEED-LANE_SPEED))) as Diff from( select avg(speed) as lane_speed,incident_id_fk as iif1 from lane,affected where affected.lane_id_fk=lane.lane_id group by incident_id_fk) inner join (select avg(speed)as car_Speed,incident_id_fk as iif2 from involves group by incident_id_fk) on iif1=iif2 where car_speed > lane_speed");
	    ResultSet rset = QR.resultSet;
	   int count = 0;
	    while (rset.next())
	    { System.out.println("investigationPeriod "+rset.getInt(1));
	    	investigationPeriod = rset.getInt(1);
	     }
	}
	catch(Exception e){
		System.out.println(e.toString());
	}
	finally{
		
		try {
			if(QR.connection !=null && !(QR.connection.isClosed()))
			QR.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return investigationPeriod;
	
}

public int getAvgSpeed() {
	QueryResult QR = null;
	int speed = -1;
	try{

	    QR = DBConnect.ExecuteQuery("select round(avg(days)) as Average_Report from ( select extract(day from ((end_timestamp - start_timestamp))) as days from investigation order by investigation_id)");
	    ResultSet rset = QR.resultSet;
	   int count = 0;
	    while (rset.next())
	    { System.out.println("speed "+rset.getInt(1));
	    	speed = rset.getInt(1);
	     }
	}
	catch(Exception e){
		System.out.println(e.toString());
	}
	finally{
		
		try {
			if(QR.connection !=null && !(QR.connection.isClosed()))
			QR.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return speed;
}
	
}
