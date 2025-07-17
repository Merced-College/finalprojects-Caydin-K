// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        UndoManager undoManager = new UndoManager();

        boolean running = true;

        while (running) {
            System.out.println("\n--- TaskMaster ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Undo Last Task");
            System.out.println("5. Count All Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Category: ");
                    String cat = scanner.nextLine();
                    System.out.print("Due Date: ");
                    String due = scanner.nextLine();
                    Task task = new Task(title, desc, cat, due);
                    manager.addTask(task);
                    undoManager.push(task);
                    System.out.println("Task added.");
                    break;
                case 2:
                    manager.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    manager.searchTasks(keyword);
                    break;
                case 4:
                    if (undoManager.hasUndo()) {
                        Task undone = manager.removeLastTask();
                        undoManager.undo();
                        System.out.println("Last task undone: " + undone.title);
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                    break;
                case 5:
                    System.out.println("Total tasks: " + manager.countTasks());
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }

        scanner.close();
    }
}
