import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 class Watch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("WATCH DETAILS");
            System.out.println("1. Enter watch details");
            System.out.println("2. Display watch details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    enterWatchDetails(scanner);
                    break;
                case 2:
                    displayWatchDetails();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    break;
            }
        }
    }

    private static void enterWatchDetails(Scanner scanner) {
        System.out.println("WATCH DETAILS");
        System.out.println("Enter watch brand: ");
        String watch_brand = scanner.nextLine();

        System.out.println("Enter watch model: ");
        String watch_model = scanner.nextLine();

        System.out.println("Enter watch category: ");
        String watch_category = scanner.nextLine();

        System.out.println("Enter watch price: ");
        double watch_price = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter watch warranty (in months): ");
        int watch_warranty = Integer.parseInt(scanner.nextLine());

        writeToCSV(watch_brand, watch_model, watch_category, watch_price, watch_warranty);
        System.out.println("Data has been saved to CSV file.");
    }

    private static void writeToCSV(String watch_brand, String watch_model, String watch_category,
                                   double watch_price, int watch_warranty) {
        String csvFileName = "watch_information.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName, true))) {
            writer.write(watch_brand + "," + watch_model + "," + watch_category + "," +
                    watch_price + "," + watch_warranty);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayWatchDetails() {
        // You can add code here to read and display data from the CSV file
        System.out.println("Displaying watch details...");
    }
}
