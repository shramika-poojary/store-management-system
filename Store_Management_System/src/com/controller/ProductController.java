package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.ProductDAOImpl;
import com.model.Product;

public class ProductController {

	public static void main(String[] args) {
		
		ProductDAOImpl dao=new ProductDAOImpl();
		
		
		Scanner sc=new Scanner(System.in);
		int choice;
		int productID;
		String productName;
		int quantity;
		double price;
		String unit;
		String category;
		
		do {

			System.out.println("################ STORE MANAGEMENT SYSTEM ###################");
			System.out.println("1.Add Product \n2.Search Product \n3.Update Product \n4.Delete Product \n5.View All products \n6.Generate Bill \n7.Exit");
			System.out.println("Enter Choice:");
			choice=sc.nextInt();
			switch (choice) {
			
			case 1:{
				System.out.println("Enter Product Name:");
				productName=sc.next();
				
				System.out.println("Enter Amount of stock present (quantity)");
				quantity=sc.nextInt();
				
				System.out.println("Enter Price of Product");
				price=sc.nextDouble();
				
				System.out.println("Enter Unit of Product");
				unit = sc.next();
				
				System.out.println("Enter Category");
				category=sc.next();
				
				dao.add_product(new Product(productName,quantity,price,unit,category));
			
				}
				break;
			case 2:{
				
					System.out.println("Enter existing product ID");
					productID = sc.nextInt();
					Product p= dao.getProduct_by_id(productID);
					if(p!=null) {
						System.out.println();
						System.out.println("Product ID: " + p.getProduct_id());
					    System.out.println("Product Name: " + p.getProduct_name());
					    System.out.println("Quantity: " + p.getQuantity());
					    System.out.println("Price: " + p.getPrice());
					    System.out.println("Unit: " + p.getUnit());
					    System.out.println("Category: " + p.getCategory());
					    System.out.println();
					}else{
						 System.out.println("Product not found!");
					}
					}
					break;
					
			case 3:	{
					System.out.println("Enter existing product ID");
					productID = sc.nextInt();
					
					Product p= dao.getProduct_by_id(productID);
					if(p!=null) {
						System.out.println();
						System.out.println("Existing details");
						System.out.println("Product ID: " + p.getProduct_id());
					    System.out.println("Product Name: " + p.getProduct_name());
					    System.out.println("Quantity: " + p.getQuantity());
					    System.out.println("Price: " + p.getPrice());
					    System.out.println("Unit: " + p.getUnit());
					    System.out.println("Category: " + p.getCategory());
					    System.out.println();
					}else{
						 System.out.println("Product not found!");
					}
					System.out.println("Enter new details here to update");
					System.out.println("enter new Product Name:");
				    productName=sc.next();
				       
				    System.out.println("enter new Stock Quantity:");
				    quantity=sc.nextInt();
				     
				    System.out.println("enter new Price:");
				    price=sc.nextDouble();

				    System.out.println("enter new Unit:");
				    unit=sc.next();
				    
				    System.out.println("enter new Category:");
				    category=sc.next();
				    
				    dao.update_product_by_id(new Product(productName,quantity,price,unit,category), productID);
				    System.out.println();
					}
					break;
			case 4:{
					System.out.println("Enter existing product ID to delete");
					productID = sc.nextInt();
					dao.delete_product_by_id(productID);
					
					}
					break;
			case 5:{
					System.out.println("All product details");
					System.out.println();
					
					List<Product> list=dao.get_all_products();
					if(list!=null) {
						for(Product p:list) {
							System.out.println(p);
						}
					}else {
						 System.out.println("list is empty");

					}
					
					}
					break;
				
			case 6:{
					System.out.println("All product details");
					System.out.println();
					List<Product> list=dao.get_all_products();
					if(list!=null) {
						for(Product p:list) {
							System.out.println(p);
						}
					}else {
						 System.out.println("list is empty");

					}
				 	System.out.println("===== Generate Bill =====");
				 	double total = 0;
				 	boolean more=false;
				 	do {
				 	System.out.print("Enter product ID: ");
			        int bid = sc.nextInt();

			        Product pp = dao.getProduct_by_id(bid);
			        
			        if(pp != null) {
			            System.out.print("Enter quantity to sell: ");
			            int sellQty = sc.nextInt();

			            if(sellQty <= pp.getQuantity()) {

			                double amount = sellQty * pp.getPrice();
			                total += amount;
			                
			                System.out.println("----------------------------------------------");
			                System.out.println("Product Name : " + pp.getProduct_name());
			                System.out.println("Unit Price   : ₹" + pp.getPrice());
			                System.out.println("Quantity     : " + sellQty);
			                System.out.println("Amount       : ₹" + amount);
			                System.out.println("----------------------------------------------");

			                
					}else {
						  System.out.println("Not enough stock available!");
					}
			            
			        }else {
			            System.out.println("Product not found!");
			        }
			        System.out.print("Add another product? (yes/no): ");
			        String another=sc.next();
			        if(another.equalsIgnoreCase("yes")) {
			        more = true;
			        }else {
			        	more=false;
			        }
					}while(more);
				 	 System.out.println("\n===============================================");
				     System.out.println(" Total Amount : ₹" + total);
				     System.out.println("===============================================");
				     System.out.println("	THANK YOU FOR VISITING OUR STORE	");
				     System.out.println("===============================================\n");
				 	
			}
					break;
			case 7:	System.out.println("Exiting....");
					choice=0;
					continue;
				
			default: if(choice!=7) {
				System.out.println("Invalid choice");
					}
			
			}
			
		}while(choice!=7);

	}

}
