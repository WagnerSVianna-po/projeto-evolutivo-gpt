package model.dao;

import db.DB;
import model.dao.impl.EmployeesDaoJDBC;

public class DaoFactory {

	public static EmployeesDao createEmployeesDao() {
		return new EmployeesDaoJDBC(DB.getConnection());
	}
}
