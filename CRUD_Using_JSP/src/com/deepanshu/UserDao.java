package com.deepanshu;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class UserDao 
{
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try 
		{
				
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root",null);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static int save(User u)
	{
		int status = 0;
		
		try 
		{
			
			Connection con = getConnection();
			java.sql.PreparedStatement ps = con.prepareStatement("insert into bank(Name,Password,Email,sex,Country)values(?,?,?,?,?)");
			
			ps.setString(1, u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getSex());
			ps.setString(5,u.getCountry());
			
			status = ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static int update(User u)
	{
		int status =0;
		
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("update bank set Name=?,Password=?,Email=?,sex=?,Country=? where id =?");
			
			ps.setString(1, u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getSex());
			ps.setString(5,u.getCountry());
			ps.setInt(6, u.getId());
			
			status = ps.executeUpdate();
			
		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(User u)
	{
		int status=0;
		
		try
		{
			
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from bank where id=?");
			
			ps.setInt(1, u.getId());
			
			status=ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<User> getAllRecords()
	{
		List<User> list = new ArrayList<User>();
		
		try
		{
			Connection con = getConnection();
			java.sql.PreparedStatement ps=con.prepareStatement("select * from bank"); 
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setEmail(rs.getString("Email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("Country"));
				list.add(u);
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static User getRecordsById(int id)
	{
		User u = null;
		
		try 
		{
			
			Connection con = getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from bank where id =?");
			
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				u = new User();
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setEmail(rs.getString("Email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("Country"));
				
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return u;
	}
	
}
