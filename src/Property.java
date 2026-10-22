public class Property {
    private int propertyID;
    private String description;
    private double rentalRate;
    private boolean isAvailable;

    public Property(int propertyID, String description, double rentalRate) {
        if (rentalRate < 0) {
            throw new IllegalArgumentException("Rental rate cannot be negative");
        }
        this.propertyID = propertyID;
        this.description = description;
        this.rentalRate = rentalRate;
        this.isAvailable = true;

    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
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
}
