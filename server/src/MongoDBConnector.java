import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;

public class MongoDBConnector {
    private static final ConnectionString connectionString = new ConnectionString(getMongoURI());

    public static MongoClient connect() {
        return MongoClients.create(connectionString);
    }

    private static String getMongoURI() {
        try {
            Dotenv dotenv = Dotenv.configure().load();
            String mongoUri = dotenv.get("MONGO_URI");
            System.out.println("Mongo URI from .env: " + mongoUri); // Print for debugging
            return mongoUri;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
