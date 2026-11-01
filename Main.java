import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST TENANT & RENTAL CONTRACT VALIDATION ===");

        Property property = new Property(101, "Apartment A101", 5000.0);
        Tenant tenant = new Tenant(1, "David", "Beckham", "david@example.com");

        LocalDate startDate = LocalDate.of(2026, 1, 1);
        LocalDate endDate = LocalDate.of(2026, 12, 31);
        
        RentalContract c1 = tenant.rentProperty(1001, property, startDate, endDate);
        if (c1 != null && tenant.getRentalContracts().size() == 1 && !property.isAvailable()) {
            System.out.println("PASSED: Valid contract created, property marked unavailable, and contract appended to tenant.");
        } else {
            System.out.println("FAILED: Valid contract creation failed.");
        }

        RentalContract c2 = tenant.rentProperty(1002, property, startDate, endDate);
        if (c2 == null && tenant.getRentalContracts().size() == 1) {
            System.out.println("PASSED: Blocked renting an unavailable property. List size remains: " + tenant.getRentalContracts().size());
        } else {
            System.out.println("FAILED: Allowed renting an unavailable property!");
        }

        Property newProp = new Property(102, "Villa B202", 12000.0);
        LocalDate invalidEndDate = LocalDate.of(2025, 12, 31); 
        
        RentalContract c3 = tenant.rentProperty(1003, newProp, startDate, invalidEndDate);
        if (c3 == null && tenant.getRentalContracts().size() == 1) {
            System.out.println("PASSED: Blocked invalid dates (endDate <= startDate). List size remains: " + tenant.getRentalContracts().size());
        } else {
            System.out.println("FAILED: Allowed invalid date range!");
        }
    }
}