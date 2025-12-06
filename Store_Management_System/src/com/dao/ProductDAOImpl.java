package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.model.Product;

public class ProductDAOImpl implements ProductDAO {


	@Override
	public void add_product(Product product) {
		String query = "INSERT INTO products(product_name,quantity,price,unit,category)values(?,?,?,?,?)";
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, product.getProduct_name());
		pstmt.setInt(2, product.getQuantity());
		pstmt.setDouble(3, product.getPrice());
		pstmt.setString(4, product.getUnit());
		pstmt.setString(5,product.getCategory());
		
		int rows_affected=pstmt.executeUpdate();
		if(rows_affected>0) {
			System.out.println("Product Added Successfully");
		}
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		};
	}

	@Override
	public void update_product_by_id(Product product, int product_id) {
		String query = "UPDATE Products SET product_name=?,quantity=?,price=?,unit=?,category=? WHERE product_id=?";
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, product.getProduct_name());
			pstmt.setInt(2, product.getQuantity());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getUnit());
			pstmt.setString(5,product.getCategory());
			pstmt.setInt(6,product_id);
			
			int rows_affected=pstmt.executeUpdate();
			if(rows_affected>0) {
				System.out.println("Product Updated Successfully");
			}else {
	            System.out.println("Product not found!");
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	@Override
	public void delete_product_by_id(int product_id) {
		String query = "DELETE FROM products WHERE product_id=?";
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, product_id);
			
			int rows_affected=pstmt.executeUpdate();
			if(rows_affected>0) {
				System.out.println("Product Deleted Successfully");
			}else {
				System.out.println("Product not found!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}

	@Override
	public Product getProduct_by_id(int product_id) {
		
		
		String query = "SELECT * FROM Products WHERE product_id=?";
		
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, product_id); 
		ResultSet result=pstmt.executeQuery();
		
		if(result.next()) {
			Product pt = new Product();
			pt.setProduct_id(result.getInt("product_id"));
			pt.setProduct_name(result.getString("product_name"));
			pt.setQuantity(result.getInt("quantity"));
			pt.setPrice(result.getDouble("price"));
			pt.setUnit(result.getString("unit"));
			pt.setCategory(result.getString("category"));
			
			return pt;
			
		}else {
			return null;
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<Product> get_all_products() {
		List<Product>  list=new ArrayList<>();

		String query = "SELECT * FROM Products";
		
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement(query);
		ResultSet result=pstmt.executeQuery();
		
		while(result.next()) {
			Product pt = new Product();
			pt.setProduct_id(result.getInt("product_id"));
			pt.setProduct_name(result.getString("product_name"));
			pt.setQuantity(result.getInt("quantity"));
			pt.setPrice(result.getDouble("price"));
			pt.setUnit(result.getString("unit"));
			pt.setCategory(result.getString("category"));
			
			list.add(pt);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return list;
	}

}
