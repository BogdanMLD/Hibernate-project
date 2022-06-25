package bog.dan.project.GeneralUtil;

import bog.dan.project.EMPLOYEE.employeeDAO.EmployeeDAOimplementation;
import bog.dan.project.TASK.taskDAO.TaskDAOimplementation;


public class Factory {


    private static EmployeeDAOimplementation employeeDAOinterface = null;
    private static TaskDAOimplementation taskDAOimplementation = null;

    private static Factory instance = null;

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }





    public EmployeeDAOimplementation getEmployeeDAOinterface(){
        if(employeeDAOinterface == null){
            employeeDAOinterface = new EmployeeDAOimplementation();
        }
        return employeeDAOinterface;
    }

    public TaskDAOimplementation getTaskDAOimplementation(){
        if(taskDAOimplementation == null){
            taskDAOimplementation = new TaskDAOimplementation();
        }
        return taskDAOimplementation;
    }

}
