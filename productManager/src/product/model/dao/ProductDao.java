package product.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import static common.JDBCTemplate.*;
import product.exception.ProductException;
import product.model.dto.Product;
// close아직 안함
public class ProductDao {

	private Properties prop = new Properties();

	public ProductDao() {
		super();

		try {
			prop.load(new FileReader("resources/query.properties"));

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Product> selectAll(Connection conn) throws ProductException {

		ArrayList<Product> list = new ArrayList<Product>();

		String query = prop.getProperty("selectall");
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Product p = new Product();
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));

				list.add(p);
			}

		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public Product selectRow(Connection conn, String p_id) throws ProductException {

		Product p = new Product();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectrow");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p_id);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));

			}

		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}

		return p;

	}

	public ArrayList<Product> selectName(Connection conn, String p_name) throws ProductException {

		ArrayList<Product> list = new ArrayList<Product>();
		String query = prop.getProperty("selectname");
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+ p_name +"%");
			rset = pstmt.executeQuery();

			if (rset.next()) {

				Product p = new Product();
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));

				list.add(p);
			}

		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;


	}

	public int insertRow(Connection conn, Product p) throws ProductException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertrow");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}

		return result;
	}

	public int updateRow(Connection conn, Product p) throws ProductException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("updaterow");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, p.getPrice());
			pstmt.setString(2, p.getProductId());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}

		return result;
	}

	public int deleteRow(Connection conn, String pId) throws ProductException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleterow");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pId);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}

		return result;
	}

}
