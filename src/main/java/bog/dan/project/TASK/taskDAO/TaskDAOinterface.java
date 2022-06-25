package bog.dan.project.TASK.taskDAO;

import bog.dan.project.TASK.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDAOinterface {
    public void addTask(Task task) throws SQLException;

    public void getTaskById(int id) throws SQLException;

    public void removeTask(Task task) throws SQLException;

    public void updateTask(Task task) throws SQLException;

    public List<Task> getAllTask() throws SQLException;
}
