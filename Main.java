public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST USER VALIDATION ===");

        try {
            User validUser = new User(2, "Anna", "Nguyen", "anna@example.com");
            System.out.println("PASSED: Create valid user successfully -> " + validUser.getFullName());
        } catch (Exception e) {
            System.out.println("FAILED: " + e.getMessage());
        }

        try {
            User invalidUser = new User(-1, "Anna", "Nguyen", "anna@example.com");
            System.out.println("FAILED: Allowed negative UserID!");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED: Blocked negative UserID -> " + e.getMessage());
        }

        try {
            User invalidEmailUser = new User(3, "Anna", "Nguyen", "anna@@example.com");
            System.out.println("FAILED: Allowed invalid email!");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED: Blocked invalid email -> " + e.getMessage());
        }
    }
}