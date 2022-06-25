package bog.dan.project.EMPLOYEE;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import bog.dan.project.TASK.Task;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "employee", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @Column(name = "eid")
    private int eid;
    @Column(name = "ename")
    private String ename;



    @Column(name = "salary")
    private double salary;
    @Column(name = "deg")
    private String deg;

    @OneToMany(mappedBy = "employee")
    private Set<Task> tasks;

    public Employee(int eid, String ename, double salary, String deg) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
    }

    public Employee(int eid) {
        this.eid = eid;
    }

    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(eid=1,)
    }




}
