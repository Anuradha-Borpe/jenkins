package com.profileproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.profileproject.entity.ProfileUser;

public class ProfileDAO implements ProfileDAOInterface {

	int i=0;
	public int createDAOProfile(ProfileUser p) {


		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profiledb","root","Anuradha");
			PreparedStatement ps=con.prepareStatement("insert into profiletb values(?,?,?,?)");
			
			ps.setString(1, p.getName());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		return i;
	}
	public boolean loginDAOProfile(ProfileUser pu) {
		
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profiledb","root","Anuradha");
			PreparedStatement ps=con.prepareStatement("select * from profiletb where name=? and password=?");
			ps.setString(1, pu.getName());
			ps.setString(2, pu.getPassword());
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return false;
	}
	public ProfileUser viewEditAttribute(ProfileUser pu) {
		ProfileUser p1=new ProfileUser();

		String name=pu.getName();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profiledb","root","Anuradha");
			PreparedStatement ps=con.prepareStatement("select * from profiletb where name=?");
			ps.setString(1, pu.getName());
			
			
			ResultSet rs=ps.executeQuery();
			p1.setName(rs.getString(1));
			p1.setPassword(rs.getString(2));
			p1.setEmail(rs.getString(3));
			p1.setAddress(rs.getString(4));
			
			
			
			if(rs.next())
			{
				
				
				System.out.println("This is Your Profile");
				System.out.println("Your old password="+p1.getPassword());
				System.out.println("Your old Email="+p1.getEmail());
				System.out.println("Your old Address="+p1.getAddress());
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return p1;
		
	}
	public int editDAOProfile(ProfileUser p2) {

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profiledb","root","Anuradha");
	PreparedStatement ps=con.prepareStatement("update profiletb set password=? address=? email=? where name=?");	
	ps.setString(1, p2.getPassword());
	ps.setString(2, p2.getAddress());
	ps.setString(3, p2.getEmail());
	ps.setString(4, p2.getName());
	
	int i=ps.executeUpdate();
}
catch(Exception e)
{
	e.printStackTrace();  
}
		return i;
	}
	public int deleteDAOProfile(ProfileUser pu) {
		
		int i=0;

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profiledb","root","Anuradha");
		PreparedStatement ps=con.prepareStatement("delete from profiletb where name=?");
		
		
		ps.setString(1, pu.getName());
		
		i=ps.executeUpdate();
		}
		catch (Exception e) {

        e.printStackTrace();
		}
		return i;
	}
	public ProfileUser viewDAOProfile(ProfileUser pu) {

		ProfileUser p1=new ProfileUser();
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profiledb","root","Anuradha");
			PreparedStatement ps=con.prepareStatement("select * from profiletb where name=?");
			ps.setString(1, pu.getName());
			ResultSet res=ps.executeQuery();
			if(res.next())
			{
				p1.setName(res.getString(1));
				p1.setPassword(res.getString(2));
				p1.setEmail(res.getString(3));
				p1.setAddress(res.getString(4));
				
			}
		}
		
		catch(Exception e)
		
		{
		e.printStackTrace();
		}

		return p1;
	}

}
