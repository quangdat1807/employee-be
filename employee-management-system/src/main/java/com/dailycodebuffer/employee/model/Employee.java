package com.dailycodebuffer.employee.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private String fullName;
    private long phoneNumber;
    private Boolean gender;
    private Date createdDate;
    private String emailId;
}
