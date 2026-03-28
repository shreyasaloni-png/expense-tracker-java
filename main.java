import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        manager.loadFromFile();

        int choice;

        do {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    manager.addExpense(category, amount);
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    manager.showTotal();
                    break;
            }
        } while (choice != 4);

        sc.close();
    }
}
