public class Property {
    private int propertyID;
    private String description;
    private double rentalRate;
    private boolean isAvailable;

    public Property(int propertyID, String description, double rentalRate) {
        if (!validatePropertyID(propertyID) || !validateDescription(description) || !validateRentalRate(rentalRate)) {
            throw new IllegalArgumentException("Invalid input data for Property creation.");
        }
        this.propertyID = propertyID;
        this.description = description.trim();
        this.rentalRate = rentalRate;
        this.isAvailable = true; 
    }

    public void updateDescription(String description) {
        if (!validateDescription(description)) {
            System.out.println("Update failed: Invalid description.");
            return;
        }
        this.description = description.trim();
    }

    public boolean updateRentalRate(double newRate) {
        if (!validateRentalRate(newRate)) {
            System.out.println("Update failed: Invalid rental rate. Rate remains unchanged.");
            return false;
        }
        this.rentalRate = newRate;
        return true;
    }

    public static boolean validatePropertyID(int id) {
        return id > 0;
    }

    public static boolean validateDescription(String desc) {
        return desc != null && !desc.trim().isEmpty();
    }

    public static boolean validateRentalRate(Double rate) {
        if (rate == null) return false;
        return Double.isFinite(rate) && rate > 0;
    }

    public int getPropertyID() { return propertyID; }
    public String getDescription() { return description; }
    public double getRentalRate() { return rentalRate; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}