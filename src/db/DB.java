package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	// 2° Metodo para acessar o banco de dados 
	// cria um metodo com a classe connection do Sql 
	public static Connection getConnection() {
		if (conn == null) {
			try {
			// chama a classe Properties do java recebendo o metodo Load que lê as infoemações do BD	
			Properties props = loadProperties();
			// Aqui a Strinf recebe o caminho da url do banco que ta guardado no arquivo lido pelo método Load
			String url = props.getProperty("dburl");
			// Aqui usa a classe DriverManger que serve para receber a url e os dados do arquivo que fra a conexão 
			conn = DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				throw new DbException(e.getLocalizedMessage());
			}
		}
		return conn;
	}
	
	
	// metodo para encerrar a conexão com o BD
	
	public static void closeConnection() {
		if(conn != null) {
			try {
			conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
		
	//1° Metodo para carregar as propriedades que estão definidas no arquivo dp.properties
	// que é os dados de acesso ao DB
	
	private static Properties loadProperties() {
		// abrir o arquivo lê os dados e armazenar em objeto do tipo Properties
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		}
		catch (IOException e) {
			// usei o trow para acessar a excessão criada pro mim na outra classe
			throw new DbException(e.getMessage());
		}
	}
	
	
	// métodos staticos para fechar as chamadas externas 
	// é melhor usa-los para não precisar ta fazendo try todo hora que for fechar
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
