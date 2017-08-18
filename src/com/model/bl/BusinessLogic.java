package com.model.bl;
import com.model.beans.*;
import com.model.dao.*;
import java.util.ArrayList;


public class BusinessLogic {

	private EmployeeDaoImpl daoObj= new EmployeeDaoImpl();
	public ArrayList<Employee> listAllEmployees(){
		return daoObj.displayAll();
	};
	public Employee search(int x) {
		return daoObj.search(x);
	};
	public boolean delete(int x) {
		return daoObj.delete(x);
	};
	public boolean insert(Employee x) {
		return daoObj.insert(x);
	};
}
