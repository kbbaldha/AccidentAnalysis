package com.accidentanalysis.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.accidentanalysis.Models.Incident;
import com.accidentanalysis.Models.User;

public class IncidentDBAccess {
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
	public StringBuffer reportIncident(Incident incident){
		
		User user1 = null;
		Connection connection = DBConnect.getConnection();
		
		String insertIntoIncident = "INSERT INTO incident"
				+ "(REPORTER_ID_FK,EVENT_TYPE,Event_Subtype,TIMESTAMP,latitude,longitude) VALUES"
				+ "(?,?,?,?,?,?)";
		
		String insertIntoInvetigation = "INSERT INTO investigation"
				+ "(LED_BY_FK,NO_OF_TEAM_MEMBERS,START_TIMESTAMP)"
				+ "(?,?,?)";
		
		
		StringBuffer stringBuffer = new StringBuffer();
		
		try{
			
			PreparedStatement preparedStatementIncident = connection.prepareStatement(insertIntoIncident);
			PreparedStatement preparedStatementInvestigation = connection.prepareStatement(insertIntoInvetigation);
			
			if(incident.getReporterid()<=0){
				System.out.println("reporter id "+incident.getReporterid());
				stringBuffer.append("Missing Reporter Id ");
			}
			else{
				preparedStatementIncident.setInt(1,incident.getReporterid());
				preparedStatementInvestigation.setInt(1,incident.getReporterid());
				}
			
			
			if(incident.getEventtype().isEmpty()){
				stringBuffer.append("Missing Incident Type ");
			}
			else{
				preparedStatementIncident.setString(2,incident.getEventtype());
				}
			
			if(incident.getEventsubtype().isEmpty()){
				stringBuffer.append("Missing Incident cause ");
			}
			else
			{
				preparedStatementIncident.setString(3,incident.getEventsubtype());
			}
			
			Timestamp timestamp = getCurrentTimeStamp();
		   preparedStatementIncident.setTimestamp(4,timestamp);
			
			if(incident.getLatitude()==0){
				stringBuffer.append("Missing Latitude ");
			}
			else
			{
				preparedStatementIncident.setFloat(4,incident.getLatitude());
			}
			
			if(incident.getLongitude()==0){
				stringBuffer.append("Missing Longitude ");
			}
			else
			{
				preparedStatementIncident.setFloat(4,incident.getLongitude());
			}
			
			
			preparedStatementInvestigation.setInt(2,incident.getNumofteammambers());
			preparedStatementInvestigation.setTimestamp(3,timestamp);
			
			
			preparedStatementIncident.executeUpdate(insertIntoIncident);
			preparedStatementInvestigation.executeUpdate(insertIntoInvetigation);
			connection.close();
			  
		}
		catch(Exception e){
			
			System.out.println(e.toString());
			stringBuffer.append("Reporting failed try again");
		}
		finally{
			try {
				if(!connection.isClosed()){
				connection.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				return stringBuffer;
			}
		}
	}

}
