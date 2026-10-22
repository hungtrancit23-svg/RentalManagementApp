import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tenant extends User {
    private List<RentalContract> rentalContracts;

    public List<RentalContract> getRentalContracts() {
        return rentalContracts;
    }

    public void setRentalContracts(List<RentalContract> rentalContracts) {
        this.rentalContracts = rentalContracts;
    }

    public Tenant(Integer userID, String firstName, String lastName, String email) {
        super(userID, firstName, lastName, email);
        this.rentalContracts = new ArrayList<>();
    }

    public RentalContract rentProperty(Integer contractID, Property property, LocalDate startDate, LocalDate endDate) {
        RentalContract contract = new RentalContract(contractID, property, this, startDate, endDate);
        this.rentalContracts.add(contract);
        return contract;
    }

}
