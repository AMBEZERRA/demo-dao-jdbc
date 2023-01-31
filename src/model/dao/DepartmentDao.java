package model.dao;

import java.util.List;

import model.entities.Department;
// Nessa interface ficam os m�todos que ir�o ser usadas para manipular o DB
public interface DepartmentDao {

	void insert(Department obj);
	void update(Department obj);
	void deleteBy(Integer id);
	Department findById(Integer id);
	List<Department> dinfALL();
	
}
