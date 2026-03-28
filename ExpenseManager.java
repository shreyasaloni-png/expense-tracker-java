import java.io.*;
import java.util.ArrayList;

public class ExpenseManager {
    ArrayList<Expense> expenses = new ArrayList<>();
    final String FILE_NAME = "expenses.dat";

    public void addExpense(String category, double amount) {
        expenses.add(new Expense(category, amount));
        saveToFile();
    }

    public void viewExpenses() {
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void showTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expense: Rs. " + total);
    }

    public void saveToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(expenses);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            expenses = (ArrayList<Expense>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found");
        }
    }
}