package ChainOfResponsibility;

import ChainOfResponsibility.middleware.Middleware;
import ChainOfResponsibility.middleware.RoleCheckMiddleware;
import ChainOfResponsibility.middleware.ThrottlingMiddleware;
import ChainOfResponsibility.middleware.UserExistsMiddleware;
import ChainOfResponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void main(String[] args) throws IOException {
        init();
        boolean success;
        do {
            System.out.println("Enter email:");
            String email = reader.readLine();
            System.out.println("Enter password:");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());
        server.setMiddleware(middleware);
    }

}
