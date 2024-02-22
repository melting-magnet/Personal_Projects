package product.controller;

import java.util.ArrayList;

import product.exception.ProductException;
import product.model.dto.Product;
import product.model.service.ProductService;

public class ProductController {

	private ProductService ps = new ProductService();

	public ArrayList<Product> selectAll() throws ProductException {
		return ps.selectAll();
	}

	public Product selectRow(String p_id) throws ProductException {

		return ps.selectRow(p_id);
	}

	public ArrayList<Product> selectName(String p_name) throws ProductException {

		return ps.selectName(p_name);
	}

	public int insertRow(Product p) throws ProductException {

		return ps.insertRow(p);

	}

	public int updateRow(Product product) throws ProductException {

		return ps.updateRow(product);

	}

	public int deleteRow(String pid) throws ProductException {
		
		return ps.deleteRow(pid);
	}

}
