
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LoginSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> list = new HashMap<String, String>();

        int choice;
        do {
            System.out.println("------------MENU------------");
            System.out.println("1.register");
            System.out.println("2.Login");
            System.out.println("3.Display all users");
            System.out.println("4.Exit");
            System.out.println("enter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter your username");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("enter your password");
                    String password = sc.nextLine();

                    if (list.containsKey(username)) {
                        System.out.println("username or password already exists");
                        break;
                    } else {
                        list.put(username, password);
                        System.out.println("registration successful");
                    }
                    break;

                case 2:
                    System.out.println("enter your username");
                    sc.nextLine();
                    String loginusername = sc.nextLine();
                    System.out.println("enter your password");
                    String loginpassword = sc.nextLine();

                    if (list.containsKey(loginusername)) {
                        if (list.get(loginusername).equals(loginpassword)) {
                            System.out.println("login successfully");
                        } else {
                            System.out.println("invalid password");
                        }
                    } else {
                        System.out.println("invalid username");
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("no users to display");
                        break;
                    } else {
                        System.out.println("displaying all users");
                        for (Map.Entry<String, String> entry : list.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                        break;
                    }
                case 4:
                    System.out.println("exiting the program");

                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        } while (choice != 4);
    }
}
