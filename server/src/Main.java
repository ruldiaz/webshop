import com.mongodb.client.MongoClient;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try(MongoClient mongoClient = MongoDBConnector.connect()){
            System.out.println("Connected to MongoDB succesfully.");

        }catch(Exception e){
            System.err.println("Failed to connect to MongoDB: " + e.getMessage());
        }
    }
}