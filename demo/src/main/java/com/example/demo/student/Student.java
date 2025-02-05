package com.example.demo.student;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name= "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate  dob;
    private String email;
    @Transient
    private Integer age;

    public Student(){}
    public Student(Long id, String name, LocalDate dob, String email){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, LocalDate dob, String email){
        this.name = name ;
        this.dob = dob;
        this.email = email;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public LocalDate getDob(){
        return dob;
    }
    public String getEmail(){
        return email;
    }

    public Integer getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDob(LocalDate dob){
        this.dob = dob;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "Student{"+
                "id=" + id+
                ", name="+name+'\''+
                ", email='"+email+'\''+
                ", dob=" + dob+
                ", age="+ age +
                '}';
    }
}
