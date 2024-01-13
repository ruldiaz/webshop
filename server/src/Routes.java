import com.google.gson.Gson;

import static spark.Spark.*;

public class Routes {
    public static void setupRoutes() {
        // Add JSON parsing filter
        before((req, res) -> {
            if ("application/json".equals(req.headers("Content-Type")) && "POST".equalsIgnoreCase(req.requestMethod())) {
                try {
                    Gson gson = new Gson();
                    req.attribute("json", gson.fromJson(req.body(), Object.class));
                } catch (Exception e) {
                    res.status(400); // Bad Request
                    res.body("Error parsing JSON: " + e.getMessage());
                }
            }
        });

        // Add CORS filter
        after((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            res.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });

        // Define a route
        get("/hello", (req, res) -> "Hello Spark!");

        // Define a route with a parameter
        get("/hello/:name", (req, res) -> "Hello " + req.params(":name"));
    }
}
