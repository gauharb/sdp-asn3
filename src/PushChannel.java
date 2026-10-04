public class PushChannel implements Channel {
    @Override
    public String format(String notificationId, String content) {
        return "{title: Notification " + notificationId + ", text: " + content + "}";
    }

    @Override
    public String deliver(String formatted) { return "PUSH delivered: " + formatted; }
}
