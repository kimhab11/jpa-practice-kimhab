package com.example.jpapracticekimhab;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    public Employee findById(Long id) {
        Employee employee = (Employee) entityManager.find(Employee.class, id);
        return employee;
    }
    @Transactional
    public Employee update(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }
    @Transactional
    public Employee deleteById(long id) {
        Employee employee = findById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
        return employee;
    }


    public List<Employee> findAll(){
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e" , Employee.class);
        return query.getResultList();
    }

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
