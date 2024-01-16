import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import models.Product;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Hello world!");

        // Connect to MongoDB
        try (MongoClient mongoClient = MongoDBConnector.connect()) {
            logger.info("Connected to MongoDB successfully.");

            // Perform MongoDB operations
            performMongoDBOperations();

            // Start the HTTP server
            HttpServerHandler.startServer(4567);

        } catch (Exception e) {
            logger.error("Failed to connect to MongoDB: {}", e.getMessage());
        }
    }

    private static void performMongoDBOperations() {
        try (MongoClient mongoClient = MongoDBConnector.connect()) {
            MongoDatabase database = mongoClient.getDatabase("Product");
            MongoCollection<Document> collection = database.getCollection("products");

            // Create a product instance
            Product product = new Product();
            product.setName("Laptop");
            product.setPrice(999.99);
            product.setCategory("Electronics");

            // Convert the product to a Document and insert it into the collection
            collection.insertOne(product.toDocument());

            // Find all documents, convert them to Product instances, and print
            collection.find().forEach(document ->
                    System.out.println("Product: " + Product.fromDocument(document)));

        } catch (Exception e) {
            logger.error("Failed to perform MongoDB operations: {}", e.getMessage());
        }
    }
}
