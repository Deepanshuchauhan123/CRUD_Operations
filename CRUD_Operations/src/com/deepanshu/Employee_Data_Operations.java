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
	
	//for Saving Employee Details into Database
	public static int save(Emp e)
	{
		int status = 0;
		
		try 
		{
			Connection con = Employee_Data_Operations.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into bank(Name,Password,Email,Country) values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status = ps.executeUpdate();
			
		}catch(Exception e1) 
		{
			e1.printStackTrace();
		}
		
		return status;
	}
	
	public static int update(Emp e)
	{
		int status = 0;
		
		try {
		Connection con = Employee_Data_Operations.getConnection();
		PreparedStatement ps = con.prepareStatement("update bank set Name=?,Password=?,Email=?,Country=? where ID=?");
		
		ps.setString(1,e.getName());  
        ps.setString(2,e.getPassword());  
        ps.setString(3,e.getEmail());  
        ps.setString(4,e.getCountry());  
        ps.setInt(5,e.getId());
		
        status=ps.executeUpdate();
        
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(int id)
	{  
        int status=0;  
        try
        {  
            Connection con = Employee_Data_Operations.getConnection();  
            PreparedStatement ps = con.prepareStatement("delete from bank where ID=?");  
          
            ps.setInt(1,id);  
            
            status=ps.executeUpdate();  
              
            con.close();  
            
        }catch(Exception e)
        {
        	e.printStackTrace();
        }  
          
        return status;  
    } 
	
    public static Emp getEmployeeById(int id)
    {  
        Emp e=new Emp();  
          
        try
        {  
            Connection con = Employee_Data_Operations.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from bank where ID=?");  
            
            ps.setInt(1,id);  
            
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
    
    public static List<Emp> getAllEmployees()
    {
    	List<Emp> list = new ArrayList<Emp>();
    	
    	try {
    		
    		Connection con = Employee_Data_Operations.getConnection();
    		
    		PreparedStatement ps = con.prepareStatement("select * from bank");
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next())
    		{
    			Emp e = new Emp();
    			e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
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
