package com.hieupv.service.impl;

import com.hieupv.controller.response.CertificateResponse;
import com.hieupv.dao.SubjectDAO;
import com.hieupv.entity.Student;
import com.hieupv.entity.Subject;
import com.hieupv.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public List<Subject> getAllSubject(Student student) {
        return subjectDAO.getSubjectList(student);
    }

    @Override
    public void save(Subject subject) {

    }

    @Override
    public Subject findSubjectById(int subjectId) {
        return subjectDAO.getSubjectById(subjectId);
    }

    @Override
    public void delete(int subjectId) {

    }

    @Override
    public List<Subject> getAllSubjectsNotCertificate(Student student) {
        return subjectDAO.findSubjectByNotCertificate(student);
    }

    @Override
    public CertificateResponse createCertificateFromSubject(Integer subjectId) {
        Subject subject = subjectDAO.getSubjectById(subjectId);
        String grade = "";
        if(subject.getScore()>=6.5 && subject.getScore() <8.0){
            grade = "Immediate";
        }
        else  if(subject.getScore()>=8.0 && subject.getScore() <9){
            grade = "Good";
        }
        else  if(subject.getScore()>=9.0){
            grade = "Excellent";
        }

        return CertificateResponse.builder()
                .nameSubject(subject.getName())
                .nameStudent(subject.getStudent().getName())
                .grade(grade)
                .dateOfDone(subject.getDateOfDone())
                .build();
    }
}
