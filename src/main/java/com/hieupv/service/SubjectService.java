package com.hieupv.service;

import com.hieupv.controller.response.CertificateResponse;
import com.hieupv.entity.Student;
import com.hieupv.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject(Student student);

    void save(Subject subject);

    Subject findSubjectById(int subjectId);

    void delete(int subjectId);

    List<Subject> getAllSubjectsNotCertificate(Student student);

    CertificateResponse createCertificateFromSubject(Integer subjectId);
}
