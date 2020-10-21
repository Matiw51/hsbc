package hsbctask;

import hsbctask.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase {
    private static List<Employee> employees;
    private static Long nextIdIndicator;

    public static void initializeDatabase() {
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "A", "X", 1, 1337));
        employees.add(new Employee(2L, "B", "Y", 3, 6666));
        employees.add(new Employee(3L, "C", "Z", 3, 7777));
        nextIdIndicator = 4L;
    }

    public static Long getNextIdIndicator(){
        return nextIdIndicator;
    }

    public static void increaseNextIdIndicator(){
        nextIdIndicator++;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }
}
