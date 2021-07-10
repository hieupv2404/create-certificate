package com.hieupv.dao.impl;

import com.hieupv.dao.StudentDAO;
import com.hieupv.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
@Transactional(rollbackFor = Exception.class)
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getStudentList() {
        return entityManager.createQuery("select s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student getStudent(int theId) {
        Student theStudent = entityManager.find(Student.class, theId);
        return theStudent;
    }

    @Override
    public Student findByUsernameAndPassword(String username, String password) {
        Student student = entityManager.createQuery("select s from Student s where s.username=:username and s.password=:password", Student.class).setParameter("username", username).setParameter("password", password).getSingleResult();

        return student;
    }
}
