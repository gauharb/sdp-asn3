public class Reminder extends Notification {
    public Reminder(String id, String message, Channel channel) { super(id, message, channel); }

    @Override
    protected String buildContent() { return "REMINDER: " + getMessage(); }
}