import com.mongodb.client.MongoClient;
import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try(MongoClient mongoClient = MongoDBConnector.connect()){
            System.out.println("Connected to MongoDB succesfully.");

            // Set up routes
            Routes.setupRoutes();

            // Start the Spark server on port 4567
            port(4567);

        }catch(Exception e){
            System.err.println("Failed to connect to MongoDB: " + e.getMessage());
        }
    }
}