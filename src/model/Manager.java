package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Manager extends Employee {

    private ArrayList<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String dateOfBirthString, String dateOfWorkString, BigDecimal salary) {
        super(name, dateOfBirthString, dateOfWorkString, salary);
    }

    public Manager(Employee employee) {
        super(employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary());
    }

    public ArrayList<Employee> getSubordinates() {
        return subordinates;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }
}
