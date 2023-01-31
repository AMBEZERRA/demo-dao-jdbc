package model.dao;

import java.util.List;
//Nessa interface ficam os métodos que irão ser usadas para manipular o DB
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteBy(Integer id);
	Seller findById(Integer id);
	List<Seller> dinfALL();
}
