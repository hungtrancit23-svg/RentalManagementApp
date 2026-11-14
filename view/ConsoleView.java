package view;

import controller.RentalController;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import model.Property;
import model.PropertyOwner;
import model.RentalContract;
import model.Tenant;

public class ConsoleView {
    private RentalController controller;
    private Scanner scanner;
    private PropertyOwner defaultOwner;
    private Tenant defaultTenant;

    public ConsoleView(RentalController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.defaultOwner = new PropertyOwner(1, "Anna", "Nguyen", "anna@example.com");
        this.defaultTenant = new Tenant(2, "Minh", "Tran", "minh@example.com");
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== RENTAL MANAGEMENT MENU ===");
            System.out.println("1. Create property  2. Rent  3. Terminate  4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    handleCreateProperty();
                    break;
                case "2":
                    handleRentProperty();
                    break;
                case "3":
                    handleTerminateContract();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
            }
        }
    }

    private void handleCreateProperty() {
        try {
            System.out.print("Enter Property ID (positive integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

            System.out.print("Enter Monthly Rental Rate: ");
            double rate = Double.parseDouble(scanner.nextLine().trim());

            Property created = controller.createProperty(defaultOwner, id, description, rate);
            if (created != null) {
                System.out.println("SUCCESS: Created Property ID=" + created.getPropertyID()
                        + " | Desc='" + created.getDescription()
                        + "' | Rate=" + created.getRentalRate()
                        + " | IsAvailable=" + created.isAvailable());
            } else {
                System.out.println("ERROR: Could not create property. Please check your inputs.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid number format. Operation cancelled.");
        }
    }

    private void handleRentProperty() {
        if (defaultOwner.getProperties().isEmpty()) {
            System.out.println("No properties available in the system. Please create a property first.");
            return;
        }

        System.out.println("Existing Properties:");
        for (Property p : defaultOwner.getProperties()) {
            System.out.println(" - ID: " + p.getPropertyID() + " | " + p.getDescription()
                    + " | Rate: " + p.getRentalRate() + " | IsAvailable: " + p.isAvailable());
        }

        try {
            System.out.print("Enter Contract ID (positive integer): ");
            int contractId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Property ID to rent: ");
            int propertyId = Integer.parseInt(scanner.nextLine().trim());

            Property selectedProperty = findPropertyById(propertyId);
            if (selectedProperty == null) {
                System.out.println("ERROR: Property ID " + propertyId + " not found.");
                return;
            }

            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine().trim());

            System.out.print("Enter End Date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine().trim());

            RentalContract contract = controller.rentProperty(defaultTenant, contractId, selectedProperty, startDate,
                    endDate);
            if (contract != null) {
                System.out.println("SUCCESS: Contract ID=" + contract.getContractID()
                        + " created for Property ID=" + selectedProperty.getPropertyID()
                        + " | Property IsAvailable is now: " + selectedProperty.isAvailable());
            } else {
                System.out.println(
                        "ERROR: Failed to create rental contract (property may be unavailable or dates invalid).");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid integer format.");
        } catch (DateTimeParseException e) {
            System.out.println("ERROR: Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    private void handleTerminateContract() {
        if (defaultTenant.getRentalContracts().isEmpty()) {
            System.out.println("No rental contracts found.");
            return;
        }

        System.out.println("Existing Rental Contracts:");
        for (RentalContract c : defaultTenant.getRentalContracts()) {
            System.out.println(" - Contract ID: " + c.getContractID()
                    + " | Property ID: " + c.getProperty().getPropertyID()
                    + " | IsActive: " + c.isActive()
                    + " | Property IsAvailable: " + c.getProperty().isAvailable());
        }

        try {
            System.out.print("Enter Contract ID to terminate: ");
            int contractId = Integer.parseInt(scanner.nextLine().trim());

            RentalContract selectedContract = findContractById(contractId);
            if (selectedContract == null) {
                System.out.println("ERROR: Contract ID " + contractId + " not found.");
                return;
            }

            boolean terminated = controller.terminateContract(selectedContract);
            if (terminated) {
                System.out.println("SUCCESS: Contract ID=" + selectedContract.getContractID()
                        + " terminated. Property IsAvailable is now: " + selectedContract.getProperty().isAvailable());
            } else {
                System.out.println("INFO: Contract is already inactive.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid Contract ID format.");
        }
    }

    private Property findPropertyById(int id) {
        for (Property p : defaultOwner.getProperties()) {
            if (p.getPropertyID() == id) {
                return p;
            }
        }
        return null;
    }

    private RentalContract findContractById(int id) {
        for (RentalContract c : defaultTenant.getRentalContracts()) {
            if (c.getContractID() == id) {
                return c;
            }
        }
        return null;
    }
}