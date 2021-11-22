package Exam_16_12_2020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(emp -> emp.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        if (this.employees.size() == 0) {
            return null;
        } else {
            return this.employees.stream().max((emp1, emp2) -> Integer.compare(emp1.getAge(), emp2.getAge())).get();
        }
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employees working at Bakery ").append(this.name).append(":").append(System.lineSeparator());
        for (Employee employee : this.employees) {
            builder.append(employee.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
