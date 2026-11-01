import java.util.ArrayList;
import java.util.List;

public class PropertyOwner extends User {
    private List<Property> ownedProperties;

    public PropertyOwner(int userID, String firstName, String lastName, String email) {
        super(userID, firstName, lastName, email);
        this.ownedProperties = new ArrayList<>();
    }

    public Property createProperty(int propertyID, String description, double rentalRate) {
        try {
            Property newProperty = new Property(propertyID, description, rentalRate);
            this.ownedProperties.add(newProperty);
            return newProperty;
        } catch (IllegalArgumentException e) {
            System.out.println("CreateProperty failed: " + e.getMessage() + " No property was appended.");
            return null;
        }
    }

    public List<Property> getProperties() {
        return this.ownedProperties;
    }
}