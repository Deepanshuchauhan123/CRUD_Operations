package com.deepanshu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper; 

public class EmpDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
	}
 
	
	public List<Emp> getEmployeeByPage(int pageid,int total)
	{
		String sql="select * from emp99 limit "+(pageid-1)+","+total;
		return template.query(sql, new RowMapper<Emp>() {

			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));    
	            e.setSalary(rs.getInt(3)); 
				return e;
			}
			
		});
	}

}



















