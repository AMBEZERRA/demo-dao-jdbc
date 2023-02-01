package application;


import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao newdepartmentDao = DaoFactory.createDepartmentDao();
		
		/*
		System.out.println("=== Test number one ISERT INTO FROM Department ");
		Department department = new Department(null, "Music");
		newdepartmentDao.insert(department);
		System.out.println("ID department Insert " + department.getId());	
		*/
		
		/*
		System.out.println("=== Test number two DELETE FROM Department ");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		newdepartmentDao.deleteBy(id);
		System.out.println("Delete completed !!!");
		*/
		
		System.out.println("=== TEST 1: findById =======");
		Department dep = newdepartmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list = newdepartmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		
		sc.close();
	}

}
