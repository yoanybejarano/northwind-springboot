package com.example.northwind.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employees", schema = "northwind", catalog = "")
public class EmployeesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EmployeeID")
    private Long employeeId;
    @Basic
    @Column(name = "LastName")
    private String lastName;
    @Basic
    @Column(name = "FirstName")
    private String firstName;
    @Basic
    @Column(name = "BirthDate")
    private Timestamp birthDate;
    @Basic
    @Column(name = "Photo")
    private String photo;
    @Basic
    @Column(name = "Notes")
    private String notes;
    @OneToMany(mappedBy="employee")
    private Set<OrdersEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return employeeId == that.employeeId && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(photo, that.photo) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, lastName, firstName, birthDate, photo, notes);
    }
}
