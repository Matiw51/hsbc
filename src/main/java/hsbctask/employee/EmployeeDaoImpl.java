package hsbctask.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hsbctask.MockDatabase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public String findEmployeeById(long id) throws EmployeeNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee desiredEmployee = findEmployee(id);

        try {
            return objectMapper.writeValueAsString(desiredEmployee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteEmployeeById(long id) throws EmployeeNotFoundException {
        Employee employeeToBeRemoved = findEmployee(id);
        MockDatabase.getEmployees().remove(employeeToBeRemoved);
    }

    @Override
    public void createEmployee(Employee employee) {
        employee.setId(MockDatabase.getNextIdIndicator());
        MockDatabase.getEmployees().add(employee);
        MockDatabase.increaseNextIdIndicator();
    }

    @Override
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        Employee oldEmployee = findEmployee(employee.getId());
        MockDatabase.getEmployees().remove(oldEmployee);
        MockDatabase.getEmployees().add(employee);
    }

    @Override
    public List<Employee> findEmployeesWithParams(String name, String surname, Integer grade, Integer salaryLow, Integer salaryHigh) {
        return MockDatabase.getEmployees().stream()
                .filter(employee -> name == null || employee.getName().equals(name))
                .filter(employee -> surname == null || employee.getSurname().equals(surname))
                .filter(employee -> grade == null || employee.getGrade().equals(grade))
                .filter(employee -> salaryLow == null || employee.getSalary() > salaryLow)
                .filter(employee -> salaryHigh == null || employee.getSalary() < salaryHigh)
                .collect(Collectors.toList());
    }

    private Employee findEmployee(long id) throws EmployeeNotFoundException {
        return MockDatabase.getEmployees().stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }


}
