package hsbctask.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeDao userDaoService;

    @GetMapping(path = "/employees/{id}")
    public String retrieveEmployee(@PathVariable long id) {
        try {
            return userDaoService.findEmployeeById(id);
        } catch (EmployeeNotFoundException e) {
            // we would somehow handle it here
        }

        return null;
    }

    @PostMapping(path = "/employees")
    public void createOrUpdateEmployee(@RequestBody Employee employee) {
        if(employee.getId()==null){
            userDaoService.createEmployee(employee);
        } else{
            try{
                userDaoService.updateEmployee(employee);
            } catch (EmployeeNotFoundException e) {
                // we would somehow handle it here
            }
        }
    }

    @DeleteMapping(path = "/employees/{id}")
    public void deleteUser(@PathVariable long id) {
        try {
            userDaoService.deleteEmployeeById(id);
        } catch (EmployeeNotFoundException e) {
            // we would somehow handle it here
        }
    }
}
