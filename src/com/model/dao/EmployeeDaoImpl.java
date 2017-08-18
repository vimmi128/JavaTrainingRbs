package com.model.dao;
import com.model.beans.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {


	@Override
	public ArrayList<Employee> displayAll() {
		ArrayList<Employee> listOfEmployees=new ArrayList<Employee>();
		Connection con=null;
		try {
			//1.Registering the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			//2. Connect to DataBase
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"hr","hr");
			//3. Query
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from empl");
			//PreparedStatement pstmt=con.prepareStatement("select * from empl");
			
			//4. Process Result
			while(rs.next()){
				Employee emp=new Employee();
				
				int id=rs.getInt("employee_id");
				String name=rs.getString("name");
				String des=rs.getString("designation");
				String dept=rs.getString("department");
				int sal=rs.getInt("salary");
				System.out.println(id+" "+name+" "+des+" "+dept+" "+sal);
				
				emp.setEmployeeId(id);
				emp.setName(name);
				emp.setDesignation(des);
				emp.setDepartment(dept);
				emp.setSalary(sal);
				listOfEmployees.add(emp);
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listOfEmployees;
	}
	
	@Override
	public Employee search(int x) {
		Connection con=null;
		Employee emp=new Employee();
		try {
			//1.Registering the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			 //2. Connect to DataBase
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"hr","hr");
			//3. Query
			
			PreparedStatement pstmt=con.prepareStatement("select * from empl where employee_id=?");
			pstmt.setInt(1, x);
			ResultSet rs=pstmt.executeQuery();
			
			//4. Process Result
			if(rs.next()){
				
				int id=rs.getInt("employee_id");
				String name=rs.getString("name");
				String des=rs.getString("designation");
				String dept=rs.getString("department");
				int sal=rs.getInt("salary");
				System.out.println(id+" "+name+" "+des+" "+dept+" "+sal);
				
				emp.setEmployeeId(id);
				emp.setName(name);
				emp.setDesignation(des);
				emp.setDepartment(dept);
				emp.setSalary(sal);
				
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
		
	}
	@Override
	public boolean delete(int x) {
		Connection con=null;
		boolean deleteFlag = false;
		Employee emp=new Employee();
		try {
			//1.Registering the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			 //2. Connect to DataBase
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"hr","hr");
			//3. Query
			
			PreparedStatement pstmt=con.prepareStatement("delete * from employee where employee_id=?");
			pstmt.setInt(1, x);
			
			 
            int status = pstmt.executeUpdate();
			
			//4. Process Result
			if(status!=0)
			{
				deleteFlag = true;
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleteFlag;
	}
	@Override
	public boolean insert(Employee x) {
		Connection con = null;
		boolean insertSuccess = false;
		try {
			//1.Registering the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connect to DataBase
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
			//3. Query
//			Statement stmt=con.createStatement();
			
//			ResultSet rs=stmt.executeQuery("select * from emp where ");
			PreparedStatement stmt=con.prepareStatement("insert into employee (employee_id,name,salary,designation,department) values (?,?,?,?,?");
			stmt.setInt(1, x.getEmployeeId());
			stmt.setString(2, x.getName());
			stmt.setInt(3, x.getSalary());
			stmt.setString(4, x.getDepartment());
			stmt.setString(5, x.getDesignation());
			
			
			int status = stmt.executeUpdate();
			
			//4. Process Result
			if(status!=0)
			{
				insertSuccess = true;
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return insertSuccess;
	}
}
