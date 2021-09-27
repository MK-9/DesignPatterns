package ChainOfResponsibility.middleware;

public class RoleCheckMiddleware extends Middleware {

    public RoleCheckMiddleware() {
    }

    @Override
    public boolean check(String email, String password) {
        if (email.contains("admin@examples.com")) {
            System.out.println("Hello, Admin!");
            return true;
        }
        System.out.println("Hello, User");
        return checkNext(email, password);
    }
}
