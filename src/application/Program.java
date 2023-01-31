package application;

import java.text.ParseException;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		/* Passando qualquer data 
			LocalDate localDate = LocalDate.parse("2023-01-30");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
		
			// ou assim  
		
		
		LocalDate localDate = LocalDate.parse("2021-01-15");
		Date date = new Date(localDate.atStartOfDay(ZoneId.of("America/Sao_Paulo")).toEpochSecond() * 1000);
			*/		
		Department obj = new Department(1, "Books");
		
		Seller seller = new Seller( 21, "Allisson", "ama@jjFla", new Date(), 4000.00, obj); // usando new Date() pega a data do dia
 		SellerDao sellerDao = DaoFactory.createSellerDao(); // aqui chama a interface para intanciar (DaoFactory)
		System.out.println(seller);
	}

}
