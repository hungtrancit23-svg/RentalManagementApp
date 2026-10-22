import java.util.ArrayList;
import java.util.List;

public class PropertyOwner extends User {
    private List<Property> OwnedProperties;

    public PropertyOwner(int userID, String firstname, String lastName, String email) {
        super(userID, firstname, lastName, email);
        this.OwnedProperties = new ArrayList<>();
    }

    public Property CreateProperty(int propertyID, String description, double rentalRate) {
        try {
            Property newProperty = new Property(propertyID, description, rentalRate);
            this.OwnedProperties.add(newProperty);
            return newProperty;
        } catch (Exception e) {
            return null;
        }
    }
}
