package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

// Essa classe vai implementar as interfaces que usamos para manipular o banco

public class SellerDaoJDBC implements SellerDao {

	// Nesses Casos a conexão fica sempre aberta
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(Integer id) {
		// TODO Auto-generated method stub
		
	}

	// Fazendo consulta no DB por ID
	// Complexo 
	// A conexão já foi feita no inicio  da classe
	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conn.prepareStatement("SELECT seller. *, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.id "
					+ "WHERE  seller.Id = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getNString("DepName"));
				
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("birthDate"));
				obj.setDepartment(dep);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
				
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		
		}		
	}

	@Override
	public List<Seller> dinfALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
