package com.accidentanalysis.DAL;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import com.accidentanalysis.Models.City;
import com.accidentanalysis.Models.MapLocation;
import com.accidentanalysis.Models.SPClass;
import com.accidentanalysis.Models.Trend;

import oracle.sql.StructDescriptor;



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
	
	public List<Trend> GetPrediction() throws SQLException{
		CallableStatement callableStatement; 
		SPClass osp =	DBConnect.GetCallableStatement("PROC1",2);
		String typeTableName = "TEMPTABLE";
		callableStatement = osp.callableStatement;
		System.out.println("SP callable");	
		Object[] data = null;
		
		String typeName = "Temp1";
		List<Trend> tds = new ArrayList<Trend>();
		// Get a description of your type (Oracle specific)
		final StructDescriptor structDescriptor = StructDescriptor.createDescriptor(typeName.toUpperCase(), osp.con);		
		final ResultSetMetaData metaData = structDescriptor.getMetaData();
 
		try{
			//callableStatement.setInt(1, 336);
			//callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.setInt(1, 2015);
			callableStatement.registerOutParameter(2, java.sql.Types.ARRAY, typeTableName);
			System.out.println("SP start");			
			callableStatement.execute();			
			//System.out.println(callableStatement.getString(2));
			data = (Object[]) ((Array)callableStatement.getObject(2)).getArray();
			for(Object tmp : data) {
				Struct row = (Struct) tmp;
				Trend td = new Trend();
				// Attributes are index 1 based...
				int idx = 1;
				
				for(Object attribute : row.getAttributes()) {				
					System.out.println(metaData.getColumnName(idx) + " = " + attribute);
					if(metaData.getColumnName(idx) == "A"){
						td.noOfAccidents = (int) attribute;
					}
					else if(metaData.getColumnName(idx) == "yr"){
						td.month = (int) attribute;
					}
					++idx;
					
				}
				tds.add(td);
				System.out.println("---");
			}
			System.out.println("HERE");
			System.out.println(data[0]);
			return tds;
			
		}
		catch(Exception e){
			System.out.println("HERE DDMDMDMDMM");
			System.out.println(e.getMessage());
		}
		finally{
			try{
			if(callableStatement!=null){
				callableStatement.close();
			}
			if(osp.con != null){
				osp.con.close();
			}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		return tds;
	}
	
	public List<MapLocation> GetMapLocationData(){
		
		
		QueryResult QR = null;
		List<MapLocation> locations = new ArrayList<MapLocation>();
		try{
			
			
		     QR = DBConnect.ExecuteQuery("SELECT latitude,longitude FROM INCIDENT");
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { 
		    	MapLocation loc = new MapLocation();
		    	loc.Latitude = rset.getFloat(1);
		    	loc.Longitude = rset.getFloat(2);
		    	locations.add(loc);
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
		
		return locations;
	}
}
