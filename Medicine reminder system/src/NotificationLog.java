public class NotificationLog {

    private int notificationId;
    private int userId;
    private String message;
    private String notificationDate;
    private String notificationTime;

    public NotificationLog() {

    }

    public NotificationLog(int notificationId, int userId,
                           String message, String notificationDate,
                           String notificationTime) {

        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.notificationDate = notificationDate;
        this.notificationTime = notificationTime;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }
}