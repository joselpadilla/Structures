use TEST_SYS;

Select * from employees;

insert into employees (id, name, salary, department)
values (default, 'Jose', 10000.00, 'IT');

INSERT INTO employees (name, salary, department) VALUES
                                                     ('John Smith', 85000.00, 'Engineering'),
                                                     ('Emily Johnson', 92000.50, 'Engineering'),
                                                     ('Michael Brown', 78000.75, 'Engineering'),
                                                     ('Sarah Davis', 95000.00, 'Engineering'),
                                                     ('David Wilson', 87000.25, 'Engineering');

INSERT INTO employees (name, salary, department) VALUES
                                                     ('Jennifer Miller', 72000.00, 'Marketing'),
                                                     ('Robert Taylor', 68000.50, 'Marketing'),
                                                     ('Lisa Anderson', 75000.00, 'Marketing'),
                                                     ('Thomas Martinez', 81000.75, 'Marketing'),
                                                     ('Patricia Robinson', 69000.25, 'Marketing');

INSERT INTO employees (name, salary, department) VALUES
                                                     ('James Clark', 65000.00, 'Human Resources'),
                                                     ('Elizabeth Rodriguez', 70000.50, 'Human Resources'),
                                                     ('Charles Lewis', 62000.75, 'Human Resources'),
                                                     ('Jessica Lee', 73000.00, 'Human Resources'),
                                                     ('Daniel Walker', 68000.25, 'Human Resources');

INSERT INTO employees (name, salary, department) VALUES
                                                     ('Matthew Hall', 88000.00, 'Finance'),
                                                     ('Ashley Allen', 92000.50, 'Finance'),
                                                     ('Andrew Young', 85000.75, 'Finance'),
                                                     ('Amanda Hernandez', 94000.00, 'Finance'),
                                                     ('Kevin King', 89000.25, 'Finance');

INSERT INTO employees (name, salary, department) VALUES
                                                     ('Stephanie Wright', 75000.00, 'Operations'),
                                                     ('Ryan Lopez', 78000.50, 'Operations'),
                                                     ('Nicole Hill', 72000.75, 'Operations'),
                                                     ('Jason Scott', 80000.00, 'Operations'),
                                                     ('Rachel Green', 76000.25, 'Operations');

SELECT department, COUNT(*) as employee_count, AVG(salary) as avg_salary
FROM employees
GROUP BY department
ORDER BY avg_salary DESC;

select salary from employees order by salary desc;

SELECT distinct salary
FROM employees e1
WHERE (
          SELECT COUNT(DISTINCT salary)
          FROM employees e2
          WHERE e2.salary > e1.salary
      ) = (10 - 1);