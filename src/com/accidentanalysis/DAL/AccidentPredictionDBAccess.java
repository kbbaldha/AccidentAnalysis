package com.accidentanalysis.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accidentanalysis.Models.Correlation;
import com.accidentanalysis.Models.Prediction;
import com.accidentanalysis.Models.SPClass;

public class AccidentPredictionDBAccess {
	
	
	public void callStoredProcedure(String name,Connection con){
		CallableStatement callableStatement = null; 
		SPClass osp =	DBConnect.getCallableStatementWithConnection(con,name,0);
		try{
		callableStatement = osp.callableStatement;
		System.out.println("SP callable");	
	
		System.out.println("SP start");					
		callableStatement.execute();
		}
		catch(Exception e){
			System.out.println("in Accident prediction proc call page");
			System.out.println(e.getMessage());
		}
		finally{
			try{
			if(callableStatement!=null){
				callableStatement.close();
			}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
	}

public List<Prediction> getAccidentPredictionData(){
		
		QueryResult QR = null;
		List<Prediction> predictions = new ArrayList<Prediction>();
		Connection con = DBConnect.getConnection();
		callStoredProcedure("proc",con);
		try{

    	    QR = DBConnect.executeQueryWithConnection("select * from temp",con);
		    ResultSet rset = QR.resultSet;
		   
		    while (rset.next())
		    { System.out.println("year "+rset.getInt(1) + " accidents "+rset.getInt(2));
		    	Prediction prediction = new Prediction(rset.getInt(1),rset.getInt(2));
		    	
		    	predictions.add(prediction);
		     }
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		finally{
			
			try {
				QR.connection.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return predictions;
	}
}
