import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


public class MongoDBConnector {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";


    public static MongoClient connect(){
        return MongoClients.create(CONNECTION_STRING);
    }
}
