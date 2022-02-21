package com.zhevakin.controller;

import com.zhevakin.dao.EmployeeDAO;
import com.zhevakin.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRESTController {

    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Example";
    }

    @RequestMapping(value = "/employees",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE,
                                MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }

    @RequestMapping(value = "/employees/{id}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE,
                                MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") String id) {
        return employeeDAO.getEmployee(id);
    }

    @RequestMapping(value = "/employees",
                    method = RequestMethod.POST,
                    produces = {MediaType.APPLICATION_XML_VALUE,
                                MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
        System.out.println("(Service Side) Creating employee: " + emp.getId());

        return employeeDAO.addEmployee(emp);
    }

    @RequestMapping(value = "/employees", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp) {

        System.out.println("(Service Side) Editing employee: " + emp.getId());

        return employeeDAO.updateEmployee(emp);
    }

    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") String empNo) {

        System.out.println("(Service Side) Deleting employee: " + empNo);

        employeeDAO.deleteEmployee(empNo);
    }

}
