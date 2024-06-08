package com.elhewazy.app;

import com.elhewazy.dao.InventoryDao;
import com.elhewazy.dao.UserDao;
import com.elhewazy.model.ProductDTO;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("please enter your email to add the user ");
		String emailNew = sc.next();
		System.out.println("please enter your password to add the user");
		String passwordNew = sc.next();
		UserDao ud1 = new UserDao();
		ud1.adduser(emailNew,passwordNew);
		System.out.println("please enter your email to login ");


		String email = sc.next();

		System.out.println("please enter your password to login");
		String password = sc.next();
		UserDao ud2 = new UserDao();
		ud2.getuser(email,password);

		InventoryDao invD = new InventoryDao();
		ProductDTO pd = new ProductDTO();
		//invD.editProdDAO();
//add product prodCode, prodName, brand; costPrice, sellPrice
		System.out.println("please enter the prodName");
		pd.setProdName(sc.next());
		System.out.println("please enter the brand");
		pd.setBrand(sc.next());
		System.out.println("please enter the  prodCode");
		pd.setProdCode(sc.next());
		System.out.println("please enter the  costPrice");
		pd.setCostPrice(sc.nextDouble());
		System.out.println("please enter the  sellPrice");
		pd.setSellPrice(sc.nextDouble());
		invD.addProduct( pd);

		//delete product
		System.out.println("please enter the  prodCode to delete the product");
		pd.setProdCode(sc.next());
		invD.deleteProductDAO(pd.getProdCode());
		//update product
		System.out.println("please enter the  prodCode to update the product");
		System.out.println("please enter the prodName");
		pd.setProdName(sc.next());
		System.out.println("please enter the brand");
		pd.setBrand(sc.next());
		System.out.println("please enter the brand");
		pd.setBrand(sc.next());
		System.out.println("please enter the  costPrice");
		pd.setCostPrice(sc.nextDouble());
		System.out.println("please enter the  sellPrice");
		pd.setSellPrice(sc.nextDouble());
		invD.editProdDAO(pd);

	}

}
