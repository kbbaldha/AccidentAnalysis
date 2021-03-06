package com.accidentanalysis.Models;

import java.sql.Date;

public class User {
	    private int id;
	    private String username;
	    private String firstname;
	    private String lastname;
	    private String password;
	    private String gender;
	    private String type;
	    private int role;
	    private String job; 
		private String street;
	    private String city;
	    private String state;
	    private int zip;
	    private Date lastlogin;
	    
	    public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public int getRole() {
			return role;
		}

		public void setRole(String role) {
			if(!role.isEmpty()){
			this.role = Integer.parseInt(role);
			}
		}
	
	    
	    public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


	    public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getZip() {
			return zip;
		}

		public void setZip(String zip) {
			if(!zip.isEmpty()){
			this.zip = Integer.parseInt(zip);
			}
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public Date getLogin() {
	        return lastlogin;
	    }

	    public void setLogin(Date lastlogin) {
	        this.lastlogin = lastlogin;
	    }
	    

	
}