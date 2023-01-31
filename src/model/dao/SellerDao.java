package model.dao;

import java.util.List;

import model.entities.Department;
//Nessa interface ficam os m�todos que ir�o ser usadas para manipular o DB
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteBy(Integer id);
	Seller findById(Integer id);
	List<Seller> findALL();
	List<Seller> findByDepartment(Department department);
}
