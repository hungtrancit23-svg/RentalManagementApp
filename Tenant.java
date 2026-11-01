import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tenant extends User {
    private List<RentalContract> rentalContracts;

    public Tenant(int userID, String firstName, String lastName, String email) {
        super(userID, firstName, lastName, email);
        this.rentalContracts = new ArrayList<>();
    }

    public RentalContract rentProperty(int contractID, Property property, LocalDate startDate, LocalDate endDate) {
        try {
            RentalContract contract = new RentalContract(contractID, property, this, startDate, endDate);
            this.rentalContracts.add(contract);
            return contract;
        } catch (IllegalArgumentException e) {
            System.out.println("RentProperty failed: " + e.getMessage() + ". No contract was appended.");
            return null;
        }
    }

    public List<RentalContract> getRentalContracts() {
        return this.rentalContracts;
    }
}