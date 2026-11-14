package controller;

import java.time.LocalDate;
import model.Property;
import model.PropertyOwner;
import model.RentalContract;
import model.Tenant;

public class RentalController {

    public Property createProperty(PropertyOwner owner, int id, String description, double rate) {
        if (owner == null) {
            return null;
        }
        return owner.createProperty(id, description, rate);
    }

    public RentalContract rentProperty(Tenant tenant, int contractId, Property property, LocalDate startDate,
            LocalDate endDate) {
        if (tenant == null) {
            return null;
        }
        return tenant.rentProperty(contractId, property, startDate, endDate);
    }

    public boolean terminateContract(RentalContract contract) {
        if (contract == null || !contract.isActive()) {
            return false;
        }
        contract.terminate();
        return true;
    }
}