package com.accidentanalysis.Models;

public class Incident {
	
	    private int id;
	    private int reporterid;
	    private int numofteammambers;
	    private String eventtype;
	    private String eventsubtype;
	    private float latitude;
	    private float longitude;
	    
	    public int getNumofteammambers() {
			return numofteammambers;
		}
		public void setNumofteammambers(int numofteammambers) {
			this.numofteammambers = numofteammambers;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getReporterid() {
			return reporterid;
		}
		public void setReporterid(int reporterid) {
			this.reporterid = reporterid;
		}
		public String getEventtype() {
			return eventtype;
		}
		public void setEventtype(String eventtype) {
			this.eventtype = eventtype;
		}
		public String getEventsubtype() {
			return eventsubtype;
		}
		public void setEventsubtype(String eventsubtype) {
			this.eventsubtype = eventsubtype;
		}
		public float getLatitude() {
			return latitude;
		}
		public void setLatitude(float latitude) {
			this.latitude = latitude;
		}
		public float getLongitude() {
			return longitude;
		}
		public void setLongitude(float longitude) {
			this.longitude = longitude;
		}  

}
