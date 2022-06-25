package bog.dan.project._RunApp;

import bog.dan.project.EMPLOYEE.Employee;
import bog.dan.project.GeneralUtil.Factory;
import bog.dan.project.GeneralUtil.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.*;


public class ItemRun {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Employee> getByIdEmployee() {
        session.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot.get("ename"));
        CriteriaQuery<Employee> select = criteriaQuery.select(employeeRoot);
        TypedQuery<Employee> query = session.createQuery(select);
        session.getTransaction().commit();

        return query.getResultList();
    }


    public static void main(String[] args) throws SQLException {

        Employee employee1 = new Employee(1, "Misha", 10, "gold");
        Employee employee2 = new Employee(2, "Vadic", 20, "platinum");
        Employee employee3 = new Employee(3, "Jora", 30, "diamant");
        Factory factory = Factory.getInstance();
        factory.getEmployeeDAOinterface().addEmployee(employee1);
        factory.getEmployeeDAOinterface().addEmployee(employee2);
        factory.getEmployeeDAOinterface().addEmployee(employee3);




        factory.getEmployeeDAOinterface().getUserById(1);
        System.out.println("===============================");
        factory.getEmployeeDAOinterface().getUserById(2);
        System.out.println("===============================");
        factory.getEmployeeDAOinterface().getUserById(3);

        System.out.println("===============================");
        System.out.println("===============================");

        factory.getEmployeeDAOinterface().getAllEmployee();

//        System.out.println("===============================");
//        System.out.println("===============================");
//        System.out.println("===============================");

//        Collection employees = factory.getEmployeeDAOinterface().getAllEmployee();
//        Iterator iterator = employees.iterator();
//        while (iterator.hasNext()){
//            Employee employee = (Employee) iterator.next();
//            System.out.println("Имя работника : "+employee.getEname());
//        }








    }



}
