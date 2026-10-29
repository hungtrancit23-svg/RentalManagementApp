public class Property {
    private int propertyID;
    private String description;
    private double rentalRate;
    private boolean isAvailable;

    public Property(int propertyID, String description, double rentalRate) {
        validatePropertyID(propertyID);
        validateDescription(description);
        validateRentalRate(rentalRate);
        this.propertyID = propertyID;
        this.description = description;
        this.rentalRate = rentalRate;
        this.isAvailable = true;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public String getDescription() {
        return description;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void updateDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    public void updateRentalRate(double rentalRate) {
        validateRentalRate(rentalRate);
        this.rentalRate = rentalRate;
    }
    private void validatePropertyID(int propertyID) {
        if (propertyID <= 0) {
            throw new IllegalArgumentException("PropertyID must be a positive integer.");
        }
    }
    private void validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
    }
    private void validateRentalRate(double rentalRate) {
        if (Double.isNaN(rentalRate) || Double.isInfinite(rentalRate) || rentalRate <= 0) {
            throw new IllegalArgumentException("Rental rate must be a finite, positive decimal number.");
        }
    }
}
