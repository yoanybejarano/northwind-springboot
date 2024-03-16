package com.example.northwind.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class EmployeeDTO {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private Timestamp birthDate;
    private String photo;
    private String notes;

}
