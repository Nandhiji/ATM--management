
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Problem {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {

            System.out.println("------------MENU------------");
            System.out.println("1.Add a student");
            System.out.println("2.Display all students");
            System.out.println("3.Search for a student");
            System.out.println("4.remove a student");
            System.out.println("5.exit");

            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter the name of the student");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter the ID of the student");

                        int id = sc.nextInt();
                        list.add(new Student(id, name));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid ID.");
                        sc.nextLine(); // clear the invalid input
                    }
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("no students to display");
                        break;
                    } else {
                        System.out.println("displaying all students");
                        for (Student s : list) {
                            System.out.println(s.name);
                        }
                    }
                    break;

                case 3:
                    System.out.println("enter the id of the student to search");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Student s : list) {
                        if (s.id == searchId) {
                            System.out.println("student found: " + s.name);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("student not found");
                    }
                    break;
                case 4:
                    System.out.println("enter the name of the student to remove");
                    sc.nextLine();
                    String name = sc.nextLine();
                    if (list.isEmpty()) {
                        System.out.println("no students to remove");
                        break;
                    } else {
                        for (Student s : list) {
                            if (s.name.equals(name)) {
                                list.remove(s);
                                System.out.println("student removed successfully");
                                break;
                            }
                        }
                    }

                    break;
                case 5:
                    System.out.println("exiting the program");
                    break;
            }
        } while (choice != 5);

    }
}

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
