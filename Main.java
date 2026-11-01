public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST PROPERTYOWNER VALIDATION ===");

        PropertyOwner owner = new PropertyOwner(1, "Anna", "Nguyen", "anna@example.com");

        Property p1 = owner.createProperty(101, "Apartment A101", 5000.0);
        if (p1 != null && owner.getProperties().size() == 1) {
            System.out.println("PASSED: Valid property created and appended. Total properties: " + owner.getProperties().size());
        } else {
            System.out.println("FAILED: Valid property was not added.");
        }

        Property p2 = owner.createProperty(102, "Apartment B102", 0.0);
        if (p2 == null && owner.getProperties().size() == 1) {
            System.out.println("PASSED: Invalid property blocked. List size remains unchanged: " + owner.getProperties().size());
        } else {
            System.out.println("FAILED: Invalid property was appended to the list!");
        }
    }
}