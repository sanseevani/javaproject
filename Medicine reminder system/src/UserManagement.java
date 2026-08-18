import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserManagement {

    Scanner sc = new Scanner(System.in);

    // Add User
    public void addUser() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Username : ");
            String username = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            String sql = "INSERT INTO users(username,password,email) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("User Added Successfully");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // View Users
    public void viewUsers() {

        try {

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while(rs.next()) {

                System.out.println(
                    rs.getInt("user_id") + " " +
                    rs.getString("username") + " " +
                    rs.getString("email")
                );
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Update User
    public void updateUser() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter User ID : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New username : ");
            String username = sc.nextLine();
            System.out.print("Enter New password : ");
            String password = sc.nextLine();
            System.out.print("Enter New Email : ");
            String email = sc.nextLine();

            String sql = "UPDATE users SET username=?, password=?, email=? WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, id);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("User Updated Successfully");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Delete User
    public void deleteUser() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter User ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM users WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("User Deleted Successfully");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}