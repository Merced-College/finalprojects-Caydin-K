// Task.java
public class Task {
    public String title;
    public String description;
    public String category;
    public String dueDate;

    public Task(String title, String description, String category, String dueDate) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description +
               "\nCategory: " + category + "\nDue Date: " + dueDate;
    }
}
