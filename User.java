public class User {
    private String userId;
    private int pin;
    private String name;

    public User(String userId, int pin, String name) {
        this.userId = userId;
        this.pin = pin;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }
}
