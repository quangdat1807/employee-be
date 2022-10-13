package com.dailycodebuffer.employee.entity;

import lombok.Data;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private long phoneNumber;
    private Boolean gender;
    private Date createdDate;
    private String emailId;
}
