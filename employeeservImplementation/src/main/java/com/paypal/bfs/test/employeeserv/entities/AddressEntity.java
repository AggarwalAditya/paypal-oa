package com.paypal.bfs.test.employeeserv.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "address")
@Data
public class AddressEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line1")
    @NotNull
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "state")
    @NotNull
    private String state;

    @Column(name = "country")
    @NotNull
    private String country;

    @Column(name = "zipcode")
    @NotNull
    private String zipcode;

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
