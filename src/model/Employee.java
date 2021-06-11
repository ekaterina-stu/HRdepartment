package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Cloneable, Comparable<Employee> {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfWork;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String name, String dateOfBirthString, String dateOfWorkString, BigDecimal salary) {
        this.name = name;
        this.dateOfBirth = formatter(dateOfBirthString);
        this.dateOfWork = formatter(dateOfWorkString);
        this.salary = salary.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    protected Employee(String name, LocalDate dateOfBirth, LocalDate dateOfWork, BigDecimal salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfWork = dateOfWork;
        this.salary = salary;
    }

    public Employee(OtherEmployee other) {
        this.name = other.getName();
        this.dateOfBirth = other.getDateOfWork();
        this.dateOfWork = other.getDateOfWork();
        this.salary = other.getSalary();
    }

    private LocalDate formatter(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfWork() {
        return dateOfWork;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " ФИО = " + name +
                ", дата рождения = " + dateOfBirth +
                ", дата принятия на работу = " + dateOfWork +
                ", зарплата = " + salary;
    }
}

