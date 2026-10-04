public class UrgentAlert extends Notification {
    public UrgentAlert(String id, String message, Channel channel) { super(id, message, channel); }

    @Override
    protected String buildContent() { return "URGENT: " + getMessage(); }
}