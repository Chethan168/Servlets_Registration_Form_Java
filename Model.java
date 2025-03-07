package com.gqt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Model {
	private String url = "jdbc:mysql://localhost:3306/collegedb";
    private String userName = "root";
    private String password = "admin";
    private Connection con;
    private PreparedStatement pstmt;
    private String usn;
    private String sName;
    private int m1;
    private int m2;
    private int m3;
    private float percentage;

    public Model() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection and load success..");
    }
	public String getUsn() {
		return usn;
	}


	public void setUsn(String usn) {
		this.usn = usn;
	}


	public String getUname() {
		return sName;
	}


	public void setUname(String uname) {
		this.sName = uname;
	}


	public int getMarks1() {
		return m1;
	}


	public void setMarks1(int marks1) {
		this.m1 = marks1;
	}


	public int getMarks2() {
		return m2;
	}


	public void setMarks2(int marks2) {
		this.m2 = marks2;
	}


	public int getMarks3() {
		return m3;
	}


	public void setMarks3(int marks3) {
		this.m3 = marks3;
	}


	public float getPercent() {
		return percentage;
	}


	public void setPercent(float percent) {
		this.percentage = percent;
	}

	public boolean getResult() throws SQLException {
        pstmt = con.prepareStatement("INSERT INTO student (usn, sName, m1, m2, m3, percentage) VALUES (?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, usn);
        pstmt.setString(2, sName);
        pstmt.setInt(3, m1);
        pstmt.setInt(4, m2);
        pstmt.setInt(5, m3);
        pstmt.setFloat(6, percentage);

        int num = pstmt.executeUpdate();
        con.close();
        pstmt.close();
        return num >= 1;
	}
}
