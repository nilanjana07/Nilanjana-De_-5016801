public class TaskManagementSystem {

    // Define the Task class
    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        // Constructor
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        // Getters and Setters
        public int getTaskId() { return taskId; }
        public void setTaskId(int taskId) { this.taskId = taskId; }

        public String getTaskName() { return taskName; }
        public void setTaskName(String taskName) { this.taskName = taskName; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        @Override
        public String toString() {
            return "TaskID: " + taskId + ", TaskName: " + taskName + ", Status: " + status;
        }
    }

    // Define the Node class for the singly linked list
    private static class Node {
        Task task;
        Node next;

        // Constructor
        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Define the TaskManager class
    public static class TaskManager {
        private Node head;

        // Constructor
        public TaskManager() {
            this.head = null;
        }

        // Add a task to the end of the linked list
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Search for a task by ID
        public Task searchTaskById(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null; // Task not found
        }

        // Traverse and print all tasks
        public void traverseTasks() {
            Node current = head;
            if (current == null) {
                System.out.println("No tasks to display.");
                return;
            }
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        // Delete a task by ID
        public void deleteTaskById(int taskId) {
            if (head == null) {
                System.out.println("No tasks to delete.");
                return;
            }

            // Special case: deleting the head node
            if (head.task.getTaskId() == taskId) {
                head = head.next;
                System.out.println("Task deleted successfully.");
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.getTaskId() == taskId) {
                    current.next = current.next.next;
                    System.out.println("Task deleted successfully.");
                    return;
                }
                current = current.next;
            }
            System.out.println("Task not found.");
        }
    }

    // Main method to demonstrate the Task Management System
    public static void main(String[] args) {
        // Create a TaskManager instance
        TaskManager manager = new TaskManager();

        // Add tasks
        manager.addTask(new Task(1, "Complete report", "Pending"));
        manager.addTask(new Task(2, "Email client", "In Progress"));
        manager.addTask(new Task(3, "Prepare presentation", "Completed"));
        manager.addTask(new Task(4, "Update website", "Pending"));

        // Traverse and print all tasks
        System.out.println("All Tasks:");
        manager.traverseTasks();

        // Search for a task by ID
        System.out.println("\nSearching for task with ID 2:");
        Task task = manager.searchTaskById(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        // Delete a task by ID
        System.out.println("\nDeleting task with ID 3:");
        manager.deleteTaskById(3);

        // Traverse and print all tasks after deletion
        System.out.println("\nAll Tasks after deletion:");
        manager.traverseTasks();
    }
}

