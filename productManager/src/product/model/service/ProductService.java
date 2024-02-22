package product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import product.exception.ProductException;
import product.model.dao.ProductDao;
import product.model.dto.Product;
import static common.JDBCTemplate.*;

public class ProductService {

	private ProductDao pd = new ProductDao();

	public ArrayList<Product> selectAll() throws ProductException{


		Connection conn = getConnection();
		ArrayList<Product> list = pd.selectAll(conn);
		close(conn);
		
		return list;
		

	}

	public Product selectRow(String p_id) throws ProductException {

		Connection conn = getConnection();
		Product p = pd.selectRow(conn, p_id);
		close(conn);
		
		return p;

	}

	public ArrayList<Product> selectName(String p_name) throws ProductException {

		Connection conn = getConnection();
		ArrayList<Product> list = pd.selectName(conn, p_name);
		close(conn);
		
		return list;

	}

	public int insertRow(Product p) throws ProductException {

		Connection conn = getConnection();
		int result = pd.insertRow(conn, p);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public int updateRow(Product product) throws ProductException {

		Connection conn = getConnection();
		int result = pd.updateRow(conn, product);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteRow(String pid) throws ProductException {

		Connection conn = getConnection();
		int result = pd.deleteRow(conn, pid);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
