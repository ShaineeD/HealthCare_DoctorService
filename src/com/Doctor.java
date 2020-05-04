package com;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class Doctor {

	public Connection connect() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitaldb_new","root", "");
			// For testing
			System.out.println("Successfully connected---1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// inserting an items .........................

	public String insertItem(String hospitalID,String docName, String docEmail, String docAddress, String specialization, String workingTime, String workingDays, String workingHospitals, String docFee, String username, String password) 
	{
		String output = "";
		
		try 
		{
			Connection con = connect();
			
			if (con == null) 
			{
				return "Error while connecting to the database";
			}
			
			// create a prepared statement
			String query = "insert into doctors" + "(`docID`, `hospitalID`, `docName`, `docEmail`, `docAddress`, `specialization`, `workingTime`, `workingDays`, `workingHospitals`, `docFee`, `username`, `password`)"
					          + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, hospitalID);
			preparedStmt.setString(3, docName);
			preparedStmt.setString(4, docEmail);
			preparedStmt.setString(5, docAddress);
			preparedStmt.setString(6, specialization);
			preparedStmt.setString(7, workingTime);
			preparedStmt.setString(8, workingDays);
			preparedStmt.setString(9, workingHospitals);
			preparedStmt.setDouble(10, Double.parseDouble(docFee));
			preparedStmt.setString(11, username);
			preparedStmt.setString(12, password);
			
			// execute the statement
			preparedStmt.execute();

			//		 System.out.print("successfuly inserted");
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
		
		} 
		catch (Exception e) 
		{
			output = "{\"status\":\"error\", \"data\":\"Error while inserting a Doctor.\"}";
			System.err.println(e.getMessage());
		}
		
		return output;
}

	// read the items from database and display----------------------

	public String readItems()
	{
	  String output = "";
	
	  try
	  {
	    Connection con = connect();
	
	    if (con == null)
	    {
	       return "Error while connecting to the database for reading.";
	    }
	
	    // Prepare the html table to be displayed
	     output ="<table border='1'><tr><th>hospitalID</th>"
	    		  +"<th>DocName</th><th>DocEmail</th>"
			      + "<th>DocAddress</th>"
			      + "<th>Specialization</th>"
			      + "<th>workingTime</th>"
			      + "<th>workingDays</th>"
			      + "<th>workingHospitals</th>"
			      + "<th>DocFee</th>"
			      + "<th>Username</th>"
			      + "<th>Password</th>"
	    		  +"<th>Update</th><th>Remove</th></tr>";
	     
	  
	     String query = "select * from doctors";
		 Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery(query);
	
	     // iterate through the rows in the result set
	     while (rs.next())
	     {
	    	 String docID = Integer.toString(rs.getInt("docID"));
		        String hospitalID = rs.getString("hospitalID");
		        String docName = rs.getString("docName");
		        String docEmail = rs.getString("docEmail");
		        String docAddress = rs.getString("docAddress");
		        String specialization = rs.getString("specialization");
		        String workingTime = rs.getString("workingTime");
		        String workingDays = rs.getString("workingDays");
		        String workingHospitals = rs.getString("workingHospitals");
		        String docFee = Double.toString(rs.getDouble("docFee"));
		        String username = rs.getString("username");
		        String password = rs.getString("password");
	
	       // Add into the html table
	       output += "<tr><td><input id='hidDocIDUpdate'" 
	    		   + "name='hidDocIDUpdate' type='hidden'"
	    		   + "value='" + docID + "'>" + hospitalID + "</td>";
	       output += "<td>" + docName + "</td>";
	       output += "<td>" + docEmail + "</td>";
	       output += "<td>" + docAddress + "</td>";
	       output += "<td>" + specialization + "</td>";
	       output += "<td>" + workingTime + "</td>";
	       output += "<td>" + workingDays + "</td>";
	       output += "<td>" + workingHospitals + "</td>";
	       output += "<td>" + docFee + "</td>";
	       output += "<td>" + username + "</td>";
	       output += "<td>" + password + "</td>";
	
	       // buttons
	       output += "<td><input name='btnUpdate' type='button'" 
	    		   + "value='Update'" 
	    		   + "class='btnUpdate btn btn-secondary'></td>"
	    		   + "<td><input name='btnRemove' type='button'"
	    		   + "value='Remove'"
	    		   + "class='btnRemove btn btn-danger' data-docid='"
	        + docID + "'>" + "</td></tr>";
	}
	     
	con.close();
	
	// Complete the html table
	output += "</table>";
	}
	
	catch (Exception e)
    {
	  output = "Error while reading Doctors.";
	  System.err.println(e.getMessage());
	}
	  
	return output;
}
	
	
	
	
	// update items ---------------------------------------------

	public String updateItem(String ID,String hID,String dName, String dEmail, String dAddress, String dspecialization, String dworkingTime, String dworkingDays, String dworkingHospitals, String dFee, String dusername, String dpassword) 
	{
		String output = "";
		
		try 
		{
			Connection con = connect();
			
			if (con == null) 
			{
				return "Error while connecting to the database for updating.";
			}
			
			// create a prepared statement
			String query = "UPDATE doctors SET hospitalID=?,docName=?,docEmail=?,docAddress=?,specialization=?,workingTime=?,workingDays=?,workingHospitals=?,docFee=?,username=?,password=?WHERE docID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, hID);
			preparedStmt.setString(2, dName);
			preparedStmt.setString(3, dEmail);
			preparedStmt.setString(4, dAddress);
			preparedStmt.setString(5, dspecialization);
			preparedStmt.setString(6, dworkingTime);
			preparedStmt.setString(7, dworkingDays);
			preparedStmt.setString(8, dworkingHospitals);
			preparedStmt.setDouble(9, Double.parseDouble(dFee));
			preparedStmt.setString(10, dusername);
			preparedStmt.setString(11, dpassword);
			preparedStmt.setInt(12, Integer.parseInt(ID));
			
 			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \""+newItems + "\"}";
		
		} 
		catch (Exception e) 
		{
			output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
			System.err.println(e.getMessage());
		}
		
		return output;
	}

	// delete items--------------------------------------

	public String deleteItem(String docID) 
	{
		String output = "";
		
		try 
		{
			Connection con = connect();
			
			if (con == null) 
			{
				return "Error while connecting to the database for deleting.";
			}
			
			// create a prepared statement
			String query = "delete from doctors where docID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(docID));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
		} 
		catch (Exception e) 
		{
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
