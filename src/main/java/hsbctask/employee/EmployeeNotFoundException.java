package hsbctask.employee;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(){
        super("Employee not found");
    }
}
