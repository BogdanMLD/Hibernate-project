package bog.dan.project.GeneralUtil;


import bog.dan.project.EMPLOYEE.Employee;
import bog.dan.project.TASK.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private  static SessionFactory sessionFactory = null;
    private static Configuration configuration = null;
    static {
        try{
           configuration = new Configuration().configure("hibernate.cfg.xml");
           configuration.addAnnotatedClass(Employee.class);
           configuration.addAnnotatedClass(Task.class);
           sessionFactory = configuration.buildSessionFactory();


        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
