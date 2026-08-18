import java.sql.*;
import java.util.Scanner;

public class NotificationHistory {

    Scanner sc = new Scanner(System.in);

    // Save Notification
    public void saveNotification() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter User ID : ");
            int userId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Message : ");
            String message = sc.nextLine();

            System.out.print("Enter Date (YYYY-MM-DD) : ");
            String date = sc.nextLine();

            System.out.print("Enter Time (HH:MM:SS) : ");
            String time = sc.nextLine();

            String sql = "INSERT INTO notification_logs(user_id,message,notification_date,notification_time) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setString(2, message);
            ps.setString(3, date);
            ps.setString(4, time);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Notification Saved Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // View Notification History
    public void viewHistory() {

        try {

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM notification_logs");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("notification_id") + " " +
                        rs.getInt("user_id") + " " +
                        rs.getString("message") + " " +
                        rs.getDate("notification_date") + " " +
                        rs.getTime("notification_time"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}