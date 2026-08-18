import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class ReminderScheduling {

    Scanner sc = new Scanner(System.in);

    // Add Reminder
    public void addReminder() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter User ID : ");
            int userId = sc.nextInt();

            System.out.print("Enter Medicine ID : ");
            int medicineId = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Reminder Date (YYYY-MM-DD) : ");
            String reminderDate = sc.nextLine();

            // Date Validation
            LocalDate enteredDate = LocalDate.parse(reminderDate);
            LocalDate today = LocalDate.now();

            if (enteredDate.isBefore(today)) {
                System.out.println("Reminder Added Failed - Past Date Not Allowed");
                return;
            }

            System.out.print("Enter Reminder Time (HH:MM:SS) : ");
            String reminderTime = sc.nextLine();

            String sql = "INSERT INTO reminders(user_id,medicine_id,reminder_date,reminder_time) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, medicineId);
            ps.setString(3, reminderDate);
            ps.setString(4, reminderTime);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Reminder Added Successfully");
            } else {
                System.out.println("Reminder Added Failed");
            }

        } catch (Exception e) {
            System.out.println("Reminder Added Failed");
        }
    }

    // View Reminder
    public void viewReminder() {

        try {

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM reminders");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("reminder_id") + " " +
                        rs.getInt("user_id") + " " +
                        rs.getInt("medicine_id") + " " +
                        rs.getDate("reminder_date") + " " +
                        rs.getTime("reminder_time"));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Reminder
    public void updateReminder() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Reminder ID : ");
            int reminderId = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter New Reminder Time (HH:MM:SS) : ");
            String reminderTime = sc.nextLine();

            String sql = "UPDATE reminders SET reminder_time=? WHERE reminder_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, reminderTime);
            ps.setInt(2, reminderId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Reminder Updated Successfully");
            } else {
                System.out.println("Reminder Update Failed");
            }

        } catch (Exception e) {
            System.out.println("Reminder Update Failed");
        }
    }

    // Delete Reminder
    public void deleteReminder() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Reminder ID : ");
            int reminderId = sc.nextInt();

            String sql = "DELETE FROM reminders WHERE reminder_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, reminderId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Reminder Deleted Successfully");
            } else {
                System.out.println("Reminder Delete Failed");
            }

        } catch (Exception e) {
            System.out.println("Reminder Delete Failed");
        }
    }
}