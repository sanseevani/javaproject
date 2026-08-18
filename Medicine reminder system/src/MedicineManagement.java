import java.sql.*;
import java.util.Scanner;

public class MedicineManagement {

    Scanner sc = new Scanner(System.in);

    // Add Medicine
    public void addMedicine() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Medicine Name : ");
            String medicineName = sc.nextLine();

            System.out.print("Enter Dosage : ");
            String dosage = sc.nextLine();

            System.out.print("Enter Quantity : ");
            int quantity = sc.nextInt();

            String sql = "INSERT INTO medicines(medicine_name,dosage,quantity) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, medicineName);
            ps.setString(2, dosage);
            ps.setInt(3, quantity);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Medicine Added Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // View Medicines
    public void viewMedicine() {

        try {

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM medicines");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("medicine_id") + " " +
                        rs.getString("medicine_name") + " " +
                        rs.getString("dosage") + " " +
                        rs.getInt("quantity"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Medicine
    public void updateMedicine() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Medicine ID : ");
            int id = sc.nextInt();

            System.out.print("Enter New Quantity : ");
            int quantity = sc.nextInt();

            String sql = "UPDATE medicines SET quantity=? WHERE medicine_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Medicine Updated Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Medicine
    public void deleteMedicine() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Medicine ID : ");
            int id = sc.nextInt();

            String sql = "DELETE FROM medicines WHERE medicine_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Medicine Deleted Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}