package com.zhevakin.dao;

import com.zhevakin.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAO {

    private static final Map<Long, Employee> empMap = new HashMap<Long,Employee>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Employee emp1 = new Employee((long) 1, "Smith", "Clerk");
        Employee emp2 = new Employee((long) 2, "Allen", "Salesman");
        Employee emp3 = new Employee((long) 3, "Jones", "Manager");

        empMap.put(emp1.getId(), emp1);
        empMap.put(emp2.getId(), emp2);
        empMap.put(emp3.getId(), emp3);
    }

    public Employee getEmployee(String empNo) {
        return empMap.get(empNo);
    }

    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getId(), emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        empMap.put(emp.getId(), emp);
        return emp;
    }

    public void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }

    public List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }

}
