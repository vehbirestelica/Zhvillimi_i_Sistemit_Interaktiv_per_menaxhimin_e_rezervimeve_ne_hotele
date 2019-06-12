package Employer;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employer {

	private int id;
	private String name1;
	private String lastname1;
	private int roomno;
	
	
	public Employer(int id, String name1, String lastname1, int roomno) {
		this.id = id;
		this.name1 = name1;
		this.lastname1 = lastname1;
		this.roomno = roomno;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getname1() {
		return name1;
	}
	
	public void setname1(String name1) {
		this.name1 = name1;
	}
	
	public String getlastname1() {
		return lastname1;
	}
	public void setlastname1(String lastname1) {
		this.lastname1 = lastname1;
	}
	
	public int getroomno() {
		return roomno;
	}
	
	public void setroomno(int roomno) {
		this.roomno = roomno;
	}
	
	public static boolean addEmployer(String name1, String lastname1, int roomno) {
		String query = "INSERT INTO Employers(name1, lastname1, roomno) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, name1);
			preparedStatement.setString(2, lastname1);
			preparedStatement.setInt(3, roomno);
			
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
