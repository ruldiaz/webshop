package models;
import org.bson.Document;

public class Product {
    private String name;
    private double price;
    private String category;

    // Constructors, if needed

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Convert the object to a Document
    public Document toDocument() {
        return new Document("name", name)
                .append("price", price)
                .append("category", category);
    }

    // Convert a Document to an object
    public static Product fromDocument(Document document) {
        Product product = new Product();
        product.setName(document.getString("name"));
        product.setPrice(document.getDouble("price"));
        product.setCategory(document.getString("category"));
        return product;
    }

    // Additional methods, if needed
}
