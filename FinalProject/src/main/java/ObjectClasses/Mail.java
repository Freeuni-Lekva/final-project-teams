package ObjectClasses;

public class Mail {
    private final User sender;
    private final User receiver;
    private final String type;
    private final String message;

    public Mail(User sender, User receiver, String type, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
        this.message = message;
    }

    public User getSender() {return sender;};

    public User getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }
}
