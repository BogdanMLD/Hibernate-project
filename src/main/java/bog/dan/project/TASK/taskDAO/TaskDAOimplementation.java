package bog.dan.project.TASK.taskDAO;

import bog.dan.project.GeneralUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import bog.dan.project.TASK.Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOimplementation implements TaskDAOinterface {

    public void addTask(Task task) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(task);
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


    public void getTaskById(int id) throws SQLException{
        Session session = null;
        Transaction transaction = null;
        Task task = new Task();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            task = session.get(Task.class, id);

            System.out.println(task.getTaskId());
            System.out.println(task.getTaskName());
            System.out.println(task.getTaskDescription());


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

    public void removeTask(Task task) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.remove(task);
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

    public void updateTask(Task task) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(task);
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



    public List<Task> getAllTask() throws SQLException{
        Session session = null;
        List tasks = new ArrayList<Task>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tasks = session.createQuery("FROM Task ",Task.class).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tasks;

    }

}
