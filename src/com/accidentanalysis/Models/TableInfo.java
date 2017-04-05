package com.accidentanalysis.Models;

public class TableInfo {

	public String TableName;
	public int RowCount;
	
	public TableInfo(String table,int count){
		this.TableName = table;
		this.RowCount = count;
	}
}

