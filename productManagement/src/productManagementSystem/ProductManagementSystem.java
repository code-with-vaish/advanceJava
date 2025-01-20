package productManagementSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagementSystem {
    private List<Product> products;

    public ProductManagementSystem() {
        products = new ArrayList<>();
    }

    
    public void addProduct(int id, String name, double price) {
        Product product = new Product(id, name, price);
        products.add(product);
        System.out.println(name + " has been added.");

        // JDBC Code for Database Insertion
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDB", "root", "vaishnavi@1234");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (id, name, price) VALUES (?, ?, ?)")) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
            System.out.println("Product added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
 // Remove a product from the list and the database
    public void removeProduct(int id) {
        Product productToRemove = null;
        for (Product p : products) {
            if (p.getId() == id) {
                productToRemove = p;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product removed from the list.");

            // JDBC Code for Database Deletion
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDB", "root", "vaishnavi@1234");
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id = ?")) {
                
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Product removed from the database.");
                } else {
                    System.out.println("Product not found in the database.");
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Product with ID " + id + " not found in the list.");
        }
    }

    
    
    
    
    

 // View all products by retrieving them from the database
    public void viewAllProducts() {
        // Clear the list and reload it from the database
        products.clear();
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDB", "root", "vaishnavi@1234");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                // Create a new Product object and add it to the list
                Product product = new Product(id, name, price);
                products.add(product);
            }

            if (products.isEmpty()) {
                System.out.println("No products available.");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Search product by ID
    public void searchProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }
}
