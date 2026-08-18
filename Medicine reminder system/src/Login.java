import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {

    public boolean validateLogin() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DatabaseConnection.getConnection();

            // Check user table empty
            String check = "SELECT COUNT(*) FROM users";

            PreparedStatement checkPs = con.prepareStatement(check);

            ResultSet countRs = checkPs.executeQuery();

            countRs.next();

            if(countRs.getInt(1) == 0) {

                String insert = 
                "INSERT INTO users(username,password,email) VALUES(?,?,?)";

                PreparedStatement insertPs = con.prepareStatement(insert);

                insertPs.setString(1, "admin");
                insertPs.setString(2, "admin123");
                insertPs.setString(3, "admin@gmail.com");

                insertPs.executeUpdate();

                System.out.println("Default Admin Created");
            }


            System.out.print("Enter Username : ");
            String username = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();


            String sql = 
            "SELECT * FROM users WHERE username=? AND password=?";


            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);


            ResultSet rs = ps.executeQuery();


            if(rs.next()) {

                System.out.println("Login Successful");
                return true;

            } else {

                System.out.println("Invalid Username or Password");
                return false;
            }


        } catch(Exception e) {

            System.out.println(e);
            return false;
        }
    }
}