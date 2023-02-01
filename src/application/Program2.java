package application;


import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao newdepartmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("=== Test number one ISERT INTO FROM Department ");
		Department department = new Department(null, "Music");
		newdepartmentDao.insert(department);
		System.out.println("ID department Insert " + department.getId());	
	
	}

}
