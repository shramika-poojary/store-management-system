package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDAO {
	
	void add_product(Product product);
	
	void update_product_by_id(Product product,int product_id);
	
	void delete_product_by_id(int product_id);
	
	Product getProduct_by_id(int product_id);
	
	List<Product> get_all_products();
	
	
	
	
}
