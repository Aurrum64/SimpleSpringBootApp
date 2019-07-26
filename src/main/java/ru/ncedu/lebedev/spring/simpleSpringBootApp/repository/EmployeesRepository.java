package ru.ncedu.lebedev.spring.simpleSpringBootApp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ncedu.lebedev.spring.simpleSpringBootApp.domain.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Integer> {
} 
