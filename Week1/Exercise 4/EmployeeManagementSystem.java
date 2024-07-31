public class EmployeeManagementSystem {

    // Define the Employee class
    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        // Constructor
        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and Setters
        public String getEmployeeId() { return employeeId; }
        public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }

        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        @Override
        public String toString() {
            return "EmployeeID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
        }
    }

    // Define the EmployeeManager class
    public static class EmployeeManager {
        private Employee[] employees;
        private int size;

        // Constructor
        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        // Add an employee
        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size++] = employee;
            } else {
                System.out.println("Employee list is full.");
            }
        }

        // Search for an employee by ID
        public Employee searchEmployee(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    return employees[i];
                }
            }
            return null; // Employee not found
        }

        // Traverse and display all employees
        public void traverseEmployees() {
            if (size == 0) {
                System.out.println("No employees to display.");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        // Delete an employee by ID
        public boolean deleteEmployee(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[size - 1] = null;
                    size--;
                    return true; // Employee deleted successfully
                }
            }
            return false; // Employee not found
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5); // Initialize with capacity of 5

        // Add employees
        manager.addEmployee(new Employee("E001", "Alice", "Developer", 70000));
        manager.addEmployee(new Employee("E002", "Bob", "Manager", 90000));
        manager.addEmployee(new Employee("E003", "Charlie", "Analyst", 60000));

        // Display all employees
        System.out.println("All Employees:");
        manager.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for Employee E002:");
        Employee found = manager.searchEmployee("E002");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        System.out.println("\nDeleting Employee E002:");
        boolean deleted = manager.deleteEmployee("E002");
        if (deleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        // Display all employees after deletion
        System.out.println("\nAll Employees After Deletion:");
        manager.traverseEmployees();
    }
}
