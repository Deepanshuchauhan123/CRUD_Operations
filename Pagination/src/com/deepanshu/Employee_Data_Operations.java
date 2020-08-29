package com.deepanshu;
import java.util.*;  
import java.sql.*;

public class Employee_Data_Operations 
{
	public static Connection getConnection()
	{
		Connection con = null;
		
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
	
	
    
    public static List<Emp> getRecords(int start,int total)
    {
    	List<Emp> list = new ArrayList<Emp>();
    	
    	try {
    		
    		Connection con = Employee_Data_Operations.getConnection();
    		
    		PreparedStatement ps = con.prepareStatement("select * from bank limit "+(start-1)+","+total);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next())
    		{
    			Emp e = new Emp();
    			e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));    
                e.setCountry(rs.getString(5));  
                list.add(e);
    		}
    		
    		con.close();
    		
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    
	
	
	
	
}
