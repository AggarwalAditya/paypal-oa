package com.paypal.bfs.test.employeeserv.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "date_of_birth")
    @NotNull
    private String dateOfBirth;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @NotNull
    private AddressEntity address;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Column(name = "status")
    @NotNull
    private int status;
}
