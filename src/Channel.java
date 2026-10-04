public interface Channel {
    String format(String notificationId, String content);
    String deliver(String formatted);
}