public class EmailChannel implements Channel {
    @Override
    public String format(String notificationId, String content) {
        return "[To: student@astanait.edu.kz | Subject: Notification " + notificationId
                + " | Body: " + content + "]";
    }

    @Override
    public String deliver(String formatted) { return "EMAIL delivered: " + formatted; }
}