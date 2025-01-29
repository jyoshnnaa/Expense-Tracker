import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Expense Tracker Menu:");
            System.out.println("1 Add Expense");
            System.out.println("2 View Expenses");
            System.out.println("3 Total Expenses");
            System.out.println("4 Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: totalExpenses(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice. Try again!");
            }
        }
    }

    static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        expenses.add(new Expense(category, amount));
        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded!");
            return;
        }
        System.out.println("\n List of Expenses:");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    static void totalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expenses: " + total);
    }
}

class Expense {
    String category;
    double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return "Category: " + category + ", Amount: " + amount;
    }
}