package ru.ncedu.lebedev.spring.simpleSpringBootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ncedu.lebedev.spring.simpleSpringBootApp.domain.Employee;
import ru.ncedu.lebedev.spring.simpleSpringBootApp.repository.EmployeesRepository;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping
    public String defaultInformation() {
        return "default";
    }

    @GetMapping("/hello")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "Friend") String name,
            Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/add")
    public @ResponseBody
    String addNewEmployee(@RequestParam String first_name,
                          @RequestParam String second_name,
                          @RequestParam String job) {
        Employee employee = new Employee();
        employee.setFirst_name(first_name);
        employee.setSecond_name(second_name);
        employee.setJob(job);
        employeesRepository.save(employee);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }
}
