import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.ConnectionString;

public class MongoDBConnector {
    private static final ConnectionString connectionString =
            new ConnectionString("mongodb://rulhdiaz:MFdzSGV2BqWkmctu@cluster0.mj44tp8.mongodb.net/webshop");

    public static MongoClient connect() {
        return MongoClients.create(connectionString);
    }
}
