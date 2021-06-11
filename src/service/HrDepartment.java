package service;

import model.Employee;
import model.Manager;
import model.OtherEmployee;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HrDepartment {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void createEmployeeFromString(String data) {
        String[] description = data.split(",");
        String name = description[0];
        String dateOfBirth = description[1];
        String dateOfWork = description[2];
        BigDecimal salary = new BigDecimal(description[3]);
        Employee employee = new Employee(name, dateOfBirth, dateOfWork, salary);
        employees.add(employee);
    }

    public void createManagerFromString(String data) {
        String[] description = data.split(",");
        String name = description[0];
        String dateOfBirth = description[1];
        String dateOfWork = description[2];
        BigDecimal salary = new BigDecimal(description[3]);
        Manager manager = new Manager(name, dateOfBirth, dateOfWork, salary);
        employees.add(manager);
    }

    public void createOtherEmployeeFromString(String data) {
        String[] description = data.split(",");
        String name = description[0];
        String dateOfBirth = description[1];
        String dateOfWork = description[2];
        BigDecimal salary = new BigDecimal(description[3]);
        String descriptionOfEmployee = description[4];
        OtherEmployee other = new OtherEmployee(name, dateOfBirth, dateOfWork, salary, descriptionOfEmployee);
        employees.add(other);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void printAllEmployees() {
        System.out.println(this.employees);
    }

    public void deleteEmployee(int number) {
        employees.remove(number);
    }

    public void promoteEmployeeToManager(int index) {
        employees.set(index, new Manager(employees.get(index)));
    }

    public void linkEmployeeToManager(Employee employee, Manager manager) {
        manager.addSubordinate(employee);
    }
    public void showManagersList(Manager manager) {
        System.out.println(manager.getSubordinates());
    }
}
