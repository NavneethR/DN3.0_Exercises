package Week_1_Exercises;

import java.util.*;

class Employee {
    int employeeId, salary;
    String name, position;

    Employee(int employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = new String(name);
        this.position = new String(position);
        this.salary = salary;
    }
}

class EmployeeManagementSystem {

    Employee[] employees;
    int count;

    EmployeeManagementSystem(int length) {
        employees = new Employee[length];
    }

    EmployeeManagementSystem() {
        employees = new Employee[1000];
    }

    public void addEmployee(Employee newEmployee){
        try {  
            employees[count] = newEmployee;
            count++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is full try to increase your array storage")
        }
    }

    public void searchEmployee(Employee[] employees, Employee employeeToBeSearched) {
        for (Employee employee : employees) {
            if (employee == employeeToBeSearched) {
                System.out.println("Employee has been found in the DB");
                return;
            }
        }
    }

    public void traverseEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void deleteEmployee(Employee[] employees, Employee employeeToBeDeleted) {
        for (int i = 0; i < count; i++) {
            if (employees[i].equals(employeeToBeDeleted)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Employee cannot be found!");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem companyEmpolyees = new EmployeeManagementSystem(700);
        /*
         * Use the above methods to modify the company Employees, using add, search,
         * traverse and delete methods
         */
    }
}

/*
 * Analysis:
 * 
 * time complexity of addEMployee: O(1)
 * time complexity of searchEmployee: O(N)
 * time complexity of traverseEmployee: O(N)
 * time complexity of deleteEmployee: O(N)
 * 
 * limitations of array includes its inability to change its size dynamically
 * when elements are being inserted or operated upon, Usually deleting and
 * searching elements in an array take O(N) time which is slower as compared to
 * Data Structures like
 */
