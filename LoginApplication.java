package loginApp;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class LoginApplication {
    private static final String REAL_USERNAME = "Emin";
    private static final int REAL_PASSWORD = 12345;
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        loginRegister();
    }

    public static void loginRegister() {
        Scanner scanner = new Scanner(System.in);

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {//1,2,3
            System.out.print("Dear customer, please enter the username: ");
            String username = scanner.nextLine();
            System.out.print("Dear customer, please enter the password: ");
            int password = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            if (Objects.equals(username, REAL_USERNAME) && password == REAL_PASSWORD) {
                showMenu(scanner);
                return; // Exit after successful login
            } else {
                if (attempt == MAX_ATTEMPTS) {
                    System.out.println("You are banned");
                    exit();
                } else {
                    System.out.println("Incorrect username or password. Please try again.");
                }
            }
        }
    }

    public static void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nCustomer menu:" +
                    "\n1. Register participants" +
                    "\n2. Start competition" +
                    "\n3. Logout" +
                    "\n4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (option) {
                case 1:
                    registerParticipants(scanner);
                    break;
                case 2:
                    startCompetition(scanner);
                    break;
                case 3:
                    loginRegister(); // Logout
                    return;
                case 4:
                    exit();
                    return;
                default:
                    flowException();
            }
        }
    }

    public static void registerParticipants(Scanner scanner) {
        System.out.print("How many participants will join the competition? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Clear the newline
        System.out.println("Successfully registered " + count + " participants.");
    }

    public static void startCompetition(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1; // Generates a number between 1 and 5
        System.out.println("Random number: " + randomNumber);
        System.out.print("Guess the number: ");
        int guess = scanner.nextInt();
        scanner.nextLine(); // Clear the newline

        if (randomNumber == guess) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("You failed.");
        }
        exit();
    }

    public static void flowException() {
        throw new IllegalArgumentException("Invalid input");
    }

    public static void exit() {
        System.exit(0);
    }

}
