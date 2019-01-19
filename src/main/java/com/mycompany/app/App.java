package com.mycompany.app;

import com.mycompany.departments.AccountingDepartment;
import com.mycompany.departments.FinanceDepartment;
import com.mycompany.departments.HRDepartment;
import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;
import com.mycompany.utils.DepartmentsUtils;
import com.mycompany.utils.EmployeePredicates;
import com.mycompany.utils.EmployeesUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mycompany.entity.DepartmentType.Accounting;

public class App {
    public static void main( String[] args ) {
        // ACCOUNTING JOBS
        Job JuniorAccountant = new Job(10, "Junior Accountant", 3000, 5000, Accounting);
        Job Accountant = new Job(20, "Accountant", 4000, 6000, Accounting);
        Job SeniorAccountant = new Job(30, "Senior Accountant", 6000, 8000, Accounting);

        Employee acc_employee_1 = new Employee("John", "White", 23, 3000, "jw@company.com",
                Accounting, JuniorAccountant, Collections.singletonList("English"));
        Employee acc_employee_2 = new Employee("Jerry", "Black", 28, 5000, "jb@company.com",
                Accounting, Accountant, Arrays.asList("English", "Spanish"));
        Employee acc_employee_3 = new Employee("Andrew", "Morgan", 38, 8000, "am@company.com",
                Accounting, SeniorAccountant, Arrays.asList("English", "Spanish", "German"));

        // FINANCIAL JOBS
        Job FinancialAnalyst = new Job(40, "Financial Analyst", 8000,10000, DepartmentType.Finance);
        Job FinanceDirector = new Job(50, "Finance Director", 10000,15000, DepartmentType.Finance);

        Employee fin_employee_1 = new Employee("Mary", "White", 33, 8000, "mw@company.com",
                DepartmentType.Finance, FinancialAnalyst, Collections.singletonList("English"));
        Employee fin_employee_2 = new Employee("Mark", "Newman", 43, 18000, "mn@company.com",
                DepartmentType.Finance, FinanceDirector, Collections.singletonList("English"));

        HRDepartment hr_department = new HRDepartment(DepartmentType.Human_Resources);

        Department finance = new FinanceDepartment(DepartmentType.Finance, Arrays.asList(FinanceDirector, FinancialAnalyst),
                Arrays.asList(fin_employee_1, fin_employee_2));
        Department accounting = new AccountingDepartment(Accounting, Arrays.asList(JuniorAccountant, Accountant, SeniorAccountant),
                Arrays.asList(acc_employee_1, acc_employee_2, acc_employee_3));


        DepartmentsUtils departmentsUtils = new DepartmentsUtils();
        System.out.println("AVG salary for finance: " + departmentsUtils.countAverageSalaryForDepartment(finance));
        System.out.println("AVG salary for accounting: " + departmentsUtils.countAverageSalaryForDepartment(accounting));
        System.out.println("Sum of salaries for finance: " + departmentsUtils.sumSalariesForDepartment(finance));
        System.out.println("Sum of salaries for accounting: " + departmentsUtils.sumSalariesForDepartment(accounting));

        EmployeesUtils employeesUtils = new EmployeesUtils();
        System.out.println("Number of employees with English in Finance: " + employeesUtils.countEmployeesWithLanguage(finance, "English"));
        System.out.println("Number of employees with German in AccountingDepartment: " + employeesUtils.countEmployeesWithLanguage(accounting, "German"));
    }
}
