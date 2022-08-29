package com.example.jpapracticekimhab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Employee {

    @PersistenceContext
    private final EntityManager entityManager;

    private Long id;
    private String name;
    private String gender;
    private String email;

    public Employee(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
