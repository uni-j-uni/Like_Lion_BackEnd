package helloworld.restapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @PostMapping("/employee")
    public String createStudent(@RequestBody Employee employee) {
        return employee.toString();
    }
    @GetMapping("/findEmployee")
    public Employee findEmployee() {
        Employee employee = new Employee(1, "윤희준", "백엔드", 24);
        return employee;
    }
}