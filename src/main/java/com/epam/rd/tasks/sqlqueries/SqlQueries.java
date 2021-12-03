package com.epam.rd.tasks.sqlqueries;

/**
 * Implement sql queries like described
 */
public class SqlQueries {
    //Select all employees sorted by last name in ascending order
    //language=HSQLDB
    private static final String SELECT = "SELECT ";
    private static final String FROM = "FROM ";
    private static final String WHERE = "WHERE ";
    private static final String EMPLOYEE = "employee ";
    private static final String ID_LASTNAME_SALARY = "id, lastname, salary ";
    protected String select01 =
        SELECT +
            ID_LASTNAME_SALARY +
        FROM +
            EMPLOYEE +
        "ORDER BY " +
            "lastname";

    //Select employees having no more than 5 characters in last name sorted by last name in ascending order
    //language=HSQLDB
    protected String select02 =
        SELECT +
            ID_LASTNAME_SALARY +
        FROM +
            EMPLOYEE +
        WHERE +
            "LENGTH(lastname) <= 5 " +
        "ORDER BY " +
            "lastname";

    //Select employees having salary no less than 2000 and no more than 3000
    //language=HSQLDB
    protected String select03 =
        SELECT +
            ID_LASTNAME_SALARY +
        FROM +
            EMPLOYEE +
        WHERE +
            "(salary >= 2000 " +
            "AND salary <= 3000)";

    //Select employees having salary no more than 2000 or no less than 3000
    //language=HSQLDB
    protected String select04 =
        SELECT +
            ID_LASTNAME_SALARY +
        FROM +
            EMPLOYEE +
        WHERE +
            "(salary <= 2000 " +
            "OR salary >= 3000)";

    //Select all employees assigned to departments and corresponding department
    //language=HSQLDB
    protected String select05 =
        SELECT +
            "lastname, salary, department.name " +
        FROM +
            EMPLOYEE +
                "JOIN " +
            "department ON " +
                "employee.department = department.id";

    //Select all employees and corresponding department name if there is one.
    //Name column containing name of the department "depname".
    //language=HSQLDB
    protected String select06 =
        SELECT +
            "lastname, salary, department.name AS depname " +
        FROM +
            EMPLOYEE +
                "LEFT JOIN " +
            "department ON " +
                "employee.department = department.id";

    //Select total salary pf all employees. Name it "total".
    //language=HSQLDB
    protected String select07 =
        SELECT +
            "SUM(salary) AS total " +
        FROM +
            EMPLOYEE;

    //Select all departments and amount of employees assigned per department
    //Name column containing name of the department "depname".
    //Name column containing employee amount "staff_size".
    //language=HSQLDB
    protected String select08 =
        SELECT +
            "COUNT (*) AS staff_size, " +
            "department.name AS depname " +
        FROM +
            EMPLOYEE +
                "JOIN department ON " +
            "employee.department = department.id " +
        "GROUP BY " +
            "department.name";

    //Select all departments and values of total and average salary per department
    //Name column containing name of the department "depname".
    //language=HSQLDB
    protected String select09 =
        SELECT +
            "SUM(salary) AS total, AVG(salary) AS average, department.name AS depname " +
        FROM +
            EMPLOYEE +
                "JOIN department ON " +
            "employee.department = department.id " +
        "GROUP BY " +
            "department.name";

    //Select lastnames of all employees and lastnames of their managers if an employee has a manager.
    //Name column containing employee's lastname "employee".
    //Name column containing manager's lastname "manager".
    //language=HSQLDB
    protected String select10 =
        SELECT +
            "e.lastname AS employee, m.lastname AS manager " +
        FROM +
            "employee e " +
                "LEFT JOIN employee m ON " +
            "e.manager = m.id";
}
