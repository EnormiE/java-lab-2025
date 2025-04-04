public class NegativeLifespanException extends Exception {
    public String message;
    public NegativeLifespanException(String message) {
        super(message);
    }
}
