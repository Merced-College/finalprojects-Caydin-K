// TaskManager.java

import java.util.*;

public class TaskManager {
    private LinkedList<Task> tasks;
    private HashMap<String, List<Task>> categoryMap;

    public TaskManager() {
        tasks = new LinkedList<>();
        categoryMap = new HashMap<>();
    }

    // Add task and map it to its category
    public void addTask(Task task) {
        tasks.add(task);
        categoryMap.computeIfAbsent(task.category, k -> new ArrayList<>()).add(task);
    }

    // Display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task t : tasks) {
            System.out.println("-----------");
            System.out.println(t);
        }
    }

    // Search tasks by keyword
    public void searchTasks(String keyword) {
        for (Task task : tasks) {
            if (task.title.contains(keyword) || task.description.contains(keyword)) {
                System.out.println(task);
            }
        }
    }

    // Recursive function to count tasks
    public int countTasks() {
        return countRecursive(0);
    }

    private int countRecursive(int index) {
        if (index >= tasks.size()) return 0;
        return 1 + countRecursive(index + 1);
    }

    public Task removeLastTask() {
        if (tasks.isEmpty()) return null;
        Task task = tasks.removeLast();
        categoryMap.get(task.category).remove(task);
        return task;
    }
}
