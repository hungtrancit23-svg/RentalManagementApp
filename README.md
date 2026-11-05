# Rental Management App

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
  <img alt="GitHub Repo" src="https://img.shields.io/badge/GitHub-RentalManagementApp-181717?style=for-the-badge&logo=github" />
  <img alt="Status" src="https://img.shields.io/badge/Status-Active-success?style=for-the-badge" />
</p>

A simple Java-based rental management console application for managing properties, tenants, property owners, and rental contracts.

## Overview

This project models a basic rental system where:

- a `PropertyOwner` can create and manage properties
- a `Tenant` can rent available properties
- a `RentalContract` tracks lease details like rent, start date, and end date
- properties can be marked as available or unavailable depending on contract activity

The app includes a sample `Main` class demonstrating the core workflow of creating a property, renting it, checking availability, updating rent, and terminating a contract.

## Features

- Create and manage properties with rental pricing
- Validate property availability before a lease is created
- Track rental contracts for tenants
- Maintain owner-owned property lists
- Handle contract termination and return property to availability
- Built with plain Java classes and no external dependencies

## Project Structure

```text
RentalManagementApp/
├── Main.java
├── Property.java
├── PropertyOwner.java
├── RentalContract.java
├── Tenant.java
├── User.java
└── README.md
```

## Core Classes

- `User` - base class for users with personal information
- `PropertyOwner` - extends `User` and manages owned properties
- `Tenant` - extends `User` and stores rental contracts
- `Property` - represents a rental property with pricing and availability state
- `RentalContract` - stores lease terms and active/inactive status
- `Main` - demo program showing how the application works

## Requirements

- Java JDK 8 or later
- Command-line terminal / IDE such as IntelliJ IDEA, Eclipse, or VS Code

## How to Run

Make sure you have Java installed on your machine.

1. Open a terminal in the project root.
2. Compile the Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java Main
   ```

## Example Workflow

The demo in Main.java does the following:

- creates a property owner and tenant
- creates a property for rent
- creates a rental contract
- prints owner and contract information
- updates the rental rate
- terminates the contract and checks property availability again

## Notes

- A property cannot be rented if it is already unavailable.
- A contract cannot end before it starts.
- Rental rates must be greater than zero.
- Terminating a contract marks the property as available again.

## License

This project does not currently include a license file. If you want to publish or share the project publicly, consider adding an open-source license such as MIT or Apache 2.0.

## Author

This repository was created by [hungtrancit23-svg](https://github.com/hungtrancit23-svg).

