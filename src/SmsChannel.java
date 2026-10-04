public class SmsChannel implements Channel {
    @Override
    public String format(String notificationId, String content) {
        return "[SMS] " + content.replaceAll("\\s+", " ").trim();
    }

    @Override
    public String deliver(String formatted) { return "SMS delivered: " + formatted; }
}