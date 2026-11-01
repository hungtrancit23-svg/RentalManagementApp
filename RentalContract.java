import java.time.LocalDate;

public class RentalContract {
    private int contractID;
    private Property property;
    private Tenant tenant;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rentAmount;
    private boolean isActive;

    public RentalContract(Integer contractID, Property property, Tenant tenant, LocalDate startDate, LocalDate endDate) {
        if (contractID == null || contractID <= 0) {
            throw new IllegalArgumentException("Invalid contract ID");
        }
        if (tenant == null) {
            throw new IllegalArgumentException("Tenant cannot be null");
        }
        if (property == null || !property.isAvailable()) {
            throw new IllegalArgumentException("Property is not available");
        }
        if (startDate == null || endDate == null || !endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("EndDate must be later than StartDate");
        }

        this.contractID = contractID;
        this.property = property;
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = property.getRentalRate();
        this.isActive = true;

        property.setAvailable(false);
    }

    public int getContractID() { return contractID; }
    public Property getProperty() { return property; }
    public Tenant getTenant() { return tenant; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getRentAmount() { return rentAmount; }
    public boolean isActive() { return isActive; }
}