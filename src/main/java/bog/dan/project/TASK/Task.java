package bog.dan.project.TASK;

import bog.dan.project.EMPLOYEE.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    @Id
    @Column(name = "taskid")
    private int taskId;
    @Column(name = "taskname")
    private String taskName;
    @Column(name = "taskdescription")
    private String taskDescription;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;




}