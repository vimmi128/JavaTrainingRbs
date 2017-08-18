package com.model.dao;
import java.util.ArrayList;
import com.model.beans.*;

public interface EmployeeDao {

	public ArrayList<Employee> displayAll();
	public Employee search(int x);
	public boolean delete(int x);
	public boolean insert(Employee x);
	
}