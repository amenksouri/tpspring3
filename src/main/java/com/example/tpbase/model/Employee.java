package com.example.tpbase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "First_Name", length = 250, nullable = false)
    private String firstname;
    @Column(name = "Last_Name", length = 250, nullable = false)
    private String lastname;
    public int getId() {
        return id;
    }
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMPUTER_ID", referencedColumnName="id")
    private Computer computer;
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Computer getComputer() {
        return computer;
    }


    public void setComputer(Computer computer) {
        this.computer =computer;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstname=" + firstname
                + ", lastname=" + lastname + "]";
    }

    // adding manytoone
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", insertable = false,updatable = false)
    @Fetch(FetchMode.JOIN)
    private Departement department;

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable (name ="Emp_proj", joinColumns = @JoinColumn(name ="Employee_id"),
            inverseJoinColumns = @JoinColumn(name = "Project_id"))
    @JsonIgnore
    private Set<Project> projects = new HashSet();

}
