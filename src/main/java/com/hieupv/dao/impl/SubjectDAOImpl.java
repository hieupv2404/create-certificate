package com.hieupv.dao.impl;

import com.hieupv.dao.SubjectDAO;
import com.hieupv.entity.Student;
import com.hieupv.entity.Subject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public class SubjectDAOImpl implements SubjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Subject> getSubjectList(Student student) {
        return entityManager.createQuery("select s FROM Subject s where s.student=?1", Subject.class).setParameter(1, student).getResultList();
    }

    @Override
    public Subject getSubjectById(int theId) {
        return entityManager.find(Subject.class, theId);
    }


    @Override
    public List<Subject> findSubjectByNotCertificate(Student student) {
        return entityManager.createQuery("select s from Subject s where s.certificate=0 and s.process=100 and s.student =?1", Subject.class).setParameter(1, student).getResultList();
    }
}
