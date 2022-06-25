package bog.dan.project.EMPLOYEE.employeeDAO;

import bog.dan.project.EMPLOYEE.Employee;
import bog.dan.project.GeneralUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimplementation implements EmployeeDAOinterface {
    public void addEmployee(Employee employee) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }


    public void getUserById(int id) throws SQLException{
        Session session = null;
        Transaction transaction = null;
        Employee employee = new Employee();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);

            System.out.println(employee.getEname());
            System.out.println(employee.getEid());
            System.out.println(employee.getSalary());
            System.out.println(employee.getDeg());

            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

    }

    public void removeEmployee(Employee employee) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.remove(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }



    public List<Employee> getAllEmployee() throws SQLException{
       Session session = null;
       List employee = new ArrayList<Employee>();
        try {
        session = HibernateUtil.getSessionFactory().openSession();
        employee = session.createQuery("FROM Employee ",Employee.class).list();
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return employee;

    }

}









