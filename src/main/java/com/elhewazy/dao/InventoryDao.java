package com.elhewazy.dao;

import com.elhewazy.model.ProductDTO;

import java.sql.*;

public class InventoryDao{
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/examDB";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        return conn;
    }
    public void editProdDAO(ProductDTO productDTO) {
        try {
            String query = "UPDATE products SET productname=?,costprice=?,sellprice=?,brand=? WHERE productcode=?";
            PreparedStatement prepStatement=  getConnection().prepareStatement(query);
            prepStatement.setString(1, productDTO.getProdName());
            prepStatement.setDouble(2, productDTO.getCostPrice());
            prepStatement.setDouble(3, productDTO.getSellPrice());
            prepStatement.setString(4, productDTO.getBrand());
            prepStatement.setString(5, productDTO.getProdCode());
            prepStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Double getProdCost(String prodCode) throws SQLException, ClassNotFoundException {
        Double costPrice = null;
        Statement statement = getConnection().createStatement();
        try {
            String query = "SELECT costprice FROM products WHERE productcode='" +prodCode+ "'";
            ResultSet  resultSet = statement.executeQuery(query);
            if (resultSet.next())
                costPrice = resultSet.getDouble("costprice");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return costPrice;
    }


    public void deleteProductDAO(String code) {
        try {
            String query = "DELETE FROM products WHERE productcode=?";
            PreparedStatement prepStatement=  getConnection().prepareStatement(query);
            prepStatement.setString(1, code);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}