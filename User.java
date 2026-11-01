import java.util.regex.Pattern;

public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String email;

    // Regex Email cơ bản & Regex tên (chữ cái, khoảng trắng, gạch nối, nháy đơn)
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String NAME_REGEX = "^[a-zA-Z\\s'-]+$";

    // Constructor có Validation
    public User(int userID, String firstName, String lastName, String email) {
        if (!validateUserID(userID) || !validateName(firstName) || !validateName(lastName) || !validateEmail(email)) {
            throw new IllegalArgumentException("Invalid input data for User creation.");
        }
        this.userID = userID;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email.trim();
    }

    // GetFullName từ Tuần 2
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    // Update Profile - Nếu lỗi dữ liệu thì giữ nguyên profile cũ
    public boolean updateProfile(String firstName, String lastName, String email) {
        if (!validateName(firstName) || !validateName(lastName) || !validateEmail(email)) {
            System.out.println("Update failed: Invalid input data. Profile remains unchanged.");
            return false;
        }
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email.trim();
        return true;
    }

    // Helper Methods để Validate
    public static boolean validateUserID(int id) {
        return id > 0;
    }

    public static boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        return Pattern.matches(NAME_REGEX, name.trim());
    }

    public static boolean validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return Pattern.matches(EMAIL_REGEX, email.trim());
    }

    // Getters
    public int getUserID() { return userID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
}