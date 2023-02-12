import java.util.Scanner;
//! Mahesh Mungase

class OnlineExam {
    static Scanner sc = new Scanner(System.in);
    static int timer = 15; // timer for the exam, in seconds
    static String username, password;
    static String name, email;
    static int[] answers = new int[5]; // array to store answers for MCQs
    static boolean loggedIn = false;
    static boolean examStarted = false;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n\t**** Welcome ****");
            System.out.println("**** Online Exam System ****\n");

            System.out.println("1. Login Account");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Start Online Exam");
            System.out.println("5. Close Session");
            System.out.println("6. Logout");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (loggedIn) {
                        System.out.println("\nYou are already logged in. Please logout first.");
                        break;
                    }
                    login();
                    break;
                case 2:
                    if (!loggedIn) {
                        System.out.println("\nPlease login first.");
                        break;
                    }
                    updateProfile();
                    break;
                case 3:
                    if (!loggedIn) {
                        System.out.println("\nPlease login first.");
                        break;
                    }
                    changePassword();
                    break;
                case 4:
                    if (!loggedIn) {
                        System.out.println("\nPlease login first.");
                        break;
                    }
                    startExam();
                    break;
                case 5:
                    closeSession();
                    break;
                case 6:
                    logout();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Try again.");
                    break;
            }
        }
    }

    // ! login
    static void login() {
        System.out.print("\nEnter username: ");
        String enteredUsername = sc.next();
        System.out.print("Enter password: ");
        String enteredPassword = sc.next();
        // Code to check if entered username and password match the stored ones
        if (enteredUsername.equals("Mahesh") && enteredPassword.equals("2357")) {
            System.out.println("\n**** Login successful. ****");
            loggedIn = true;
        } else {
            System.out.println("\nInvalid username or password. Try again.");
        }
    }

    // !updateProfile
    static void updateProfile() {
        if (!loggedIn) {
            System.out.println("\nYou need to login first to update your profile.");
            return;
        }
        if (examStarted) {
            System.out.println("\nYou can't update your profile during an exam.");
            return;
        }
        System.out.println("\nUpdate Profile");
        System.out.print("Enter your new name: ");
        name = sc.nextLine();

        System.out.print("Enter your new email: ");
        email = sc.nextLine();

        System.out.print("Enter your new password: ");
        password = sc.nextLine();
        System.out.println("\nProfile updated successfully.");
    }

    // ! changePassword
    static void changePassword() {
        if (!loggedIn) {
            System.out.println("\nYou must be logged in to change your password.");
            return;
        }

        System.out.print("\nEnter your old password: ");
        String oldPassword = sc.nextLine();
        if (!oldPassword.equals(password)) {
            System.out.println("\nIncorrect password. Please try again.");
            return;
        }

        System.out.print("Enter your new password: ");
        password = sc.nextLine();
        System.out.println("\nPassword changed successfully.");
    }

    // ! startExam
    static void startExam() {
        System.out.println("\nExam started.");
        examStarted = true;
        System.out.println("You have " + timer + " seconds to complete the exam.");

        // ! Code to display MCQs

        System.out.println("\nQuestion 1: What is the name of the method used to start a thread execution?");
        System.out.println("1. init();");
        System.out.println("2. start();");
        System.out.println("3. run();");
        System.out.println("4. resume();");
        System.out.print("\nEnter your answer: ");
        answers[0] = sc.nextInt();

        System.out.println("\nQuestion 2: Who is the CEO of Google?");
        System.out.println("1. Jeff Bezos");
        System.out.println("2. Elon Musk");
        System.out.println("3. Mark Zuckerberg");
        System.out.println("4. Sundar Pichai");
        System.out.print("\nEnter your answer: ");
        answers[1] = sc.nextInt();

        System.out.println(
                "\nQuestion 3: Which two are valid constructors for Thread?\n Thread(Runnable r, String name) \nThread() \nThread(int priority) \nThread(Runnable r, ThreadGroup g) Thread(Runnable r, int priority)");
        System.out.println("1. 1 and 3");
        System.out.println("2. 2 and 4");
        System.out.println("3. 1 and 2");
        System.out.println("4. 2 and 5");
        System.out.print("\nEnter your answer: ");
        answers[2] = sc.nextInt();

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timer * 100) {
        }

        System.out.println("\nTime's up! Your answers will be submitted automatically.");
        System.out.println("\n Result :");
        System.out.println("\n For Result go to our link: https://www.linkedin.com/in/mahesh-mungase-54ab14245/");
    }

    static void closeSession() {
        if (!loggedIn) {
            System.out.println("\nYou are not logged in.");
            return;
        }
        if (!examStarted) {
            System.out.println("\nNo exam is in progress.");
            return;
        }
        System.out.println("\nThe exam session has been closed.");
        examStarted = false;
    }

    static void logout() {
        if (!loggedIn) {
            System.out.println("\nYou are already logged out.");
            return;
        }
        if (examStarted) {
            System.out.println("\nYou can't logout during an exam.");
            return;
        }
        System.out.println("\nLogout successful.");
        loggedIn = false;
    }
}