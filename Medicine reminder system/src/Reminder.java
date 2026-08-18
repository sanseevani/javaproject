public class Reminder {

    private int reminderId;
    private int userId;
    private int medicineId;
    private String reminderDate;
    private String reminderTime;

    public Reminder() {

    }

    public Reminder(int reminderId, int userId, int medicineId,
                    String reminderDate, String reminderTime) {

        this.reminderId = reminderId;
        this.userId = userId;
        this.medicineId = medicineId;
        this.reminderDate = reminderDate;
        this.reminderTime = reminderTime;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }
}