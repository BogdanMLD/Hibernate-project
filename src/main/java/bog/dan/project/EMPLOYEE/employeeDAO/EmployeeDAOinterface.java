package bog.dan.project.EMPLOYEE.employeeDAO;

import bog.dan.project.EMPLOYEE.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAOinterface {
    public void addEmployee(Employee employee) throws SQLException;

    public void getUserById(int id) throws SQLException;

    public void removeEmployee(Employee employee) throws SQLException;

    public void updateEmployee(Employee employee) throws SQLException;

    public List<Employee> getAllEmployee() throws SQLException;


}
