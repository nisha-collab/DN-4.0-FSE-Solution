package com.cognizant.orm_learn.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Employee;

@Service
public class HibernateEmployeeService {
    public Integer addEmployee(Employee employee) {
        Transaction tx = null;
        Integer empId = null;

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            tx = session.beginTransaction();
            empId = (Integer) session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empId;
    }
}
