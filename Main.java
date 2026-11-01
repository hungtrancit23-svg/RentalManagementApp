public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST PROPERTY VALIDATION ===");

        try {
            Property prop = new Property(101, "Apartment A101", 5000.50);
            System.out.println("PASSED: Property created successfully -> " + prop.getDescription());
        } catch (Exception e) {
            System.out.println("FAILED: " + e.getMessage());
        }

        try {
            Property invalidProp = new Property(102, "Apartment B", -50.0);
            System.out.println("FAILED: Allowed negative rental rate!");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED: Blocked negative rate -> " + e.getMessage());
        }

        try {
            Property invalidDesc = new Property(103, "   ", 3000.0);
            System.out.println("FAILED: Allowed empty description!");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED: Blocked empty description -> " + e.getMessage());
        }

        Property prop = new Property(104, "Penthouse", 10000.0);
        boolean updateResult = prop.updateRentalRate(-200.0);
        if (!updateResult && prop.getRentalRate() == 10000.0) {
            System.out.println("PASSED: Failed update preserved old rate (10000.0)");
        } else {
            System.out.println("FAILED: Old rate was changed on invalid update!");
        }
    }
}