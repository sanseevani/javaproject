import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Login login = new Login();

        if (login.validateLogin()) {

            UserManagement user = new UserManagement();
            MedicineManagement medicine = new MedicineManagement();
            ReminderScheduling reminder = new ReminderScheduling();
            NotificationHistory history = new NotificationHistory();

            int choice;

            do {

                System.out.println("\n===== MEDICINE REMINDER SYSTEM =====");
                System.out.println("1. User Management");
                System.out.println("2. Medicine Management");
                System.out.println("3. Reminder Scheduling");
                System.out.println("4. Notification History");
                System.out.println("5. Exit");

                System.out.print("Enter Your Choice : ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.println("\n--- USER MANAGEMENT ---");
                        System.out.println("1. Add User");
                        System.out.println("2. View Users");
                        System.out.println("3. Update User");
                        System.out.println("4. Delete User");

                        System.out.print("Enter Choice : ");
                        int userChoice = sc.nextInt();

                        switch (userChoice) {

                            case 1:
                                user.addUser();
                                break;

                            case 2:
                                user.viewUsers();
                                break;

                            case 3:
                                user.updateUser();
                                break;

                            case 4:
                                user.deleteUser();
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }

                        break;

                    case 2:

                        System.out.println("\n--- MEDICINE MANAGEMENT ---");
                        System.out.println("1. Add Medicine");
                        System.out.println("2. View Medicine");
                        System.out.println("3. Update Medicine");
                        System.out.println("4. Delete Medicine");

                        System.out.print("Enter Choice : ");
                        int medicineChoice = sc.nextInt();

                        switch (medicineChoice) {

                            case 1:
                                medicine.addMedicine();
                                break;

                            case 2:
                                medicine.viewMedicine();
                                break;

                            case 3:
                                medicine.updateMedicine();
                                break;

                            case 4:
                                medicine.deleteMedicine();
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }

                        break;

                    case 3:

                        System.out.println("\n--- REMINDER SCHEDULING ---");
                        System.out.println("1. Add Reminder");
                        System.out.println("2. View Reminder");
                        System.out.println("3. Update Reminder");
                        System.out.println("4. Delete Reminder");

                        System.out.print("Enter Choice : ");
                        int reminderChoice = sc.nextInt();

                        switch (reminderChoice) {

                            case 1:
                                reminder.addReminder();
                                break;

                            case 2:
                                reminder.viewReminder();
                                break;

                            case 3:
                                reminder.updateReminder();
                                break;

                            case 4:
                                reminder.deleteReminder();
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }

                        break;

                    case 4:

                        System.out.println("\n--- NOTIFICATION HISTORY ---");
                        System.out.println("1. Save Notification");
                        System.out.println("2. View Notification History");

                        System.out.print("Enter Choice : ");
                        int notificationChoice = sc.nextInt();

                        switch (notificationChoice) {

                            case 1:
                                history.saveNotification();
                                break;

                            case 2:
                                history.viewHistory();
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }

                        break;

                    case 5:

                        System.out.println("Thank You!");
                        break;

                    default:

                        System.out.println("Invalid Choice");
                }

            } while (choice != 5);

        } else {

            System.out.println("Login Failed");
        }
    }
}