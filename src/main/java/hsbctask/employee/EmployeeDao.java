package hsbctask.employee;

import java.util.List;

public interface EmployeeDao {
    String findEmployeeById(long id) throws EmployeeNotFoundException;

    void deleteEmployeeById(long id) throws EmployeeNotFoundException;

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee) throws EmployeeNotFoundException;

    List<Employee> findEmployeesWithParams(String name, String surname, Integer grade, Integer salaryLow, Integer salaryHigh);
}
