package bog.dan.project._RunApp;

import bog.dan.project.EMPLOYEE.Employee;
import bog.dan.project.GeneralUtil.HibernateUtil;
import bog.dan.project.TASK.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class RUNN {
    public static void main(String[] args) {
        Set<Task> tasks = new HashSet<>();
        Employee employee = new Employee(1,"Joric",2,"platinum");
        Task task1 = new Task(1,"name1","name1",employee);
        tasks.add(task1);




        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(employee);
        session.persist(task1);

        System.out.println("Mapped with item1 employee obkect is: "+ task1.getEmployee());

        tx.commit();




    }
}
