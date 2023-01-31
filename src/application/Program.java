package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); // aqui chama a interface para instanciar (DaoFactory)
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findByAll =====");
		list = sellerDao.findALL();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		
		LocalDate localDate = LocalDate.parse("2021-05-30");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
		
		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail", date, 4000.0, department);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller UPDATE =====");
		seller = sellerDao.findById(1); // alterei o nome do id = 1 na tabela seller
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		
	
	
	
	}
		
}
