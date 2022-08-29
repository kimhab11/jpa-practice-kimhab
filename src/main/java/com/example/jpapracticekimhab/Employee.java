package com.example.jpapracticekimhab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name" )
    private String name;

    @Column(name = "gender" , length = 7)

    private String gender;

    @Column(name = "email",  unique = true )
    private String email;
}
